package artesanasHueyapan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import artesanasHueyapan.model.Payment;
import artesanasHueyapan.repository.PaymentRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    // Obtiene todos los pagos
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    // Guarda o actualiza un pago
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    // Obtiene un pago por ID
    public Payment getIdPayment(Long idPayment) {
        return paymentRepository.findById(idPayment).get();
    }

    // Elimina un pago por ID
    public void delete(Long idPayment) {
        paymentRepository.deleteById(idPayment);

    }
      
    
}
