package org.example.movieproject.request;

import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;
import org.example.movieproject.model.enums.Genre;

@Data
public class MovieRequest {
    @NotNull(message = "Title is required")
    private String title;
    @NotNull(message = "Director is required")
    private String director;

    @NotNull(message = "Release year is required")
    private Integer releaseYear;

    @NotNull(message = "Genre is required")
    private Genre genre;

    @NotNull(message = "Rating is required")
    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 10, message = "Rating must be at most 10")
    private Integer rating;
}
