package com.paremskis.sms.service;

import com.paremskis.sms.model.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {

    List<Teacher> getAllTeachers();

    Optional<Teacher> findById(long id);

    Optional<Teacher> findByName(String name);

    Teacher save(Teacher tch);

    void deleteById(long id);

    void deleteById(Teacher tch);
}