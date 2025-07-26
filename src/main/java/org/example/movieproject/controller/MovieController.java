package org.example.movieproject.controller;

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

    @PatchMapping("/update/{id}")
    public MovieResponse updateMovie(@PathVariable Long id, @RequestBody @Valid MovieRequest movieRequest) {
        return movieService.updateMovie(id, movieRequest);
    }

    @GetMapping("/getMovie/{id}")
    public MovieResponse getMovie(@PathVariable Long id) {
        return movieService.getMovie(id);
    }

    @GetMapping("/getMovieByTitle/{title}")
    public MovieResponse getMovieByTitle(@PathVariable String title) {
        return movieService.getMovieByTitle(title);
    }

}
