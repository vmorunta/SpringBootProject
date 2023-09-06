package com.example.WebApp.repository;

import com.example.WebApp.model.Student;
import com.example.WebApp.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

//@Service,@Component = beans but more specific.
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentByID(Long id){
        return studentRepository.findById(id).orElseThrow(()->new IllegalStateException("Doesn't exist"));
    }

    public void addNewStudent(Student student){
        //We verify that the student's email doesn't already exit in the db before we add the new student in the db
        Optional<Student> studentOptinal = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptinal.isPresent()){
            throw  new IllegalStateException("Email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long id){
        boolean exists = studentRepository.existsById(id);
        if(!exists){
            throw  new IllegalStateException("Student is id "+ id + " doesn't exist");
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id,String name,String email){
        Student student = studentRepository.findById(id).orElseThrow(()->new IllegalStateException("Doesn't exist"));

        //If name has been given as a param by the user and it is not the same then we update the student's name
        if(name!=null && name.length()>0 && !Objects.equals(student.getName(),name)){
            student.setName(name);
        }

        if(email!=null && email.length()>0 && !Objects.equals(student.getEmail(),email)){
            Optional<Student> studentByEmail = studentRepository.findStudentByEmail(email);
            if(studentByEmail.isPresent()){
                throw  new IllegalStateException("Email already exists");
            }
            student.setEmail(email);
        }

    }

}
