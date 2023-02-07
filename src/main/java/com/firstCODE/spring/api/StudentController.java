package com.firstCODE.spring.api;

import com.firstCODE.spring.dto.StudentDTO;
import com.firstCODE.spring.services.StudentService;
import com.firstCODE.spring.student.Student;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RequestMapping("/api/v2/student")
@RestController
public class StudentController {


    private final StudentService studentService;

    @GetMapping
    private List<StudentDTO> findAll() {
        return studentService.findAll();
    }

    @PostMapping("/save")
    public StudentDTO saveStudent(@RequestBody StudentDTO student) {
        return studentService.saveStudent(student);
    }

    @PatchMapping("/update/{studentId}")
    public void updateStudent(@PathVariable Long studentId,
                              @RequestBody StudentDTO student) {
         studentService.updateStudent(studentId, student);
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") Long id) {
        System.out.println(id);
        return studentService.findById(id);
    }

    @DeleteMapping("/remove/{id}")
    public void removeStudent(@PathVariable("id") Long id) {
        studentService.deleteById(id);
        System.out.println("delete request for student with ID " + id);
    }

}



