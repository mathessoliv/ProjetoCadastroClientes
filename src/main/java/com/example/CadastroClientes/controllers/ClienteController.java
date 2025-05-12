package com.example.CadastroClientes.controllers;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ClienteController {

    @GetMapping("/cliente")
    public String cliente() {
        return "Perfil do cliente";
    }

}
