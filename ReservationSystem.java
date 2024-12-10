import java.util.HashMap;
import java.util.LinkedList;

public class ReservationSystem {
    private HashMap<String, Reservation> reservations;
    private TableManager tableManager;
    private LinkedList<String> availableTimeSlots;
    private Waitlist waitlist;

    public ReservationSystem(int[] tableSizes, String[] timeSlots) {
        reservations = new HashMap<>();
        tableManager = new TableManager(tableSizes);
        availableTimeSlots = new LinkedList<>();
        for (String timeSlot : timeSlots) {
            availableTimeSlots.add(timeSlot);
        }
        waitlist = new Waitlist();
    }
    public boolean makeReservation(Customer customer, String timeSlot) {
        if (!availableTimeSlots.contains(timeSlot)) {
            System.out.println("Time is not available.");
            return false;
        }
        Integer tableSize = tableManager.findBestTable(customer.getPartySize());
        if (tableSize == null) {
            System.out.println("No table available. Adding customer to the waitlist.");
            waitlist.addToWaitlist(customer);
            return false;
        }

        tableManager.reserveTable(tableSize);
        Reservation reservation = new Reservation(customer, timeSlot, tableSize);
        reservations.put(customer.getPhoneNumber(), reservation);
        System.out.println("Reservation confirmed:" + reservation);
        return true;
    


    }
    
}


