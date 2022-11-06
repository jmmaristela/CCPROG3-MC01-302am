public class Tile {

    public enum TileStatus {
        UNPLOWED,
        PLOWED,
        PLANTED,
        WATERED,
        FERTILIZED,
        HARVESTED,
        WITHERED
    }

    private boolean planted = false;
    private boolean harvested = false;
    private boolean withered = false;

    public static Tools myTools = new Tools();

    public static TileStatus currentTileStatus = TileStatus.UNPLOWED;

    public static Plants myPlant1 = new Plants("Turnip", 2,1,2,5);
    public static Plants myPlant2 = new Plants("Potato", 4,2,5,20);
    public static Plants myPlant3 = new Plants("Apple", 7,5,10,200);

    public static Plants myPlanted = new Plants("null", 0,0,0,0);


    public void createTile() {
        for (int i = 1; i <= 5; i++) {

            for (int j = 1; j <= 32; j++) {

                if (i == 1 || i == 5) {
                    if (j < 15 || j > 30) {
                        System.out.print(" ");
                    } else {
                        System.out.print("-");
                    }
                } else if (j == 15 || j == 30 && (i != 3)) {
                    System.out.print("|");

                } else {
                    if (i == 3 && j == 21) {
                        System.out.print("TILE\t |");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }

    public void createCommandMenu() {
        System.out.println("\nAvailable Commands: ");
        System.out.println("[P] Plow Tile\t\t[W] Water Tile");
        System.out.println("[F] FERTILIZE\t\t[H] HARVEST CROP");
        System.out.println("\t[Type \"PLANT\" to plant a seed]");
        System.out.println("\t\t [Q] Quit the game");
    }

    public void displayTile() {

        if (!myTools.isPlowed()) {
            createTile();

            myTools.setPlowed(false);
            currentTileStatus = TileStatus.UNPLOWED;

            System.out.println("\t\t\t\t  " + currentTileStatus);
        } else if (myTools.isPlowed()) {
            createTile();

            if (isPlanted()) {
                currentTileStatus = TileStatus.PLANTED;

                System.out.println("\t\t\t   " + currentTileStatus + " " + myPlanted.getStrSeedName());

                if (myTools.isWatered()) {
                    System.out.println("\t\t\t   " + myTools.WaterCan + "    " + myPlanted.getiWater() + " / " + myPlanted.getiWaterNeeds());
                }
                if (myTools.isFertilized()) {
                    System.out.println("\t\t\t   " + myTools.Fertilizer + " " + myPlanted.getiFertilizer() + " / " + myPlanted.getiFertilizerNeeds());
                }
            }
            else {
                myTools.setPlowed(true);
                currentTileStatus = Tools.PlowTool;

                System.out.println("\t\t\t\t   " + currentTileStatus);
            }
        }

        createCommandMenu();
    }

    public boolean isPlanted() {
        return planted;
    }

    public void setPlanted(boolean planted) {
        this.planted = planted;
    }

    public void plowTile() {
        if (myTools.isPlowed()) {
            System.out.println("Invalid action! Tile is already plowed\n");
        }
        else {
            myTools.setPlowed(true);
            currentTileStatus = Tools.PlowTool;
        }
    }

    public void plantSeed (int i) {

        if (isPlanted()) {
            System.out.println("Invalid action! Tile is already occupied. You have already planted " + myPlanted.getStrSeedName() + "\n");
        }
        else {
            setPlanted(true);
            currentTileStatus = TileStatus.PLANTED;

            switch (i) {
                case 1:
                    myPlanted = myPlant1;
                    break;
                case 2:
                    myPlanted = myPlant2;
                    break;
                case 3:
                    myPlanted = myPlant3;
                    break;
            }

        }
    }

    public void waterSeed(int iWaterNeeds, int iWater) {
        myTools.setWatered(true);

        int iMinWaterNeeds = 0;

        if (myPlanted.equals(myPlant1)) {
            iMinWaterNeeds = myPlanted.getiWaterNeeds() - 1;

            if (iWater == iMinWaterNeeds || iWater >= iWaterNeeds) {
                System.out.println("\nWatering successful");
                System.out.println("Crop is now ready for harvest...");
            }
        }

    }

    public void fertilizeSeed(int iFertilizerNeeds, int iFertilizer) {
        myTools.setFertilized(true);

        int iMinFertilizerNeeds = 0;

        if (myPlanted.equals((myPlant1))) {
            if (iFertilizer == iMinFertilizerNeeds || iFertilizer >= iFertilizerNeeds) {
                System.out.println("Fertilizing successful");
            }
        }

    }

    public void harvestSeed() {


    }


}

