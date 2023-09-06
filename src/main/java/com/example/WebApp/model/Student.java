package com.example.WebApp.model;

import jakarta.persistence.*;

import java.time.LocalDate;

//Model : simple class to represent a student
@Entity
@Table
public class Student {
    @Id
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    private Integer age;

    public Student(){

    }

    public Student(Long id,String name,String email,LocalDate dob,int age){
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
    }

    public Student(String name,String email,LocalDate dob,int age){
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
    }
    //Getters
    public Integer getAge() {
        return age;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getName() {
        return name;
    }


    //Setters
    public void setAge(int age) {
        this.age = age;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
