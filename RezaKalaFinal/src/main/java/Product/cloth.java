package Product;

import Enum.ClothSize;
import Enum.ClothType;
import Users.Seller;

public class cloth extends Clothing {
    //---------------(Fields)---------------
    private ClothSize Size;
    private ClothType Type;

    @Override
    public String toString() {
        return super.toString() +
                "Size: " + Size + '\n' +
                "Type: " + Type + '\n';
    }

    //---------------(Constructor)---------------
    public cloth(String name, String brand, int price, boolean inStock, String info, String country, String material, ClothSize size, ClothType type, Seller seller) {
        super(name, brand, price, inStock, info, country, material, seller, "Cloth");
        setSize(size);
        setType(type);
    }

    //---------------(Setters & Getters)---------------
    public ClothSize getSize() {
        return Size;
    }

    public void setSize(ClothSize size) {
        Size = size;
    }

    public ClothType getType() {
        return Type;
    }

    public void setType(ClothType type) {
        Type = type;
    }

}
