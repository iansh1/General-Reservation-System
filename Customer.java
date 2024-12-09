
//getting and storing customer data
public class Customer {
    private String name;
    private String phoneNumber;
    private int partySize;

    public Customer(String name, String phoneNumber, int partySize) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.partySize = partySize;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getPartySize() {
        return partySize;
    }

    @Override
    public String toString() {
        return "Customer{name='" + name + "', phoneNumber='" + phoneNumber + "', partySize=" + partySize + "}";
    }
}
