package com.bruno.os.dtos;

import com.bruno.os.domain.Cliente;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotEmpty(message = "O campo NOME é requerido!")
    private String nome;
    @NotEmpty(message = "O campo CPF é requerido!")
    private String cpf;
    @NotEmpty(message = "O campo TELEFONE é requerido!")
    private String telefone;

    public ClienteDTO () {
        super();
    }

    public ClienteDTO(Cliente objCliente) {
        this.id = objCliente.getId();
        this.nome = objCliente.getNome();
        this.cpf = objCliente.getCpf();
        this.telefone = objCliente.getTelefone();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
