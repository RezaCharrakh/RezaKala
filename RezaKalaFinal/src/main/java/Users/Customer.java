package Users;

import Product.Item;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

public class Customer extends Account implements Serializable {
    //--------------(Fields)--------------
    private int Fund;
    private ArrayList<Item> Cart;
    private ArrayList<BuyFactor> PurchaseHistory;
    private int Id;
    private static int LastAccountId;

    @Override
    public String toString() {
        return "Id: " + Id +'\n' +
                super.toString() +
                "Credit: " + Fund + "$" + '\n';
    }

    //---------------(Constructor)---------------
    public Customer(String name, String family, String email, String number, String username,
                    String password, int fund) throws SQLException {
        super(name, family, email, number, username, password);
        setFund(fund);
        setId();
        Cart = new ArrayList<>();
        PurchaseHistory = new ArrayList<>();
    }

    //--------------(Setters & Getters)--------------
    public int getFund() {
        return Fund;
    }

    public void setFund(int fund) {
        Fund = fund;
    }

    public ArrayList<Item> getCart() {
        return Cart;
    }

    public void setCart(ArrayList<Item> cart) {
        Cart = cart;
    }

    public ArrayList<BuyFactor> getPurchaseHistory() {
        return PurchaseHistory;
    }

    public void setPurchaseHistory(ArrayList<BuyFactor> purchaseHistory) {
        PurchaseHistory = purchaseHistory;
    }


    public int getId() {
        return Id;
    }


    public void setId(int id) {
        Id = id;
    }

    public void setId() throws SQLException {
        LastAccountId = MySQL.getMySQL().GetMaxIntCustomer();
        Id = ++LastAccountId;
    }

    public static int getLastAccountId() {
        return LastAccountId;
    }

    public static void setLastAccountId(int lastAccountId) {
        LastAccountId = lastAccountId;
    }
    //--------------(Methods)--------------

}
