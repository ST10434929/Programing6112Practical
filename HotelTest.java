package hotelbookingapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    private Hotel hotel;

    @BeforeEach
    void setUp() {
        hotel = new Hotel();
    }

    @Test
    void testShowAvailableRooms() {
        assertEquals(4, hotel.getRooms().size()); // initially all rooms available
    }

    @Test
    void testBookRoomSuccess() {
        boolean booked = hotel.bookRoom("Alice", 101, 3);
        assertTrue(booked);

        Room room101 = hotel.getRoomByNumber(101);
        assertTrue(room101.isBooked());
    }

    @Test
    void testBookRoomAlreadyBooked() {
        hotel.bookRoom("Alice", 101, 3);
        boolean booked = hotel.bookRoom("Bob", 101, 2);
        assertFalse(booked);
    }

    @Test
    void testBookingCostCalculation() {
        hotel.bookRoom("Alice", 102, 4);
        Booking booking = hotel.getBookingByGuestName("Alice");
        assertEquals(3200, booking.calculateCost()); // 800 * 4 nights
    }
}
