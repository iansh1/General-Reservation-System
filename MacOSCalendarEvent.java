import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MacOSCalendarEvent {

    public static void main(String[] args) {
        // Event Details
        String title = "Meeting with John";
        String startDate = "2024-12-30 14:00:00"; // Format: "YYYY-MM-DD HH:MM:SS"
        String endDate = "2024-12-30 15:00:00";   // End date should be after start date
        String description = "Discuss project progress.";
        String location = "Online - Zoom";

        // AppleScript for Calendar event
        String appleScript = String.format(
            "tell application \"Calendar\"\n" +
            "   set newEvent to make new event with properties {summary:\"%s\", start date:date \"%s\", end date:date \"%s\"}\n" +
            "   tell newEvent\n" +
            "       set description to \"%s\"\n" +
            "       set location to \"%s\"\n" +
            "   end tell\n" +
            "end tell",
            title, startDate, endDate, description, location
        );

        runAppleScript(appleScript);
    }

    /**
     * Runs the given AppleScript command on macOS
     * @param script The AppleScript command to execute
     */
    public static void runAppleScript(String script) {
        String[] command = { "osascript", "-e", script };

        try {
            Process process = new ProcessBuilder(command).start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Calendar event added successfully.");
            } else {
                System.out.println("Failed to add event. Exit code: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}