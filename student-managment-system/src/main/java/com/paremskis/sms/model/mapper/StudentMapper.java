package com.paremskis.sms.model.mapper;

import com.paremskis.sms.model.Student;
import com.paremskis.sms.model.request.AddStudentRequest;

public class StudentMapper {

    public static Student map(AddStudentRequest studentRequest) {
        return new Student()
                .setFirstName(studentRequest.getFirstName())
                .setLastName(studentRequest.getLastName())
                .setEmail(studentRequest.getEmail());
    }
}
