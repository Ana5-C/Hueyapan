package artesanasHueyapan.controller;

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

import artesanasHueyapan.dto.ProductRequestDTO;
import artesanasHueyapan.model.Product;
import artesanasHueyapan.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
   @Autowired
    private ProductService productService;

    @Autowired
    private ModelMapper modelMapper;

     @GetMapping("/{idProduct}")
    public ResponseEntity<Product> findByIdProduct(@PathVariable Long idProduct) {
        return new ResponseEntity<Product>(productService.getByIdProduct(idProduct), HttpStatus.OK);
    }

    // crea un producto
  @PostMapping
    public ResponseEntity<ProductRequestDTO> add(
            @RequestBody ProductRequestDTO productRequestDTO) {
        ProductRequestDTO savedProductRequestDTO = convertToDTO(
                productService.save(convertToEntity(productRequestDTO)));
        return new ResponseEntity<ProductRequestDTO>(savedProductRequestDTO, HttpStatus.CREATED);
    }

    public Product convertToEntity(ProductRequestDTO productRequestDTO) {
        return modelMapper.map(productRequestDTO, Product.class);
    }

    private ProductRequestDTO convertToDTO(Product product) {
        return modelMapper.map(product, ProductRequestDTO.class);
    }

    // Actualiza un producto
      @PutMapping("/{idProduct}")
    public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Long idProduct) {
        Product auxProduct = productService.getByIdProduct(idProduct);
        product.setIdProduct(auxProduct.getIdProduct());
        return new ResponseEntity<String>("Updated", HttpStatus.OK);
    }

    // Elimina un producto
@DeleteMapping("/{idProduct}")
    public ResponseEntity<?> delete(@PathVariable Long idProduct) {
        productService.delete(idProduct);
        return new ResponseEntity<String>("Delete", HttpStatus.OK);
    }
}
