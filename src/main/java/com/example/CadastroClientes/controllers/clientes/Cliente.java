package com.example.CadastroClientes.controllers.clientes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Cliente {

    @GetMapping("/cliente")
    public String cliente() {
        return "Perfil do cliente";
    }

}
