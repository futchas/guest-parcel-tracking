package com.futchas.microservice.guesttracking.guest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {

    Guest findByLastNameAndFirstName(String lastName, String firstName);
}
