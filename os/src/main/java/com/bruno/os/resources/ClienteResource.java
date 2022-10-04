package com.bruno.os.resources;

import com.bruno.os.domain.Cliente;
import com.bruno.os.dtos.ClienteDTO;
import com.bruno.os.repositories.ClienteRepository;
import com.bruno.os.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService service;

    private ClienteRepository repository;

    // Busca Cliente pelo id

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> findById (@PathVariable Integer id) {
        ClienteDTO clienteDTO = new ClienteDTO(service.findById(id));
        return ResponseEntity.ok().body(clienteDTO);
    }

    // Busca todos os clientes
    @GetMapping
    public ResponseEntity <List<ClienteDTO>>  findall () {
        List<ClienteDTO> clienteDTO = service.findAll().stream().map(cliente -> new ClienteDTO(cliente)).collect(Collectors.toList());
        return ResponseEntity.ok().body(clienteDTO);

    }

    // Cria um cliente pelo seu id 
    @PostMapping(value = "/{id}")
    public ResponseEntity <ClienteDTO> create (@Valid @PathVariable ClienteDTO clienteDTO) {
        Cliente cliente = service.create(clienteDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }



}
