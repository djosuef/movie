package com.aulamatriz.movie.repository;

import com.aulamatriz.movie.entities.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {


    List<MovieEntity> findByNameContaining(String keyword);
}
