import com.paremskis.sms.model.Schedule;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScheduleTest {
    @Test
    public void testScheduleCreation() {
        List<String> subjects = Arrays.asList("Math", "Science");
        Schedule schedule = new Schedule(DayOfWeek.MONDAY, subjects);

        assertEquals(DayOfWeek.MONDAY, schedule.getDayOfWeek());
        assertEquals(subjects, schedule.getSubjects());
    }
}

