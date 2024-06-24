package com.devsuperior.uri2611.dto;

import com.devsuperior.uri2611.projections.MovieIdNameProjection;

public class MovieIdNameDTO {

    private Long id;
    private String name;

    public MovieIdNameDTO() {
    }

    public MovieIdNameDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public MovieIdNameDTO(MovieIdNameProjection projection) {
        id = projection.getId();
        name = projection.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
