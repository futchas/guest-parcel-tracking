package com.futchas.microservice.guesttracking.guest;

import com.futchas.microservice.guesttracking.parcel.ParcelClient;
import com.futchas.microservice.guesttracking.parcel.ParcelRequest;
import com.futchas.microservice.guesttracking.parcel.ParcelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/{applicationName}/guests")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @Autowired
    private ParcelClient parcelClient;

    @PostMapping
    public void storeGuest(@Valid @RequestBody Guest guest) {
        guestService.addGuest(guest);
    }

    @GetMapping("{id}")
    public Guest getGuestById(@PathVariable long id) {
        return guestService.getGuestById(id);
    }

    @GetMapping("{lastname}/{firstName}")
    public Guest getGuestByName(@PathVariable String firstName, @PathVariable String lastName) {
        return guestService.getGuestByName(firstName, lastName);
    }

    @GetMapping
    public List<Guest> getGuests(@RequestParam(required = false) boolean checkedIn) {
        return guestService.getGuests(checkedIn);
    }

    @PostMapping("{lastname}/{firstName}")
    public String takeParcelForGuest(@Valid @RequestBody ParcelRequest parcelRequest) {
        Guest guest = guestService.getGuestByName(parcelRequest.getLastName(), parcelRequest.getFirstName());
        if(guest == null)
            return "Parcel receiver is not a guest!";
        if(guest.getCheckOut() == null) {
            ParcelDto parcelDto = new ParcelDto(guest.getId(), parcelRequest.getParcelCode(),
                    parcelRequest.getDeliveryService());
            parcelClient.storeParcelForGuest(parcelDto);
            return "Guest is still checked in! Parcel was store";
        }
        return "Guest has already checked out on " + guest.getCheckOut();
    }


    @PutMapping("{id}/checkout")
    public String checkoutGuest(@PathVariable long id) {
        guestService.checkoutGuest(id);
        List<ParcelDto> parcelDtos = parcelClient.pickUpParcels(id);
        if(parcelDtos.isEmpty())
            return "No parcel for guest! Guest checkout is successful";

        return "Guest has " + parcelDtos.size() + " parcels stored here!";
    }


}
