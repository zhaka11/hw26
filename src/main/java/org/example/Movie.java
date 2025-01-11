package org.example;

import java.util.List;

public class Movie {
    private String name;
    private int year;
    private List<String> genres;
    private String type;
    private List<Integer> length;
    private double budget;
    private Director director;
    private List<Actor> cast;

    public String getName() { return name; }
    public int getYear() { return year; }
    public List<String> getGenres() { return genres; }
    public String getType() { return type; }
    public List<Integer> getLength() { return length; }
    public double getBudget() { return budget; }
    public Director getDirector() { return director; }
    public List<Actor> getCast() { return cast; }

    @Override
    public String toString() {
        return "\n=========================================" +
                "\nФильм: " + name +
                "\nГод выпуска: " + year +
                "\nЖанры: " + String.join(", ", genres) +
                "\nТип: " + type +
                "\nДлительность: " + (length != null ? length + " минут" : "не указано") +
                "\nБюджет: $" + String.format("%,.2f", budget) +
                "\nРежиссер: " + director +
                "\nАктерский состав: " + (cast != null ? cast : "не указан") +
                "\n=========================================";
    }
}
