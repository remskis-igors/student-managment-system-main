package com.paremskis.sms.rest.controller;

import com.paremskis.sms.exception.StudentNotFoundException;
import com.paremskis.sms.model.Student;
import com.paremskis.sms.model.mapper.StudentMapper;
import com.paremskis.sms.model.request.AddStudentRequest;
import com.paremskis.sms.persistence.StudentRepository;
import com.paremskis.sms.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;



import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "Student Controller")
@Validated
@RestController
@RequestMapping(path = "/students", produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final StudentRepository studentRepository ;

    //handler method to handle list students and return mode view
    @Operation(summary = "get students", description = "gets all students")
    @GetMapping()
    public Object listStudents() {
        return studentRepository.findAll();
    }

    @PutMapping()
    public Object putStudent(
            @RequestBody @Valid AddStudentRequest addStudentRequest){
        studentRepository.save(StudentMapper.map(addStudentRequest));
        return listStudents();
    }

    @PostMapping(value="/")
    public Student addStudent(@Valid @RequestBody Student std) {
        return studentService.save(std);
    }
    @PutMapping(value="/{id}")
    public Student updateStudent(@PathVariable("id") @Min(1) int id, @Valid @RequestBody Student newstd) {
        Student stdu = studentService.findById(id)
                .orElseThrow(()->new StudentNotFoundException("Student with "+id+" is Not Found!"));
        stdu.setFirstName(newstd.getFirstName());
        stdu.setLastName(newstd.getLastName());
        stdu.setEmail(newstd.getEmail());
        return studentService.save(stdu);
    }
    @GetMapping(value="/{id}")
    public Student getStudentById(@PathVariable("id") @Min(1) int id) {
        Student std = studentService.findById(id)
                .orElseThrow(()->new StudentNotFoundException("Student with "+id+" is Not Found!"));
        return std;
    }
    @DeleteMapping(value="/{id}")
    public String deleteStudent(@PathVariable("id") @Min(1) int id) {
        Student std = studentService.findById(id)
                .orElseThrow(()->new StudentNotFoundException("Student with "+id+" is Not Found!"));
        studentService.deleteById(std.getId());
        return "Student with ID :"+id+" is deleted";
    }

}


