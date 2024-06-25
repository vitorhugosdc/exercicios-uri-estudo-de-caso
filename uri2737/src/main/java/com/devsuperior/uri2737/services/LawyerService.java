package com.devsuperior.uri2737.services;

import com.devsuperior.uri2737.dto.LawyerMinDTO;
import com.devsuperior.uri2737.projections.LawyerMinProjection;
import com.devsuperior.uri2737.repositories.LawyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LawyerService {

    @Autowired
    private LawyerRepository repository;

    @Transactional(readOnly = true)
    public List<LawyerMinDTO> search() {
        List<LawyerMinProjection> result = repository.search();
        return result.stream().map(x -> new LawyerMinDTO(x)).collect(Collectors.toList());
    }
}
