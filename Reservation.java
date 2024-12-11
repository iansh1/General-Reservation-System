public class Reservation {
    private Customer customer;
    private String timeSlot;
    private int tableNumber;

    public Reservation(Customer customer, String timeSlot, int tableNumber) {
        this.customer = customer;
        this.timeSlot = timeSlot;
        this.tableNumber = tableNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    @Override
    public String toString() {
        return "Reservation{customer=" + customer + ", timeSlot='" + timeSlot + "', tableNumber=" + tableNumber + "}";
    }
}
