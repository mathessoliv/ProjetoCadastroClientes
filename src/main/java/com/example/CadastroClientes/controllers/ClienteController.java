package com.example.CadastroClientes.controllers;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_clientes")
public class ClienteController {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String sobrenome;
    private String email;
    private String telefone;
    private String endereco;

    public ClienteController(String nome, String sobrenome, String email, String telefone, String endereco) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public ClienteController() {
    }

    public String getCliente() {
        return "Nome: " + this.nome +
               "\nSobrenome: " + this.sobrenome +
               "\nEmail: " + this.email +
               "\nTelefone: " + this.telefone +
               "\nEndereço: " + this.endereco;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCliente(String nome, String sobrenome, String email, String telefone, String endereco) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }
}
