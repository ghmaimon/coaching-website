package com.coaching.backend.model;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @NotNull(message = "Client is required")
    private Client client;

    @NotNull(message = "Price is required")
    private long price;

    @NotNull(message = "Acceptance date is required")
    private Date AcceptanceDate;

    @NotNull(message = "Offer is required")
    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "offer_id")
    private Offer offer;

    private boolean paid;

    public Contract() {}

    public Contract(Long id, Client client, long price, Date acceptanceDate, Offer offer, boolean paid) {
        this.id = id;
        this.client = client;
        this.price = price;
        this.offer = offer;
        this.paid = paid;
        this.AcceptanceDate = acceptanceDate;
    }

    public Contract(Client client, long price, Date acceptanceDate, Offer offer, boolean paid) {
        this.client = client;
        this.price = price;
        AcceptanceDate = acceptanceDate;
        this.offer = offer;
        this.paid = paid;
    }


    public Offer getOffer() {
        return offer;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Long getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Date getAcceptanceDate() {
        return AcceptanceDate;
    }

    public void setAcceptanceDate(Date acceptanceDate) {
        AcceptanceDate = acceptanceDate;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }
}
