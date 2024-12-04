package artesanasHueyapan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import artesanasHueyapan.model.Shopping;

public interface ShoppingRepository extends JpaRepository<Shopping, Long>{
     //Fecha
    @Query(value = "SELECT * FROM shopping WHERE date = :date AND phone_number = :phoneNumber", nativeQuery = true)
    List<Shopping> getShoppingByDateAndPhoneNumber(@Param("date") String date, @Param("phoneNumber") String phoneNumber);
    
    @Query(value = "SELECT s FROM Shopping s WHERE s.date = :date AND s.phoneNumber = :phoneNumber")
    List<Shopping> getShoppingByDateAndPhoneNumberJPQL(@Param("date") String date, @Param("phoneNumber") String phoneNumber);


}
