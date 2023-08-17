package com.paremskis.sms.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.List;

@Entity
@Data
@Table(name = "schedules")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "dayOfWeek", nullable = false)
    DayOfWeek dayOfWeek ;


    @ElementCollection
    @Column(name = "subjects")
    private List<String> subjects;
}