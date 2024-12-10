import java.util.TreeSet;

public class TableManager {
    private TreeSet<Integer> availableTables;
    public TableManager(int[] tableSizes) {
        availableTables = new TreeSet<>();
        for (int size : tableSizes) {
            availableTables.add(size);
        }
    }

    public Integer findBestTable(int partySize) {
        return availableTables.ceiling(partySize); //logic to find the smallest table given a party size
    }

    public void reserveTable(int tableSize) {
        availableTables.remove(tableSize);
    }







    @Override
    public String toString() {
        return "Available tables: " + availableTables.toString();
    }
}
