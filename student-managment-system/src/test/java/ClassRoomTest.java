import com.paremskis.sms.model.Classroom;
import com.paremskis.sms.model.Student;
import com.paremskis.sms.model.Teacher;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClassRoomTest {
    @Test
    public void testClassroomCreation() {
        Teacher teacher = new Teacher();
        teacher.setName("Petersons").setName("Math");

        Student student1 = new Student();
        student1.setFirstName("Alise");
        student1.setLastName("Putnina");
        student1.setEmail("alicse@putnina.lv");

        List<Student> students = new ArrayList<>();
        students.add(student1);

        Classroom classroom = new Classroom("Math Class", teacher, students, null);

        assertEquals("Math Class", classroom.getName());
        assertEquals(teacher, classroom.getTeacher());
        assertEquals(students, classroom.getStudents());
    }
}
