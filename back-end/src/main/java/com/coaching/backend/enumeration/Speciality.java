package com.coaching.backend.enumeration;

public enum Speciality {

    FOOD_PROGRAMS("food_programs"),
    FITNESS("fitness"),
    YOGA("yoga"),
    MARTIAL_ARTS("martial_art"),
    WEIGHT_LIFTING("weight_lifting");

    private String value;

    Speciality(String value) {
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
