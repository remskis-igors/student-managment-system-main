package com.paremskis.sms.collegePersonBuilder;

import lombok.Getter;
public class CollegePerson {

    @Getter
    private String name;
    @Getter
    private String surName;
    @Getter
    private String email;
    @Getter
    private String personStatus;
    @Getter
    public boolean isDon;
    @Getter
    private boolean payment;

    public CollegePerson setName(String name) {
        this.name = name;
        return this;
    }

    public CollegePerson setSurName(String surName) {
        this.surName = surName;
        return this;

    }

    public CollegePerson setEmail(String email) {
        this.email = email;
        return this;
    }

    public CollegePerson setDon(boolean don) {
       this.isDon = don;
        return this;
    }

    public CollegePerson setPayment(boolean payment) {
        this.payment = payment;
        return this;
    }
   @Override
    public String toString() {
        return "Trainable{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", email='" + email + '\'' +
                ", lastPaymentDone=" + payment+
                ", personStatus='" + personStatus + '\'' +
                ", isDon=" + isDon +
                '}';
    }
}
