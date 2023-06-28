package Users;

import Product.Item;

import java.util.ArrayList;

//Others
abstract public class Category {
    //---------------(Fields)---------------
    private String Name;
    private String Property;
    private static ArrayList<Item> AllItemList;
    private static ArrayList<Item> DigitalItemList;
    private static ArrayList<Item> HomeAppliancesItemList;
    private static ArrayList<Item> FoodItemList;
    private static ArrayList<Item> ClothingItemList;


    //---------------(Setters & Getters)---------------
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getProperty() {
        return Property;
    }

    public void setProperty(String property) {
        Property = property;
    }

    public static ArrayList<Item> getAllItemList() {
        return AllItemList;
    }

    public static void setAllItemList(ArrayList<Item> allItemList) {
        AllItemList = allItemList;
    }

    public static ArrayList<Item> getDigitalItemList() {
        return DigitalItemList;
    }

    public static void setDigitalItemList(ArrayList<Item> digitalItemList) {
        DigitalItemList = digitalItemList;
    }

    public static ArrayList<Item> getHomeAppliancesItemList() {
        return HomeAppliancesItemList;
    }

    public static void setHomeAppliancesItemList(ArrayList<Item> homeAppliancesItemList) {
        HomeAppliancesItemList = homeAppliancesItemList;
    }

    public static ArrayList<Item> getFoodItemList() {
        return FoodItemList;
    }

    public static void setFoodItemList(ArrayList<Item> foodItemList) {
        FoodItemList = foodItemList;
    }

    public static ArrayList<Item> getClothingItemList() {
        return ClothingItemList;
    }

    public static void setClothingItemList(ArrayList<Item> clothingItemList) {
        ClothingItemList = clothingItemList;
    }
}
