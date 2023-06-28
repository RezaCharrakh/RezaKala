package Product;

import Users.Seller;

public class Food extends Item {
    //---------------(Fields)---------------
    private String Pr;
    private String Ex;

    @Override
    public String toString() {
        return super.toString() +
                "Pr: " + Pr + '\n' +
                "Ex: " + Ex + '\n';
    }

    //---------------(Constructor)---------------
    public Food(String name, String brand, int price, boolean inStock, String info, String pr, String ex, Seller seller) {
        super(name, brand, price, inStock, info, seller, "Food");
        setPr(pr);
        setEx(ex);
    }

    //---------------(Setters & Getters)---------------
    public String getPr() {
        return Pr;
    }

    public void setPr(String pr) {
        Pr = pr;
    }

    public String getEx() {
        return Ex;
    }

    public void setEx(String ex) {
        Ex = ex;
    }
}
