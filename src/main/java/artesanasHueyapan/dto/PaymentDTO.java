package artesanasHueyapan.dto;

public class PaymentDTO {
    private Long idPayment;
    private Integer total;
    private String date;
    private String paymentMethod;
    public Long getIdPayment() {
        return idPayment;
    }
    public void setIdPayment(Long idPayment) {
        this.idPayment = idPayment;
    }
    public Integer getTotal() {
        return total;
    }
    public void setTotal(Integer total) {
        this.total = total;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    

}
