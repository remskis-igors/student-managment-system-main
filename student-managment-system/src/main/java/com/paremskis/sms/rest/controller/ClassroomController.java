package com.paremskis.sms.rest.controller;

import com.paremskis.sms.model.Classroom;
import com.paremskis.sms.service.ClassroomService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "Classroom Controller")
@Validated
@RestController
@RequestMapping(path = "/classroom", produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor

public class ClassroomController {

    private final ClassroomService classroomService;

    @PostMapping
    public ResponseEntity<Classroom> createClassroom(@RequestBody @Valid Classroom classroom) {
        Classroom createdClassroom = classroomService.createClassroom(classroom);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClassroom);
    }

    @GetMapping
    public ResponseEntity<List<Classroom>> getAllClassrooms() {
        List<Classroom> classrooms = classroomService.getAllClassrooms();
        return ResponseEntity.ok(classrooms);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Classroom> getClassroomById(@PathVariable Long id) {
        Optional<Classroom> classroom = classroomService.getClassroomById(id);
        return classroom.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClassroom(@PathVariable Long id) {
        classroomService.deleteClassroom(id);
        return ResponseEntity.noContent().build();
    }
}
