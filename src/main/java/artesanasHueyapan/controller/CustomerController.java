package artesanasHueyapan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import artesanasHueyapan.model.Customer;
import artesanasHueyapan.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/{idCustomer}")
    public ResponseEntity<Customer> getIdCustomer(@PathVariable Long idCustomer) {
        return new ResponseEntity<Customer>(customerService.getIdCustomer(idCustomer), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<?> create(@RequestBody Customer customer) {
        customerService.save(customer);
        return new ResponseEntity<String>("saved", HttpStatus.OK);
    }


    @PutMapping("/{idCustomer}")
    public ResponseEntity<?> update(@RequestBody Customer customer, @PathVariable Long idCustomer) {
        Customer auxCustomer = customerService.getIdCustomer(idCustomer);
        customer.setIdCustomer(auxCustomer.getIdCustomer());
        customerService.save(customer);
        return new ResponseEntity<String>("Updated", HttpStatus.OK);
    }

    
    @DeleteMapping("/{idCustomer}")
    public ResponseEntity<?> delete(@PathVariable Long idCustomer) {
        customerService.delete(idCustomer);
        return new ResponseEntity<String>("Delete", HttpStatus.OK);
    }
}
