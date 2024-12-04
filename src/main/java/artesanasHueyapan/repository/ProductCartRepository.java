package artesanasHueyapan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import artesanasHueyapan.model.ProductCart;

public interface ProductCartRepository extends JpaRepository <ProductCart, Long> {

}
