package com.coaching.backend.model;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class MealContract extends Contract{

    private boolean delivered;
    private boolean accepted;

    public MealContract() {}

    public MealContract(Long id, Client client, long price, Date acceptanceDate, Offer offer, boolean paid, boolean delivered, boolean accepted) {
        super(id, client, price, acceptanceDate, offer, paid);
        this.delivered = delivered;
        this.accepted = accepted;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
}
