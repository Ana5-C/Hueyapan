package artesanasHueyapan.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import artesanasHueyapan.model.Cart;
import artesanasHueyapan.repository.CartRepository;
import jakarta.transaction.Transactional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public List<Cart> getAll() {
        return cartRepository.findAll();
    }

    @Transactional
    public Cart save (Cart cart){
        return cartRepository.save(cart);
    }
    /*public void save(Cart cart) {
        cartRepository.save(cart);
    }*/

    public Cart getByIdCart(Long idCart) {
        return cartRepository.findById(idCart).get();
    }

    public void delete(Long idCart) {
        cartRepository.deleteById(idCart);
    }
}
