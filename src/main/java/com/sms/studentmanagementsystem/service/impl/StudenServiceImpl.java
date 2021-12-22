package com.sms.studentmanagementsystem.service.impl;

import com.sms.studentmanagementsystem.entity.Student;
import com.sms.studentmanagementsystem.repository.StudentRepository;
import com.sms.studentmanagementsystem.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudenServiceImpl implements StudentService {
private StudentRepository studentRepository;
// here we are using constructor to make the object loosely coupled

    public StudenServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
//If the spring bean(StudentServiceImpl) has only one constructor then avoid @autowired annotation

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student updateStudent(Student student) {
       return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(long id) {
        studentRepository.deleteById(id);
    }
}
