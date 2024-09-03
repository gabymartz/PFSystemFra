package com.ups.oop.controller;

import com.ups.oop.dto.PaymentMethDTO;
import com.ups.oop.service.PaymentMethService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentMethController {

    private final PaymentMethService paymentMethService;

    public PaymentMethController(PaymentMethService paymentMethService) {
        this.paymentMethService = paymentMethService;
    }

    @GetMapping("/get-all-payment-methods")
    public ResponseEntity getAllPaymentMethods() {
        return this.paymentMethService.getAllPayment();
    }

    @GetMapping("/get-payment-method")
    public ResponseEntity getPaymentMethodById(@RequestParam String id) {
        return this.paymentMethService.getPaymentMethbyId(id);
    }

    @PostMapping("/payment-method")
    public ResponseEntity createPaymentMethod(@RequestBody PaymentMethDTO paymentMethDTO) {
        return this.paymentMethService.createPayment(paymentMethDTO);
    }

    @PutMapping("/update-payment-method")
    public ResponseEntity updatePaymentMethod(@RequestBody PaymentMethDTO paymentMethDTO) {
        return this.paymentMethService.updatePayment(paymentMethDTO);
    }

    @DeleteMapping("/remove-payment-method")
    public ResponseEntity deletePaymentMethodById(@RequestParam String id) {
        return this.paymentMethService.deletePaymentById(id);
    }
}
