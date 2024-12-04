package artesanasHueyapan.controller;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import artesanasHueyapan.dto.ShippingDTO;
import artesanasHueyapan.model.Shipping;
import artesanasHueyapan.service.ShippingService;

@Controller
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    @Autowired
    private ModelMapper modelMapper;

    @QueryMapping
    public List<Shipping> getAll() {
        return shippingService.getAll();
    }

    @QueryMapping
    public Shipping getIdShipping(@Argument Long idShipping) {
        return shippingService.getIdShipping(idShipping);
    }

    @MutationMapping
    public Shipping createShipping(@Argument(value = "shipping") ShippingDTO shippingDTO) {
        return shippingService.save(convertToEntity(shippingDTO));
    }

    // Mutación para actualizar
    @MutationMapping
    public Shipping updateShipping(@Argument Long idShipping, @Argument(value = "shipping") ShippingDTO shippingDTO) {
        Shipping existingShipping = shippingService.getIdShipping(idShipping);
        if (existingShipping != null) {
            Shipping updatedShipping = convertToEntity(shippingDTO);
            updatedShipping.setIdShipping(idShipping); // Mantener el ID del objeto existente
            return shippingService.save(updatedShipping);
        }
        // Si no se encuentra, simplemente devuelve null
        return null;
    }

    // Mutación para eliminar
    @MutationMapping
    public String deleteShipping(@Argument Long idShipping) {
        Shipping shipping = shippingService.getIdShipping(idShipping);
        if (shipping != null) {
            shippingService.delete(idShipping);
            return "Shipping deleted successfully with id: " + idShipping;
        }
        // Si no se encuentra, devuelve un mensaje básico
        return "Shipping not found with id: " + idShipping;
    }

    // Conversión DTO <-> Entidad
    public Shipping convertToEntity(ShippingDTO shippingDTO) {
        return modelMapper.map(shippingDTO, Shipping.class);
    }

    public ShippingDTO convertToDTO(Shipping shipping) {
        return modelMapper.map(shipping, ShippingDTO.class);
    }

}