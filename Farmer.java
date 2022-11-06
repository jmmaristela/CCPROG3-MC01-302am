public class Farmer {

    private String strUsername = "";
    private String strFarmerName = "";

    private int iFarmerLevel = 0;
    private double dObjectCoins = 100;

    public String getStrUsername() {
        return strUsername;
    }

    public void setStrUsername(String strUsername) {
        this.strUsername = strUsername;
    }

    public String getStrFarmerName() {
        return strFarmerName;
    }

    public void setStrFarmerName(String strFarmerName) {
        this.strFarmerName = strFarmerName;
    }

    public int getiFarmerLevel() {
        return iFarmerLevel;
    }

    public void setiFarmerLevel(int iFarmerLevel) {
        this.iFarmerLevel = iFarmerLevel;
    }

    public double getdObjectCoins() {
        return dObjectCoins;
    }

    public void setdObjectCoins(double dObjectCoins) {
        this.dObjectCoins = dObjectCoins;
    }

    public double computeCost(double dCost) {
        double dUpdatedObjectCoins = getdObjectCoins();

        dUpdatedObjectCoins = dUpdatedObjectCoins - dCost;

        return dUpdatedObjectCoins;
    }

}
