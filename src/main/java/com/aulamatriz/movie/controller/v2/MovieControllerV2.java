package com.aulamatriz.movie.controller.v2;

import com.aulamatriz.movie.controller.v2.docs.IMovieDoc;
import com.aulamatriz.movie.dto.MovieDto;
import com.aulamatriz.movie.service.IMovieService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/v2/movies")
public class MovieControllerV2 implements IMovieDoc{

    private final IMovieService iMovieService;

    @Override
    public ResponseEntity<?> create(@Valid MovieDto movieDto) {

        return iMovieService.create(movieDto);
    }
}
