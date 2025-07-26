package org.example.movieproject.dao.repository;

import org.example.movieproject.dao.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<MovieEntity, Long> {

    boolean existsByTitleAndDirector(String title, String director);

    Optional<MovieEntity> findByTitle(String title);
}
