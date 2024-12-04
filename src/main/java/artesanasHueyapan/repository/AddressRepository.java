package artesanasHueyapan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import artesanasHueyapan.model.Address;

public interface AddressRepository extends JpaRepository <Address, Long> {

}
