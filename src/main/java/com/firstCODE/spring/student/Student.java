package com.firstCODE.spring.student;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;

@Entity(name = "Student")
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String sureName;
    private String password;
    @Email
    private String email;
    private String phoneNumber;
    private String address;
    @CreatedDate
    private LocalDate createdAt;

    public Student(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

}
