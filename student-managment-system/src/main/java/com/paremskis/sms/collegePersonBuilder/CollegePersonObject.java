package com.paremskis.sms.collegePersonBuilder;

public class CollegePersonObject implements CollegePersonBuilder{
    private String name;
    private String surName;
    private String eMail;
    private String personStatus;

    private boolean isDon;
    private boolean payment;


    @Override
    public CollegePersonBuilder setName(String name) {
        this.name =name;
        return this;
    }

    @Override
    public CollegePersonBuilder setSurName(String surName) {
        this.surName = surName;
        return this;
    }

    @Override
    public CollegePersonBuilder setEmail(String eMail) {
        this.eMail = eMail;
        return this;
    }

    @Override
    public CollegePersonBuilder setIsPersonDon(boolean isDon) {
        this.isDon = isDon;
        return this;
    }

    @Override
    public CollegePersonBuilder setPayment(boolean payment) {
        this.payment = payment;
        return this;
    }

    @Override
    public CollegePerson build() {

        return new CollegePerson()
                .setName(name)
                .setSurName(surName)
                .setEmail(eMail)
                .setDon(isDon)
                .setPayment(payment);
    }

}

