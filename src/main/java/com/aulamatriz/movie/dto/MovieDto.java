package com.aulamatriz.movie.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {

    @NotBlank(message = "El nombre es obligatorio")
    //@UniqueField
    private String name;
    private String description;
    private String genre;

    @Min(value = 1896, message = "El año mínimo es 1896")
    private int year;

    @Range(min = 0, max = 10, message = "El Rating debe estar entre {min} y {max}")
    private int rating;

}
