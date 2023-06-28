package Product;

import Enum.EnergyConsumption;
import Users.Seller;
public class TV extends HomeAppliances {
    //---------------(Fields)---------------
    private String ScreenQuality;
    private int MonitorSize;

    @Override
    public String toString() {
        return super.toString() +
                "ScreenQuality: " + ScreenQuality + '\n' +
                "MonitorSize: " + MonitorSize + '\n';
    }

    @Override
    public int CalculateGuaranteeTime() {
        if (isWarranty())
            return (MonitorSize * 10);
        else
        return 0;
    }

    //---------------(Constructor)---------------
    public TV(String name, String brand, int price, boolean inStock, String info, EnergyConsumption energy, boolean warranty, String screenQuality, int monitorSize, Seller seller) {
        super(name, brand, price, inStock, info, energy, warranty, seller, "TV");
        setScreenQuality(screenQuality);
        setMonitorSize(monitorSize);

    }

    //---------------(Setters & Getters)---------------
    public String getScreenQuality() {
        return ScreenQuality;
    }

    public void setScreenQuality(String screenQuality) {
        ScreenQuality = screenQuality;
    }

    public int getMonitorSize() {
        return MonitorSize;
    }

    public void setMonitorSize(int monitorSize) {
        MonitorSize = monitorSize;
    }
}
