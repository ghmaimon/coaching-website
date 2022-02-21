package com.coaching.backend.model;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author oubaydos
 * @assigned mimoun
 * @todo handle storing the files in the database
 */
@Embeddable
public class DietPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "plan_location", nullable = false, length = 500)
    private String planLocation;

    public DietPlan(Long id, String planLocation) {
        this.id = id;
        this.planLocation = planLocation;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DietPlan dietPlan = (DietPlan) o;
        return id != null && Objects.equals(id, dietPlan.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "planLocation = " + planLocation + ")";
    }
}
