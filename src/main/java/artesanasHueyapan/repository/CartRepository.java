package artesanasHueyapan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import artesanasHueyapan.model.Cart;

public interface CartRepository extends JpaRepository <Cart,Long> {

}
