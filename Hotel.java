package hotelbookingapp;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Room> rooms;
    private List<Booking> bookings;

    public Hotel() {
        rooms = new ArrayList<>();
        bookings = new ArrayList<>();

        // Rooms and their prices
        rooms.add(new Room(101, "Single", 500));
        rooms.add(new Room(102, "Double", 800));
        rooms.add(new Room(201, "Suite", 1500));
        rooms.add(new Room(202, "Single", 500));
    }

    // Show available rooms to user
    public void showAvailableRooms() {
        System.out.println("=== Available Rooms ===");
        for (Room room : rooms) {
            if (!room.isBooked()) {
                System.out.println(room);
            }
        }
    }

    // Book a room
    public boolean bookRoom(String guestName, int roomNumber, int nights) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && !room.isBooked()) {
                Booking booking = new Booking(guestName, room, nights);
                bookings.add(booking);
                System.out.println("Booking successful: " + booking);
                return true;
            }
        }
        System.out.println("Room " + roomNumber + " is not available.");
        return false;
    }

    // Show all bookings
    public void showBookings() {
        System.out.println("=== All Bookings ===");
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }

    public List<Room> getRooms() {
        return rooms;
    }

    // Get a room by number
    public Room getRoomByNumber(int number) {
        for (Room r : rooms) {
            if (r.getRoomNumber() == number) return r;
        }
        return null;
    }

    // Get booking by guest name
    public Booking getBookingByGuestName(String guestName) {
        for (Booking b : bookings) {
            if (b.getGuestName().equalsIgnoreCase(guestName)) return b;
        }
        return null;
    }
}
