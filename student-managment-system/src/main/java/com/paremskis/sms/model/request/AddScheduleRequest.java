package com.paremskis.sms.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.DayOfWeek;
import java.util.List;

@Data
public class AddScheduleRequest {

    @NotBlank
    private DayOfWeek dayOfWeek;

    @NotBlank
    private List<String> subjects;

}

