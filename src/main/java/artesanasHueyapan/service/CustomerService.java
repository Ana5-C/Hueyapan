package artesanasHueyapan.service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import artesanasHueyapan.model.Customer;
import artesanasHueyapan.repository.CustomerRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    public List<Customer> getAll(int page,  int pageSize){
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        Page<Customer> customer = customerRepository.findAll(pageRequest);
        return customer.getContent();
    }
    
    public void save(Customer customer){
        customerRepository.save(customer);
    }

    public Customer getIdCustomer(Long idCustomer){
        return customerRepository.findById(idCustomer).get();
    }

    public void delete(Long idCustomer){
        customerRepository.deleteById(idCustomer);
    }
}
