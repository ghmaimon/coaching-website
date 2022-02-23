package com.coaching.backend.model;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;


@Embeddable
public class DietPlan {


    @Column(name = "plan_location", nullable = false, length = 500)
    private String planLocation;



    public DietPlan(String planLocation) {
        this.planLocation = planLocation;
    }

    public DietPlan() {

    }


    public String getPlanLocation() {
        return planLocation;
    }

    public void setPlanLocation(String planLocation) {
        this.planLocation = planLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DietPlan dietPlan = (DietPlan) o;
        return planLocation != null && Objects.equals(planLocation, dietPlan.planLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planLocation);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "planLocation = " + planLocation + ")";
    }
}
