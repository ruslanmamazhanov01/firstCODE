package com.firstCODE.spring.repository;

import com.firstCODE.spring.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    boolean existsStudentByName(String name);

    @Query(value = "select n from Student n where n.email = ?1")
    Student getStudentByEmail(String email);
}
