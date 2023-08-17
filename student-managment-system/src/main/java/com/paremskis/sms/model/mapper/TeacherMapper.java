package com.paremskis.sms.model.mapper;


import com.paremskis.sms.model.Teacher;
import com.paremskis.sms.model.request.AddTeacherRequest;

public class TeacherMapper {

        public static Teacher map(AddTeacherRequest teacherRequest) {
            return new Teacher()
                    .setName(teacherRequest.getName())
                    .setSubject(teacherRequest.getSubject());
        }

    }