package com.paremskis.sms.rest.controller;
import com.paremskis.sms.model.Schedule;
import com.paremskis.sms.model.request.AddScheduleRequest;
import com.paremskis.sms.service.ScheduleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@Tag(name = "Schedule Controller")
@Validated
@RestController
@RequestMapping(path = "/schedules", produces = APPLICATION_JSON_VALUE)
//@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    public ResponseEntity<Schedule> createSchedule(@RequestBody @Valid AddScheduleRequest request) {
        Schedule createdSchedule = scheduleService.createSchedule(request);
        return ResponseEntity.ok(createdSchedule);
    }

    @GetMapping
    public ResponseEntity<List<Schedule>> getAllSchedules() {
        List<Schedule> schedules = scheduleService.getAllSchedules();
        return ResponseEntity.ok(schedules);
    }

    @DeleteMapping("/{scheduleId}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long scheduleId) {
        scheduleService.deleteSchedule(scheduleId);
        return ResponseEntity.noContent().build();
    }
}