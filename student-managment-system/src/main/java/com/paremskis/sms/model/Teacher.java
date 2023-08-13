package com.paremskis.sms.model;

//import lombok.AccessLevel;
//import lombok.Data;
//import lombok.experimental.FieldDefaults;
//
//import javax.persistence.*;

//@Entity
//@Data
//@Table(name = "teachers")
//@FieldDefaults(level = AccessLevel.PRIVATE)
//public class Teacher {
//
//    @Column(name = "name", nullable = false)
//    String firstName;
//    @Column(name = "subject")
//    String subject;
//
//}

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String subject;
}