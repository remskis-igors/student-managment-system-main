package com.paremskis.sms.service;

import com.paremskis.sms.model.Teacher;
import com.paremskis.sms.persistence.TeacherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class TeacherServiceImpl implements TeacherService{

    private final TeacherRepository teacherRepository;


    @Override
    public List<Teacher> getAllTeachers() {
        log.info("Find all teachers");
        return teacherRepository.findAll();
    }

    @Override
    public Optional<Teacher> findById(long id) {
        return Optional.ofNullable(teacherRepository.findById(id).orElse(null));
    }

    @Override
    public Optional<Teacher> findByName(String name) {
        log.info("Find all teachers");
        return Optional.ofNullable(teacherRepository.findByName(name).orElse(null));
    }

    @Override
    public Teacher save(Teacher tch) {
        log.info("Save all teachers" + tch);
        return teacherRepository.save(tch);
    }

    public List<Teacher> saveAllTeachers(List<Teacher> teacherList) {
        log.debug("Save teacher list: " + teacherList);
        return teacherRepository.saveAll(teacherList);
    }

    @Override
    public void deleteById(long id) {
        log.debug("Delete teacher by ID: " + id);
        teacherRepository.deleteById(id);
    }

    @Override
    public void deleteById(Teacher tch) {

    }
}
