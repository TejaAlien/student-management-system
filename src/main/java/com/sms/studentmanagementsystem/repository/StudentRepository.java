package com.sms.studentmanagementsystem.repository;

import com.sms.studentmanagementsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//JPa repository takes two arguments type of the entity and datatype of the primary Key
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    //JPA repository ->SimpleJPRepository class implements JPARepository so we no need to add the @Repository Annotation
    //Also all the  methods by default provides transaction to all teh methods so no need to add the annotations in service layer


}
