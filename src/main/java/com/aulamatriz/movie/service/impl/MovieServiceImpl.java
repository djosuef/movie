package com.aulamatriz.movie.service.impl;

import com.aulamatriz.movie.entities.MovieEntity;
import com.aulamatriz.movie.repository.MovieRepository;
import com.aulamatriz.movie.service.IMovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements IMovieService {
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @Override
    public ResponseEntity<?> create(MovieEntity movie) {
        return ResponseEntity.ok(this.movieRepository.save(movie));
    }

    @Override
    public ResponseEntity<?> findByNameContaining(String name) {
        System.out.println("Name:" + name);
        List<MovieEntity> movies = this.movieRepository.findByNameContaining(name);
        if(movies.size() > 0){
            return ResponseEntity.ok(movies);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Se han encontrado peliculas");
    }

    @Override
    public ResponseEntity<?> findById(int id) {
        Optional<MovieEntity> movie = this.movieRepository.findById(id);
        if(movie.isPresent()){
            return ResponseEntity.ok(this.movieRepository.findById(id));
        }
        return new ResponseEntity<>("Pelicula no encontrada", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<List<MovieEntity>> findAll() {
        return ResponseEntity.ok(this.movieRepository.findAll());
    }

    @Override
    public ResponseEntity<?> update(int id, MovieEntity movie) {
        System.out.println("ID:" + id);

        Optional<MovieEntity> movies = this.movieRepository.findById(id);
        if(movies.isPresent()){
            MovieEntity movieEntity = movies.get();

            movieEntity.setName(movie.getName());
            movieEntity.setDescription(movie.getDescription());
            movieEntity.setGenre(movie.getGenre());
            movieEntity.setYear(movie.getYear());

            MovieEntity newMovie = this.movieRepository.save(movieEntity);

            return ResponseEntity.ok(newMovie);

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No fue posible modificar la pelicula");
    }
}
