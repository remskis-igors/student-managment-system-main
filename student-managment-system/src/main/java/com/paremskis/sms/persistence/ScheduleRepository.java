package com.paremskis.sms.persistence;

import com.paremskis.sms.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.Optional;


@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    Optional<Schedule> findByDayOfWeek(DayOfWeek dayOfWeek);

}

