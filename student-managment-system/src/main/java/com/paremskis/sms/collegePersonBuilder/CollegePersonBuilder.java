package com.paremskis.sms.collegePersonBuilder;


public interface CollegePersonBuilder {

    public CollegePersonBuilder setName(String name);
    public CollegePersonBuilder setSurName(String surName);
    public CollegePersonBuilder setEmail(String eMail);
    public CollegePersonBuilder setIsPersonDon(boolean isDon);
    public CollegePersonBuilder setPayment(boolean payment);
    public CollegePerson build();

}
