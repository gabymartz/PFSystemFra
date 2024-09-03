package com.ups.oop.controller;

import com.ups.oop.dto.ClientDTO;
import com.ups.oop.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/get-all-clients")
    public ResponseEntity getAllClients() {
        return this.clientService.getAllClients();
    }

    @GetMapping("/get-client")
    public ResponseEntity getClientById(@RequestParam String id) {
        return this.clientService.getClientById(id);
    }

    @PostMapping("/client")
    public ResponseEntity createClient(@RequestBody ClientDTO clientDTO) {
        return this.clientService.createClient(clientDTO);
    }

    @PutMapping("/update-client")
    public ResponseEntity updateClient(@RequestBody ClientDTO clientDTO) {
        return this.clientService.updateClient(clientDTO);
    }

    @DeleteMapping("/remove-client")
    public ResponseEntity deleteClientById(@RequestParam String id) {
        return this.clientService.deleteClientById(id);
    }
}
