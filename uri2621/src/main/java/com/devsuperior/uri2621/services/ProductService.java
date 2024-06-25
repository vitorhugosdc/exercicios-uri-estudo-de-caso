package com.devsuperior.uri2621.services;

import com.devsuperior.uri2621.dto.ProductNameDTO;
import com.devsuperior.uri2621.projections.ProductNameProjection;
import com.devsuperior.uri2621.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public List<ProductNameDTO> findProductsSQL(Integer min, Integer max, String providerInitial) {
        List<ProductNameProjection> result = repository.findProductsSQL(min, max, providerInitial);
        return result.stream().map(x -> new ProductNameDTO(x)).collect(Collectors.toList());
    }
}
