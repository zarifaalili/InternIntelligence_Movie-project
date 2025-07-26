package org.example.movieproject.dao.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.movieproject.model.enums.Genre;

@Entity
@Table(name = "movies")
@Getter
@Setter
@Data
public class MovieEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String title;
    private String director;
    private Integer releaseYear;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private Integer rating;

}
