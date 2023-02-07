package com.firstCODE.spring.services.interfaces;

import com.firstCODE.spring.student.Student;
import com.firstCODE.spring.dto.StudentDTO;

import java.util.List;

public interface StudentServiceInterface {

    List<StudentDTO> findAll();

    Student findById(Long id);

    StudentDTO saveStudent(StudentDTO studentDTO);
    void updateStudent(Long StudentId, StudentDTO student);

    void deleteById(Long id);
}
