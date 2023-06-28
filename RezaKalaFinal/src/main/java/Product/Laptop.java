package Product;

import Enum.CPU;
import Enum.Os;
import Users.Seller;
public class Laptop extends Digital {
    //---------------(Fields)---------------
    private boolean Gaming;
    private CPU Cpu;

    @Override
    public String toString() {
        return super.toString() +
                "Gaming: " + Gaming + '\n' +
                "Cpu: " + Cpu + '\n';
    }

    //---------------(Constructor)---------------
    public Laptop(String name, String brand, int price, boolean inStock, String info, int ramMemory, Os operatingSystem, double weight, double length, double width,
                  double height, boolean gaming, CPU cpu, Seller seller) {
        super(name, brand, price, inStock, info, ramMemory, operatingSystem, weight, length, width, height, seller, "Laptop");
        setGaming(gaming);
        setCpu(cpu);
    }

    //---------------(Setters & Getters)---------------
    public boolean isGaming() {
        return Gaming;
    }

    public void setGaming(boolean gaming) {
        Gaming = gaming;
    }

    public CPU getCpu() {
        return Cpu;
    }

    public void setCpu(CPU cpu) {
        Cpu = cpu;
    }

    @Override
    public double CalculateGuaranteeValue() {
        return 0;
    }

    @Override
    public int CalculateGuaranteeTime() {
        return 0;
    }
}
