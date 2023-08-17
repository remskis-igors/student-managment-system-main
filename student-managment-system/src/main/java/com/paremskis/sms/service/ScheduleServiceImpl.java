package com.paremskis.sms.service;

import com.paremskis.sms.model.Schedule;
import com.paremskis.sms.model.request.AddScheduleRequest;
import com.paremskis.sms.persistence.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    @Transactional
    public Schedule createSchedule(AddScheduleRequest scheduleRequest) {
        Schedule schedule = new Schedule();
        schedule.setDayOfWeek(scheduleRequest.getDayOfWeek());
        schedule.setSubjects(scheduleRequest.getSubjects());

        return scheduleRepository.save(schedule);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteSchedule(Long scheduleId) {
        scheduleRepository.deleteById(scheduleId);
    }
}
