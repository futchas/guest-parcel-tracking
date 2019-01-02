package com.futchas.microservice.parcelservice.parcel;

// Could be moved to a published shared lib and pulled as a gradle dependency
public class ParcelDto {

    private long guestId;
    private String parcelCode;
    private String deliveryService;

    public ParcelDto(long guestId, String parcelCode, String deliveryService) {
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
}
