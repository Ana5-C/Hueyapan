package artesanasHueyapan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import artesanasHueyapan.model.Customer;


public interface CustomerRepository extends JpaRepository <Customer, Long>  {
    }


