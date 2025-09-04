package hotelbookingapp;

public class Booking {
    private String guestName;
    private Room room;
    private int nights;

    public Booking(String guestName, Room room, int nights) {
        this.guestName = guestName;
        this.room = room;
        this.nights = nights;
        this.room.bookRoom(); // Mark room as booked
    }

    
    public String getGuestName() {
        return guestName;
    }

    // Calculate total costs
    public double calculateCost() {
        return nights * room.getPricePerNight();
    }

    // Show booking details
    @Override
    public String toString() {
        return "Booking for " + guestName + " → Room " + room.getRoomNumber() +
                " (" + room.getRoomType() + "), " + nights + " nights, Total: R" + calculateCost();
    }
}
