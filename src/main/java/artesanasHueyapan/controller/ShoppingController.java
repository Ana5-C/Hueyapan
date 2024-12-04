package artesanasHueyapan.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import artesanasHueyapan.dto.ShoppingDTO;
import artesanasHueyapan.model.Shopping;
import artesanasHueyapan.service.ShoppingService;

@Controller
public class ShoppingController {
    @Autowired
    private ShoppingService shoppingService;

    @Autowired
    private ModelMapper modelMapper;

    // Consultas
    @QueryMapping
    public List<Shopping> getAllShoppings() {
        return shoppingService.getAll();
    }

    @QueryMapping
    public Shopping getIdShopping(@Argument Long idShopping) {
        return shoppingService.getIdShopping(idShopping);
    }

    // Mutación para crear
    @MutationMapping
    public Shopping createShopping(@Argument(value = "shopping") ShoppingDTO shoppingDTO) {
        return shoppingService.save(convertToEntity(shoppingDTO));  
    }

    // Mutación para actualizar
    @MutationMapping
    public Shopping updateShopping(@Argument Long idShopping, @Argument(value = "shopping") ShoppingDTO shoppingDTO) {
        Shopping existingShopping = shoppingService.getIdShopping(idShopping);
        if (existingShopping != null) {
            Shopping updatedShopping = convertToEntity(shoppingDTO);
            updatedShopping.setIdShopping(idShopping); // Mantener el ID del objeto existente
            return shoppingService.save(updatedShopping);
        }
        // Si no se encuentra, simplemente devuelve null
        return null;
    }

    // Mutación para eliminar
    @MutationMapping
    public String deleteShopping(@Argument Long idShopping) {
        Shopping shopping = shoppingService.getIdShopping(idShopping);
        if (shopping != null) {
            shoppingService.delete(idShopping);
            return "Shopping item deleted successfully with id: " + idShopping;
        }
        // Si no se encuentra, devuelve un mensaje básico
        return "Shopping item not found with id: " + idShopping;
    }

    // Conversión DTO <-> Entidad
    public Shopping convertToEntity(ShoppingDTO shoppingDTO) {
        return modelMapper.map(shoppingDTO, Shopping.class);
    }

    public ShoppingDTO convertToDTO(Shopping shopping) {
        return modelMapper.map(shopping, ShoppingDTO.class);
    }
}
