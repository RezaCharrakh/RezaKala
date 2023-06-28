package Users;

import Enum.Delivery;
import Product.Item;

import java.util.ArrayList;
import java.util.Date;

class SellFactor extends Factor {
    //---------------(Fields)---------------
    private int AmountReceived;
    private ArrayList<Item> SoldItems;
    private Customer customer;
    private Delivery ItemSituation;

    @Override
    public String toString() {
        setItemSituation();
        return super.toString() +
                "AmountReceived: " + AmountReceived + '\n' +
                "SoldItems: " + SoldItems + '\n' +
                "CustomerName: " + customer.getName() + '\n' +
                "CustomerFamily: " + customer.getFamily() + '\n' +
                "ItemSituation: " + ItemSituation + '\n';
    }

    //---------------(Constructor)---------------
    public SellFactor(java.util.Date date, int amountReceived, Customer customer, Date delivery) {
        super(date, delivery);
        SoldItems = new ArrayList<>();
        setAmountReceived(amountReceived);
        setCustomer(customer);
    }

    //---------------(Setters & Getters)---------------
    public int getAmountReceived() {
        return AmountReceived;
    }

    public void setAmountReceived(int amountReceived) {
        AmountReceived = amountReceived;
    }

    public ArrayList<Item> getSoldItems() {
        return SoldItems;
    }

    public void setSoldItems(ArrayList<Item> soldItems) {
        SoldItems = soldItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Delivery getItemSituation() {
        return ItemSituation;
    }

    public void setItemSituation() {
        if (new Date(System.currentTimeMillis()).before(super.getDelivery())) {
            ItemSituation = Delivery.IN_PROGRESS;
        } else {
            ItemSituation = Delivery.DELIVERD;
        }

    }
}
