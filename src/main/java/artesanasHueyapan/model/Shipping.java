package artesanasHueyapan.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "shipping")
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    @Column(name = "id_shipping")
    private Long idShipping;
    
    @NotBlank(message = "The content must not be null and must contain at least one non-whitespace character ")
    @Size(min = 1, max = 500, message = "The content must be at most 500 characteres, and has at least one character")
    @Column(name = "paqueteria")
    @JsonProperty("paqueteria")
    private String parcel;
   
    @NotBlank(message = "The content must not be null and must contain at least one non-whitespace character ")
    @Size(min = 1, max = 30, message = "The content must be at most 500 characteres, and has at least one character")
    @Column(name = "numero_seguimiento")
    @JsonProperty("numero_seguimiento")
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