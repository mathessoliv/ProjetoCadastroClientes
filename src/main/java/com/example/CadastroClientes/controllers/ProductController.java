package com.example.CadastroClientes.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ProductController {

    @GetMapping("/product")
    public String produto() {
        return "Detalhes do produto: ";
    }
}
