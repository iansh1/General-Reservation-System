import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReservationSystemTest {

    private ReservationSystem system;

    @Before
    public void setUp() {
        int[] tableSizes = {2, 4, 4, 6, 8};
        String[] timeSlots = {"6:00 PM", "7:00 PM", "8:00 PM"};
        system = new ReservationSystem(tableSizes, timeSlots);
    }

    @Test
    public void testMakeReservation_Successful() {
        Customer customer = new Customer("Alice", "1234567890", 2);
        boolean result = system.makeReservation(customer, "7:00 PM");

        assertTrue("Reservation should be successful.", result);
        assertTrue("Reservation should be stored with customer's phone number.", 
                   system.getReservations().containsKey("1234567890"));
    }

    @Test
    public void testCancelReservation_Successful() {
        Customer customer = new Customer("Charlie", "1112223333", 4);
        system.makeReservation(customer, "6:00 PM");

        assertTrue(system.getReservations().containsKey("1112223333"));

        boolean result = system.cancelReservation("1112223333");

        assertTrue(result);
        assertFalse(system.getReservations().containsKey("1112223333"));
    }

    @Test
    public void testWaitlist_Priority() {
        for (int i = 0; i < 5; i++) {
            Customer tempCustomer = new Customer("Customer" + i, "800000000" + i, 2);
            system.makeReservation(tempCustomer, "6:00 PM");
        }

        Customer customer1 = new Customer("Diana", "5551110000", 4);
        Customer customer2 = new Customer("Eve", "5552220000", 4);

        system.makeReservation(customer1, "6:00 PM");
        system.makeReservation(customer2, "6:00 PM");

        assertEquals(2, system.getWaitlist().size());
        
        system.cancelReservation("8000000000");

        assertEquals(1, system.getWaitlist().size());
    }
}