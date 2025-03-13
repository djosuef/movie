package com.aulamatriz.movie.controller.v2.docs;


import com.aulamatriz.movie.dto.MovieDto;
import com.aulamatriz.movie.entities.MovieEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Movie-api", description = "crud basico de peliculas")
@RequestMapping("/v2/movie")
public interface IMovieDoc {

    @Operation(summary = "Crear nueva pelicula")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pelicula creada"),
            @ApiResponse(responseCode = "500", description = "Error desarrollo"),
            @ApiResponse(responseCode = "404", description = "EndPoint no encontrado")
    })
    @PostMapping
    ResponseEntity<?> create(@RequestBody @Valid MovieDto movieDto);

}
