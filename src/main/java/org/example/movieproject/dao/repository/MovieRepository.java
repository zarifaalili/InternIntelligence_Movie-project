package org.example.movieproject.dao;

import org.example.movieproject.dao.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity, Long> {

    boolean existyByTitleAndDirector(String title, String director);
}
