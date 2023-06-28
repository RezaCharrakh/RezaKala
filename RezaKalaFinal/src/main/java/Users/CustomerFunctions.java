package Users;

import Product.Item;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static Users.pages.CustomerLoggedIn;

public abstract class CustomerFunctions {
    public static void EditInfo(int Input, String NewInfo) throws IOException, SQLException {
        String SqlCmd;
        switch (Input) {
            case 1:
                CustomerLoggedIn.setUsername(NewInfo);
                SqlCmd = String.format("UPDATE customers SET Username = '%s' WHERE Id = %d ", NewInfo, CustomerLoggedIn.getId());
                MySQL.getMySQL().Execute(SqlCmd);
                CustomerStuff.CustomerEditInfoMenu();
                break;

            case 2:
                CustomerLoggedIn.setPassword(NewInfo);
                SqlCmd = String.format("UPDATE customers SET Password = '%s' WHERE Id = %d ", NewInfo, CustomerLoggedIn.getId());
                MySQL.getMySQL().Execute(SqlCmd);
                CustomerStuff.CustomerEditInfoMenu();
                break;

            case 3:
                CustomerLoggedIn.setName(NewInfo);
                SqlCmd = String.format("UPDATE customers SET Name = '%s' WHERE Id = %d ", NewInfo, CustomerLoggedIn.getId());
                MySQL.getMySQL().Execute(SqlCmd);
                CustomerStuff.CustomerEditInfoMenu();
                break;

            case 4:
                CustomerLoggedIn.setFamily(NewInfo);
                SqlCmd = String.format("UPDATE customers SET Family = '%s' WHERE Id = %d ", NewInfo, CustomerLoggedIn.getId());
                MySQL.getMySQL().Execute(SqlCmd);
                CustomerStuff.CustomerEditInfoMenu();
                break;

            case 5:
                CustomerLoggedIn.setNumber(NewInfo);
                SqlCmd = String.format("UPDATE numbers SET Number = '%s' WHERE Id = %d ", NewInfo, CustomerLoggedIn.getId());
                MySQL.getMySQL().Execute(SqlCmd);
                CustomerStuff.CustomerEditInfoMenu();
                break;

            case 6:
                CustomerLoggedIn.setEmail(NewInfo);
                SqlCmd = String.format("UPDATE emails SET Email = '%s' WHERE Id = %d ", NewInfo, CustomerLoggedIn.getId());
                MySQL.getMySQL().Execute(SqlCmd);
                CustomerStuff.CustomerEditInfoMenu();
                break;

            case 7:
                CustomerStuff.CustomerPanel();
                break;

            default:
                CustomerStuff.CustomerEditInfoMenu();
                break;
        }
    }

    public static void Rate(int Index, int Index2, double Rate) {
        CustomerLoggedIn.getPurchaseHistory().get(Index).getPurchasedItems().get(Index2).getAllRates().add(new Item.Rate(Rate));
        double aveRate = CustomerLoggedIn.getPurchaseHistory().get(Index).getPurchasedItems().get(Index2).getRate();
        int Size = CustomerLoggedIn.getPurchaseHistory().get(Index).getPurchasedItems().get(Index2).getAllRates().size();
        double Sum = (aveRate * Size - 1) + Rate;
        CustomerLoggedIn.getPurchaseHistory().get(Index).getPurchasedItems().get(Index2).setRate(Sum / Size);
    }

    public static void FilterByPrice(ArrayList<Item> ItemArray) {

        for (int i = 0; i < ItemArray.size(); i++) {
            for (int j = 0; j < ItemArray.size() - 1; j++) {
                if (ItemArray.get(j).getPrice() > ItemArray.get(j + 1).getPrice()) {
                    Item TempItem = ItemArray.get(j);
                    ItemArray.remove(j);
                    ItemArray.add(j + 1, TempItem);
                }
            }
        }
    }

    public static void FilterByAlphabet(ArrayList<Item> ItemArray) {
        for (int i = 0; i < ItemArray.size(); i++) {
            for (int j = 0; j < ItemArray.size() - 1; j++) {
                if (ItemArray.get(j).getName().compareTo(ItemArray.get(j + 1).getName()) > 0) {
                    Item TempItem = ItemArray.get(j);
                    ItemArray.remove(j);
                    ItemArray.add(j + 1, TempItem);
                }
            }
        }
    }

    public static void FilterByRate(ArrayList<Item> ItemArray) {
        for (int i = 0; i < ItemArray.size(); i++) {
            for (int j = 0; j < ItemArray.size() - 1; j++) {
                if (ItemArray.get(j).getPrice() > ItemArray.get(j + 1).getRate()) {
                    Item TempItem = ItemArray.get(j);
                    ItemArray.remove(j);
                    ItemArray.add(j + 1, TempItem);
                }
            }
        }
    }

    public static void FilterByDefualt(ArrayList<Item> ItemArray) {
        for (int i = 0; i < ItemArray.size(); i++) {
            for (int j = 0; j < ItemArray.size() - 1; j++) {
                if (ItemArray.get(j).compareTo(ItemArray.get(j + 1)) > 0) {
                    Item TempItem = ItemArray.get(j);
                    ItemArray.remove(j);
                    ItemArray.add(j + 1, TempItem);
                }
            }
        }
    }

    public static void InsertCustonmer(int Id, String Name, String Family, String Email, String Number,
                                       String Username, String Password, int Fund) throws SQLException {

        String SQLCom = String.format("INSERT INTO customers (Id, Name, Family, Username, Password, Fund)" +
                " VALUES (%d,'%s','%s','%s','%s',%d)", Id, Name, Family, Username, Password, Fund);
        MySQL.getMySQL().Execute(SQLCom);

        String SQLCom2 = String.format("INSERT INTO emails (Id, Email)" + " VALUES (%d, '%s')", Id, Email);
        MySQL.getMySQL().Execute(SQLCom2);

        String SQLCom3 = String.format("INSERT INTO numbers (Id, Number)" + " VALUES (%d, '%s')", Id, Number);
        MySQL.getMySQL().Execute(SQLCom3);
    }
}
