package artesanasHueyapan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import artesanasHueyapan.model.ProductCart;
import artesanasHueyapan.service.ProductCartService;

@RestController
@RequestMapping("/productsCarts")
public class ProductCartController {

     @Autowired
    private ProductCartService productCartService;

 /*    @ApiResponse(responseCode = "200", description = "Found product carts", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProductCart.class)))
    }) */
    @GetMapping
    public List<ProductCart> getAll() {
        return productCartService.getAll();
    }

}
