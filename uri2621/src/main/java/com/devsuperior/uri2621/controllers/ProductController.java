package com.devsuperior.uri2621.controllers;

import com.devsuperior.uri2621.dto.ProductNameDTO;
import com.devsuperior.uri2621.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/findProductsSQL")
    public ResponseEntity<List<ProductNameDTO>> findProductsSQL(@RequestParam(value = "min", defaultValue = "0") Integer min, @RequestParam(value = "max", defaultValue = "0") Integer max, @RequestParam(value = "initial", defaultValue = "") String providerInitial) {
        List<ProductNameDTO> result = service.findProductsSQL(min, max, providerInitial);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/findProductsJPQL")
    public ResponseEntity<List<ProductNameDTO>> findProductsJPQL(@RequestParam(value = "min", defaultValue = "0") Integer min, @RequestParam(value = "max", defaultValue = "0") Integer max, @RequestParam(value = "initial", defaultValue = "") String providerInitial) {
        List<ProductNameDTO> result = service.findProductsJPQL(min, max, providerInitial);
        return ResponseEntity.ok(result);
    }
}
