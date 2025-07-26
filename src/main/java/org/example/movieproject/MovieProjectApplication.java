package org.example.movieproject;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Movie Backend API",
                version = "1.0",
                description = "its a backend API for Movie project"
        )
)
public class MovieProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieProjectApplication.class, args);
    }

}
