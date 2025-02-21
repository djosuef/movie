package com.aulamatriz.movie.service;

import com.aulamatriz.movie.entities.MovieEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IMovieService {

    public ResponseEntity<?> create(MovieEntity movie);

    public ResponseEntity<?> findByNameContaining(String name);

    public ResponseEntity<?> findById(int id);

    public ResponseEntity<List<MovieEntity>> findAll();

    public ResponseEntity<?> update(int id, MovieEntity movie);

    public ResponseEntity<?> delete(int id);
}
