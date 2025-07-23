package com.example.CadastroClientes.dtos.client;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateClientRequestDTO {

    @NotBlank(message = "O nome é obrigatório")
    private String name;

    private String lastName;

    @Email(message = "Formato de email inválido")
    private String email;

    @NotBlank(message = "Senha não pode estar vazia")
    private String password;

    private Long productId;

}
