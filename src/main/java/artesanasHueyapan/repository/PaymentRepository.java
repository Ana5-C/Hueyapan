package artesanasHueyapan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import artesanasHueyapan.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
