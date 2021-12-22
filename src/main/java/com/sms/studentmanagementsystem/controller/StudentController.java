package com.sms.studentmanagementsystem.controller;

import com.sms.studentmanagementsystem.entity.Student;
import com.sms.studentmanagementsystem.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
//to make this class as a  spring mvc class to handle the requests

@Controller
public class StudentController {
    //injecting the dependency studentservice
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    //Create a handler method to handle the list of students and return the model and view
//we don't need to create a view resolver bean for thymeleaf ,
    //Springboot automatically create a view resolver for thymeleaf when finds the thymeleaf dependency in classpath(pom.xml)
    //Springboot by default finds the thymeleaf templates under templetes folder
    //src/main/resources/templates

    @GetMapping("/students")
    //Add model to the method Argument
    public String liststudents(Model model){
       // model has list of students and append that lsit to the view (students.html)
        // Adding data to the model(Key, value)
        //retrieving list of students from database by calling studentservice.getallstudents
        model.addAttribute("students",studentService.getAllStudents());//Adding data to the model
return "students";//view
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model){
//creating student object to hold the student form data
        Student student = new Student();
        model.addAttribute("student",student);
        return "create_student";
    }
    //here we are binding the formdata to the object and the object is student
    //and we are going to bind it to student .we are binding it to student entity
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
studentService.saveStudent(student);
return "redirect:/students";
    }
    //we need to return some data to the view right for that we are using Model
    //here we are getting student id from db
    @GetMapping("/students/edit/{id}")
    public String editstudentform(@PathVariable Long id , Model model){
model.addAttribute("student",studentService.getStudentById(id));
return "edit_student";
    }
@PostMapping("/students/{id}")
    public String updateStudent(@PathVariable long id,@ModelAttribute("student") Student student){
//get student from database by id
    Student existingstudent = studentService.getStudentById(id);
    existingstudent.setId(id);
    existingstudent.setFirstName(student.getFirstName());
    existingstudent.setLastName(student.getLastName());
    existingstudent.setRollnumber(student.getRollnumber());
    existingstudent.setEmail(student.getEmail());
studentService.updateStudent(existingstudent);
return "redirect:/students";
    }
    //once we click on delete button
//handler method to handle the delete student request
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable long id){
studentService.deleteStudentById(id);
return "redirect:/students";
    }
}
