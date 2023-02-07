package com.firstCODE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstCodeApplication.class, args);
        System.out.println("Hello world");
    }

//    @Bean
//    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
//        return args -> {
//            Student student = new Student();
//            student.setName("Ruslanbek");
//            student.setPassword("ruslan");
//            studentRepository.save(student);
//        };


}
