import com.paremskis.sms.model.Teacher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeacherTest {
    @Test
    public void testTeacherCreation() {
        Teacher teacher = new Teacher();
        teacher.setName("Mr. Smith");
        teacher.setSubject("Math");
        assertEquals("Mr. Smith", teacher.getName());
        assertEquals("Math", teacher.getSubject());
    }
}