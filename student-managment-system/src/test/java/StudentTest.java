import com.paremskis.sms.model.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {
    @Test
    public void testStudentCreation() {
        Student student = new Student();
        student.setFirstName("Alise");
        student.setLastName("Putnina");
        student.setEmail("alise@putnina.com");

        assertEquals("Alise", student.getFirstName());
        assertEquals("Putnina", student.getLastName());
        assertEquals("alise@putnina.com", student.getEmail());
    }
}