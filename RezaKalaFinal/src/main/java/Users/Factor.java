package Users;

import java.util.Date;

//Factors
abstract public class Factor {
    //---------------(Fields)---------------
    private static int LastFactorId = 0;
    private int Id;
    private java.util.Date Date;
    private Date Delivery;

    @Override
    public String toString() {
        return "Id: " + Id + '\n' +
                "Date: " + Date + '\n';
    }

    //---------------(Constructor)---------------
    public Factor(Date date, Date delivery) {
        setId();
        setDate(date);
        setDelivery(delivery);
    }

    //---------------(Setters & Getters)---------------
    public int getId() {
        return Id;
    }

    public void setId() {
        Id = LastFactorId++;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date date) {
        Date = date;
    }

    public java.util.Date getDelivery() {
        return Delivery;
    }

    public void setDelivery(java.util.Date delivery) {
        Delivery = delivery;
    }

}
