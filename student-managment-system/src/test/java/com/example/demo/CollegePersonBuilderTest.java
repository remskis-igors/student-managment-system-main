package com.example.demo;

import com.paremskis.sms.collegePersonBuilder.CollegePerson;
import com.paremskis.sms.collegePersonBuilder.CollegePersonBuilder;
import com.paremskis.sms.collegePersonBuilder.CollegePersonObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CollegePersonBuilderTest {

    @Test
    public void test() {
        CollegePerson student;
        CollegePerson teacher;
        CollegePersonBuilder builder = (CollegePersonBuilder) new CollegePersonObject();

        student = builder.setName("Test")
                .setSurName("Testovi4")
                .setEmail("admin@prnh.xxx")
                .setIsPersonDon(false)
                .setPayment(true)
                .build();
        CollegePersonBuilder builderT = (CollegePersonBuilder) new CollegePersonObject();
        teacher = builderT.setName("Anto6ka")
                .setSurName("PAVLOV")
                .setEmail("admin@prnh.yyy")
                .setIsPersonDon(true)
                .build();

        System.out.println(student);

        assertEquals("Test", student.getName());
        assertTrue(student instanceof CollegePerson);
        assertEquals("Testovi4", student.getSurName());
        assertEquals("admin@prnh.xxx", student.getEmail());
        assertFalse( student.isDon);
        assertTrue(student.isPayment());

        assertEquals("Anto6ka", teacher.getName());
        assertTrue(teacher instanceof CollegePerson);
        assertEquals("PAVLOV", teacher.getSurName());
        assertEquals("admin@prnh.yyy", teacher.getEmail());
        assertTrue( teacher.isDon);

    }

}

