package com.example.WebApp.repository;

import com.example.WebApp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Responsible for data access to the db.
//The @Repository gives a large amount of coded queries/methods for the db access
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    //Custom Query/Method created by us
    @Query("Select s from Student s where s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
