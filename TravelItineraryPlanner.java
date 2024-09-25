import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Destination {
    private String name;
    private String date;
    private String preferences;

    public Destination(String name, String date, String preferences) {
        this.name = name;
        this.date = date;
        this.preferences = preferences;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getPreferences() {
        return preferences;
    }

    @Override
    public String toString() {
        return "Destination: " + name + "\nDate: " + date + "\nPreferences: " + preferences;
    }
}

public class TravelItineraryPlanner {
    private List<Destination> itinerary;

    public TravelItineraryPlanner() {
        itinerary = new ArrayList<>();
    }

    public void addDestination(String name, String date, String preferences) {
        Destination destination = new Destination(name, date, preferences);
        itinerary.add(destination);
        System.out.println("Added: " + destination.getName());
    }

    public void viewItinerary() {
        System.out.println("\n--- Your Travel Itinerary ---");
        if (itinerary.isEmpty()) {
            System.out.println("No destinations added.");
        } else {
            for (Destination destination : itinerary) {
                System.out.println(destination);
            }
        }
    }

    public void calculateBudget() {
        // Mock budget calculation
        double totalBudget = 0;
        for (Destination destination : itinerary) {
            totalBudget += 500; // Assuming a fixed cost per destination
        }
        System.out.println("Estimated total budget: $" + totalBudget);
    }

    public void getWeatherInfo(String destination) {
        // Placeholder for weather information
        System.out.println("Weather information for " + destination + ":");
        System.out.println("Sunny, 75°F (placeholder info)");
    }

    public static void main(String[] args) {
        TravelItineraryPlanner planner = new TravelItineraryPlanner();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Travel Itinerary Planner ---");
            System.out.println("1. Add Destination");
            System.out.println("2. View Itinerary");
            System.out.println("3. Calculate Budget");
            System.out.println("4. Get Weather Info");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter destination name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter preferences: ");
                    String preferences = scanner.nextLine();
                    planner.addDestination(name, date, preferences);
                    break;
                case 2:
                    planner.viewItinerary();
                    break;
                case 3:
                    planner.calculateBudget();
                    break;
                case 4:
                    System.out.print("Enter destination for weather info: ");
                    String weatherDestination = scanner.nextLine();
                    planner.getWeatherInfo(weatherDestination);
                    break;
                case 5:
                    System.out.println("Exiting... Thank you for using the travel itinerary planner!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
