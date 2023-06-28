package Product;

import Enum.EnergyConsumption;
import Users.Seller;
public class Refrigerator extends HomeAppliances {
    //---------------(Fields)---------------
    private int Capacity;
    private String Type;
    private boolean Freezer;

    @Override
    public String toString() {
        return super.toString() +
                "Capacity: " + Capacity + '\n' +
                "Type: " + Type + '\n' +
                "Freezer: " + Freezer + '\n';
    }

    @Override
    public int CalculateGuaranteeTime() {
        if(isWarranty())
        return (Capacity * 10);
        else
            return 0;
    }

    //---------------(Constructor)---------------
    public Refrigerator(String name, String brand, int price, boolean inStock,
                        String info, EnergyConsumption energy, boolean warranty, int capacity, boolean freezer, String type, Seller seller) {
        super(name, brand, price, inStock, info, energy, warranty, seller, "Refrigerator");
        setCapacity(capacity);
        setType(type);
        setFreezer(freezer);

    }

    //---------------(Setters & Getters)---------------
    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public boolean isFreezer() {
        return Freezer;
    }

    public void setFreezer(boolean freezer) {
        Freezer = freezer;
    }
}
