package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MovieCollection collection = MovieCollection.readFromJson("src/main/resources/movies.json");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Показать все фильмы");
            System.out.println("2. Искать фильмы по названию");
            System.out.println("3. Сортировать фильмы");
            System.out.println("4. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> collection.displayMovies();
                case 2 -> {
                    System.out.print("Введите название: ");
                    String name = scanner.nextLine();
                    List<Movie> results = collection.searchByName(name);
                    results.forEach(System.out::println);
                }
                case 3 -> {
                    System.out.println("1. Сортировать по году");
                    System.out.println("2. Сортировать по названию");
                    System.out.println("3. Сортировать по режиссеру");
                    int sortChoice = scanner.nextInt();
                    System.out.print("Сортировать по возрастанию? (true/false): ");
                    boolean ascending = scanner.nextBoolean();
                    switch (sortChoice) {
                        case 1 -> collection.sortMoviesByYear(ascending);
                        case 2 -> collection.sortMoviesByName(ascending);
                        case 3 -> collection.sortMoviesByDirector(ascending);
                    }
                }
                case 4 -> {
                    System.out.println("Выход...");
                    return;
                }
                default -> System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}
