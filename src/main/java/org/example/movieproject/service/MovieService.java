package org.example.movieproject.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.movieproject.dao.repository.MovieRepository;
import org.example.movieproject.dao.entity.MovieEntity;
import org.example.movieproject.exception.customexception.AlreadyExistsException;
import org.example.movieproject.mapper.MovieMapper;
import org.example.movieproject.request.MovieRequest;
import org.example.movieproject.response.MovieResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieService {
    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    public MovieResponse createMovie(MovieRequest movieRequest) {
        log.info("ActionLog.createMovie.start");
        boolean existingMovie=movieRepository.existsByTitleAndDirector(movieRequest.getTitle(),movieRequest.getDirector());
        if(existingMovie){
            throw new AlreadyExistsException("Movie already exists");
        }

        var relaseYear=movieRequest.getReleaseYear();

        if(relaseYear> LocalDate.now().getYear()){
            throw new RuntimeException("Invalid release year.Year must be present or past");
        }
        MovieEntity movieEntity=movieRepository.save(movieMapper.toEntity(movieRequest));
        var response=movieMapper.toResponse(movieEntity);
        log.info("ActionLog.createMovie.end");
        return response;

    }

    public MovieResponse deleteMovie(Long id) {
        log.info("ActionLog.deleteMovie.start");
        var movie=movieRepository.findById(id);
        if(movie.isEmpty()){
            throw new RuntimeException("Movie not found");
        }
        movieRepository.deleteById(id);
        log.info("ActionLog.deleteMovie.end");
        return null;
    }

    public List<MovieResponse> getAllMovies() {
        log.info("ActionLog.getAllMovies.start");
        var movies=movieRepository.findAll();
        if(movies.isEmpty()){
            throw new RuntimeException("No movies found");
        }
        log.info("ActionLog.getAllMovies.end");
        return movies.stream().map(movieMapper::toResponse).toList();
    }

}
