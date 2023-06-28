package Product;

import Users.Seller;

abstract class Clothing extends Item {
    //---------------(Fields)---------------
    private String Country;
    private String Material;

    @Override
    public String toString() {
        return super.toString() +
                "Country: " + Country + '\n' +
                "Material: " + Material + '\n';
    }

    //---------------(Constructor)---------------
    public Clothing(String name, String brand, int price, boolean inStock, String info, String country, String material, Seller seller, String tag) {
        super(name, brand, price, inStock, info, seller, tag);
        setCountry(country);
        setMaterial(material);
    }

    //---------------(Setters & Getters)---------------
    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getMaterial() {
        return Material;
    }

    public void setMaterial(String material) {
        Material = material;
    }


}
