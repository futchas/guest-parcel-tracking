package com.futchas.microservice.guesttracking.guest;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

//    @Column(name = "firstName")
    @NotBlank
    @Size(min=2, message="First name should have at least 2 characters")
    private String firstName;

//    @Column(name = "lastName")
    @NotBlank
    @Size(min=2, message="Last name should have at least 2 characters")
    private String lastName;

    private LocalDateTime checkIn;
    private LocalDateTime checkOut;

//    private List<ParcelRequest> parcels;
//
//    public List<ParcelRequest> pickUpParcels() {
//        return parcels;
//    }
//
//    public void addParcels(ParcelRequest parcel) {
//        this.parcels.add(parcel);
//    }

    public Guest() {
        checkIn = LocalDateTime.now();
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckOut() {
        this.checkOut = LocalDateTime.now();;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }
}
