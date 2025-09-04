package tvseriesapp;

import java.util.ArrayList;
import java.util.Scanner;

public class Operations {
    private ArrayList<Series> seriesList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public ArrayList<Series> getSeriesList() {
        return seriesList;
    }

    // New series
    public void captureSeries() {
        System.out.println("\nCAPTURE A NEW SERIES");

        System.out.print("Enter the series id: ");
        String id = scanner.nextLine();

        System.out.print("Enter the series name: ");
        String name = scanner.nextLine();

        int age;
        while (true) {
            try {
                System.out.print("Enter the series age restriction: ");
                age = Integer.parseInt(scanner.nextLine());

                if (age >= 2 && age <= 18) {
                    break;
                } else {
                    System.out.println("You have entered an incorrect series age!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number for age.");
            }
        }

        int episodes;
        while (true) {
            try {
                System.out.print("Enter the number of episodes: ");
                episodes = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number for episodes.");
            }
        }

        Series s = new Series(id, name, age, episodes);
        seriesList.add(s);
        System.out.println("Series processed successfully!!!");
    }

    // Search for a series by ID 
    public void searchSeries() {
        System.out.print("Enter the series id to search: ");
        String id = scanner.nextLine();

        Series found = searchSeriesById(id);
        if (found != null) {
            found.displaySeriesDetails();
        } else {
            System.out.println("Series with Series Id: " + id + " was not found!");
        }
    }

    public Series searchSeriesById(String id) {
        for (Series s : seriesList) {
            if (s.getSeriesId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    // Update series details via console
    public void updateSeries() {
        System.out.print("Enter the series id to update: ");
        String id = scanner.nextLine();

        if (!updateSeriesByIdConsole(id)) {
            System.out.println("Series with Series Id: " + id + " was not found!");
        }
    }

    public boolean updateSeriesById(String id, String newName, int newAge, int newEpisodes) {
        Series s = searchSeriesById(id);
        if (s != null) {
            s.setSeriesName(newName);
            s.setSeriesAge(newAge);
            s.setNumberOfEpisodes(newEpisodes);
            return true;
        }
        return false;
    }

    private boolean updateSeriesByIdConsole(String id) {
        for (Series s : seriesList) {
            if (s.getSeriesId().equals(id)) {
                System.out.print("Enter the new series name: ");
                s.setSeriesName(scanner.nextLine());

                int age;
                while (true) {
                    try {
                        System.out.print("Enter the new age restriction: ");
                        age = Integer.parseInt(scanner.nextLine());

                        if (age >= 2 && age <= 18) {
                            s.setSeriesAge(age);
                            break;
                        } else {
                            System.out.println("You have entered an incorrect series age!!!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number for age.");
                    }
                }

                System.out.print("Enter the new number of episodes: ");
                s.setNumberOfEpisodes(Integer.parseInt(scanner.nextLine()));

                System.out.println("Series updated successfully!");
                return true;
            }
        }
        return false;
    }

    // Delete a series
    public void deleteSeries() {
        System.out.print("Enter the series id to delete: ");
        String id = scanner.nextLine();

        if (!deleteSeriesByIdConsole(id)) {
            System.out.println("Series with Series Id: " + id + " was not found!");
        }
    }

    // Helper method 
    public boolean deleteSeriesById(String id) {
        Series s = searchSeriesById(id);
        if (s != null) {
            seriesList.remove(s);
            return true;
        }
        return false;
    }

    // Private method to delete 
    private boolean deleteSeriesByIdConsole(String id) {
        for (Series s : seriesList) {
            if (s.getSeriesId().equals(id)) {
                System.out.print("Are you sure you want to delete series " + id + "? (y/n): ");
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("y")) {
                    seriesList.remove(s);
                    System.out.println("Series with Series Id: " + id + " was deleted!");
                } else {
                    System.out.println("Delete cancelled.");
                }
                return true;
            }
        }
        return false;
    }

    // Print report of all series
    public void seriesReport2025() {
        System.out.println("\nLATEST SERIES REPORT - 2025");
        if (seriesList.isEmpty()) {
            System.out.println("No series captured yet.");
        } else {
            int counter = 1;
            for (Series s : seriesList) {
                System.out.println("Series " + counter++);
                s.displaySeriesDetails();
                System.out.println();
            }
        }
    }
}
