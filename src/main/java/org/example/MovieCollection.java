package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class MovieCollection {
    private List<Movie> movies;

    public static MovieCollection readFromJson(String filePath) {
        Gson gson = new Gson();
        try {
            String jsonContent = Files.readString(Path.of(filePath));
            return gson.fromJson(jsonContent, MovieCollection.class);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка загрузки JSON файла: " + filePath, e);
        }
    }

    public void displayMovies() {
        movies.forEach(System.out::println);
    }

    public List<Movie> searchByName(String name) {
        return movies.stream()
                .filter(movie -> movie.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void sortMoviesByYear(boolean ascending) {
        movies.sort(Comparator.comparingInt(Movie::getYear));
        if (!ascending) Collections.reverse(movies);
    }

    public void sortMoviesByName(boolean ascending) {
        movies.sort(Comparator.comparing(Movie::getName));
        if (!ascending) Collections.reverse(movies);
    }

    public void sortMoviesByDirector(boolean ascending) {
        movies.sort(Comparator.comparing(movie -> movie.getDirector().getFullName()));
        if (!ascending) Collections.reverse(movies);
    }
}
