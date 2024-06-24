package com.devsuperior.uri2611.services;

import com.devsuperior.uri2611.dto.MovieIdNameDTO;
import com.devsuperior.uri2611.projections.MovieIdNameProjection;
import com.devsuperior.uri2611.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public List<MovieIdNameDTO> findByDescription(String description) {
        List<MovieIdNameProjection> result = repository.findByDescription(description);
        return result.stream().map(x -> new MovieIdNameDTO(x)).collect(Collectors.toList());
    }
}
