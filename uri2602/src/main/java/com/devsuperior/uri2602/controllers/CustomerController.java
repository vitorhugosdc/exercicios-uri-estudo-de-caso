package com.devsuperior.uri2602.controllers;

import com.devsuperior.uri2602.dto.CustomerMinDTO;
import com.devsuperior.uri2602.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping(value = "/searchByStateSQL")
    public ResponseEntity<List<CustomerMinDTO>> searchByStateSQL(@RequestParam(name = "state", defaultValue = "") String state) {
        List<CustomerMinDTO> result = service.searchByStateSQL(state);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/searchByStateJPQL")
    public ResponseEntity<List<CustomerMinDTO>> searchByStateJPQL(@RequestParam(name = "state", defaultValue = "") String state) {
        List<CustomerMinDTO> result = service.findByStateJPQL(state);
        return ResponseEntity.ok(result);
    }
}
