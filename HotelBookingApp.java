package hotelbookingapp;

import java.util.Scanner;

public class HotelBookingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();

        System.out.println("Welcome to the Hotel Booking App!");  // Greeting for users

        while (true) {
            System.out.println("\n=== MENU ===");  // The menu and all the available options down below
            System.out.println("1. Show available rooms");
            System.out.println("2. Book a room");
            System.out.println("3. Show all bookings");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> hotel.showAvailableRooms();
                case 2 -> {
                    System.out.print("Enter guest name: ");   // Name of user
                    String name = scanner.nextLine();
                    System.out.print("Enter room number: ");   
                    int roomNumber = scanner.nextInt();
                    System.out.print("Enter number of nights: "); 
                    int nights = scanner.nextInt();
                    hotel.bookRoom(name, roomNumber, nights);
                }
                case 3 -> hotel.showBookings();
                case 4 -> {
                    System.out.println("Thank you for choosing our hotel. We hope to see you again soon!"); // Exit message to the user when they leave the app
                    return;
                }
                default -> System.out.println("Invalid choice."); //Message displayed when user inputs a invalid answer
            }
        }
    }
}
