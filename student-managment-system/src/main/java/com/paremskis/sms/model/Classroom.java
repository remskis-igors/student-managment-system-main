package com.paremskis.sms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classroom {
    private String name;
    private Teacher teacher;
    private List<Student> students;
    private List<Schedule> schedules;
}