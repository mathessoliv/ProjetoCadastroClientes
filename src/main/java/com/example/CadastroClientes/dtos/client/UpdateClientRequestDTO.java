package com.example.CadastroClientes.dtos.client;

public record UpdateClientRequestDTO(
        String name,
        String lastName,
        Long productId
    ) {

}
