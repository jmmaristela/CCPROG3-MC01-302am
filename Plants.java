import java.util.ArrayList;

public class Plants {

    private String strSeedName;
    private String strSeedType;

    private int iWater;
    private int iWaterNeeds;

    private int iFertilizer;
    private int iFertilizerNeeds;

    private int iHarvestTime; // In days

    private double dSeedCost;

    public Plants(String strSeedName, int iWaterNeeds, int iFertilizerNeeds, int iHarvestTime, double dSeedCost) {
        this.strSeedName = strSeedName;
        this.iWaterNeeds = iWaterNeeds;
        this.iFertilizerNeeds = iFertilizerNeeds;
        this.iHarvestTime = iHarvestTime;
        this.dSeedCost = dSeedCost;
    }

    public String getStrSeedName() {
        return strSeedName;
    }

    public void setStrSeedName(String strSeedName) {
        this.strSeedName = strSeedName;
    }

    public String getStrSeedType() {
        return strSeedType;
    }

    public void setStrSeedType(String strSeedType) {
        this.strSeedType = strSeedType;
    }

    public int getiWater() {
        return iWater;
    }

    public void setiWater(int iWater) {
        this.iWater = iWater;
    }

    public int getiWaterNeeds() {
        return iWaterNeeds;
    }

    public void setiWaterNeeds(int iWaterNeeds) {
        this.iWaterNeeds = iWaterNeeds;
    }

    public int getiFertilizer() {
        return iFertilizer;
    }

    public void setiFertilizer(int iFertilizer) {
        this.iFertilizer = iFertilizer;
    }

    public int getiFertilizerNeeds() {
        return iFertilizerNeeds;
    }

    public void setiFertilizerNeeds(int iFertilizerNeeds) {
        this.iFertilizerNeeds = iFertilizerNeeds;
    }

    public int getiHarvestTime() {
        return iHarvestTime;
    }

    public void setiHarvestTime(int iHarvestTime) {
        this.iHarvestTime = iHarvestTime;
    }

    public double getdSeedCost() {
        return dSeedCost;
    }

    public void setdSeedCost(double dSeedCost) {
        this.dSeedCost = dSeedCost;
    }

    public void display(int i) {
        System.out.print("[" + i + "]" + strSeedName + "\t\t " + iWaterNeeds+ "\t\t\t\t\t");
        System.out.print(iFertilizerNeeds + "\t\t\t\t" + iHarvestTime+ "\t\t\t  " + dSeedCost + "\n");

    }
}
