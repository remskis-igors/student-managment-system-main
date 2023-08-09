package com.example.demo;

import com.paremskis.sms.Adapter.Student;
import com.paremskis.sms.Adapter.StudentAdapter;
import com.paremskis.sms.Adapter.StudentImpl;
import com.paremskis.sms.Adapter.Teacher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentAdapterTest {

    @Test
    public void test() {
        Student student = new StudentImpl();
        Teacher fakeTeacher = new StudentAdapter(new StudentImpl());
        System.out.println("real student");
        System.out.println(student.getKnowlege());

        System.out.println("fake teacher");
        System.out.println(fakeTeacher.learn());

        assertTrue(fakeTeacher instanceof Teacher);
        assertTrue(student instanceof Student);
    }
}
