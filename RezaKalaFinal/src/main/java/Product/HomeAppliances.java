package Product;

import Enum.EnergyConsumption;
import Users.Seller;
abstract public class HomeAppliances extends Item implements WarrantyCapability {
    //---------------(Fields)---------------
    private EnergyConsumption Energy;
    private boolean Warranty;

    @Override
    public String toString() {
        return super.toString() +
                "Energy: " + Energy + '\n' +
                "Warranty: " + Warranty + '\n';
    }

    @Override
    public double CalculateGuaranteeValue() {
        if(isWarranty())
        return getPrice() * 0.2; // %20 of main price
        else
            return 0;
    }


    //---------------(Constructor)---------------
    public HomeAppliances(String name, String brand, int price, boolean inStock, String info, EnergyConsumption energy, boolean warranty, Seller seller, String tag) {
        super(name, brand, price, inStock, info, seller, tag);
        setEnergy(energy);
        setWarranty(warranty);

    }

    //---------------(Setters & Getters)---------------
    public EnergyConsumption getEnergy() {
        return Energy;
    }

    public void setEnergy(EnergyConsumption energy) {
        Energy = energy;
    }

    public boolean isWarranty() {
        return Warranty;
    }

    public void setWarranty(boolean warranty) {
        Warranty = warranty;
    }
}
