package Users;

import Product.Item;

import java.io.Serializable;
import java.util.ArrayList;

public class Lists implements Serializable {
    ArrayList<Customer> CustomerList = new ArrayList<>();
    ArrayList<Seller> SellerList = new ArrayList<>();

    public ArrayList<Seller> SellerRegisterList = new ArrayList<>();
    ArrayList<Item> SllerRemoveList = new ArrayList<>();
    ArrayList<Item> SellerEditList = new ArrayList<>();
    public ArrayList<Item> SellerAddList = new ArrayList<>();

    public ArrayList<Requests> EditRequests = new ArrayList<>();

    ArrayList<Item> AllItems = new ArrayList<>();

    ArrayList<Item> DigitalItems = new ArrayList<>();
    public ArrayList<Item> MobileItems = new ArrayList<>();
    ArrayList<Item> LaptopItems = new ArrayList<>();

    ArrayList<Item> HomeAppliancesItems = new ArrayList<>();
    ArrayList<Item> TVItems = new ArrayList<>();
    ArrayList<Item> RefrigeratorItems = new ArrayList<>();
    ArrayList<Item> StoveItems = new ArrayList<>();

    public ArrayList<Item> ClothingItems = new ArrayList<>();
    public ArrayList<Item> ClothItems = new ArrayList<>();
    ArrayList<Item> ShoesItems = new ArrayList<>();

    ArrayList<Item> FoodItems = new ArrayList<>();

    ArrayList<Comment> CommentRequests = new ArrayList<>();


    private static Lists lists = null;

    public static Lists getLists() {
        if (lists == null)
            lists = new Lists();

        return lists;

    }

    public ArrayList<Customer> getCustomerList() {
        return CustomerList;
    }

    public void setCustomerList(ArrayList<Customer> customerList) {
        CustomerList = customerList;
    }

    public ArrayList<Seller> getSellerList() {
        return SellerList;
    }

    public void setSellerList(ArrayList<Seller> sellerList) {
        SellerList = sellerList;
    }

    public ArrayList<Seller> getSellerRegisterList() {
        return SellerRegisterList;
    }
}
