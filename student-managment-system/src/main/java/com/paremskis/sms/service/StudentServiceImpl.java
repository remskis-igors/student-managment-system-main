package com.paremskis.sms.service;

import com.paremskis.sms.model.Student;
import com.paremskis.sms.model.Teacher;
import com.paremskis.sms.persistence.StudentRepository;
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
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;


    @Override
    public List<Student> getAllStudents() {
        log.info("Find all students");
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(long id) {
        return Optional.ofNullable(studentRepository.findById(id).orElse(null));
    }

    @Override
    public Optional<Student> findByEmail(String email) {
        log.info("Searching student by Email: " + email);
        return studentRepository.findByEmail(email);
    }

    @Override
    public Student save(Student std) {
        log.debug("Save student: " + std);
        return studentRepository.save(std);
    }

    public void saveAllStudents(List<Student> studentList) {
        log.debug("Save student list: " + studentList);
        studentRepository.saveAll(studentList);
    }

    @Override
    public void deleteById(long id) {
        log.info("Deleted student by id--{}", id);
        studentRepository.deleteById(id);

    }

    @Override
    public void deleteById(Student std) {
        studentRepository.delete(std);
    }
}



