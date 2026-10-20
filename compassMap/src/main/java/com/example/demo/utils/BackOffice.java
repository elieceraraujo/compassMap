package com.example.demo.utils;

import com.example.demo.model.RoadMap;
import com.example.demo.service.CustomerService;
import com.example.demo.service.RoadMapService;

import java.util.Scanner;

public class BackOffice {

    //static Scanner scan = new Scanner(System.in);

    // it is the entry-point for the backoffice class
    // and it has the main MENU, main options
    // and CRUD operation for our model and fake data
    public static void startBackOffice(PopulatorDB populatorDB) {
        // We will create just one scanner object
        // and it will pass to another methods

        Scanner scan = new Scanner(System.in);

        while (true) {
            mainMenu();

            String option = askMenuOption(scan);

            switch (option) {
                case "1":
                    customerLoop(scan, populatorDB);
                    break;
                case "2":
                    roadMapLoop(scan, populatorDB);
                    break;
                case "3":
                    System.out.println("Profile - not implemented yet.");
                    break;
                case "4":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }

    public static void customerLoop(Scanner scan, PopulatorDB populatorDB) {
        boolean inCustomerMenu = true;
        while (inCustomerMenu) {
            customerMenu();
            String custOption = scan.nextLine();
            switch (custOption) {
                case "1":
                    System.out.print("How many customers? ");
                    int count = Integer.parseInt(scan.nextLine());
                    populatorDB.createAndSaveCustomer(count);
                    System.out.println(count + " customers created and saved.");
                    break;
                case "2":
                    System.out.print("Customer ID to delete: ");
                    String id = scan.nextLine();
                    populatorDB.customerService.deleteCustomer(id);
                    System.out.println("Customer " + id + " deleted.");
                    break;
                case "3":
                    populatorDB.customerService.deleteAllCustomers();
                    System.out.println("All customers deleted.");
                    break;
                case "4":
                    long total = populatorDB.customerService.countCustomers();
                    System.out.println("Total customers: " + total);
                    break;
                case "5":
                    inCustomerMenu = false;
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }

    public static void roadMapLoop(Scanner scan, PopulatorDB populatorDB){
        boolean inRoadMapMenu = true;
        while (inRoadMapMenu) {
            roadMapMenu();
            String roadOption = scan.nextLine();
            switch (roadOption) {
                case "1":
                    //System.out.print("How many RoadMaps? ");
                    //int count = Integer.parseInt(scan.nextLine());
                    //populatorDB.createAndSaveRoadMap(count);
                    //System.out.println(count + " RoadMaps created and saved.");
                    CreateRoadMap(scan, populatorDB);
                    break;
                case "2":
                    System.out.print("RoadMap ID to delete: ");
                    String id = scan.nextLine();
                    populatorDB.roadMapService.deleteRoadMapById(id);
                    System.out.println("RoadMap " + id + " deleted.");
                    break;
                case "3":
                    populatorDB.roadMapService.deleteAllRoadMaps();
                    System.out.println("All RoadMaps deleted.");
                    break;
                case "4":
                    UpdateRoadMap(scan, populatorDB);
                    break;
                case "5":
                    long total = populatorDB.roadMapService.countRoadMaps();
                    System.out.println("Total RoadMaps: " + total);
                    break;
                case "6":
                    inRoadMapMenu = false;
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }
    public static void roadMapMenu() {
        System.out.println("\n===== ROADMAP MENU =====");
        System.out.println("1. Create roadMaps");
        System.out.println("2. Delete roadMap by ID");
        System.out.println("3. Delete all roadMaps");
        System.out.println("4. Update roadMaps");
        System.out.println("5. Count roadMaps");
        System.out.println("6. Quit");
    }
    public static void customerMenu() {
        System.out.println("\n===== CUSTOMER MENU =====");
        System.out.println("1. Create customers");
        System.out.println("2. Delete customer");
        System.out.println("3. Delete all customers");
        System.out.println("4. Count customers");
        System.out.println("5. Quit");
    }

    public static void mainMenu() {
        System.out.println("\n===== MAIN MENU =====");
        System.out.println("1. Customer");
        System.out.println("2. Roadmap");
        System.out.println("3. Profile");
        System.out.println("4. Quit");

    }

    public static String askMenuOption(Scanner scan){
        System.out.print("Select an option: ");
        String option = scan.nextLine();
        return option;
    }

    public static RoadMap CreateRoadMap(Scanner scan, PopulatorDB populatorDB){
        System.out.println("Creating RoadMap");
        System.out.println("================");

        return populatorDB.roadMapService.createRoadMap(MakeRoadMap(scan));
    }

    public static void DeleteRoadMapById(Scanner scan, PopulatorDB populatorDB){
        System.out.println("Deleting RoadMap by ID");
        System.out.println("======================");

        System.out.println("Enter ID of RoadMap to be deleted");
        String id = scan.nextLine();

        populatorDB.roadMapService.deleteRoadMapById(id);
        System.out.print("RoadMap has been delete successfully.");

        return;
    }
    public static void UpdateRoadMap(Scanner scan, PopulatorDB populatorDB){
        System.out.println("Updating RoadMap");
        System.out.println("================");

        System.out.println("Enter ID of RoadMap to be updated");
        String id = scan.nextLine();

        populatorDB.roadMapService.updateRoadMap(id, MakeRoadMap(scan));
        System.out.print("RoadMap has been updated successfully.");

        return;
    }
    private static RoadMap MakeRoadMap(Scanner scan){
        System.out.println("Enter name of RoadMap");
        String name = scan.nextLine();
        System.out.println("Enter a brief description of RoadMap");
        String description = scan.nextLine();
        System.out.println("Enter the steps of RoadMap");
        int steps  = Integer.parseInt(scan.nextLine());

        return new RoadMap(name, description, steps, false);
    }
}
