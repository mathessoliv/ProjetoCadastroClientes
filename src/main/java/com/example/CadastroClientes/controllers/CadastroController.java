package com.example.CadastroClientes.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CadastroController {

    @GetMapping("/cadastro")
    public String cadastro() {
        return "Cadastro de clientes";
    }

}
