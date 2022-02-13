package com.coaching.backend.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "client_id")
    @NotNull(message = "Client is required")
    private Client client;

    @NotNull(message = "Price is required")
    private long price;

    @NotNull(message = "Acceptance date is required")
    private Date AcceptanceDate;

    public Contract() {}

    public Contract(Long id, Client client, long price, Date acceptanceDate, boolean paid) {
        this.id = id;
        this.client = client;
        this.price = price;
        this.paid = paid;
        this.AcceptanceDate = acceptanceDate;
    }

    private boolean paid;

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
}
