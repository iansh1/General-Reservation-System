public class Reservation {
    private Customer customer;
    private String timeSlot;
    private int tableNumber;

    public Reservation(Customer customer, String timeSlot, int tableNumber) {
        this.customer = customer;
        this.timeSlot = timeSlot;
        this.tableNumber = tableNumber;
    }
}
