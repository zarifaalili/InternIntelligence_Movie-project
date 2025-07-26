package org.example.movieproject.mapper;


import org.example.movieproject.dao.entity.MovieEntity;
import org.example.movieproject.request.MovieRequest;
import org.example.movieproject.response.MovieResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface MovieMapper {

    @Mapping(target = "id", ignore = true)
    MovieEntity toEntity(MovieRequest movieRequest);

    MovieResponse toResponse(MovieEntity movieEntity);
}
