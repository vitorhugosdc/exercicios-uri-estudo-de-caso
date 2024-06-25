package com.devsuperior.uri2609.services;

import com.devsuperior.uri2609.dto.CategorySumDTO;
import com.devsuperior.uri2609.projections.CategorySumProjection;
import com.devsuperior.uri2609.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<CategorySumDTO> findProductsByCategorySQL(){
        List<CategorySumProjection> result = repository.findProductsByCategorySQL();
        return result.stream().map(x-> new CategorySumDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<CategorySumDTO> findProductsByCategoryJPQL(){
        return repository.findProductsByCategoryJPQL();
    }
}
