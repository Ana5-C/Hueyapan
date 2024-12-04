package artesanasHueyapan.dto;

public class ShippingDTO {

    private Long idShipping;
    private String parcel;
    private String trackingNumber;
    
    public Long getIdShipping() {
        return idShipping;
    }
    public void setIdShipping(Long idShipping) {
        this.idShipping = idShipping;
    }
    public String getParcel() {
        return parcel;
    }
    public void setParcel(String parcel) {
        this.parcel = parcel;
    }
    public String getTrackingNumber() {
        return trackingNumber;
    }
    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    
}
