package com.devsuperior.uri2621.dto;

import com.devsuperior.uri2621.projections.ProductNameProjection;

public class ProductNameDTO {

    private String name;

    public ProductNameDTO(String name) {
        this.name = name;
    }

    public ProductNameDTO(ProductNameProjection projection) {
        name = projection.getName();
    }

    public String getName() {
        return name;
    }
}
