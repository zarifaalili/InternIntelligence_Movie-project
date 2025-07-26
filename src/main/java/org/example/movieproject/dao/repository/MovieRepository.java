package org.example.movieproject.dao.repository;

import org.example.movieproject.dao.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity, Long> {

    boolean existsByTitleAndDirector(String title, String director);
}
