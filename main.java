import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //initial setup
        int[] tableSizes = {2, 4, 4, 6, 8}; //Sizes of tables in the restaurant, changeable
        String[] timeSlots = {"6:00 PM", "7:00 PM", "8:00 PM"}; //times also changeable
        ReservationSystem system = new ReservationSystem(tableSizes, timeSlots);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n- Restaurant Reservation System -");
            System.out.println("1. Make a Reservation");
            System.out.println("2. Cancel a Reservation");
            System.out.println("3. View current Reservations");
            System.out.println("4. View the Waitlist");
            System.out.println("5. View the Available Tables");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); //clear newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter party size: ");
                    int partySize = scanner.nextInt();

                    scanner.nextLine(); //clear newline
                    System.out.print("Enter time slot: ");
                    String timeSlot = scanner.nextLine();
                    Customer customer = new Customer(name, phone, partySize);
                    system.makeReservation(customer, timeSlot);
                    break;
                case 2:
                    System.out.print("Enter phone number to cancel reservation: ");
                    String phoneNumber = scanner.nextLine();
                    system.cancelReservation(phoneNumber);
                    break;
                case 3:
                    system.displayReservations();
                    break;
                case 4:
                    system.displayWaitlist();
                    break;
                case 5:
                    system.displayAvailableTables();
                    break;
                case 6:
                    System.out.println("Exiting system.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        
        }

    }
}
