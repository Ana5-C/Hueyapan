package artesanasHueyapan.dto;

import java.time.LocalDate;

public class ShoppingDTO {
    private Long idShopping;
    private Integer amount;
    private LocalDate date;
    private Integer phoneNumber;
    private Integer total;
    public Long getIdShopping() {
        return idShopping;
    }
    public void setIdShopping(Long idShopping) {
        this.idShopping = idShopping;
    }
    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public Integer getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Integer getTotal() {
        return total;
    }
    public void setTotal(Integer total) {
        this.total = total;
    }

   
    
    

    
}
