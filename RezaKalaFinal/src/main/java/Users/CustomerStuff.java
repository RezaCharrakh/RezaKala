package Users;

import Product.Item;
import exception.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static Users.pages.CustomerLoggedIn;
import static Users.pages.MainMenu;

abstract public class CustomerStuff {
    static int InputMenu;
    static int Input2Menu;

    public static void NoMoney(int totalPrice, int fund) {
        if (totalPrice > fund)
            throw new NoMoneyException();
    }

    public static void CustomerPanel() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n             ========= " + CustomerLoggedIn.getName() + " " + CustomerLoggedIn.getFamily() + " Panel ========= ");
        System.out.println("             [1] Products");
        System.out.println("             [2] Edit info");
        System.out.println("             [3] Cart");
        System.out.println("             [4] Purchase history");
        System.out.println("             [5] User info");
        System.out.println("             [6] Comment");
        System.out.println("             [7] Rate");
        System.out.println("             [8] Increase credit");
        System.out.println("             [9] Log out");
        System.out.println("             ============================");
        System.out.println("             Please enter a number: ");

        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }

        switch (InputMenu) {
            case 1:
                CustomerProductMenu();
                break;

            case 2:
                CustomerEditInfoMenu();
                break;

            case 3:
                CartMenu();
                break;

            case 4:
                PurchaseHistoryMenu();
                break;

            case 5:
                CustomerInfoMenu();
                break;

            case 6:
                CustomerComment();
                break;

            case 7:
                CustomerRate();
                break;

            case 8:
                ChargeCredit();
                break;


            case 9:
                MainMenu();
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                CustomerPanel();
                break;
        }
    }

    public static void CustomerProductMenu() throws IOException, SQLException {
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
                CustomerDigitalMenu();
                break;

            case 2:
                CustomerHomeAppliancesMenu();
                break;

            case 3:
                CustomerClothingMenu();
                break;

            case 4:
                CustomerFoodMenu();
                break;

            case 5:
                CustomerPanel();
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                CustomerProductMenu();
                break;
        }
    }

    public static void CustomerEditInfoMenu() throws IOException, SQLException {
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
        System.out.println("                 Please enter a number & new your new info: ");

        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }
        String InputMenu2 = input.next();

        CustomerFunctions.EditInfo(InputMenu, InputMenu2);


    } //Function

    public static void CartMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n              ========= Cart Panel ========= ");
        for (int i = 0; i < CustomerLoggedIn.getCart().size(); i++) {
            System.out.println(CustomerLoggedIn.getCart().get(i).toString());
            System.out.println("------------------------------------------");
            System.out.println("                 [1] to Remove from cart");
            System.out.println("                 [2] to continue");
            int InputMenu = input.nextInt();
            if (InputMenu == 1) {
                CustomerLoggedIn.getCart().remove(i);
            } else if (InputMenu == 2) {
                if (!CustomerLoggedIn.getCart().get(i).isInStock()) {
                    try {
                        throw new InStockException();
                    } catch (InStockException ex) {
                        System.out.println(ex.toString());
                        CustomerLoggedIn.getCart().remove(i);
                    }
                }
            }
        }
        int TotalPrice = 0;
        for (int i = 0; i < CustomerLoggedIn.getCart().size(); i++) {
            TotalPrice += CustomerLoggedIn.getCart().get(i).getPrice();
        }
        System.out.println("                 [1] Finalize the purchase");
        System.out.println("                 [2] Back to panel");
        System.out.println("                 Please enter a number: ");
        try {
            Input2Menu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }
        switch (Input2Menu) {
            case 1: {
                try {
                    NoMoney(TotalPrice, CustomerLoggedIn.getFund());
                    CustomerStuff.ShippingMenu(TotalPrice);
                }
                catch (NoMoneyException ex) {
                    System.out.println(ex.toString());
                    String SQLCom = String.format("INSERT INTO errorLogs (ErrorMessage)" +
                            " VALUES ('%s')",ex.toString());
                    MySQL.getMySQL().Execute(SQLCom);
                    CustomerStuff.CustomerPanel();
                }

                break;
            }
            case 2:
                CustomerStuff.CustomerPanel();
                break;


            default:
                CustomerStuff.CartMenu();
                break;
        }


    }

    public static void PurchaseHistoryMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n           ========= Purchase History Panel ========= ");

        for (int i = 0; i < CustomerLoggedIn.getPurchaseHistory().size(); i++) {
            System.out.println(CustomerLoggedIn.getPurchaseHistory().get(i).toString() + '\n');
            for (int j = 0; j < CustomerLoggedIn.getPurchaseHistory().get(i).getPurchasedItems().size(); j++) {
                System.out.println(CustomerLoggedIn.getPurchaseHistory().get(i).getPurchasedItems().get(j).toString());
                System.out.println("------------------------------------------");
            }
            System.out.println("==========================================");
        }
        System.out.println("              [1] Back to panel");
        System.out.println("              Please enter a number: ");
        try {
            Input2Menu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }

        if (Input2Menu == 1) {
            CustomerPanel();
        } else {
            System.out.println("                 Please enter a valid number...");
            PurchaseHistoryMenu();
        }
    }

    public static void CustomerComment() throws IOException, SQLException {

        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n           ========= Comment Panel ========= ");

        for (int i = 0; i < CustomerLoggedIn.getPurchaseHistory().size(); i++) {
            for (int j = 0; j < CustomerLoggedIn.getPurchaseHistory().get(i).getPurchasedItems().size(); j++) {
                System.out.println(CustomerLoggedIn.getPurchaseHistory().get(i).getPurchasedItems().get(j).toString());
                System.out.println("------------------------------------------");
                System.out.println("[1] If you want to submit a comment: ");
                System.out.println("[2] Continue ");
                int InputMenu = input.nextInt();
                if (InputMenu == 1) {
                    System.out.println("                   ( ) Please enter Your comment:");
                    input.nextLine();
                    String CommentText = input.nextLine();
                    Lists.getLists().CommentRequests.add(new Comment(CustomerLoggedIn.getName(), CustomerLoggedIn.getFamily(),
                            CommentText, CustomerLoggedIn.getPurchaseHistory().get(i).getPurchasedItems().get(j)));
                    System.out.println("                   ( ) Your comment submitted & it's under review!");
                }

            }
        }
        System.out.println("              [1] Back to panel");
        System.out.println("              Please enter a number: ");
        try {
            Input2Menu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }

        if (Input2Menu == 1) {
            CustomerPanel();
        } else {
            System.out.println("                 Please enter a valid number...");
            CustomerComment();
        }
    }

    public static void CustomerRate() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n           ========= Rate Panel ========= ");

        for (int i = 0; i < CustomerLoggedIn.getPurchaseHistory().size(); i++) {
            for (int j = 0; j < CustomerLoggedIn.getPurchaseHistory().get(i).getPurchasedItems().size(); j++) {
                System.out.println(CustomerLoggedIn.getPurchaseHistory().get(i).getPurchasedItems().get(j).toString());
                System.out.println("------------------------------------------");
                System.out.println("[1] If you want to submit a Rate: ");
                System.out.println("[2] Continue ");
                int InputMenu = input.nextInt();
                if (InputMenu == 1) {
                    System.out.println("                   ( ) Please enter Your Rate from 0 to 5:");
                    double InputRate = input.nextDouble();
                    CustomerFunctions.Rate(i, j, InputRate);
                }
            }
        }
        System.out.println("              [1] Back to panel");
        System.out.println("              Please enter a number: ");
        try {
            Input2Menu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }

        if (Input2Menu == 1) {
            CustomerPanel();
        } else {
            System.out.println("                 Please enter a valid number...");
            CustomerComment();
        }
    } //Function

    public static void CustomerInfoMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n              ========= Info Panel ========= ");
        System.out.println(CustomerLoggedIn.toString());
        System.out.println("----------------------------------------");
        System.out.println("                 [1] Back to panel");
        System.out.println("                 Please enter a number: ");
        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }

        if (InputMenu == 1) {
            CustomerPanel();
        } else {
            System.out.println("                 Please enter a valid number...");
            CustomerInfoMenu();
        }
    }

    public static void ShippingMenu(int AmountPaid) throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n                 ========= Shipping Panel ========= ");
        Date date = new Date();
        Date delivery = new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(10));
        Date d = new Date(12);

        CustomerLoggedIn.getPurchaseHistory().add(new BuyFactor(date, AmountPaid, delivery));
        CustomerLoggedIn.setFund(CustomerLoggedIn.getFund() - AmountPaid);
        System.out.println("Please enter your address: ");
        String InputMenu = input.nextLine();
        System.out.println("[ ] " + CustomerLoggedIn.getName() + CustomerLoggedIn.getFamily() + "\n[ ] " +
                CustomerLoggedIn.getNumber() + "\n[ ] " + CustomerLoggedIn.getEmail() + "\n[ ] " + InputMenu + "\n[ ] " + AmountPaid + "$");


        for (int i = 0; i < CustomerLoggedIn.getCart().size(); i++) {
            System.out.println(CustomerLoggedIn.getCart().get(i).toString());
            CustomerLoggedIn.getPurchaseHistory().get(CustomerLoggedIn.getPurchaseHistory().size() - 1).getPurchasedItems().add(CustomerLoggedIn.getCart().get(i));

            CustomerLoggedIn.getCart().get(i).getSellerItem().setFund(CustomerLoggedIn.getCart().get(i).getSellerItem().getFund() + CustomerLoggedIn.getCart().get(i).getPrice());

            CustomerLoggedIn.getCart().get(i).getSellerItem().getSellHistoryList().add(new SellFactor(date,
                    CustomerLoggedIn.getCart().get(i).getPrice(), CustomerLoggedIn, delivery));

            CustomerLoggedIn.getCart().get(i).getSellerItem().getSellHistoryList().get(CustomerLoggedIn.getCart()
                    .get(i).getSellerItem().getSellHistoryList().size() - 1).getSoldItems().add(CustomerLoggedIn.getCart().get(i));

            CustomerLoggedIn.getCart().get(i).setInStock(false);
            System.out.println("------------------------------------------");
        }
        for (int i = 0; i < CustomerLoggedIn.getCart().size(); i++)
            CustomerLoggedIn.getCart().remove(i);

        System.out.println("                 [ ] Thanks for your purchase!");
        System.out.println("                 [1] Back to panel");
        System.out.println("                 Please enter a number: ");
        try {
            Input2Menu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }

        if (Input2Menu == 1) {
            CustomerPanel();
        } else {
            System.out.println("                 Please enter a valid number...");
            ShippingMenu(AmountPaid);
        }
    }

    public static void CustomerDigitalMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n              ========= Digital Products ========= ");
        System.out.println("              [1] Show Products");
        System.out.println("              [2] Search by name of the product");
        System.out.println("              [3] Filters");
        System.out.println("              [4] Mobile");
        System.out.println("              [5] Laptop");
        System.out.println("              [6] Categories");
        System.out.println("              ============================");
        System.out.println("              Please enter a number: ");

        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }

        switch (InputMenu) {
            case 1:
                CustomerShowProductsMenu(Lists.getLists().DigitalItems);
                break;

            case 2:
                CustomerSearchProductMenu(Lists.getLists().DigitalItems);
                break;

            case 3:
                CustomerFiltersMenu(Lists.getLists().DigitalItems);
                break;

            case 4:
                CustomerMobileMenu();
                break;

            case 5:
                CustomerLaptopMenu();
                break;

            case 6:
                CustomerProductMenu();
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                CustomerDigitalMenu();
                break;
        }
    }

    public static void CustomerMobileMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n              ========= Mobile Products ========= ");
        System.out.println("              [1] Show Products");
        System.out.println("              [2] Search by name of the product");
        System.out.println("              [3] Filters");
        System.out.println("              ============================");
        System.out.println("              Please enter a number: ");

        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }

        switch (InputMenu) {
            case 1:
                CustomerShowProductsMenu(Lists.getLists().MobileItems);
                break;

            case 2:
                CustomerSearchProductMenu(Lists.getLists().MobileItems);
                break;

            case 3:
                CustomerFiltersMenu(Lists.getLists().MobileItems);
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                CustomerMobileMenu();
                break;
        }
    }

    public static void CustomerLaptopMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n              ========= Laptop Products ========= ");
        System.out.println("              [1] Show Products");
        System.out.println("              [2] Search by name of the product");
        System.out.println("              [3] Filters");
        System.out.println("              ============================");
        System.out.println("              Please enter a number: ");

        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }

        switch (InputMenu) {
            case 1:
                CustomerShowProductsMenu(Lists.getLists().LaptopItems);
                break;

            case 2:
                CustomerSearchProductMenu(Lists.getLists().LaptopItems);
                break;

            case 3:
                CustomerFiltersMenu(Lists.getLists().LaptopItems);
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                CustomerLaptopMenu();
                break;
        }
    }

    public static void CustomerClothingMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n              ========= Clothing Products ========= ");
        System.out.println("              [1] Show Products");
        System.out.println("              [2] Search by name of the product");
        System.out.println("              [3] Filters");
        System.out.println("              [4] Cloth");
        System.out.println("              [5] Shoes");
        System.out.println("              [6] Categories");
        System.out.println("              ============================");
        System.out.println("              Please enter a number: ");

        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }

        switch (InputMenu) {
            case 1:
                CustomerShowProductsMenu(Lists.getLists().ClothingItems);
                break;

            case 2:
                CustomerSearchProductMenu(Lists.getLists().ClothingItems);
                break;

            case 3:
                CustomerFiltersMenu(Lists.getLists().ClothingItems);
                break;

            case 4:
                CustomerClothMenu();
                break;

            case 5:
                CustomerShoesMenu();
                break;

            case 6:
                CustomerProductMenu();
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                CustomerClothingMenu();
                break;
        }
    }

    public static void CustomerClothMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n              ========= Cloth Products ========= ");
        System.out.println("              [1] Show Products");
        System.out.println("              [2] Search by name of the product");
        System.out.println("              [3] Filters");
        System.out.println("              ============================");
        System.out.println("              Please enter a number: ");

        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }

        switch (InputMenu) {
            case 1:
                CustomerShowProductsMenu(Lists.getLists().ClothItems);
                break;

            case 2:
                CustomerSearchProductMenu(Lists.getLists().ClothItems);
                break;

            case 3:
                CustomerFiltersMenu(Lists.getLists().ClothItems);
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                CustomerClothMenu();
                break;
        }
    }

    public static void CustomerShoesMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n              ========= Shoes Products ========= ");
        System.out.println("              [1] Show Products");
        System.out.println("              [2] Search by name of the product");
        System.out.println("              [3] Filters");
        System.out.println("              ============================");
        System.out.println("              Please enter a number: ");

        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }

        switch (InputMenu) {
            case 1:
                CustomerShowProductsMenu(Lists.getLists().ShoesItems);
                break;

            case 2:
                CustomerSearchProductMenu(Lists.getLists().ShoesItems);
                break;

            case 3:
                CustomerFiltersMenu(Lists.getLists().ShoesItems);
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                CustomerShoesMenu();
                break;
        }
    }

    public static void CustomerFoodMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n              ========= Food Products ========= ");
        System.out.println("              [1] Show Products");
        System.out.println("              [2] Search by name of the product");
        System.out.println("              [3] Filters");
        System.out.println("              [4] Categories");
        System.out.println("              ============================");
        System.out.println("              Please enter a number: ");

        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }

        switch (InputMenu) {
            case 1:
                CustomerShowProductsMenu(Lists.getLists().FoodItems);
                break;

            case 2:
                CustomerSearchProductMenu(Lists.getLists().FoodItems);
                break;

            case 3:
                CustomerFiltersMenu(Lists.getLists().FoodItems);
                break;

            case 4:
                CustomerProductMenu();
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                CustomerFoodMenu();
                break;
        }
    }

    public static void CustomerHomeAppliancesMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n           ========= HomeAppliances Products ========= ");
        System.out.println("           [1] Show Products");
        System.out.println("           [2] Search by name of the product");
        System.out.println("           [3] Filters");
        System.out.println("           [4] Stove");
        System.out.println("           [5] Refrigerator");
        System.out.println("           [6] TV");
        System.out.println("           [7] Categories");
        System.out.println("           ============================");
        System.out.println("           Please enter a number: ");

        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }

        switch (InputMenu) {
            case 1:
                CustomerShowProductsMenu(Lists.getLists().HomeAppliancesItems);
                break;

            case 2:
                CustomerSearchProductMenu(Lists.getLists().HomeAppliancesItems);
                break;

            case 3:
                CustomerFiltersMenu(Lists.getLists().HomeAppliancesItems);
                break;

            case 4:
                CustomerStoveMenu();
                break;

            case 5:
                CustomerRefrigeratorMenu();
                break;

            case 6:
                CustomerTVMenu();
                break;

            case 7:
                CustomerProductMenu();
                break;


            default:
                System.out.println("                 Please enter a valid number...");
                CustomerHomeAppliancesMenu();
                break;
        }
    }

    public static void CustomerTVMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n           ========= TV Products ========= ");
        System.out.println("           [1] Show Products");
        System.out.println("           [2] Search by name of the product");
        System.out.println("           [3] Filters");
        System.out.println("           ============================");
        System.out.println("           Please enter a number: ");

        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }

        switch (InputMenu) {
            case 1:
                CustomerShowProductsMenu(Lists.getLists().TVItems);
                break;

            case 2:
                CustomerSearchProductMenu(Lists.getLists().TVItems);
                break;

            case 3:
                CustomerFiltersMenu(Lists.getLists().TVItems);
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                CustomerTVMenu();
                break;
        }
    }

    public static void CustomerStoveMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n           ========= Stove Products ========= ");
        System.out.println("           [1] Show Products");
        System.out.println("           [2] Search by name of the product");
        System.out.println("           [3] Filters");
        System.out.println("           ============================");
        System.out.println("           Please enter a number: ");

        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }

        switch (InputMenu) {
            case 1:
                CustomerShowProductsMenu(Lists.getLists().StoveItems);
                break;

            case 2:
                CustomerSearchProductMenu(Lists.getLists().StoveItems);
                break;

            case 3:
                CustomerFiltersMenu(Lists.getLists().StoveItems);
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                CustomerStoveMenu();
                break;
        }
    }

    public static void CustomerRefrigeratorMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n           ========= Refrigerator Products ========= ");
        System.out.println("           [1] Show Products");
        System.out.println("           [2] Search by name of the product");
        System.out.println("           [3] Filters");
        System.out.println("           ============================");
        System.out.println("           Please enter a number: ");

        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }

        switch (InputMenu) {
            case 1:
                CustomerShowProductsMenu(Lists.getLists().RefrigeratorItems);
                break;

            case 2:
                CustomerSearchProductMenu(Lists.getLists().RefrigeratorItems);
                break;

            case 3:
                CustomerFiltersMenu(Lists.getLists().RefrigeratorItems);
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                CustomerRefrigeratorMenu();
                break;
        }
    }

    public static void CustomerFiltersMenu(ArrayList<Item> ItemList) throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n              ========= Products ========= ");
        System.out.println("              [1] By Price");
        System.out.println("              [2] By Alphabet");
        System.out.println("              [3] By Rate");
        System.out.println("              [4] By Defualt");
        System.out.println("              [5] Back to categories");
        System.out.println("              ============================");
        System.out.println("              Please enter a number: ");

        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }

        switch (InputMenu) {
            case 1:
                CustomerFilterByPrice(ItemList);
                break;

            case 2:
                CustomerFilterByAlphabet(ItemList);
                break;

            case 3:
                CustomerFilterByRate(ItemList);
                break;

            case 4:
                CustomerFilterByDefualt(ItemList);
                break;

            case 5:
                CustomerProductMenu();
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                CustomerFiltersMenu(ItemList);
                break;
        }
    }

    public static void CustomerFilterByPrice(ArrayList<Item> ItemList) throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        ArrayList<Item> FilterList = new ArrayList<>();
        Collections.copy(FilterList, ItemList);
        CustomerFunctions.FilterByPrice(FilterList);

        for (Item item : FilterList) {
            System.out.println(item.toString());
            System.out.println("------------------------------------------------");
        }
        System.out.println("[Enter the product id to add to cart]");
        System.out.println("[m1] Back to categories");
        System.out.println("[m2] Back to panel");
        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }
        for (Item item : ItemList) {
            if (InputMenu == item.getId()) {
                CustomerLoggedIn.getCart().add(item);
                System.out.println("Item added to cart!");
            }
        }
        String Input2Menu = input.next();

        switch (Input2Menu) {
            case "m1":
                CustomerProductMenu();
                break;

            case "m2":
                CustomerPanel();
                break;

            default: {
                System.out.println("                 Please enter a valid number...");
                CustomerShowProductsMenu(ItemList);
            }
            break;
        }
    } //Function

    public static void CustomerFilterByAlphabet(ArrayList<Item> ItemList) throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        ArrayList<Item> FilterList = new ArrayList<>();
        Collections.copy(FilterList, ItemList);
        CustomerFunctions.FilterByAlphabet(FilterList);

        for (Item item : FilterList) {
            System.out.println(item.toString());
            System.out.println("------------------------------------------------");
        }
        System.out.println("[Enter the product id to add to cart]");
        System.out.println("[m1] Back to categories");
        System.out.println("[m2] Back to panel");
        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }
        for (Item item : ItemList) {
            if (InputMenu == item.getId()) {
                CustomerLoggedIn.getCart().add(item);
                System.out.println("Item added to cart!");
            }
        }
        String Input2Menu = input.next();

        switch (Input2Menu) {
            case "m1": {
                CustomerProductMenu();
            }
            break;

            case "m2": {
                CustomerPanel();
            }
            break;
            default: {
                System.out.println("                 Please enter a valid number...");
                CustomerShowProductsMenu(ItemList);
            }
            break;
        }
    } //Function

    public static void CustomerFilterByRate(ArrayList<Item> ItemList) throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        ArrayList<Item> FilterList = new ArrayList<>();
        Collections.copy(FilterList, ItemList);
        CustomerFunctions.FilterByRate(FilterList);

        for (Item item : FilterList) {
            System.out.println(item.toString());
            System.out.println("------------------------------------------------");
        }
        System.out.println("[Enter the product id to add to cart]");
        System.out.println("[m1] Back to categories");
        System.out.println("[m2] Back to panel");
        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }
        for (Item item : ItemList) {
            if (InputMenu == item.getId()) {
                CustomerLoggedIn.getCart().add(item);
                System.out.println("Item added to cart!");
            }
        }
        String Input2Menu = input.next();

        switch (Input2Menu) {
            case "m1": {
                CustomerProductMenu();
            }
            break;
            case "m2": {
                CustomerPanel();
            }
            break;
            default: {
                System.out.println("                 Please enter a valid number...");
                CustomerShowProductsMenu(ItemList);
            }
            break;
        }
    } //Function

    public static void CustomerFilterByDefualt(ArrayList<Item> ItemList) throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        ArrayList<Item> FilterList = new ArrayList<>();
        Collections.copy(FilterList, ItemList);
        CustomerFunctions.FilterByDefualt(FilterList);

        for (Item item : FilterList) {
            System.out.println(item.toString());
            System.out.println("------------------------------------------------");
        }
        System.out.println("[Enter the product id to add to cart]");
        System.out.println("[m1] Back to categories");
        System.out.println("[m2] Back to panel");
        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }
        for (Item item : ItemList) {
            if (InputMenu == item.getId()) {
                CustomerLoggedIn.getCart().add(item);
                System.out.println("Item added to cart!");
            }
        }
        String Input2Menu = input.next();

        switch (Input2Menu) {
            case "m1": {
                CustomerProductMenu();
            }
            break;
            case "m2": {
                CustomerPanel();
            }
            break;
            default: {
                System.out.println("                 Please enter a valid number...");
                CustomerShowProductsMenu(ItemList);
            }
            break;
        }
    } //Function


    public static void CustomerShowProductsMenu(ArrayList<Item> ItemList) throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n                ========= Products ========= ");
        for (Item item : ItemList) {
            System.out.println(item.toString());
            System.out.println("------------------------------------------------");
        }
        System.out.println("[Enter the product id to add to cart]");
        System.out.println("[m1] Back to categories");
        System.out.println("[m2] Back to panel");
        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }
        for (Item item : ItemList) {
            if (InputMenu == item.getId()) {
                try {
                    if (!item.isInStock()) {
                        throw new InStockException();
                    }
                } catch (InStockException ex) {
                    System.out.println(ex.toString());
                    CustomerShowProductsMenu(ItemList);
                }
                CustomerLoggedIn.getCart().add(item);
                System.out.println("Item added to cart!");
            }
        }
        String Input2Menu = input.next();

        switch (Input2Menu) {
            case "m1": {
                CustomerProductMenu();
            }
            break;
            case "m2": {
                CustomerPanel();
            }
            break;
            default: {
                System.out.println("                 Please enter a valid number...");
                CustomerShowProductsMenu(ItemList);
            }
            break;
        }

    }

    public static void CustomerSearchProductMenu(ArrayList<Item> ItemList) throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n              ========= Search Product ========= ");
        System.out.println("              [ ] Please enter name of the product");
        System.out.println("              ============================");

        String InputMenu = input.next();

        for (int i = 0; i < ItemList.size(); i++) {
            if (InputMenu.equals(ItemList.get(i).getName())) {
                System.out.println(ItemList.get(i).toString());
                System.out.println("--------------------------------------------");
                System.out.println("[1] Add to cart");
                System.out.println("[2] Continue");
                int InputMenu2 = input.nextInt();
                if (InputMenu2 == 1) {
                    CustomerLoggedIn.getCart().add(ItemList.get(i));
                    System.out.println("Item added to cart!");
                }
            }
        }
        System.out.println("[1] Back to categories");
        System.out.println("[2] Back to panel");
        try {
            Input2Menu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }

        switch (Input2Menu) {
            case 1:
                CustomerProductMenu();
                break;

            case 2:
                CustomerPanel();
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                CustomerSearchProductMenu(ItemList);
                break;
        }

    }

    public static void ChargeCredit() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n           ========= Credit Panel ========= ");

        System.out.println("Please Enter the amount you want to add: ");
        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }
        CustomerLoggedIn.setFund(CustomerLoggedIn.getFund() + InputMenu);
        String SqlCmd = String.format("UPDATE customers SET Fund = %d WHERE Id = %d ",CustomerLoggedIn.getFund(), CustomerLoggedIn.getId() );
        MySQL.getMySQL().Execute(SqlCmd);
        System.out.println("Youre current credit is: " + CustomerLoggedIn.getFund() + "$");
        System.out.println("--------------------------------------------------");
        System.out.println("              [1] Back to panel");
        System.out.println("              Please enter a number: ");
        try {
            Input2Menu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }

        if (Input2Menu == 1) {
            CustomerPanel();
        } else {
            System.out.println("                 Please enter a valid number...");
            ChargeCredit();
        }
    }

}
