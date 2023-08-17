package com.paremskis.sms.service;

import com.paremskis.sms.model.Classroom;

import java.util.List;
import java.util.Optional;

public interface ClassroomService {

        Classroom createClassroom(Classroom classroom);

        List<Classroom> getAllClassrooms();

        Optional<Classroom> getClassroomById(Long id);

        void deleteClassroom(Long id);
}