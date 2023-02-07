package com.firstCODE.spring.dto.mapper;

import com.firstCODE.spring.student.Student;
import com.firstCODE.spring.dto.StudentDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;


@Data
@RequiredArgsConstructor
@Component
public class StudentRequestMapper {

    @Transactional
    public Student studentRequestMapper(StudentDTO studentDTO) {
        Student student = new Student();

        student.setName(studentDTO.getName());
        student.setSureName(student.getSureName());
        student.setPassword(student.getPassword());
        student.setEmail(student.getEmail());

        return student;
    }

}
