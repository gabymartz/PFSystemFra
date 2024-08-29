package com.ups.oop.service;

import com.ups.oop.dto.ClientDTO;
import com.ups.oop.entity.Client;
import com.ups.oop.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ResponseEntity createClient(ClientDTO clientDTO) {
        String clientId = clientDTO.getId();
        Optional<Client> clientOptional = clientRepository.findByPersonId(clientId);

        if (clientOptional.isPresent()) {
            String errorMessage = "Client with id " + clientId + " already exists";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        } else {
            if (clientDTO.getName().contains(" ")) {
                Client clientRecord = new Client();
                clientRecord.setPersonId(clientDTO.getId());
                String[] nameStrings = clientDTO.getName().split(" ");
                String name = nameStrings[0];
                String lastname = nameStrings[1];
                clientRecord.setName(name);
                clientRecord.setLastname(lastname);
                clientRecord.setAge(clientDTO.getAge());
                clientRecord.setClientCode(clientDTO.getClientCode());
                clientRepository.save(clientRecord);
                return ResponseEntity.status(HttpStatus.OK).body(clientDTO);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Client name must contain two strings separated by a whitespace");
            }
        }
    }

    public ResponseEntity getAllClients() {
        Iterable<Client> clientIterable = clientRepository.findAll();
        List<ClientDTO> clientList = new ArrayList<>();

        for (Client c : clientIterable) {
            ClientDTO clientDTO = new ClientDTO(
                    c.getPersonId(),
                    c.getName() + " " + c.getLastname(),
                    c.getAge(),
                    c.getClientCode()
            );
            clientList.add(clientDTO);
        }

        if (clientList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Client list is empty");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clientList);
    }

    public ResponseEntity getClientById(String clientId) {
        Optional<Client> clientOptional = clientRepository.findByPersonId(clientId);
        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            ClientDTO clientDTO = new ClientDTO(
                    client.getPersonId(),
                    client.getName() + " " + client.getLastname(),
                    client.getAge(),
                    client.getClientCode()
            );
            return ResponseEntity.status(HttpStatus.OK).body(clientDTO);
        } else {
            String errorMessage = "Client with id " + clientId + " does not exist";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    public ResponseEntity updateClient(ClientDTO clientDTO) {
        String clientId = clientDTO.getId();
        Optional<Client> clientOptional = clientRepository.findByPersonId(clientId);

        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();

            if (clientDTO.getName().contains(" ")) {
                client.setPersonId(clientId);
                String[] nameStrings = clientDTO.getName().split(" ");
                String name = nameStrings[0];
                String lastname = nameStrings[1];
                client.setName(name);
                client.setLastname(lastname);
                client.setAge(clientDTO.getAge());
                client.setClientCode(clientDTO.getClientCode());
                clientRepository.save(client);
                return ResponseEntity.status(HttpStatus.OK).body(clientDTO);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Client name must contain two strings separated by a whitespace");
            }
        } else {
            String errorMessage = "Client with id " + clientId + " not found";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    public ResponseEntity deleteClientById(String clientId) {
        Optional<Client> clientOptional = clientRepository.findByPersonId(clientId);
        if (clientOptional.isPresent()) {
            clientRepository.delete(clientOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body("Client with id " + clientId + " removed successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client with id " + clientId + " not found");
        }
    }
}
