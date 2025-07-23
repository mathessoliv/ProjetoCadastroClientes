package com.example.CadastroClientes.dtos.client;

import com.example.CadastroClientes.dtos.ProductDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientResponseDTO {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private ProductDTO product;
    private String message;
}
