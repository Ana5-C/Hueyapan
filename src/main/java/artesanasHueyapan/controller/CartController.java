package artesanasHueyapan.controller;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
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

import artesanasHueyapan.dto.CartRequestDTO;
import artesanasHueyapan.dto.ProductCartDTO;
import artesanasHueyapan.model.Cart;
import artesanasHueyapan.model.Product;
import artesanasHueyapan.model.ProductCart;
import artesanasHueyapan.service.CartService;
import artesanasHueyapan.service.ProductService;

@RestController
@RequestMapping("/carts")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ModelMapper modelMapper;

    // Buscar por ID
    @GetMapping("/{idCart}")
    public ResponseEntity<Cart> getByIdCart(@PathVariable Long idCart) {
        return new ResponseEntity<Cart>(cartService.getByIdCart(idCart), HttpStatus.OK);
    }

    // Crea un carrito
    @PostMapping
    public ResponseEntity<Cart> add(
            @RequestBody CartRequestDTO cartRequestDTO) {
        Cart savedCart = cartService.save(convertToEntity(cartRequestDTO));
        return new ResponseEntity<Cart>(savedCart, HttpStatus.CREATED);
    }

    public Cart convertToEntity(CartRequestDTO cartRequestDTO) {
        List<ProductCartDTO> productCartDTOs = cartRequestDTO.getProductCartDTOs();
        List<ProductCart> productCarts = productCartDTOs.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        Cart cart = modelMapper.map(cartRequestDTO, Cart.class);
        cart.setProductsCart(productCarts);

        Iterator<ProductCartDTO> productCartDTOIterator = productCartDTOs.iterator();
        Iterator<ProductCart> productCartIterator = productCarts.iterator();

        while (productCartDTOIterator.hasNext()) {
            ProductCartDTO productCartDTO = productCartDTOIterator.next();
            ProductCart productCart = productCartIterator.next();
            Product managedProduct = productService.getByIdProduct(productCartDTO.getProductId());

            productCart.setProduct(managedProduct);
            productCart.setCart(cart);
        }
        return cart;
    }

    private ProductCart convertToDTO(ProductCartDTO productCartDTO) {
        return modelMapper.map(productCartDTO, ProductCart.class);
    }

    // actualiza un carrito
    @PutMapping("/{idCart}")
    public ResponseEntity<?> update(@RequestBody Cart cart, @PathVariable Long idCart) {
        Cart auxCart = cartService.getByIdCart(idCart);
        cart.setIdCart(auxCart.getIdCart());
        cartService.save(cart);
        return new ResponseEntity<String>("updated", HttpStatus.OK);
    }

    // elimina carrito
    @DeleteMapping("/{idCart}")
    public ResponseEntity<?> delete(@PathVariable Long idCart) {
        cartService.delete(idCart);
        return new ResponseEntity<String>("Delete", HttpStatus.OK);
    }

}
