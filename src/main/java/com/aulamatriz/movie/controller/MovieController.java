package com.aulamatriz.movie.controller;

import com.aulamatriz.movie.entities.MovieEntity;
import com.aulamatriz.movie.service.IMovieService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final IMovieService iMovieService;

    public MovieController(IMovieService iMovieService) {
        this.iMovieService = iMovieService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody MovieEntity movie){
        return this.iMovieService.create(movie);
    }

    @GetMapping()
    public ResponseEntity<?> findAll(){
        return this.iMovieService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        return this.iMovieService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id,
                                    @RequestBody MovieEntity movie){
        return  this.iMovieService.update(id, movie);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> findMoviesByName(@PathVariable String name){

        return this.iMovieService.findByNameContaining(name);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return this.iMovieService.delete(id);
    }
}
