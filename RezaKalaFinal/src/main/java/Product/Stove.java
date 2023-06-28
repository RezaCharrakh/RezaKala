package Product;

import Enum.EnergyConsumption;
import Users.Seller;
public class Stove extends HomeAppliances {
    //---------------(Fields)---------------
    private int Flames;
    private String Material;
    private boolean Oven;

    @Override
    public String toString() {
        return super.toString() +
                "Flames: " + Flames + '\n' +
                "Material: " + Material + '\n' +
                "Oven: " + Oven + '\n';
    }

    @Override
    public int CalculateGuaranteeTime() {
        if(isWarranty())
        return (Flames * 10);
        else return 0;
    }

    //---------------(Constructor)---------------
    public Stove(String name, String brand, int price, boolean inStock, String info, EnergyConsumption energy, boolean warranty, int flames, String material, boolean oven, Seller seller) {
        super(name, brand, price, inStock, info, energy, warranty, seller, "Stove");
        setFlames(flames);
        setMaterial(material);
        setOven(oven);
    }

    //---------------(Setters & Getters)---------------
    public int getFlames() {
        return Flames;
    }

    public void setFlames(int flames) {
        Flames = flames;
    }

    public String getMaterial() {
        return Material;
    }

    public void setMaterial(String material) {
        Material = material;
    }

    public boolean isOven() {
        return Oven;
    }

    public void setOven(boolean oven) {
        Oven = oven;
    }
}
