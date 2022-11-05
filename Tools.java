public class Tools {

    /* Initialize values to false */
    private boolean plowed = false;
    private boolean watered = false;
    private boolean fertilized = false;

    public static Tile.TileStatus PlowTool = Tile.TileStatus.PLOWED;
    public static Tile.TileStatus WaterCan = Tile.TileStatus.WATERED;
    public static Tile.TileStatus Fertilizer = Tile.TileStatus.FERTILIZED;

    public boolean isPlowed() {
        return plowed;
    }

    public void setPlowed(boolean plowed) {
        this.plowed = plowed;
    }

    public boolean isWatered() {
        return watered;
    }

    public void setWatered(boolean watered) {
        this.watered = watered;
    }

    public boolean isFertilized() {
        return fertilized;
    }

    public void setFertilized(boolean fertilized) {
        this.fertilized = fertilized;
    }

}
