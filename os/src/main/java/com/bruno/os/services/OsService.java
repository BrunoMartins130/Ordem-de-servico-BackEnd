package com.bruno.os.services;

import com.bruno.os.domain.OS;
import com.bruno.os.repositories.OsRepository;
import com.bruno.os.repositories.PessoaRepository;
import com.bruno.os.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OsService {

    @Autowired
    private OsRepository repository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public OS findById(Integer id) {
        Optional<OS> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + OS.class.getName()));
    }

    public List<OS> findall(){
        return repository.findAll();
    }

}
