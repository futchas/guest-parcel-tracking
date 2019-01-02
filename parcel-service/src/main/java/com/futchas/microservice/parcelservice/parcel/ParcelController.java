package com.futchas.microservice.parcelservice.parcel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{applicationName}/parcels")
public class ParcelController {

    @Autowired
    private ParcelService parcelService;

    @PostMapping
    public void addParcel(@RequestBody ParcelDto parcel) {
        parcelService.addParcel(parcel);
    }

    @GetMapping
    public List<Parcel> getAllParcels() {
        return parcelService.getParcels();
    }

    @GetMapping ("{guestId}")
    public List<ParcelDto> pickUpParcelsByGuest(@PathVariable int guestId) {
        return parcelService.pickUpParcelsByGuestId(guestId);
    }

}
