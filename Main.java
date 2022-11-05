
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static final Scanner input = new Scanner(System.in); //This is intended for user inputs

    public static Farmer myFarmer = new Farmer();
    public static Tile myTile = new Tile();

    public static Plants myPlant1 = new Plants("Turnip", 2,1,2,5);
    public static Plants myPlant2 = new Plants("Potato", 4,2,5,20);
    public static Plants myPlant3 = new Plants("Apple", 7,5,10,200);


    public static boolean isRunning = true;

    /* This is the main driver function of this java program */
    public static void main(String[] args) {

        /* Declaration of Variables */
        int iChoice;
        int iCropChoice;

        String strCommand;

        /* PROGRAM IMPLEMENTATION */
        System.out.print("Enter your username: ");
        myFarmer.setStrUsername(input.nextLine());

        System.out.println("Hello, " + myFarmer.getStrUsername() + "! Welcome to this farming simulation game...\n");

        System.out.println("\t\t\t MAIN MENU\t\t");
        System.out.println("[1] Start the game\t\t[2] Exit");

        do {
            iChoice = inputChoice();

            if (iChoice != 1 && iChoice != 2) {
                System.out.println("Invalid input! Please try again...");
            }

        }while (iChoice != 1 && iChoice != 2);

        switch(iChoice) {
            case 1:
                System.out.println("\n\t\t------START OF THE GAME-----\n");
                while (isRunning) {
                    System.out.print("Day 0\n");
                    System.out.print("Current Farmer Level: " + myFarmer.getiFarmerLevel());
                    System.out.print("\t\t" + "Object Coins: " + myFarmer.getdObjectCoins() + "\n");

                    myTile.displayTile();
                    strCommand = inputCommand();

                    switch (strCommand) {
                        case "P":
                        case "p":
                            myTile.plowTile();
                            break;

                        case "PLANT":
                            if (myTile.myTools.isPlowed()) {
                                displayListOfPlants();

                            }
                            else {
                                System.out.println("Invalid action! Tile is not yet plowed\n");
                            }
                            break;

//                        case "W":
//                        case "w":
//
//                            break;
//
//                        case "F":
//                        case "f":
//
//                            break;
//
//                        case "H":
//                        case "h":
//
//                            break;

                        case "Q":
                        case "q":
                            isRunning = false;
                            System.out.println("\nExiting simulation...");
                            System.exit(0);
                            break;

                        default:
                            System.out.println("Invalid input! Command error, please try again...\n");
                            break;
                    }
                }
                break;

            case 2:
                isRunning = false;
                System.out.println("Exiting simulation...");
                System.exit(0);
                break;
        }

    }

    /* Functions */
    public static int inputChoice() {
        System.out.println("Please enter your choice: ");
        return input.nextInt();
    }

    public static String inputCommand () {
        System.out.println("\nSelect input from the following options: ");
        return input.next();
    }

    public static void displayListOfPlants() {
        System.out.println("\nPlease select from the list of available seeds:");
        System.out.println("\nSeed Name\tWater Needs\t\tFertilizer Needs\tHarvest Time\tSeed Cost");

        myPlant1.display(1);
        myPlant2.display(2);
        myPlant3.display(3);

        System.out.println("\n\n");
    }

}
