package com.paremskis.sms.model;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Data
@Table(name = "teachers")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "subject")
    private String subject;
}