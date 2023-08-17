package com.paremskis.sms.rest.controller;

import com.paremskis.sms.exception.StudentNotFoundException;
import com.paremskis.sms.model.Teacher;
import com.paremskis.sms.model.mapper.TeacherMapper;
import com.paremskis.sms.model.request.AddTeacherRequest;
import com.paremskis.sms.persistence.TeacherRepository;
import com.paremskis.sms.service.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;



import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "Teacher Controller")
@Validated
@RestController
@RequestMapping(path = "/teachers", produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;
    private final TeacherRepository teacherRepository; //TODO remove

    //handler method to handle list students and return mode view
    @Operation(summary = "teachers", description = "gets all teachers")
    @GetMapping()
    public Object listTeacher() {
        return teacherRepository.findAll();
    }

    @PutMapping()
    public Object putTeachers(
            @RequestBody @Valid AddTeacherRequest addTeacherRequest) {
        teacherRepository.save(TeacherMapper.map(addTeacherRequest)); //TODO move business logic to service
        return listTeacher();
    }

    @PostMapping(value = "/")
    public Teacher addTeacher(@Valid @RequestBody Teacher tch) {
        return teacherService.save(tch);
    }

    @PutMapping(value = "/{id}")
    public Teacher updateTeacher(@PathVariable("id") @Min(1) int id, @Valid @RequestBody Teacher tch) {
        Teacher teacher = teacherService.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with " + id + " is Not Found!"));
        teacher.setName(tch.getName());
        teacher.setSubject(tch.getSubject());
        return teacherService.save(teacher);
    }

    @GetMapping(value = "/{id}")
    public Teacher getTeacherById(@PathVariable("id") @Min(1) int id) {
        Teacher teacher = teacherService.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with " + id + " is Not Found!"));
        return teacher;
    }

    @DeleteMapping(value = "/{id}")
    public String deleteTeacher(@PathVariable("id") @Min(1) int id) {
        Teacher teacher = teacherService.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with " + id + " is Not Found!"));
        teacherService.deleteById(teacher.getId());
        return "Student with ID :" + id + " is deleted";
    }

}


