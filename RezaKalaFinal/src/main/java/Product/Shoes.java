package Product;

import Enum.ShoesType;
import Users.Seller;
public class Shoes extends Clothing {
    //---------------(Fields)---------------
    private int Size;
    private ShoesType Type;

    @Override
    public String toString() {
        return super.toString() +
                "Size: " + Size + '\n' +
                "Type: " + Type + '\n';
    }

    //---------------(Constructor)---------------
    public Shoes(String name, String brand, int price, boolean inStock, String info, String country, String material, int size, ShoesType type, Seller seller) {
        super(name, brand, price, inStock, info, country, material, seller, "Shoes");
        setSize(size);
        setType(type);
    }

    //---------------(Setters & Getters)---------------
    public int getSize() {
        return Size;
    }

    public void setSize(int size) {
        Size = size;
    }

    public ShoesType getType() {
        return Type;
    }

    public void setType(ShoesType type) {
        Type = type;
    }
}
