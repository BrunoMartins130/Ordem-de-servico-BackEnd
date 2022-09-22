package com.bruno.os.services;

import com.bruno.os.domain.Cliente;
import com.bruno.os.domain.OS;
import com.bruno.os.domain.Tecnico;
import com.bruno.os.domain.enuns.Prioridade;
import com.bruno.os.domain.enuns.Status;
import com.bruno.os.repositories.ClienteRepository;
import com.bruno.os.repositories.OsRepository;
import com.bruno.os.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private OsRepository osRepository;


    public void instanciaDB() {
        Tecnico t1 = new Tecnico(null, "Bruno Martins","568.443.840-76","(11)952342021");
        Tecnico t2 = new Tecnico(null, "João Henrique","354.575.690-47","(11)952542322");
        Tecnico t3 = new Tecnico(null, "João Pedro","494.756.460-19","(11)952242321");
        Cliente c1 = new Cliente(null, "Brian Martins", "154.426.830-00", "(11)902105560");

        OS os1 = new OS(null, Prioridade.ALTA,"Teste create Os", Status.ANDAMENTO, t1,c1);

        t1.getList().add(os1);
        t2.getList().add(os1);
        t3.getList().add(os1);
        c1.getList().add(os1);

        tecnicoRepository.saveAll(Arrays.asList(t1));
        tecnicoRepository.saveAll(Arrays.asList(t2));
        tecnicoRepository.saveAll(Arrays.asList(t3));
        clienteRepository.saveAll(Arrays.asList(c1));
        osRepository.saveAll(Arrays.asList(os1));
    }
}
