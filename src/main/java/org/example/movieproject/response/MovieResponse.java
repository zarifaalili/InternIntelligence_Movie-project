package org.example.movieproject.response;

import lombok.Data;
import org.example.movieproject.model.enums.Genre;

@Data
public class MovieResponse {
    private Long id;
    private String title;
    private String director;
    private Integer releaseYear;
    private Genre genre;
    private Integer rating;
}
