package com.devsuperior.uri2611.controllers;

import com.devsuperior.uri2611.dto.MovieIdNameDTO;
import com.devsuperior.uri2611.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping(value = "/findByDescriptionSQL")
    public ResponseEntity<List<MovieIdNameDTO>> findByDescriptionSQL(@RequestParam(name = "description", defaultValue = "") String description){
        List<MovieIdNameDTO> result = service.findByDescriptionSQL(description);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/findByDescriptionJPQL")
    public ResponseEntity<List<MovieIdNameDTO>> findByDescriptionJPQL(@RequestParam(name = "description", defaultValue = "") String description){
        List<MovieIdNameDTO> result = service.findByDescriptionJPQL(description);
        return ResponseEntity.ok(result);
    }
}
