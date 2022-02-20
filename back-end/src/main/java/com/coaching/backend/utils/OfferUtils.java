package com.coaching.backend.utils;

import com.coaching.backend.model.Coach;

public class OfferUtils {
    /**
     * this is a method that will be used to hide details of the coach like
     * password, email ... from being returned to a client,
     * it will leave just the id, firstName, lastName, and specialities
     * @param coach the coach
     * @return the coach without personal information
     */
    public static Coach getCoachWithoutPersonalDetails(Coach coach) {
        Coach newCoach = new Coach();
        newCoach.setId(coach.getId());
        newCoach.setFirstName(coach.getFirstName());
        newCoach.setLastName(coach.getLastName());
        newCoach.setSpecialities(coach.getSpecialities());
        return newCoach;
    }
}
