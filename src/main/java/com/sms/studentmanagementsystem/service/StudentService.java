package com.sms.studentmanagementsystem.service;

import com.sms.studentmanagementsystem.entity.Student;

import java.util.List;

// for loose coupling we are using interface and create a class to implement these methods
public interface StudentService {
    List<Student> getAllStudents();
Student saveStudent(Student student);
Student getStudentById(long id);
Student updateStudent(Student student);
void deleteStudentById(long id);

}
