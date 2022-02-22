package com.coaching.backend.model;

import javax.persistence.Entity;
import java.time.Duration;
import java.util.Date;

@Entity
public class TrainingContract extends Contract{

    private Duration duration;

    private long daysInWeek;

    private long hoursInDay;

    public TrainingContract(Long id, Client client, Offer offer, long price, boolean paid, Duration duration, long daysInWeek, long hoursInDay) {
        super(id, client, price, new Date(), offer, paid);
        this.duration = duration;
        this.daysInWeek = daysInWeek;
        this.hoursInDay = hoursInDay;
    }

    public TrainingContract() {}

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public long getDaysInWeek() {
        return daysInWeek;
    }

    public void setDaysInWeek(long daysInWeek) {
        this.daysInWeek = daysInWeek;
    }

    public long getHoursInDay() {
        return hoursInDay;
    }

    public void setHoursInDay(long hoursInDay) {
        this.hoursInDay = hoursInDay;
    }
}
