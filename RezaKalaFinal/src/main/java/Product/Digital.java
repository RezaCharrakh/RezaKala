package Product;

import Enum.Os;
import Users.Seller;
abstract class Digital extends Item implements WarrantyCapability {
    //---------------(Fields)---------------
    private int RamMemory;
    private Os OperatingSystem;
    private double Weight;
    private double Length;
    private double Width;
    private double Height;

    @Override
    public double CalculateGuaranteeValue() {
        return getPrice() * 0.5; // %50 of main price
    }

    @Override
    public int CalculateGuaranteeTime() {
        return (int) (RamMemory / 5 + Weight * 15);
    }

    @Override
    public String toString() {
        return super.toString() +
                "RamMemory: " + RamMemory + '\n' +
                "OperatingSystem: " + OperatingSystem + '\n' +
                "Weight: " + Weight + '\n' +
                "Length: " + Length + '\n' +
                "Width: " + Width + '\n' +
                "Height: " + Height + '\n';
    }

    //---------------(Constructor)---------------
    public Digital(String name, String brand, int price, boolean inStock, String info, int ramMemory, Os operatingSystem, double weight, double length, double width, double height, Seller seller, String tag) {
        super(name, brand, price, inStock, info, seller, tag);
        setRamMemory(ramMemory);
        setOperatingSystem(operatingSystem);
        setWeight(weight);
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    //---------------(Setters & Getters)---------------
    public int getRamMemory() {
        return RamMemory;
    }

    public void setRamMemory(int ramMemory) {
        RamMemory = ramMemory;
    }

    public Os getOperatingSystem() {
        return OperatingSystem;
    }

    public void setOperatingSystem(Os operatingSystem) {
        OperatingSystem = operatingSystem;
    }

    public double getWeight() {
        return Weight;
    }

    public void setWeight(double weight) {
        Weight = weight;
    }

    public double getLength() {
        return Length;
    }

    public void setLength(double length) {
        Length = length;
    }

    public double getWidth() {
        return Width;
    }

    public void setWidth(double width) {
        Width = width;
    }

    public double getHeight() {
        return Height;
    }

    public void setHeight(double height) {
        Height = height;
    }
}
