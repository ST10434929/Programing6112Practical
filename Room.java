package hotelbookingapp;

public class Room {
    private int roomNumber;
    private String roomType;
    private double pricePerNight;
    private boolean booked;

    
    public Room(int roomNumber, String roomType, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.booked = false;
    }

   
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public boolean isBooked() {
        return booked;
    }

    // Book the room
    public void bookRoom() {
        this.booked = true;
    }

    // Free the room
    public void freeRoom() {
        this.booked = false;
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + " (" + roomType + ") - R" + pricePerNight + " per night" +
               (booked ? " [BOOKED]" : " [AVAILABLE]");
    }
}
