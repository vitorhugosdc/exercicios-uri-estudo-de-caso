package com.devsuperior.uri2737.controllers;

import com.devsuperior.uri2737.dto.LawyerMinDTO;
import com.devsuperior.uri2737.services.LawyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lawyers")
public class LawyerController {

    @Autowired
    private LawyerService service;

    @GetMapping
    public ResponseEntity<List<LawyerMinDTO>> search() {
        List<LawyerMinDTO> result = service.search();
        return ResponseEntity.ok(result);
    }
}
