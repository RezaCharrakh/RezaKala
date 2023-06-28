package Users;

import Enum.Delivery;
import Product.*;

import java.util.ArrayList;
import java.util.Date;

class BuyFactor extends Factor {
    //---------------(Fields)---------------
    private int AmountPaid;
    private ArrayList<Item> PurchasedItems;
    private Delivery ItemSituation;

    @Override
    public String toString() {
        setItemSituation();
        return super.toString() +
                "AmountPaid: " + AmountPaid + '\n' +
                "ItemSituation: " + ItemSituation + '\n' +
                "PurchasedItems:" + PurchasedItems + '\n';

    }

    //---------------(Constructor)---------------
    public BuyFactor(Date date, int amountPaid, Date delivery) {
        super(date, delivery);
        PurchasedItems = new ArrayList<>();
        setAmountPaid(amountPaid);

    }

    //---------------(Setters & Getters)---------------
    public int getAmountPaid() {
        return AmountPaid;
    }

    public void setAmountPaid(int amountReceived) {
        AmountPaid = amountReceived;
    }

    public ArrayList<Item> getPurchasedItems() {
        return PurchasedItems;
    }

    public void setPurchasedItems(ArrayList<Item> purchasedItems) {
        PurchasedItems = purchasedItems;
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
