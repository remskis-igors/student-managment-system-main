


import com.paremskis.sms.model.Student;
import com.paremskis.sms.persistence.StudentRepository;
import com.paremskis.sms.service.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllStudents() {
        // Arrange
        List<Student> students = new ArrayList<>();
        students.add(new Student(/* Initialize with data */));
        when(studentRepository.findAll()).thenReturn(students);

        // Act
        List<Student> result = studentService.getAllStudents();

        // Assert
        assertEquals(students, result);
        verify(studentRepository, times(1)).findAll();
    }

    @Test
    public void testFindById_ExistingId() {
        // Arrange
        long studentId = 1;
        Student student = new Student(/* Initialize with data */);
        when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));

        // Act
        Optional<Student> result = studentService.findById(studentId);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(student, result.get());
        verify(studentRepository, times(1)).findById(studentId);
    }

    @Test
    public void testFindById_NonExistingId() {
        // Arrange
        long studentId = 1;
        when(studentRepository.findById(studentId)).thenReturn(Optional.empty());

        // Act
        Optional<Student> result = studentService.findById(studentId);

        // Assert
        assertFalse(result.isPresent());
        verify(studentRepository, times(1)).findById(studentId);
    }

    @Test
    public void testFindByEmail() {
        // Arrange
        String email = "test@email.com";
        Student student = new Student();
        when(studentRepository.findByEmail(email)).thenReturn(Optional.of(student));

        // Act
        Optional<Student> result = studentService.findByEmail(email);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(student, result.get());
        verify(studentRepository, times(1)).findByEmail(email);
    }

    @Test
    public void testSaveStudent() {
        // Arrange
        Student student = new Student();
        when(studentRepository.save(student)).thenReturn(student);

        // Act
        Student result = studentService.save(student);

        // Assert
        assertEquals(student, result);
        verify(studentRepository, times(1)).save(student);
    }

    @Test
    public void testDeleteById() {
        // Arrange
        long studentId = 1;
                // Act & Assert
        assertDoesNotThrow(() -> studentService.deleteById(studentId));
        verify(studentRepository, times(1)).deleteById(studentId);
    }

    @Test
    public void testDelete() {
        // Arrange
        Student student = new Student();

        // Act & Assert
        assertDoesNotThrow(() -> studentService.deleteById(student));
        verify(studentRepository, times(1)).delete(student);
    }
}
