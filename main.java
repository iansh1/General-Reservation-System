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
        }

    }
}
