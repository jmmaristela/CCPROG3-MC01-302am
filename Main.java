import java.util.Scanner;

// Updated as of Nov 6, 8:28pm

public class Main {

    public static final Scanner input = new Scanner(System.in); //This is intended for user inputs

    public static Farmer myFarmer = new Farmer();
    public static Tile myTile = new Tile();

    public static final Stats myStats = new Stats();

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
                    System.out.println("-----------------------------------------------");
                    System.out.print("Day 0\n");
                    System.out.print("Current Farmer Level: " + myFarmer.getiFarmerLevel());
                    System.out.print("\t\t" + "Object Coins: " + myFarmer.getdObjectCoins() + "\n");

                    myTile.displayTile();
                    strCommand = inputCommand();

                    switch (strCommand) {
                        case "P":
                        case "p":
                            if (!myTile.myTools.isPlowed()) {
                                myStats.addTimesPlowed();
                            }

                            myTile.plowTile();

                            break;

                        case "PLANT":
                            if (Tile.myTools.isPlowed() && !myTile.isPlanted()) {
                                displayListOfPlants();

                                do {
                                    iCropChoice = inputCropChoice();

                                    if (iCropChoice != 1 && iCropChoice != 2 && iCropChoice != 3) {
                                        System.out.println("Invalid input! Please try again...\n");
                                    }

                                } while (iCropChoice != 1 && iCropChoice != 2 && iCropChoice != 3);

                                switch (iCropChoice) {
                                    case 1:
                                        if (myFarmer.getdObjectCoins() >= Tile.myPlanted.getdSeedCost()) {
                                            myTile.plantSeed(iCropChoice);

                                            myFarmer.setdObjectCoins(myFarmer.computeCost(Tile.myPlanted.getdSeedCost()));

                                            myStats.addTimesPlanted();

                                        }
                                        else {
                                            System.out.println("Planting failed! Insufficient coins...");
                                        }
                                        break;
                                    default:
                                        System.out.println("Functionality not available yet as per specifications");
                                        System.out.println("Sorry for the inconvenience...");
                                        break;

                                }

                            }
                            else {
                                if (myTile.isPlanted()) {
                                    System.out.println("Invalid action! Tile is occupied. You have already planted " + Tile.myPlanted.getStrSeedName() + "\n");
                                }
                                else {
                                    System.out.println("Invalid action! Tile is not yet plowed\n");
                                }
                            }
                            break;

                        case "W":
                        case "w":
                            if (Tile.myTools.isPlowed() && myTile.isPlanted()) {
                                Tile.myTools.setWatered(true);

                                myStats.addTimesWatered();

                                Tile.myPlanted.setiWater(myStats.getTimesWatered());

                                myTile.waterSeed(Tile.myPlanted.getiWaterNeeds(), myStats.getTimesWatered());

                            }
                            else {
                                if (!Tile.myTools.isPlowed()) {
                                    System.out.println("Invalid action! Tile is not yet plowed\n");
                                }
                                else {
                                    System.out.println("Invalid action! No seed planted yet\n");
                                }
                            }

                            break;

                        case "F":
                        case "f":
                            if (Tile.myTools.isPlowed() && myTile.isPlanted()) {

                                if (myFarmer.getdObjectCoins() >= Tile.myTools.getiFertilizerCost()) {
                                    Tile.myTools.setFertilized(true);

                                    myStats.addTimesFertilized();

                                    Tile.myPlanted.setiFertilizer(myStats.getTimesFertilized());

                                    myTile.fertilizeSeed(Tile.myPlanted.getiFertilizerNeeds(), myStats.getTimesFertilized());

                                    myFarmer.setdObjectCoins(myFarmer.computeCost(Tile.myTools.getiFertilizerCost()));

                                }
                                else {
                                    System.out.println("Fertilizing failed! Insufficient coins...");
                                }
                            }
                            else {
                                if (!Tile.myTools.isPlowed()) {
                                    System.out.println("Invalid action! Tile is not yet plowed\n");
                                }
                                else {
                                    System.out.println("Invalid action! No seed planted yet\n");
                                }
                            }

                            break;

                        case "H":
                        case "h":

                            break;

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

                    System.out.println("\n" + myStats);
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

    public static String inputCommand() {
        System.out.println("\nSelect input from the following options: ");
        return input.next();
    }

    public static void displayListOfPlants() {
        System.out.println("\nPlease select from the list of available seeds:");
        System.out.println("\nSeed Name\tWater Needs\t\tFertilizer Needs\tHarvest Time\tSeed Cost");

        Tile.myPlant1.display(1);
        Tile.myPlant2.display(2);
        Tile.myPlant3.display(3);
    }

    public static int inputCropChoice() {
        System.out.println("Enter the number of the seed you want to choose: ");
        return input.nextInt();
    }

}
