package com.devsuperior.uri2609.controllers;

import com.devsuperior.uri2609.dto.CategorySumDTO;
import com.devsuperior.uri2609.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping(value = "/findProductsByCategorySQL")
    public ResponseEntity<List<CategorySumDTO>> findProductsByCategorySQL() {
        List<CategorySumDTO> result = service.findProductsByCategorySQL();
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/findProductsByCategoryJPQL")
    public ResponseEntity<List<CategorySumDTO>> findProductsByCategoryJPQL() {
        List<CategorySumDTO> result = service.findProductsByCategoryJPQL();
        return ResponseEntity.ok(result);
    }
}
