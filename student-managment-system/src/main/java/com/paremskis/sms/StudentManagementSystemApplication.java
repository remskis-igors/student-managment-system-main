package com.paremskis.sms;

import com.paremskis.sms.model.Classroom;
import com.paremskis.sms.model.Schedule;
import com.paremskis.sms.model.Student;
import com.paremskis.sms.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class StudentManagementSystemApplication {

    @Autowired
    Schedule schedule;

    public static void main(String[] args) {
        // Initialize Hibernate
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        // Sample data
        Teacher teacher1 = new Teacher();
        teacher1.setName("Burkins");
        teacher1.setSubject("Math");
        Teacher teacher2 = new Teacher();
        teacher2.setName("Janson");
        teacher2.setSubject("Science");
        Student student1 = new Student();
        student1.setFirstName("Alise");
        student1.setLastName("Putnina");
        student1.setEmail("alise@putnina.com");

        Student student2 = new Student();
        student2.setFirstName("Bob");
        student2.setLastName("Janson");
        student2.setEmail("bob@mail.com");

        List<Student> mathClassStudents = new ArrayList<>();
        mathClassStudents.add(student1);
        mathClassStudents.add(student2);

        List<String> mathSubjects = new ArrayList<>();
        mathSubjects.add("Algebra");
        mathSubjects.add("Geometry");
        Schedule mathSchedule = new Schedule(DayOfWeek.MONDAY, mathSubjects);

        Classroom mathClassroom = new Classroom("Math Class", teacher1, mathClassStudents, List.of(mathSchedule));


        // Database operations using Hibernate
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();

            session.save(student1);
            session.save(student2);
            session.save(teacher1);
            session.save(teacher2);

            session.save(mathSchedule);
            session.save(mathSchedule);
            session.save(mathClassroom);

            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

        factory.close();
    }
    //   public static void main(String[] args) {
//
//        Configuration cfg = new Configuration().configure();
//        try (SessionFactory sessionFactory = cfg.buildSessionFactory();
//             Session session = sessionFactory.openSession()) {
//
//            Transaction tx = session.beginTransaction();
//
//            Teacher teacher = new Teacher();
//            teacher.setName("Abols");
//            teacher.setSubject("Math");
//
//            Student student = new Student();
//            student.setFirstName("Anda");
//            student.setFirstName("Anda");
//            student.setLastName("Burka");
//            student.setEmail("anda@burka.com");
//
//
//            session.save(teacher);
//            session.save(student);
//
//            tx.commit();
//
//            System.out.println("Session" + session.getSession());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}