package org.example.movieproject.exception.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.movieproject.request.MovieRequest;
import org.example.movieproject.response.MovieResponse;
import org.example.movieproject.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping("/create")
    public MovieResponse createMovie(@RequestBody @Valid MovieRequest movieRequest) {
        return movieService.createMovie(movieRequest);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }

    @GetMapping("/getMovies")
    public List<MovieResponse> getMovies() {
        return movieService.getAllMovies();
    }
}
