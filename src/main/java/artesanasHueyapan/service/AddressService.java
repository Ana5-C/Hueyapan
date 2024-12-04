package artesanasHueyapan.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import artesanasHueyapan.model.Address;
import artesanasHueyapan.repository.AddressRepository;

@Service
@Transactional
public class AddressService {
     @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAll(){
        return addressRepository.findAll();
    }

    public Address save(Address address){
        return addressRepository.save(address);
    }
    
    public Address getIdAddress(Long idAddress){
        return addressRepository.findById(idAddress).get();
    }

    public void delete (Long idAddress){
        addressRepository.deleteById(idAddress);
    }

}
