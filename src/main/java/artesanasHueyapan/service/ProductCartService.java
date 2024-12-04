package artesanasHueyapan.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import artesanasHueyapan.model.ProductCart;
import artesanasHueyapan.repository.ProductCartRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductCartService {
    @Autowired
    private ProductCartRepository productCartRepository;

    public List<ProductCart> getAll(){
        return productCartRepository.findAll();
    }

    public void save(ProductCart productCart){
        productCartRepository.save(productCart);
    }
}