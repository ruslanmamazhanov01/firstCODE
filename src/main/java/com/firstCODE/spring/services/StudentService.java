package com.firstCODE.spring.services;

import com.firstCODE.spring.Exceptions.AlreadyExistsException;
import com.firstCODE.spring.Exceptions.StudentNotFoudException;
import com.firstCODE.spring.services.interfaces.StudentServiceInterface;
import com.firstCODE.spring.student.Student;
import com.firstCODE.spring.repository.StudentRepository;
import com.firstCODE.spring.dto.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class StudentService implements StudentServiceInterface {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<StudentDTO> findAll() {
        List<Student> studentList = studentRepository.findAll();
        log.info("getStudents was called" + studentList.size());
        return studentList.stream()
                .map(student -> modelMapper.map
                        (student, StudentDTO.class))
                .collect(Collectors.toList());

    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(
                        () -> {
                            StudentNotFoudException studentNotFoudException = new StudentNotFoudException
                                    ("customer with id [%s] not found");
                            log.error("error in getting student{}; id notFoundException :");
                            return studentNotFoudException;
                        });
    }

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        String name = studentDTO.getName();
        if (studentRepository.existsStudentByName(name)) {
            log.error("student -> {} has already exists in database", name);
            throw new AlreadyExistsException(
                    "student = " + name + " has already exists"
            );
        }
        log.info("saving new student [{}] to database", studentDTO);
        return modelMapper.map(studentRepository.save(
                        modelMapper.map(studentDTO, Student.class)),
                StudentDTO.class);

    }

    @Override
    @Transactional
    public void updateStudent(Long StudentId, StudentDTO student) {
        Student studentId = findById(StudentId);
        String name = studentId.getName();
        String name1 = student.getName();
        if (!name1.isEmpty() &&
                !Objects.equals(name, name1)) {
            studentId.setName(name1);
        }
        log.info("student[{}] updated to [{}]", name, name1);

    }


    @Override
    public void deleteById(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoudException("Client with id " + id + " does not exists");

        }
        studentRepository.deleteById(id);
    }


}
