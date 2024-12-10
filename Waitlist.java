import java.util.LinkedList;
import java.util.Queue;

public class Waitlist {
    private Queue<Customer> waitlist;

    public Waitlist() {
        waitlist = new LinkedList<>();
    }
    public void addToWaitlist(Customer customer) {
        waitlist.add(customer);
    }
    public Customer getNextCustomer() {
        return waitlist.poll(); //first in first out
    }

    public boolean isEmpty() {
        return waitlist.isEmpty();
    }

    public int size() {
        return waitlist.size();
    }

}
