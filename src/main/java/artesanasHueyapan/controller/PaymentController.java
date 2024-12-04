package artesanasHueyapan.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import artesanasHueyapan.dto.PaymentDTO;
import artesanasHueyapan.model.Payment;
import artesanasHueyapan.service.PaymentService;

@Controller
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ModelMapper modelMapper;

    // Consultas
    @QueryMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAll();
    }

    @QueryMapping
    public Payment getIdPayment(@Argument Long idPayment) {
        return paymentService.getIdPayment(idPayment);
    }

    // Mutaciones
    @MutationMapping
    public Payment createPayment(@Argument(value = "payment") PaymentDTO paymentDTO) {
        return paymentService.save(convertToEntity(paymentDTO));
    }

    // Mutación para actualizar
    @MutationMapping
    public Payment updatePayment(@Argument Long idPayment, @Argument(value = "payment") PaymentDTO paymentDTO) {
        Payment existingPayment = paymentService.getIdPayment(idPayment);
        if (existingPayment != null) {
            Payment updatedPayment = convertToEntity(paymentDTO);
            updatedPayment.setIdPayment(idPayment); // Mantener el ID del objeto existente
            return paymentService.save(updatedPayment);
        }
        // Si no se encuentra, simplemente devuelve null
        return null;
    }

    // Mutación para eliminar
    @MutationMapping
    public String deletePayment(@Argument Long idPayment) {
        Payment payment = paymentService.getIdPayment(idPayment);
        if (payment != null) {
            paymentService.delete(idPayment);
            return "Payment deleted successfully with id: " + idPayment;
        }
        // Si no se encuentra, devuelve un mensaje básico
        return "Payment not found with id: " + idPayment;
    }

    // Conversión DTO <-> Entidad
    public Payment convertToEntity(PaymentDTO paymentDTO) {
        return modelMapper.map(paymentDTO, Payment.class);
    }

    public PaymentDTO convertToDTO(Payment payment) {
        return modelMapper.map(payment, PaymentDTO.class);
    }

}
