package com.example.CadastroClientes.controllers;

import com.example.CadastroClientes.dtos.client.CreateClientRequestDTO;
import com.example.CadastroClientes.dtos.client.ClientResponseDTO;
import com.example.CadastroClientes.dtos.client.UpdateClientRequestDTO;
import com.example.CadastroClientes.services.ClientService;
import jakarta.validation.Valid;
import org.hibernate.sql.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/create")
    public ResponseEntity<ClientResponseDTO> createClient(@Valid @RequestBody CreateClientRequestDTO createClientRequestDTO) {
        ClientResponseDTO response = clientService.createClient(createClientRequestDTO);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ClientResponseDTO> updateClient(@PathVariable Long id,
                                                          @Valid @RequestBody UpdateClientRequestDTO updateClientRequestDTO,
                                                          @RequestParam(value = "productId", required = false) Long productId) {
        ClientResponseDTO response = clientService.updateClient(id, updateClientRequestDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ClientResponseDTO> getClient(@PathVariable Long id) {
        ClientResponseDTO response = clientService.getClientById(id);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ClientResponseDTO>> getAllClients() {
        List<ClientResponseDTO> response = clientService.getAllClients();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ClientResponseDTO> deletClient(@PathVariable Long id) {
        ClientResponseDTO response = clientService.deleteClient(id);

        return ResponseEntity.ok(response);
    }

}
