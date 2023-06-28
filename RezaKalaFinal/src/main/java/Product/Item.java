package Product;

import Users.Seller;

import javax.xml.stream.events.Comment;
import java.util.ArrayList;

//Products
abstract public class Item implements Comparable {
    //---------------(Fields)---------------
    private static int LastItemId = 0;
    private int Id;
    private String Name;
    private String Brand;
    private int Price;
    private Seller SellerItem;
    private boolean InStock;
    private String Info;
    private double Rate = 0;
    private String Tag;
    private ArrayList<Comment> CommentList;
    private ArrayList<Item.Rate> AllRates;

    @Override
    public String toString() {
        return "Id: " + Id + '\n' +
                "Name: " + Name + '\n' +
                "Brand: " + Brand + '\n' +
                "Price: " + Price + '\n' +
                "SellerName: " + SellerItem.getName() + '\n' +
                "SellerFamily: " + SellerItem.getFamily() + '\n' +
                "SellerCompany: " + SellerItem.getCompany() + '\n' +
                "InStock: " + InStock + '\n' +
                "Info: " + Info + '\n' +
                "Rate: " + Rate + '\n' +
                "CommentList: " + CommentList + '\n';
    }
    //---------------(CompareTo)---------------
    @Override
    public int compareTo(Object Obj) {
        Item ItemTest = (Item) Obj;
        if(this.Name.compareTo(ItemTest.Name) > 0)
        {
            return 1;
        }
        else if(this.Name.compareTo(ItemTest.Name) < 0)
        {
            return -1;
        }
        else if (this.Rate > ItemTest.Rate)
        {
            return 1;
        }
        else if (this.Rate < ItemTest.Rate)
        {
            return -1;
        }
        else if (this.getPrice() > ItemTest.getPrice())
        {
            return 1;
        }
        else if (this.getPrice() < ItemTest.getPrice())
        {
            return -1;
        }
        else if (this.isInStock() == true && ItemTest.isInStock() == false)
        {
            return 1;
        }
        else if (this.isInStock() == false && ItemTest.isInStock() == true)
        {
            return -1;
        }
        else return 0;
    }

    //---------------(Constructor)---------------
    public Item(String name, String brand, int price, boolean inStock, String info, Seller seller, String tag) {
        setId();
        setName(name);
        setBrand(brand);
        setPrice(price);
        setInfo(info);
        setSellerItem(seller);
        setTag(tag);
        setInStock(inStock);
        CommentList = new ArrayList<>();
        AllRates = new ArrayList<>();
    }

    //---------------(Setters & Getters)---------------

    public int getId() {
        return Id;
    }

    public void setId() {
        Id = LastItemId++;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public Seller getSellerItem() {
        return SellerItem;
    }

    public void setSellerItem(Seller sellerItem) {
        SellerItem = sellerItem;
    }

    public boolean isInStock() {
        return InStock;
    }

    public void setInStock(boolean inStock) {
        InStock = inStock;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public double getRate() {
        return Rate;
    }

    public void setRate(double rate) {
        Rate = rate;
    }

    public ArrayList<Comment> getCommentList() {
        return CommentList;
    }

    public void setCommentList(ArrayList<Comment> commentList) {
        CommentList = commentList;
    }

    public String getTag() {
        return Tag;
    }

    public void setTag(String tag) {
        Tag = tag;
    }

    public ArrayList<Item.Rate> getAllRates() {
        return AllRates;
    }

    public void setAllRates(ArrayList<Rate> allRates) {
        AllRates = allRates;
    }

    public static class Rate {
        //---------------(Fields)---------------
        private double Rate;

        //---------------(Constructor)---------------
        public Rate(double rate) {
            setRate(rate);
        }

        //---------------(Setters & Getters)---------------
        public double getRate() {
            return Rate;
        }

        public void setRate(double rate) {
            Rate = rate;
        }

    }
}
