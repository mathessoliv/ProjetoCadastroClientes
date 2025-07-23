package com.example.CadastroClientes.mappers;

import com.example.CadastroClientes.dtos.client.CreateClientRequestDTO;
import com.example.CadastroClientes.dtos.client.ClientResponseDTO;
import com.example.CadastroClientes.dtos.ProductDTO;
import com.example.CadastroClientes.dtos.client.UpdateClientRequestDTO;
import com.example.CadastroClientes.models.Client;
import com.example.CadastroClientes.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mapping (target = "product", ignore = true)
    Client toEntity(CreateClientRequestDTO createClientRequestDTO);

    @Mapping(target = "message", constant= "Client created successfully" )
    ClientResponseDTO toResponseDTO(Client client);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDTO(UpdateClientRequestDTO updateClientRequestDTO, @MappingTarget Client client);

    ProductDTO toDTO(Product product);

}
