package com.paremskis.sms.service;

import com.paremskis.sms.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> getAllStudents();

    Optional<Student> findById(long id);

    Optional<Student> findByEmail(String email);

    Student save(Student std);

    void deleteById(long id);

    void deleteById(Student std);
}
