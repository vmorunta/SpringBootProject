package com.example.WebApp.view;

import com.example.WebApp.model.Student;
import com.example.WebApp.controller.StudentController;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



//using Thymeleaf (imported in pom) for the views (html)
@Controller
public class IndexController {
    private final StudentController studentController;

    @Autowired
    public IndexController(StudentController studentController){
        this.studentController = studentController;
    }
    @GetMapping("/index")
    public String Index(){
        return "index";
    }


    @PostMapping("/register")
    public String userRegistration(@ModelAttribute Student student,Model model){
        System.out.println(student);
        studentController.registerNewStudent(student);
        //Pass attributes to html page
        model.addAttribute("studentName",student.getName());

        return "welcome";
    }

    @PostMapping("/delete")
    public void deleteUser(HttpServletRequest request, HttpServletResponse response){
        Long id = Long.parseLong(request.getParameter("id"));
        studentController.deleteStudent(id);
    }

    @PostMapping("/updateEmail")
    public void updateUserEmail(HttpServletRequest request, HttpServletResponse response){
        Long id = Long.parseLong(request.getParameter("id"));
        String email = request.getParameter("email");
        studentController.updateStudent(id,studentController.getStudentByID(id).getName(),email);
    }

    //Created to see how to retrieve parameters from frontend using Servlet
    @PostMapping("/add")
    public String add(HttpServletRequest request, HttpServletResponse response){
        int nr1 = Integer.parseInt(request.getParameter("nr1"));
        int nr2 = Integer.parseInt(request.getParameter("nr2"));
        System.out.println(nr1+nr2);
        // model.addAttribute("nr",nr1+nr2);
        return "welcome";
    }
}
