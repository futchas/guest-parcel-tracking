package com.futchas.microservice.parcelservice.parcel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Parcel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private long guestId;

    private String parcelCode;
    private String deliveryService;
    private boolean pickedUp;

    public Parcel() {
    }

    public Parcel(long guestId, String parcelCode, String deliveryService) {
        this.guestId = guestId;
        this.parcelCode = parcelCode;
        this.deliveryService = deliveryService;
    }

    public long getGuestId() {
        return guestId;
    }

    public void setGuestId(long guestId) {
        this.guestId = guestId;
    }

    public String getParcelCode() {
        return parcelCode;
    }

    public void setParcelCode(String parcelCode) {
        this.parcelCode = parcelCode;
    }

    public String getDeliveryService() {
        return deliveryService;
    }

    public void setDeliveryService(String deliveryService) {
        this.deliveryService = deliveryService;
    }

    public boolean isPickedUp() {
        return pickedUp;
    }

    public void setPickedUp() {
        this.pickedUp = true;
    }
}

