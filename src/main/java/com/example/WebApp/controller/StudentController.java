package com.example.WebApp.controller;

import com.example.WebApp.model.Student;
import com.example.WebApp.repository.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controller Class that has all our resources for our api
@RestController
//In place of writing localhost:8080 , now we have to write localhost:8080/api/v1/student
@RequestMapping(path="api/v1/student")
public class StudentController {
    private final StudentService studentService;

    //The studentService should be autowired for us, so it will be init. for us and then injected into this constructor.
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentByID(@PathVariable("id") Long id){
        return studentService.getStudentByID(id);
    }

    //@RequestBody means to take the whole json that represents a Student and convert it into a Student object
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    //Delete HTTP Request
    //PathVariable takes the variable inputted in the path as parameter
    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id){
        studentService.deleteStudent(id);
    }

    //Put HTTP Request = Update
    //@RequestParam(required=false) params that could be given or not since not required.
    @PutMapping(path="{studentId}")
    public void updateStudent(@PathVariable("studentId") Long id,@RequestParam(required = false) String name,@RequestParam(required = false) String email){
        studentService.updateStudent(id,name,email);
    }

}
