package com.sms.studentmanagementsystem;

import com.sms.studentmanagementsystem.entity.Student;
import com.sms.studentmanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementSystemApplication.class, args);
    }
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public void run(String... args) throws Exception {

            Student student1 = new Student(1,"Ravi","Nanda",28,"nanda.28@gmail.com");
            studentRepository.save(student1);
            Student student2 = new Student(2,"Tony","hifigur",78,"tony98@gmail.com");
            studentRepository.save(student2);
            Student student3 = new Student(3,"trump","Donald",45,"donald@trump@yahoo.com");
            studentRepository.save(student3);
    }
//this run method executes when we run our spring boot application
    // here writing a logic to insert the few student records
    //we are injecting the student repository


    }
//we are writing a code to add record to the table

