package com.example.CadastroClientes.repositories;

import com.example.CadastroClientes.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
