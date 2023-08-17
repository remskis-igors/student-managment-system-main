package com.paremskis.sms.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AddTeacherRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String subject;


}

