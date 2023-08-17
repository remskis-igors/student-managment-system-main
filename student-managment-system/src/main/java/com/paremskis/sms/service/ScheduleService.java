package com.paremskis.sms.service;
import com.paremskis.sms.model.Schedule;
import com.paremskis.sms.model.request.AddScheduleRequest;

import java.util.List;

public interface ScheduleService {

    Schedule createSchedule(AddScheduleRequest scheduleRequest);

    List<Schedule> getAllSchedules();

    void deleteSchedule(Long scheduleId);
}