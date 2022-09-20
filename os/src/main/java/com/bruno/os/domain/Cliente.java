package com.bruno.os.domain;

public class Cliente extends Pessoa{

    public Cliente() {
        super();

    }

    public Cliente(Long id, String nome, String cpf, String telefone) {
        super(id, nome, cpf, telefone);
    }
}
