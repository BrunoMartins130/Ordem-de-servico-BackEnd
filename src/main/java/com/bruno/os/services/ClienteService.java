package com.bruno.os.services;

import com.bruno.os.domain.Cliente;
import com.bruno.os.domain.Pessoa;

import com.bruno.os.dtos.ClienteDTO;
import com.bruno.os.dtos.TecnicoDTO;
import com.bruno.os.repositories.ClienteRepository;
import com.bruno.os.repositories.PessoaRepository;
import com.bruno.os.services.exceptions.DataIntegratyViolationException;
import com.bruno.os.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ClienteRepository repository;


    public Cliente findById(Integer id) {
        Optional<Cliente> cliente = repository.findById(id);
        return cliente.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! " + id + ", Tipo: " + Cliente.class.getName()));
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente create(ClienteDTO clienteDTO) {
        if(findByCpf(clienteDTO) != null) {
            throw new DataIntegratyViolationException("CPF já cadastrado na base de dados");
        }
        return repository.save(new Cliente(null, clienteDTO.getNome(), clienteDTO.getCpf(), clienteDTO.getTelefone()));
    }
    public Cliente update(Integer id, ClienteDTO clienteDTO) {
              Cliente objCliente = findById(id);
              if(findByCpf(clienteDTO) != null && findByCpf(clienteDTO).getId() != id) {
                  throw new DataIntegratyViolationException("CPF já cadastrado na base de dados! ");
              }
              objCliente.setNome(clienteDTO.getNome());
              objCliente.setCpf(clienteDTO.getCpf());
              objCliente.setTelefone(objCliente.getTelefone());
              return repository.save(objCliente);
    }
    public void delete(Integer id) {
        Cliente cliente = findById(id);
        if(cliente.getList().size() > 0) {
            throw new DataIntegratyViolationException("Cliente possuio ordens de serviço, não pode ser deletado! ");
        }
        repository.deleteById(id);
    }

    private Pessoa findByCpf(ClienteDTO clienteDTO) {
        Pessoa pessoa = pessoaRepository.findByCPF(clienteDTO.getCpf());
        if(pessoa != null){
        }
        return pessoa;
    }

    private Pessoa findByCPF(ClienteDTO objDTO) {
        Pessoa obj = pessoaRepository.findByCPF(objDTO.getCpf());
        if(obj != null) {
            return obj;
        }
        return null;
    }


}
