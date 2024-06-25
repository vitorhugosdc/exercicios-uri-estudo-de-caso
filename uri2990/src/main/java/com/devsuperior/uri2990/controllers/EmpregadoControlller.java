package com.devsuperior.uri2990.controllers;

import com.devsuperior.uri2990.dto.EmpregadoDeptDTO;
import com.devsuperior.uri2990.services.EmpregadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/empregados")
public class EmpregadoControlller {

    @Autowired
    private EmpregadoService service;

    @GetMapping
    public ResponseEntity<List<EmpregadoDeptDTO>> find() {
        List<EmpregadoDeptDTO> result = service.find();
        return ResponseEntity.ok(result);
    }
}
