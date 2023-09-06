package com.example.WebApp.configs;

import com.example.WebApp.model.Student;
import com.example.WebApp.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student max = new Student(1L,"Max","max@yahoo.com", LocalDate.of(2000, Month.JANUARY,8),23);
            Student alex = new Student(2L,"Alex","alex@yahoo.com", LocalDate.of(2000, Month.JANUARY,20),23);
            repository.saveAll(List.of(max,alex));
        };
    }
}
