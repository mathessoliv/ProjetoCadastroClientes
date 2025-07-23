package com.example.CadastroClientes.services;

import com.example.CadastroClientes.dtos.client.CreateClientRequestDTO;
import com.example.CadastroClientes.dtos.client.ClientResponseDTO;
import com.example.CadastroClientes.dtos.client.UpdateClientRequestDTO;
import com.example.CadastroClientes.mappers.ClientMapper;
import com.example.CadastroClientes.models.Client;
import com.example.CadastroClientes.models.Product;
import com.example.CadastroClientes.repositories.ClientRepository;
import com.example.CadastroClientes.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;
    private final ClientMapper clientMapper;

    public ClientService(
            ClientRepository clientRepository,
            ProductRepository productRepository,
            ClientMapper clientMapper)
    {
            this.clientRepository = clientRepository;
            this.productRepository = productRepository;
            this.clientMapper = clientMapper;
    }

    private Long validateIdProduct(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Product ID must be provided");
        };

        return id;
    }

    private Product checkProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product with ID " + id + " does not exist"));
    }

    @Transactional
    public ClientResponseDTO createClient(CreateClientRequestDTO createClientRequestDTO) {
        Client client = clientMapper.toEntity(createClientRequestDTO);

        Long productId = validateIdProduct(createClientRequestDTO.getProductId());
        Product product = checkProduct(productId);

        client.setProduct(product);

        clientRepository.save(client);

        return clientMapper.toResponseDTO(clientRepository.save(client));
    }

    @Transactional
    public ClientResponseDTO updateClient(Long id, UpdateClientRequestDTO updateClientRequestDTO) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Client with id " + id + " does not exist"));

        if (updateClientRequestDTO.productId() != null) {
            Product product = checkProduct(updateClientRequestDTO.productId());
            client.setProduct(product);
        }

        clientMapper.updateEntityFromDTO(updateClientRequestDTO, client);

        clientRepository.save(client);

        return clientMapper.toResponseDTO(client);
    }

    @Transactional
    public ClientResponseDTO getClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Client with ID " + id + " does not exist"));

        return clientMapper.toResponseDTO(client);
    }

    @Transactional
    public List<ClientResponseDTO> getAllClients() {
        List<Client> clients = clientRepository.findAll();

        if (clients.isEmpty()) {
            throw new IllegalArgumentException("No clients found");
        }

        return clients.stream()
                .map(clientMapper::toResponseDTO)
                .toList();

    }

    @Transactional
    public ClientResponseDTO deleteClient(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Client with ID " + id + " does not exist"));

        ClientResponseDTO clientResponseDTO = clientMapper.toResponseDTO(client);
        clientResponseDTO.setMessage("Client deleted successfully");

        clientRepository.delete(client);

        return clientResponseDTO;
    }


}
