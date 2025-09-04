package tvseriesapp;

import java.util.Scanner;

public class TVSeriesApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Operations ops = new Operations();

        System.out.println("LATEST SERIES 2025");
        System.out.print("Enter 1 to launch menu or any other key to exit: ");
        String start = scanner.nextLine();

        if (!start.equals("1")) {
            System.out.println("Exiting application...");
            return;
        }

        while (true) {
            // Display menu
            System.out.println("\nPlease select one of the following menu items:");
            System.out.println("(1) Capture a new series");
            System.out.println("(2) Search for a series");
            System.out.println("(3) Update series");
            System.out.println("(4) Delete a series");
            System.out.println("(5) Print series report - 2025");
            System.out.println("(6) Exit Application");

            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    ops.captureSeries();
                    break;
                case "2":
                    ops.searchSeries();
                    break;
                case "3":
                    ops.updateSeries();
                    break;
                case "4":
                    ops.deleteSeries();
                    break;
                case "5":
                    ops.seriesReport2025();
                    break;
                case "6":
                    System.out.println("Exiting application...");
                    return;
                default:
                    System.out.println("Invalid option, please try again."); // Response to invalid input
            }

            System.out.print("\nEnter (1) to launch menu or any other key to exit: ");
            String again = scanner.nextLine();
            if (!again.equals("1")) {
                System.out.println("Exiting application...");
                break;
            }
        }

        scanner.close();
    }
}

