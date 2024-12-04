package artesanasHueyapan.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    @Column(name = "id_cart")
    private Long idCart;
    
    @NotBlank(message = "The content not be blank")
    @Size(min = 1, max = 10, message = "The content must be at most 10")
    @Column(name = "fecha")
    @JsonProperty("fecha")
    private String dateCreated;

    
    @OneToOne
    @JoinColumn(name = "id_customer", referencedColumnName = "id_customer")
    private Customer customers;  


    
    @JsonManagedReference
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductCart> productsCart;

}