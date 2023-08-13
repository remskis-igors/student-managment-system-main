package com.paremskis.sms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
    private DayOfWeek dayOfWeek;
    private List<String> subjects;
}