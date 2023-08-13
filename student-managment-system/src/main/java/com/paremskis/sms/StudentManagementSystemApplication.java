package com.paremskis.sms;

import com.paremskis.sms.model.Student;
import com.paremskis.sms.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.hibernate.cfg.Configuration;

@SpringBootApplication
public class StudentManagementSystemApplication {

    public static void main(String[] args) {

        Configuration cfg = new Configuration().configure();
        try (SessionFactory sessionFactory = cfg.buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            Transaction tx = session.beginTransaction();

            Teacher teacher = new Teacher();
            teacher.setName("Abols");
            teacher.setSubject("Math");

            Student student = new Student();
            student.setFirstName("Anda");
            student.setLastName("Burka");
            student.setEmail("anda@burka.com");


            session.save(teacher);
            session.save(student);

            tx.commit();

            System.out.println("Session" + session.getSession());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
