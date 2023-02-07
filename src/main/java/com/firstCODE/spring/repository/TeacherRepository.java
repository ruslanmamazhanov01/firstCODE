package com.firstCODE.spring.repository;

import com.firstCODE.spring.student.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository  extends JpaRepository<Long, Teacher> {

}
