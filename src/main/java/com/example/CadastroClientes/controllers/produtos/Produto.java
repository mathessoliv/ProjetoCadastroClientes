package com.example.CadastroClientes.controllers.produtos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Produto {

    @GetMapping("/produto")
    public String produto() {
        return "Detalhes do produto: ";
    }
}
