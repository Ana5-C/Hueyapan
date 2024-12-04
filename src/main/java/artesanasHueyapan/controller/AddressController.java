package artesanasHueyapan.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import artesanasHueyapan.dto.AddressDTO;
import artesanasHueyapan.model.Address;
import artesanasHueyapan.service.AddressService;

@Controller
public class AddressController {
    
    @Autowired
    private AddressService addressService;

    @Autowired
    private ModelMapper modelMapper;

    @QueryMapping
    public List<Address> getAllAddresses() {
        return addressService.getAll();
    }

    @QueryMapping
    public Address getIdAddress(@Argument Long idAddress) {
        return addressService.getIdAddress(idAddress);
    }

    @MutationMapping
    public Address createAddress(@Argument(value = "address") AddressDTO addressDTO) {
        return addressService.save(convertToEntity(addressDTO));
    }

    // Mutación para actualizar
    @MutationMapping
    public Address updateAddress(@Argument Long idAddress, @Argument(value = "address") AddressDTO addressDTO) {
        Address existingAddress = addressService.getIdAddress(idAddress);
        if (existingAddress != null) {
            Address updatedAddress = convertToEntity(addressDTO);
            updatedAddress.setIdAddress(idAddress); // Mantener el ID del objeto existente
            return addressService.save(updatedAddress);
        }
        // Si no se encuentra, simplemente devuelve null
        return null;
    }

    // Mutación para eliminar
    @MutationMapping
    public String deleteAddress(@Argument Long idAddress) {
        Address address = addressService.getIdAddress(idAddress);
        if (address != null) {
            addressService.delete(idAddress);
            return "Address deleted successfully with id: " + idAddress;
        }
        // Si no se encuentra, devuelve un mensaje básico
        return "Address not found with id: " + idAddress;
    }

    // Conversión DTO <-> Entidad
    public Address convertToEntity(AddressDTO addressDTO) {
        return modelMapper.map(addressDTO, Address.class);
    }

    public AddressDTO convertToDTO(Address address) {
        return modelMapper.map(address, AddressDTO.class);
    }

}
