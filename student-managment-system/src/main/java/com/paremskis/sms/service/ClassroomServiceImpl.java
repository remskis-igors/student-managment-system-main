package com.paremskis.sms.service;

import com.paremskis.sms.model.Classroom;
import com.paremskis.sms.persistence.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    private final ClassroomRepository classroomRepository;

    @Autowired
    public ClassroomServiceImpl(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    @Override
    public Classroom createClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    @Override
    public List<Classroom> getAllClassrooms() {
        return classroomRepository.findAll();
    }

    @Override
    public Optional<Classroom> getClassroomById(Long id) {
        return classroomRepository.findById(id);
    }

    @Override
    public void deleteClassroom(Long id) {
        classroomRepository.deleteById(id);
    }
}