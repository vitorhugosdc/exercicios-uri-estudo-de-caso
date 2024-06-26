package com.devsuperior.uri2611.services;

import com.devsuperior.uri2611.dto.MovieIdNameDTO;
import com.devsuperior.uri2611.projections.MovieIdNameProjection;
import com.devsuperior.uri2611.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    @Transactional(readOnly = true)
    public List<MovieIdNameDTO> findByDescriptionSQL(String description) {
        List<MovieIdNameProjection> result = repository.findByDescriptionSQL(description);
        return result.stream().map(x -> new MovieIdNameDTO(x)).collect(Collectors.toList());
    }

    public List<MovieIdNameDTO> findByDescriptionJPQL(String description) {
        List<MovieIdNameDTO> result = repository.findByDescriptionJPQL(description);
        return result;
    }
}
