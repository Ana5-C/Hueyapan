package artesanasHueyapan.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import artesanasHueyapan.model.Shopping;
import artesanasHueyapan.repository.ShoppingRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ShoppingService {

    @Autowired
    private ShoppingRepository shoppingRepository;

    public List<Shopping> getAll(){
        return shoppingRepository.findAll();
    }

    public Shopping save(Shopping shopping){
        return shoppingRepository.save(shopping);
    }

    public Shopping getIdShopping(Long idShopping){
        return shoppingRepository.findById(idShopping).get();
    }

    public void delete(Long idShopping){
        shoppingRepository.deleteById(idShopping);
    }
}
