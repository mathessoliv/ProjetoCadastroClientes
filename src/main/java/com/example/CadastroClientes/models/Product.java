package com.example.CadastroClientes.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table (name = "tb_product")
public class Product {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private double price;

    @OneToMany(mappedBy = "product")
    private List<Client> client;

}
