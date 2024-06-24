package com.devsuperior.uri2602.services;

import com.devsuperior.uri2602.dto.CustomerMinDTO;
import com.devsuperior.uri2602.projections.CustomerMinProjection;
import com.devsuperior.uri2602.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Transactional(readOnly = true)
    public List<CustomerMinDTO> searchByStateSQL(String state) {
        List<CustomerMinProjection> projection = repository.search1(state);
        /*.collect(Collectors.toList()) pois o projeto baixado tá em java 11 e não 17 que tem o .toList() direto*/
        return projection.stream().map(x -> new CustomerMinDTO(x)).collect(Collectors.toList());
        /*Mesmo recebendo uma projeção, a boa prática do DTO continua mesmo se fosse a entidade, ou seja, temos que converter para DTO*/
    }

    public List<CustomerMinDTO> findByStateJPQL(String state) {
        List<CustomerMinDTO> result = repository.search2(state);
        /*Não precisa do map pois como é JPQL, a gente já recebe um CustomerMinDTO direto, sem passar pela Projection*/
        return result;
    }
}
