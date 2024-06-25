package com.devsuperior.uri2990.services;

import com.devsuperior.uri2990.dto.EmpregadoDeptDTO;
import com.devsuperior.uri2990.projections.EmpregadoDeptProjection;
import com.devsuperior.uri2990.repositories.EmpregadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpregadoService {

    @Autowired
    private EmpregadoRepository repository;

    @Transactional(readOnly = true)
    public List<EmpregadoDeptDTO> find() {
        List<EmpregadoDeptProjection> result = repository.find();
        return result.stream().map(x -> new EmpregadoDeptDTO(x)).collect(Collectors.toList());
    }
}
