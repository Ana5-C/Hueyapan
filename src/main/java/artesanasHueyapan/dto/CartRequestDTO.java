package artesanasHueyapan.dto;


import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class CartRequestDTO {
    
    private Long id;

    @NotBlank(message = "The content not be blank")
    @Size(min = 1, max = 10, message = "The content must be at most 10")
    private String  dateCreated;

    
    private Long customerId;
    private List<ProductCartDTO> productCartDTOs;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDateCreated() {
        return dateCreated;
    }
    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
    public Long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public List<ProductCartDTO> getProductCartDTOs() {
        return productCartDTOs;
    }
    public void setProductCartDTOs(List<ProductCartDTO> productCartDTOs) {
        this.productCartDTOs = productCartDTOs;
    }
    
   

    
}