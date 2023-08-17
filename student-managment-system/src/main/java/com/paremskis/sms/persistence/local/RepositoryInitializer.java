package com.paremskis.sms.persistence.local;


import com.paremskis.sms.model.Classroom;
import com.paremskis.sms.model.Schedule;
import com.paremskis.sms.model.Student;
import com.paremskis.sms.model.Teacher;
import com.paremskis.sms.service.ClassroomService;
import com.paremskis.sms.service.ScheduleService;
import com.paremskis.sms.service.StudentServiceImpl;
import com.paremskis.sms.service.TeacherServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

@ConditionalOnProperty(name = "app.mocks.repository", havingValue = "true")
@Component
@RequiredArgsConstructor
public class RepositoryInitializer {

    private final StudentServiceImpl studentService;
    private final TeacherServiceImpl teacherService;

    @PostConstruct
    public void init() {

        List<Teacher> teacherList = initTeachers();
        List<Student> studentList = initStudents();

        List<String> mathSubjects = new ArrayList<>();
        mathSubjects.add("Algebra");
        mathSubjects.add("Geometry");
        Schedule mathSchedule = new Schedule().setDayOfWeek(DayOfWeek.MONDAY).setSubjects(mathSubjects);
        Classroom classroom = new Classroom().setTeacher(teacherList.get(0))
                .setStudents(studentList).setSchedules(List.of(mathSchedule));

        studentService.saveAllStudents(studentList);
        teacherService.saveAllTeachers(teacherList);


        //TODO repository for schedules and classrooms
        //TODO


    }

    private List<Teacher> initTeachers() {
        return List.of(
                new Teacher()
                        .setName("Burkins")
                        .setSubject("Math"),
                new Teacher()
                        .setName("Janson")
                        .setSubject("Science")
        );
    }

    private List<Student> initStudents() {
        return List.of(
                new Student()
                        .setFirstName("Alise")
                        .setLastName("Putnina")
                        .setEmail("alise@putnina.com"),
                new Student()
                        .setFirstName("Bob")
                        .setLastName("Janson")
                        .setEmail("bob@mail.com")
        );
    }
}