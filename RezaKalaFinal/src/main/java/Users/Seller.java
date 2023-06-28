package Users;

import Product.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public class Seller extends Account {
    //---------------(Fields)---------------
    private int Fund;
    private String Company;
    private ArrayList<SellFactor> SellHistoryList;
    private ArrayList<Item> ItemList;
    private int Id;
    private static int LastAccountId;

    @Override
    public String toString() {
        return "Id: " + Id +'\n' +
                super.toString() +
                "Credit: " + Fund + '\n' +
                "Company: " + Company + '\n';
    }

    //---------------(Constructor)---------------
    public Seller(String name, String family, String email, String number, String username,
                  String password, int fund, String company) throws SQLException {
        super(name, family, email, number, username, password);
        SellHistoryList = new ArrayList<>();
        ItemList = new ArrayList<>();
        setCompany(company);
        setFund(fund);
        setId();
    }

    //--------------(Setters & Getters)--------------
    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public ArrayList<SellFactor> getSellHistoryList() {
        return SellHistoryList;
    }

    public void setSellHistoryList(ArrayList<SellFactor> sellHistoryList) {
        SellHistoryList = sellHistoryList;
    }

    public ArrayList<Item> getItemList() {
        return ItemList;
    }

    public void setItemList(ArrayList<Item> itemList) {
        ItemList = itemList;
    }

    public int getFund() {
        return Fund;
    }

    public void setFund(int fund) {
        Fund = fund;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setId() throws SQLException {
//        LastAccountId = MySQL.mySQL.GetMaxIntSeller();
        Id = ++LastAccountId;
    }

    public static int getLastAccountId() {
        return LastAccountId;
    }

    public static void setLastAccountId(int lastAccountId) {
        LastAccountId = lastAccountId;
    }
    //--------------(Methods)-------------
}
