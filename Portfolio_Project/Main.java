import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkedList<Vehicle> vehicleList = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);

        // Prompt user for vehicle data in a loop
        while(true) {
            System.out.println("Enter the vehicle make or 'quit' to exit program: ");
            String make = scanner.nextLine();
            if(make.equalsIgnoreCase("quit")) {
                break; // If user enters quit then exit the loop
            }

            System.out.print("Enter the vehicle model: ");
            String model = scanner.nextLine();

            double milesPerGallon;
            while(true) {
                System.out.print("Enter the vehicles miles per gallon: ");
                String mpgString = scanner.nextLine();
                try {
                    milesPerGallon = Double.parseDouble(mpgString);
                    break; // Exit loop if the input is a valid double
                } catch(NumberFormatException e) {
                    System.out.println("Invalid input. Please a valid numeric value.");
                }
            }

            // Create a new Vehicle object and add it to linked list
            Vehicle vehicle = new Vehicle(make, model, milesPerGallon);
            vehicleList.add(vehicle);
        }

        // Sorting the linked list by miles per gallon in ascending order
        Collections.sort(vehicleList, Comparator.comparingDouble(Vehicle::getMilesPerGallon));

        // Writing sorted vehicle data to a text file
        try(PrintWriter writer = new PrintWriter("vehicle_data.txt")) {
            for (Vehicle vehicle : vehicleList) {
                writer.println("Make: " + vehicle.getMake());
                writer.println("Model: " + vehicle.getModel());
                writer.println("Miles per Gallon: " + vehicle.getMilesPerGallon());
                writer.println();
            }
        } catch(IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }

        System.out.println("Vehicle data has been written to 'vehicle_data.txt'.");
    }
}