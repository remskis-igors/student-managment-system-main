package com.paremskis.sms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne // This indicates a ManyToOne relationship with the Teacher entity
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ElementCollection
    @Column(name = "classroomStudents")
    private List<Student> students;

    @ElementCollection
    @Column(name = "classroomSchedules")
    private List<Schedule> schedules;
}