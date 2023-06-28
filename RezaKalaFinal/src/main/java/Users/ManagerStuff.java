package Users;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static Users.pages.MainMenu;

abstract public class ManagerStuff {
    static int InputMenu;
    static int InputMenu2;

    public static void ManagerPanel() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n              ========= Admin Panel ========= ");
        System.out.println("                 [1]  List of Customers");
        System.out.println("                 [2]  List of Sellers");
        System.out.println("                 [3]  Edit info");
        System.out.println("                 [4]  Add product requests");
        System.out.println("                 [5]  Edit product requests");
        System.out.println("                 [6]  Admin info");
        System.out.println("                 [7]  Remove a Customer");
        System.out.println("                 [8]  Remove a Seller");
        System.out.println("                 [9]  Category list");
        System.out.println("                 [10] Seller register requests");
        System.out.println("                 [11] Comment requests");
        System.out.println("                 [12] Log out");
        System.out.println("                 ============================");
        System.out.println("                 Please enter a number: ");

        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }
        switch (InputMenu) {
            case 1:
                ListOfCustomersMenu();
                break;

            case 2:
                ListOfSellersMenu();
                break;

            case 3:
                ManagerEditInfoMenu();
                break;

            case 4:
                AddItemRequestsMenu();
                break;

            case 5:
                EditItemRequestMenu();
                break;
            case 6:
                ManagerInfoMenu();
                break;

            case 7:
                RemoveUserMenu();
                break;

            case 8:
                RemoveSellerMenu();
                break;

            case 9:
                CategoryListMenu();
                break;

            case 10:
                AcceptSellerMenu();
                break;

            case 11:
                CommentRequestsMenu();
                break;

            case 12:
                MainMenu();
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                ManagerPanel();
                break;
        }
    }

    public static void ListOfCustomersMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n              ========= Customer List ========= ");
        for (int i = 0; i < Lists.getLists().CustomerList.size(); i++) {
            System.out.println(Lists.getLists().CustomerList.get(i).toString());
            System.out.println("-----------------------------------------");
        }
        System.out.println("              [1] Back to panel ");
        System.out.println("              ============================");
        System.out.println("              Please enter a number: ");

        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }

        if (InputMenu == 1) {
            ManagerPanel();
        } else {
            System.out.println("                 Please enter a valid number...");
            ListOfCustomersMenu();
        }
    }

    public static void ListOfSellersMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n              ========= Seller List ========= ");
        for (int i = 0; i < Lists.getLists().SellerList.size(); i++) {
            System.out.println(Lists.getLists().SellerList.get(i).toString());
            System.out.println("-----------------------------------------");
        }
        System.out.println("              [1] Back to panel ");
        System.out.println("              ============================");
        System.out.println("              Please enter a number: ");

        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }

        if (InputMenu == 1) {
            ManagerPanel();
        } else {
            System.out.println("                 Please enter a valid number...");
            ListOfCustomersMenu();
        }
    }

    public static void ManagerEditInfoMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n              ========= EditInfo Panel ========= ");
        System.out.println("                 [1] Username");
        System.out.println("                 [2] Password");
        System.out.println("                 [3] Name");
        System.out.println("                 [4] Family");
        System.out.println("                 [5] Phone number");
        System.out.println("                 [6] Email");
        System.out.println("                 [7 + A character] Back to panel");
        System.out.println("                 ============================");
        System.out.println("                 Please enter a number & your new info: ");

        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }
        String InputMenu2 = input.next();
        ManagerFunctions.EditInfo(InputMenu, InputMenu2);

    } //Function

    public static void AddItemRequestsMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n         ========= Add Product List ========= ");
        for (int i = 0; i < Lists.getLists().SellerAddList.size(); i++) {
            System.out.println(Lists.getLists().SellerAddList.get(i).toString());
            System.out.println("-----------------------------------------");
            System.out.println("         [1] Accept the request ");
            System.out.println("         [2] Reject the request ");
            int InputMenu = input.nextInt();

            ManagerFunctions.AddItemRequest(InputMenu, i);
        }
        System.out.println("         [1] Back to panel ");
        System.out.println("         ============================");
        System.out.println("         Please enter a number: ");

        try {
            InputMenu2 = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }

        if (InputMenu2 == 1) {
            ManagerPanel();
        } else {
            System.out.println("                 Please enter a valid number...");
            AddItemRequestsMenu();
        }
    } //Function

    public static void CommentRequestsMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n         ========= Comment request List ========= ");
        for (int i = 0; i < Lists.getLists().CommentRequests.size(); i++) {
            System.out.println(Lists.getLists().CommentRequests.get(i).toString());
            System.out.println("-----------------------------------------");
            System.out.println("         [1] Accept the request ");
            System.out.println("         [2] Reject the request ");
            int InputMenu = input.nextInt();

            ManagerFunctions.CommentRequest(InputMenu, i);
        }
        System.out.println("         [1] Back to panel ");
        System.out.println("         ============================");
        System.out.println("         Please enter a number: ");

        try {
            InputMenu2 = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }

        if (InputMenu2 == 1) {
            ManagerPanel();
        } else {
            System.out.println("                 Please enter a valid number...");
            CommentRequestsMenu();
        }
    } //Function

    public static void AcceptSellerMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n         ========= Seller register request List ========= ");
        for (int i = 0; i < Lists.getLists().SellerRegisterList.size(); i++) {
            System.out.println(Lists.getLists().SellerRegisterList.get(i).toString());
            System.out.println("-----------------------------------------");
            System.out.println("         [1] Accept the request ");
            System.out.println("         [2] Reject the request ");
            int InputMenu = input.nextInt();

            ManagerFunctions.AcceptSeller(InputMenu, i);
        }
        System.out.println("         [1] Back to panel ");
        System.out.println("         ============================");
        System.out.println("         Please enter a number: ");

        try {
            InputMenu2 = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }

        if (InputMenu2 == 1) {
            ManagerPanel();
        } else {
            System.out.println("                 Please enter a valid number...");
            ListOfCustomersMenu();
        }
    } //Function

    public static void EditItemRequestMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n         ========= Edit product request List ========= ");
        for (int i = 0; i < Lists.getLists().EditRequests.size(); i++) {
            System.out.println(Lists.getLists().EditRequests.get(i).getItemForEdit().toString());
            System.out.println("New information are: ");
            System.out.println(Lists.getLists().EditRequests.get(i).toString());
            System.out.println("-----------------------------------------");
            System.out.println("         [1] Accept the request ");
            System.out.println("         [2] Reject the request ");
            int InputMenu = input.nextInt();

            ManagerFunctions.EditItemRequest(InputMenu, i);
        }
        System.out.println("         [1] Back to panel ");
        System.out.println("         ============================");
        System.out.println("         Please enter a number: ");

        try {
            InputMenu2 = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }

        if (InputMenu2 == 1) {
            ManagerPanel();
        } else {
            System.out.println("                 Please enter a valid number...");
            EditItemRequestMenu();
        }
    } //Function

    public static void ManagerInfoMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n              ========= Info Panel ========= ");
        System.out.println(Manager.getManager().toString());
        System.out.println("----------------------------------------");
        System.out.println("                 [1] Back to panel");
        System.out.println("                 Please enter a number: ");
        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }

        if (InputMenu == 1) {
            ManagerPanel();
        } else {
            System.out.println("                 Please enter a valid number...");
            ManagerInfoMenu();
        }
    }

    public static void RemoveUserMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n              ========= Remove Customer ========= ");
        System.out.print("1.Name" + '\t');
        System.out.print("2.Family" + '\t');
        System.out.print("3.Username" + '\t');
        System.out.print("4.Password" + '\t');
        System.out.print("5.Fund" + '\t');
        System.out.print("6.Email" + '\t');
        System.out.println("7.Number");
//        for (int i = 0; i < Lists.getLists().getCustomerList().size(); i++) {
//            System.out.println(Lists.getLists().getCustomerList().get(i).toString());
//            System.out.println("-----------------------------------------");
//        }
        ResultSet rs = MySQL.getMySQL().ExecuteQuery("SELECT customers.Name, customers.Family," +
                " customers.Username, customers.Password, customers.Fund, " +
                "emails.Email, numbers.Number FROM numbers JOIN customers ON customers.Id = numbers.Id" +
                " JOIN emails ON emails.Id = numbers.Id");
        while (rs.next())
        {
            System.out.print("1." + rs.getString("Name") + " ---- ");
            System.out.print("2." + rs.getString("Family") + " ---- ");
            System.out.print("3." + rs.getString("Username") + " ---- ");
            System.out.print("4." + rs.getString("Password") + " ---- ");
            System.out.print("5." + rs.getString("Fund") + " ---- ");
            System.out.print("6." + rs.getString("Email") + " ---- ");
            System.out.println("7." + rs.getString("Number"));
        }
        System.out.println("              [ ] Please enter the customer Username: ");
        String InputMenuString = null;
        try {
            InputMenuString = input.next();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }
        String SqlCmd = String.format("DELETE FROM customers WHERE Username='%s'",InputMenuString);
        MySQL.getMySQL().Execute(SqlCmd);
        ManagerFunctions.RemoveUser(InputMenu);

        System.out.println("              [1] Back to panel ");
        System.out.println("              ============================");
        System.out.println("              Please enter a number: ");

        try {
            InputMenu2 = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }

        if (InputMenu2 == 1) {
            ManagerPanel();
        } else {
            System.out.println("                 Please enter a valid number...");
            RemoveUserMenu();
        }
    } //Function

    public static void CategoryListMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n             ========= ProductsCategory ========= ");
        System.out.println("             [1] Digital");
        System.out.println("             [2] Home Appliances");
        System.out.println("             [3] Clothing");
        System.out.println("             [4] Food");
        System.out.println("             [5] Back to panel");
        System.out.println("             ====================================");
        System.out.println("             Please enter a number: ");

        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }

        switch (InputMenu) {
            case 1:
                ManagerDigitalMenu();
                break;

            case 2:
                ManagerHomeAppliancesMenu();
                break;

            case 3:
                ManagerClothingMenu();
                break;

            case 4:
                ManagerFoodMenu();
                break;

            case 5:
                ManagerPanel();
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                CategoryListMenu();
                break;
        }
    }

    public static void ManagerDigitalMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n              ========= Digital Products ========= ");
        for (int i = 0; i < Category.getDigitalItemList().size(); i++) {
            System.out.println(Category.getDigitalItemList().get(i).toString());
            System.out.println("------------------------------------------------");
        }
        System.out.println("              [1] Back to categories");
        System.out.println("              [2] Back to panel");
        System.out.println("              ============================");
        System.out.println("              Please enter a number: ");

        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }

        switch (InputMenu) {
            case 1:
                CategoryListMenu();
                break;

            case 2:
                ManagerPanel();
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                ManagerDigitalMenu();
                break;
        }
    }

    public static void ManagerClothingMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n              ========= Clothing Products ========= ");
        for (int i = 0; i < Category.getClothingItemList().size(); i++) {
            System.out.println(Category.getClothingItemList().get(i).toString());
            System.out.println("------------------------------------------------");
        }
        System.out.println("              [1] Back to categories");
        System.out.println("              [2] Back to panel");
        System.out.println("              ============================");
        System.out.println("              Please enter a number: ");

        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }

        switch (InputMenu) {
            case 1:
                CategoryListMenu();
                break;

            case 2:
                ManagerPanel();
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                ManagerClothingMenu();
                break;
        }
    }

    public static void ManagerFoodMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n              ========= Food Products ========= ");
        for (int i = 0; i < Category.getFoodItemList().size(); i++) {
            System.out.println(Category.getFoodItemList().get(i).toString());
            System.out.println("------------------------------------------------");
        }
        System.out.println("              [1] Back to categories");
        System.out.println("              [2] Back to panel");
        System.out.println("              ============================");
        System.out.println("              Please enter a number: ");

        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }

        switch (InputMenu) {
            case 1:
                CategoryListMenu();
                break;

            case 2:
                ManagerPanel();
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                ManagerFoodMenu();
                break;
        }
    }

    public static void ManagerHomeAppliancesMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n              ========= HomeAppliances Products ========= ");
        for (int i = 0; i < Category.getHomeAppliancesItemList().size(); i++) {
            System.out.println(Category.getHomeAppliancesItemList().get(i).toString());
            System.out.println("------------------------------------------------");
        }
        System.out.println("              [1] Back to categories");
        System.out.println("              [2] Back to panel");
        System.out.println("              ============================");
        System.out.println("              Please enter a number: ");

        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }

        switch (InputMenu) {
            case 1:
                CategoryListMenu();
                break;

            case 2:
                ManagerPanel();
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                ManagerHomeAppliancesMenu();
                break;
        }
    }

    public static void RemoveSellerMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n              ========= Remove Seller ========= ");
        System.out.print("1.Name" + '\t');
        System.out.print("2.Family" + '\t');
        System.out.print("3.Username" + '\t');
        System.out.print("4.Password" + '\t');
        System.out.print("5.Fund" + '\t');
        System.out.print("6.Email" + '\t');
        System.out.print("7.Company" + '\t');
        System.out.println("8.Number");
//        for (int i = 0; i < Lists.getLists().SellerList.size(); i++) {
//            System.out.println(Lists.getLists().SellerList.get(i).toString());
//            System.out.println("-----------------------------------------");
//        }
        ResultSet rs = MySQL.getMySQL().ExecuteQuery("SELECT sellers.Name, sellers.Family," +
                " sellers.Username, sellers.Password, sellers.Fund, sellers.Company, " +
                "emails.Email, numbers.Number FROM numbers INNER JOIN sellers ON sellers.Id = numbers.Id" +
                " INNER JOIN emails ON emails.Id = numbers.Id");
        while (rs.next())
        {
            System.out.print("1." + rs.getString("Name") + " ---- ");
            System.out.print("2." + rs.getString("Family") + " ---- ");
            System.out.print("3." + rs.getString("Username") + " ---- ");
            System.out.print("4." + rs.getString("Password") + " ---- ");
            System.out.print("5." + rs.getString("Fund") + " ---- ");
            System.out.print("6." + rs.getString("Email") + " ---- ");
            System.out.print("7." + rs.getString("Company") + " ---- ");
            System.out.println("8." + rs.getString("Number"));
        }
        System.out.println("              [ ] Please enter the customer id: ");
        String InputMenuString = null;
        try {
            InputMenuString = input.next();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }

        String SqlCmd = String.format("DELETE FROM sellers WHERE Username='%s'",InputMenuString);
        MySQL.getMySQL().Execute(SqlCmd);
        ManagerFunctions.RemoveSeller(InputMenu);

        System.out.println("              [1] Back to panel ");
        System.out.println("              ============================");
        System.out.println("              Please enter a number: ");

        try {
            InputMenu2 = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }

        if (InputMenu2 == 1) {
            ManagerPanel();
        } else {
            System.out.println("                 Please enter a valid number...");
            RemoveSellerMenu();
        }
    } //Function
}

abstract class ManagerFunctions {
    public static void EditItemRequest(int Input, int Index) {
        if (Input == 1) {
            Lists.getLists().EditRequests.get(Index).getItemForEdit().setName(Lists.getLists().EditRequests.get(Index).getNameForEdit());
            Lists.getLists().EditRequests.get(Index).getItemForEdit().setBrand(Lists.getLists().EditRequests.get(Index).getBrandForEdit());
            Lists.getLists().EditRequests.get(Index).getItemForEdit().setInfo(Lists.getLists().EditRequests.get(Index).getInfoForEdit());
            Lists.getLists().EditRequests.get(Index).getItemForEdit().setPrice(Lists.getLists().EditRequests.get(Index).getPriceForEdit());
            Lists.getLists().EditRequests.remove(Index);
        } else if (Input == 2) {
            Lists.getLists().SellerAddList.remove(Index);
        }
    }

    public static void EditInfo(int Input, String NewInfo) throws IOException, SQLException {
        switch (Input) {
            case 1:
                Manager.getManager().setUsername(NewInfo);
                System.out.println(
                        "Your Username successfully changed!"
                );
                ManagerStuff.ManagerEditInfoMenu();
                break;

            case 2:
                Manager.getManager().setPassword(NewInfo);
                System.out.println(
                        "Your Password successfully changed!"
                );
                ManagerStuff.ManagerEditInfoMenu();
                break;

            case 3:
                Manager.getManager().setName(NewInfo);
                System.out.println(
                        "Your Name successfully changed!"
                );
                ManagerStuff.ManagerEditInfoMenu();
                break;

            case 4:
                Manager.getManager().setFamily(NewInfo);
                System.out.println(
                        "Your Family successfully changed!"
                );
                ManagerStuff.ManagerEditInfoMenu();
                break;

            case 5:
                Manager.getManager().setNumber(NewInfo);
                System.out.println(
                        "Your Phone number successfully changed!"
                );
                ManagerStuff.ManagerEditInfoMenu();
                break;
            case 6:
                Manager.getManager().setEmail(NewInfo);
                System.out.println(
                        "Your Email successfully changed!"
                );
                ManagerStuff.ManagerEditInfoMenu();
                break;

            case 7:
                ManagerStuff.ManagerPanel();
                break;


            default:
                System.out.println("                 Please enter a valid number...");
                ManagerStuff.ManagerEditInfoMenu();
                break;
        }
    }

    public static void AddItemRequest(int Input, int Index) {
        if (Input == 1) {
            if (Lists.getLists().SellerAddList.get(Index).getTag().equals("Mobile")) {
                Lists.getLists().AllItems.add(Lists.getLists().SellerAddList.get(Index));
                Lists.getLists().DigitalItems.add(Lists.getLists().SellerAddList.get(Index));
                Lists.getLists().MobileItems.add(Lists.getLists().SellerAddList.get(Index));
                Lists.getLists().SellerAddList.get(Index).getSellerItem().getItemList().add(Lists.getLists().SellerAddList.get(Index));
                Lists.getLists().SellerAddList.remove(Index);
            } else if (Lists.getLists().SellerAddList.get(Index).getTag().equals("Laptop")) {
                Lists.getLists().AllItems.add(Lists.getLists().SellerAddList.get(Index));
                Lists.getLists().DigitalItems.add(Lists.getLists().SellerAddList.get(Index));
                Lists.getLists().LaptopItems.add(Lists.getLists().SellerAddList.get(Index));
                Lists.getLists().SellerAddList.get(Index).getSellerItem().getItemList().add(Lists.getLists().SellerAddList.get(Index));
                Lists.getLists().SellerAddList.remove(Index);
            } else if (Lists.getLists().SellerAddList.get(Index).getTag().equals("TV")) {
                Lists.getLists().AllItems.add(Lists.getLists().SellerAddList.get(Index));
                Lists.getLists().HomeAppliancesItems.add(Lists.getLists().SellerAddList.get(Index));
                Lists.getLists().TVItems.add(Lists.getLists().SellerAddList.get(Index));
                Lists.getLists().SellerAddList.get(Index).getSellerItem().getItemList().add(Lists.getLists().SellerAddList.get(Index));
                Lists.getLists().SellerAddList.remove(Index);
            } else if (Lists.getLists().SellerAddList.get(Index).getTag().equals("Refrigerator")) {
                Lists.getLists().AllItems.add(Lists.getLists().SellerAddList.get(Index));
                Lists.getLists().HomeAppliancesItems.add(Lists.getLists().SellerAddList.get(Index));
                Lists.getLists().RefrigeratorItems.add(Lists.getLists().SellerAddList.get(Index));
                Lists.getLists().SellerAddList.get(Index).getSellerItem().getItemList().add(Lists.getLists().SellerAddList.get(Index));
                Lists.getLists().SellerAddList.remove(Index);
            } else if (Lists.getLists().SellerAddList.get(Index).getTag().equals("Stove")) {
                Lists.getLists().AllItems.add(Lists.getLists().SellerAddList.get(Index));
                Lists.getLists().HomeAppliancesItems.add(Lists.getLists().SellerAddList.get(Index));
                Lists.getLists().StoveItems.add(Lists.getLists().SellerAddList.get(Index));
                Lists.getLists().SellerAddList.get(Index).getSellerItem().getItemList().add(Lists.getLists().SellerAddList.get(Index));
                Lists.getLists().SellerAddList.remove(Index);
            } else if (Lists.getLists().SellerAddList.get(Index).getTag().equals("Cloth")) {
                Lists.getLists().AllItems.add(Lists.getLists().SellerAddList.get(Index));
                Lists.getLists().ClothingItems.add(Lists.getLists().SellerAddList.get(Index));
                Lists.getLists().ClothItems.add(Lists.getLists().SellerAddList.get(Index));
                Lists.getLists().SellerAddList.get(Index).getSellerItem().getItemList().add(Lists.getLists().SellerAddList.get(Index));
                Lists.getLists().SellerAddList.remove(Index);
            } else if (Lists.getLists().SellerAddList.get(Index).getTag().equals("Shoes")) {
                Lists.getLists().AllItems.add(Lists.getLists().SellerAddList.get(Index));
                Lists.getLists().ClothingItems.add(Lists.getLists().SellerAddList.get(Index));
                Lists.getLists().ShoesItems.add(Lists.getLists().SellerAddList.get(Index));
                Lists.getLists().SellerAddList.get(Index).getSellerItem().getItemList().add(Lists.getLists().SellerAddList.get(Index));
                Lists.getLists().SellerAddList.remove(Index);
            } else if (Lists.getLists().SellerAddList.get(Index).getTag().equals("Food")) {
                Lists.getLists().AllItems.add(Lists.getLists().SellerAddList.get(Index));
                Lists.getLists().FoodItems.add(Lists.getLists().SellerAddList.get(Index));
                Lists.getLists().SellerAddList.get(Index).getSellerItem().getItemList().add(Lists.getLists().SellerAddList.get(Index));
                Lists.getLists().SellerAddList.remove(Index);
            }
        } else if (Input == 2) {
            Lists.getLists().SellerAddList.remove(Index);
        }
    }

    public static void CommentRequest(int Input, int Index) {
        if (Input == 1) {
            Lists.getLists().CommentRequests.get(Index).getProduct().getCommentList().add((javax.xml.stream.events.Comment) Lists.getLists().CommentRequests.get(Index));
            Lists.getLists().CommentRequests.remove(Index);
        } else if (Input == 2) {
            Lists.getLists().CommentRequests.remove(Index);
        }
    }

    public static void AcceptSeller(int Input, int Index) throws SQLException {
        if (Input == 1) {
            Seller seller = Lists.getLists().SellerRegisterList.get(Index);
            Lists.getLists().SellerList.add(seller);

            SellerFunctions.InsertSeller(seller.getId(), seller.getName(), seller.getFamily(), seller.getEmail(), seller.getNumber(),
                    seller.getUsername(), seller.getPassword(), seller.getCompany(), seller.getFund());

            Lists.getLists().SellerRegisterList.remove(Index);
        } else if (Input == 2) {
            Lists.getLists().SellerRegisterList.remove(Index);
        }
    }

    public static void RemoveUser(int Id) throws SQLException {
        for (int i = 0; i < Lists.getLists().getCustomerList().size(); i++) {
            if (Lists.getLists().getCustomerList().get(i).getId() == Id) {
                String SqlCmd = String.format("DELETE FROM customers WHERE Id = %s", Id);
                MySQL.getMySQL().Execute(SqlCmd);
                Lists.getLists().getCustomerList().remove(i);
            }

        }
    }

    public static void RemoveSeller(int Id) throws SQLException {
        for (int i = 0; i < Lists.getLists().getSellerList().size(); i++) {
            if (Lists.getLists().getSellerList().get(i).getId() == Id) {
                String SqlCmd = String.format("DELETE FROM sellers WHERE Id = %s", Id);
                MySQL.getMySQL().Execute(SqlCmd);
                Lists.getLists().getSellerList().remove(i);
            }

        }
    }
}
