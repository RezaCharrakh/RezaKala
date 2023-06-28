package Users;

import java.io.IOException;
import java.sql.SQLException;

import static Users.pages.CustomerLoggedIn;
import static Users.pages.SellerLoggedIn;

public abstract class SellerFunctions {
    public static void EditInfo(int Input, String NewInfo) throws IOException, SQLException {
        String SqlCmd;
        switch (Input) {
            case 1:
                SellerLoggedIn.setUsername(NewInfo);
                SqlCmd = String.format("UPDATE sellers SET Username = '%s' WHERE Id = %d ", NewInfo, CustomerLoggedIn.getId());
                MySQL.getMySQL().Execute(SqlCmd);
                System.out.println(
                        "Your Username successfully changed!"
                );
                SellerStuff.SellerEditInfoMenu();
                break;

            case 2:
                SellerLoggedIn.setPassword(NewInfo);
                SqlCmd = String.format("UPDATE sellers SET Password = '%s' WHERE Id = %d ", NewInfo, CustomerLoggedIn.getId());
                MySQL.getMySQL().Execute(SqlCmd);
                System.out.println(
                        "Your Password successfully changed!"
                );
                SellerStuff.SellerEditInfoMenu();
                break;

            case 3:
                SellerLoggedIn.setName(NewInfo);
                SqlCmd = String.format("UPDATE sellers SET Name = '%s' WHERE Id = %d ", NewInfo, CustomerLoggedIn.getId());
                MySQL.getMySQL().Execute(SqlCmd);
                System.out.println(
                        "Your Name successfully changed!"
                );
                SellerStuff.SellerEditInfoMenu();
                break;

            case 4:
                SellerLoggedIn.setFamily(NewInfo);
                SqlCmd = String.format("UPDATE sellers SET Family = '%s' WHERE Id = %d ", NewInfo, CustomerLoggedIn.getId());
                MySQL.getMySQL().Execute(SqlCmd);
                System.out.println(
                        "Your Family successfully changed!"
                );
                SellerStuff.SellerEditInfoMenu();
                break;

            case 5:
                SellerLoggedIn.setNumber(NewInfo);
                SqlCmd = String.format("UPDATE numbers SET Number = '%s' WHERE Id = %d ", NewInfo, CustomerLoggedIn.getId());
                MySQL.getMySQL().Execute(SqlCmd);
                System.out.println(
                        "Your Phone number successfully changed!"
                );
                SellerStuff.SellerEditInfoMenu();
                break;
            case 6:
                SellerLoggedIn.setEmail(NewInfo);
                SqlCmd = String.format("UPDATE emails SET Email = '%s' WHERE Id = %d ", NewInfo, CustomerLoggedIn.getId());
                MySQL.getMySQL().Execute(SqlCmd);
                System.out.println(
                        "Your Email successfully changed!"
                );
                SellerStuff.SellerEditInfoMenu();
                break;

            case 7:
                SellerLoggedIn.setCompany(NewInfo);
                SqlCmd = String.format("UPDATE sellers SET Company = '%s' WHERE Id = %d ", NewInfo, CustomerLoggedIn.getId());
                MySQL.getMySQL().Execute(SqlCmd);
                System.out.println(
                        "Your Company name successfully changed!"
                );
                SellerStuff.SellerEditInfoMenu();
            case 8:
                SellerStuff.SellerPanel();
                break;


            default:
                System.out.println("                 Please enter a valid number...");
                SellerStuff.SellerEditInfoMenu();
                break;
        }
    }

    public static void SellerRemoveItem(int Input) {
        for (int i = 0; i < SellerLoggedIn.getItemList().size(); i++) {
            if (SellerLoggedIn.getItemList().get(i).getId() == Input) {
                int AllItemsIndex = 0;
                for (int j = 0; j < Lists.getLists().AllItems.size(); j++) {
                    if (SellerLoggedIn.getItemList().get(i).getId() == Lists.getLists().AllItems.get(j).getId()) {
                        AllItemsIndex = j;
                        break;
                    }
                }
                switch (SellerLoggedIn.getItemList().get(i).getTag()) {
                    case "Product.Mobile": {
                        int DigitalItemsIndex = 0;
                        for (int j = 0; j < Lists.getLists().DigitalItems.size(); j++) {
                            if (SellerLoggedIn.getItemList().get(i).getId() == Lists.getLists().DigitalItems.get(j).getId()) {
                                DigitalItemsIndex = j;
                                break;
                            }
                        }
                        int MobileItemIndex = 0;
                        for (int j = 0; j < Lists.getLists().MobileItems.size(); j++) {
                            if (SellerLoggedIn.getItemList().get(i).getId() == Lists.getLists().MobileItems.get(j).getId()) {
                                MobileItemIndex = j;
                                break;
                            }
                        }
                        Lists.getLists().AllItems.remove(AllItemsIndex);
                        Lists.getLists().DigitalItems.remove(DigitalItemsIndex);
                        Lists.getLists().MobileItems.remove(MobileItemIndex);
                        SellerLoggedIn.getItemList().remove(i);

                    }
                    break;
                    case "Product.Laptop": {
                        int DigitalItemsIndex = 0;
                        for (int j = 0; j < Lists.getLists().DigitalItems.size(); j++) {
                            if (SellerLoggedIn.getItemList().get(i).getId() == Lists.getLists().DigitalItems.get(j).getId()) {
                                DigitalItemsIndex = j;
                                break;
                            }
                        }
                        int LaptopItemsIndex = 0;
                        for (int j = 0; j < Lists.getLists().LaptopItems.size(); j++) {
                            if (SellerLoggedIn.getItemList().get(i).getId() == Lists.getLists().LaptopItems.get(j).getId()) {
                                LaptopItemsIndex = j;
                                break;
                            }
                        }
                        Lists.getLists().AllItems.remove(AllItemsIndex);
                        Lists.getLists().DigitalItems.remove(DigitalItemsIndex);
                        Lists.getLists().LaptopItems.remove(LaptopItemsIndex);
                        SellerLoggedIn.getItemList().remove(i);

                    }
                    break;
                    case "Product.TV": {
                        int HomeAppliancesItemsIndex = 0;
                        for (int j = 0; j < Lists.getLists().HomeAppliancesItems.size(); j++) {
                            if (SellerLoggedIn.getItemList().get(i).getId() == Lists.getLists().HomeAppliancesItems.get(j).getId()) {
                                HomeAppliancesItemsIndex = j;
                                break;
                            }
                        }
                        int TVItemsIndex = 0;
                        for (int j = 0; j < Lists.getLists().TVItems.size(); j++) {
                            if (SellerLoggedIn.getItemList().get(i).getId() == Lists.getLists().TVItems.get(j).getId()) {
                                TVItemsIndex = j;
                                break;
                            }
                        }
                        Lists.getLists().AllItems.remove(AllItemsIndex);
                        Lists.getLists().HomeAppliancesItems.remove(HomeAppliancesItemsIndex);
                        Lists.getLists().TVItems.remove(TVItemsIndex);
                        SellerLoggedIn.getItemList().remove(i);
                    }
                    break;
                    case "Product.Refrigerator": {
                        int HomeAppliancesItemsIndex = 0;
                        for (int j = 0; j < Lists.getLists().HomeAppliancesItems.size(); j++) {
                            if (SellerLoggedIn.getItemList().get(i).getId() == Lists.getLists().HomeAppliancesItems.get(j).getId()) {
                                HomeAppliancesItemsIndex = j;
                                break;
                            }
                        }
                        int RefrigeratorItemsIndex = 0;
                        for (int j = 0; j < Lists.getLists().RefrigeratorItems.size(); j++) {
                            if (SellerLoggedIn.getItemList().get(i).getId() == Lists.getLists().RefrigeratorItems.get(j).getId()) {
                                RefrigeratorItemsIndex = j;
                                break;
                            }
                        }
                        Lists.getLists().AllItems.remove(AllItemsIndex);
                        Lists.getLists().HomeAppliancesItems.remove(HomeAppliancesItemsIndex);
                        Lists.getLists().RefrigeratorItems.remove(RefrigeratorItemsIndex);
                        SellerLoggedIn.getItemList().remove(i);

                    }
                    break;
                    case "Product.Stove": {
                        int HomeAppliancesItemsIndex = 0;
                        for (int j = 0; j < Lists.getLists().HomeAppliancesItems.size(); j++) {
                            if (SellerLoggedIn.getItemList().get(i).getId() == Lists.getLists().HomeAppliancesItems.get(j).getId()) {
                                HomeAppliancesItemsIndex = j;
                                break;
                            }
                        }
                        int StoveItemsIndex = 0;
                        for (int j = 0; j < Lists.getLists().StoveItems.size(); j++) {
                            if (SellerLoggedIn.getItemList().get(i).getId() == Lists.getLists().StoveItems.get(j).getId()) {
                                StoveItemsIndex = j;
                                break;
                            }
                        }
                        Lists.getLists().AllItems.remove(AllItemsIndex);
                        Lists.getLists().HomeAppliancesItems.remove(HomeAppliancesItemsIndex);
                        Lists.getLists().StoveItems.remove(StoveItemsIndex);
                        SellerLoggedIn.getItemList().remove(i);

                    }
                    break;
                    case "Cloth": {
                        int ClothingItemsIndex = 0;
                        for (int j = 0; j < Lists.getLists().ClothingItems.size(); j++) {
                            if (SellerLoggedIn.getItemList().get(i).getId() == Lists.getLists().ClothingItems.get(j).getId()) {
                                ClothingItemsIndex = j;
                                break;
                            }
                        }
                        int ClothItemsIndex = 0;
                        for (int j = 0; j < Lists.getLists().ClothItems.size(); j++) {
                            if (SellerLoggedIn.getItemList().get(i).getId() == Lists.getLists().ClothItems.get(j).getId()) {
                                ClothItemsIndex = j;
                                break;
                            }
                        }
                        Lists.getLists().AllItems.remove(AllItemsIndex);
                        Lists.getLists().ClothingItems.remove(ClothingItemsIndex);
                        Lists.getLists().ClothItems.remove(ClothItemsIndex);
                        SellerLoggedIn.getItemList().remove(i);

                    }
                    break;
                    case "Product.Shoes": {
                        int ClothingItemsIndex = 0;
                        for (int j = 0; j < Lists.getLists().ClothingItems.size(); j++) {
                            if (SellerLoggedIn.getItemList().get(i).getId() == Lists.getLists().ClothingItems.get(j).getId()) {
                                ClothingItemsIndex = j;
                                break;
                            }
                        }
                        int ShoesItemsIndex = 0;
                        for (int j = 0; j < Lists.getLists().ShoesItems.size(); j++) {
                            if (SellerLoggedIn.getItemList().get(i).getId() == Lists.getLists().ShoesItems.get(j).getId()) {
                                ShoesItemsIndex = j;
                                break;
                            }
                        }
                        Lists.getLists().AllItems.remove(AllItemsIndex);
                        Lists.getLists().ClothingItems.remove(ClothingItemsIndex);
                        Lists.getLists().ShoesItems.remove(ShoesItemsIndex);
                        SellerLoggedIn.getItemList().remove(i);

                    }
                    break;
                    case "Product.Food": {
                        int FoodItemsIndex = 0;
                        for (int j = 0; j < Lists.getLists().FoodItems.size(); j++) {
                            if (SellerLoggedIn.getItemList().get(i).getId() == Lists.getLists().FoodItems.get(j).getId()) {
                                FoodItemsIndex = j;
                                break;
                            }
                        }
                        Lists.getLists().AllItems.remove(AllItemsIndex);
                        Lists.getLists().FoodItems.remove(FoodItemsIndex);
                        SellerLoggedIn.getItemList().remove(i);
                    }
                    break;
                }
                System.out.println("                   [You have successfully remove the product!]");
                break;
            }
        }
    }

    public static void InsertSeller(int Id, String Name, String Family, String Email, String Number,
                                    String Username, String Password, String Company, int Fund) throws SQLException {


        String SQLCom = String.format("INSERT INTO sellers (Id, Name, Family, Username, Password, Company, Fund)" +
                " VALUES (%d,'%s','%s','%s','%s','%s',%d)", Id, Name, Family, Username, Password, Company, Fund);
        MySQL.getMySQL().Execute(SQLCom);

        String SQLCom2 = String.format("INSERT INTO emails (Id, Email)" + " VALUES (%d, '%s')", Id, Email);
        MySQL.getMySQL().Execute(SQLCom2);

        String SQLCom3 = String.format("INSERT INTO numbers (Id, Number)" + " VALUES (%d, '%s')", Id, Number);
        MySQL.getMySQL().Execute(SQLCom3);
    }
}
