public class Tile {

    public enum TileStatus {
        UNPLOWED,
        PLOWED,
        WATERED,
        FERTILIZED,
        HARVESTED,
        WITHERED
    }

    Tools myTools = new Tools();

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
            Tools.PlowTool = TileStatus.UNPLOWED;

            System.out.println("\t\t\t\t  " + Tools.PlowTool);
        } else if (myTools.isPlowed()) {
            createTile();

            myTools.setPlowed(true);
            Tools.PlowTool = TileStatus.PLOWED;
            System.out.println("\t\t\t\t   " + Tools.PlowTool);
        }

        createCommandMenu();
    }

    public void plowTile() {
        if (myTools.isPlowed()) {
            System.out.println("Invalid action! Tile is already plowed\n");
        }
        else {
            myTools.setPlowed(true);
            Tools.PlowTool = Tile.TileStatus.PLOWED;
        }
    }

    public void waterTile() {

    }

    public void fertilizeTile() {


    }

    public void harvestTile() {


    }


}

