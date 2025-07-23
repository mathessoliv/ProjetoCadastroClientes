package com.example.CadastroClientes.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
@Entity
@Table(name = "tb_clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;

    private String lastName;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @ManyToOne
    @JoinColumn (name = "id_product")
    private Product product;

}
