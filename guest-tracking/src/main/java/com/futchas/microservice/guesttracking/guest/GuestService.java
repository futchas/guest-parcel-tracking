package com.futchas.microservice.guesttracking.guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public void addGuest(Guest guest) {
        guestRepository.save(guest);
    }

    public Guest getGuestById(long id) {
        return guestRepository.findById(id).orElse(null);
    }

    public List<Guest> getGuests(boolean checkedIn) {
        List<Guest> guestList = guestRepository.findAll();
        if(checkedIn)
            return guestList.stream().filter(g -> g.getCheckOut() == null).collect(Collectors.toList());
        return guestList;
    }

    public void checkoutGuest(long id) {
        Guest guest = guestRepository.getOne(id);
        guest.setCheckOut();
        guestRepository.save(guest);
    }


    public Guest getGuestByName(String lastName, String firstName) {
        return guestRepository.findByLastNameAndFirstName(lastName, firstName);
    }
}
