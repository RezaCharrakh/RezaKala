package Users;

import Product.*;
import exception.InvalidEmail;
import exception.InvalidPhoneNumber;

import java.io.IOException;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Pages
abstract public class pages implements Serializable {
    public static Customer CustomerLoggedIn;
    public static Seller SellerLoggedIn;
    public static int InputMenu;
    public static int Input2Menu;

    //SignIn & SignUpCL
    public static void SignInMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n                  ========= SignIn ========= ");
        System.out.println("                  [1] Sign in as a Customer");
        System.out.println("                  [2] Sign in as a Seller");
        System.out.println("                  [3] Admin Sign in");
        System.out.println("                  [4] Main menu");
        System.out.println("                  ============================");
        System.out.println("                  Please enter a number: ");

        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
            String SQLCom = String.format("INSERT INTO errorLogs (ErrorMessage)" +
                    " VALUES ('%s')", ex.toString());
            MySQL.getMySQL().Execute(SQLCom);
            SignInMenu();
        }

        switch (InputMenu) {
            case 1:
                CustomerSignIn();
                break;

            case 2:
                SellerSignIn();
                break;

            case 3:
                ManagerSignIn();
                break;

            case 4:
                MainMenu();
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                SignInMenu();
                break;
        }
    }

    public static void SignUpMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n                  ========= SignUpCL ========= ");
        System.out.println("                  [1] Sign up as a Customer");
        System.out.println("                  [2] Sign up as a Seller");
        System.out.println("                  [3] Main menu");
        System.out.println("                  ============================");
        System.out.println("                  Please enter a number: ");
        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
            String SQLCom = String.format("INSERT INTO errorLogs (ErrorMessage)" +
                    " VALUES ('%s')", ex.toString());
            MySQL.getMySQL().Execute(SQLCom);
            SignUpMenu();
        }

        switch (InputMenu) {
            case 1:
                CustomerSignUp();
                break;

            case 2:
                SellerSignUp();
                break;

            case 3:
                MainMenu();
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                SignUpMenu();
                break;
        }
    }

    public static void CustomerSignIn() throws IOException, SQLException {

        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n               ========= Customer SignIn ========= ");
        System.out.println("                   (1) Please enter your UserName:");
        String Username = input.nextLine();
        System.out.println("                   (2) Please enter your Password:");
        String Password = input.nextLine();
        System.out.println("                   ============================");
        boolean user_exist = false;

//        for (int i = 0; i < Lists.getLists().CustomerList.size(); i++) {
//            if (Username.equals(Lists.getLists().CustomerList.get(i).getUsername()) &&
//                    Password.equals(Lists.getLists().CustomerList.get(i).getPassword())) {
//                CustomerLoggedIn = Lists.getLists().CustomerList.get(i);
//                CustomerStuff.CustomerPanel();
//                user_exist = true;
//                break;
//            }
//        }

        ResultSet rs = MySQL.getMySQL().ExecuteQuery("SELECT customers.Name, customers.Family," +
                " customers.Username, customers.Password, customers.Fund, " +
                "emails.Email, numbers.Number FROM numbers JOIN customers ON customers.Id = numbers.Id" +
                " JOIN emails ON emails.Id = numbers.Id");
        while (rs.next()) {
            if (Username.equals(rs.getString("Username")) && Password.equals(rs.getString("Password")))
                {
                    Customer customer = new Customer(rs.getString("Name"), rs.getString("Family"),
                            rs.getString("Email"), rs.getString("Number"), rs.getString("Username"),
                            rs.getString("Password"), rs.getInt("Fund"));
                    Customer.setLastAccountId(Customer.getLastAccountId() - 1);
                    customer.setId(customer.getId() - 1);
                    CustomerLoggedIn = customer;
                    CustomerStuff.CustomerPanel();
                }
            }
            if (!user_exist) {
                System.out.println("========================== RezaKala ==========================");
                System.out.println("             ====================================");
                System.out.println("\n\n               ========= Customer SignIn ========= ");
                System.out.println("\n               [Username or Password is incorrect...]\n");
                System.out.println("               [1] Try signing in again");
                System.out.println("               [2] Main Menu");
                System.out.println("               ============================");
                System.out.println("               Please enter a number: ");

                try {
                    InputMenu = input.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println(ex.toString());
                    String SQLCom = String.format("INSERT INTO error logs (Error)" +
                            " VALUES ('%s')", ex.toString());
                    MySQL.getMySQL().Execute(SQLCom);
                    CustomerSignIn();

                }

                switch (InputMenu) {
                    case 1:
                        CustomerSignIn();
                        break;

                    case 2:
                        MainMenu();
                        break;

                    default:
                        System.out.println("                 Please enter a valid number...");
                        CustomerSignIn();
                        break;
                }

            }

        }

    public static void CustomerSignUp() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n               ========= Customer SignUpCL ========= ");
        System.out.println("                   (1) Please enter your UserName:");
        String Username = input.nextLine();
        System.out.println("                   (2) Please enter your Password:");
        String Password = input.nextLine();
        System.out.println("                   (3) Please enter your Name:");
        String Name = input.nextLine();
        System.out.println("                   (4) Please enter your Family:");
        String Family = input.nextLine();
        System.out.println("                   (5) Please enter your Phone number:");
        String PhoneNumber = input.nextLine();
        String RegexNumber = "\\d{11}$";
        Pattern patternNumber = Pattern.compile(RegexNumber);
        Matcher matcherNumber = patternNumber.matcher(PhoneNumber);
        if (!matcherNumber.matches()) {
            try {
                throw new InvalidPhoneNumber();
            } catch (InvalidPhoneNumber ex) {
                System.out.println(ex.toString());
                String SQLCom = String.format("INSERT INTO errorLogs (ErrorMessage)" +
                        " VALUES ('%s')", ex.toString());
                MySQL.getMySQL().Execute(SQLCom);
                CustomerSignUp();
            }
        }
        System.out.println("                   (6) Please enter your Email:");
        String Email = input.nextLine();
        String RegexEmail = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern patternEmail = Pattern.compile(RegexEmail);
        Matcher matcherEmail = patternEmail.matcher(Email);
        if (!matcherEmail.matches()) {
            try {
                throw new InvalidEmail();
            } catch (InvalidEmail ex) {
                System.out.println(ex.toString());
                String SQLCom = String.format("INSERT INTO errorLogs (ErrorMessage)" +
                        " VALUES ('%s')", ex.toString());
                MySQL.getMySQL().Execute(SQLCom);
                CustomerSignUp();
            }
        }
        System.out.println("                   (7) Please enter your Fund:");
        int Fund = 0;
        try {
            Fund = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
            String SQLCom = String.format("INSERT INTO errorLogs (ErrorMessage)" +
                    " VALUES ('%s')", ex.toString());
            MySQL.getMySQL().Execute(SQLCom);
            CustomerSignUp();
        }
        System.out.println("                   ============================");
        boolean username_exist = false;
//        for (int i = 0; i < Lists.getLists().CustomerList.size(); i++) {
//            if (Username.equals(Lists.getLists().CustomerList.get(i).getUsername())) {
//                System.out.println("                   The Username is already taken please re-register... ");
//                username_exist = true;
//                break;
//            }
//        }

        ResultSet rs_check = MySQL.getMySQL().ExecuteQuery("SELECT Username FROM customers");
        while (rs_check.next())
        {
            if(Username.equals(rs_check.getString("Username")))
            {
                username_exist = true;
                System.out.println("                   The Username is already taken please re-register... ");
                break;
            }
        }

        if (username_exist)
            CustomerSignUp();
        else {
            Customer customer = new Customer(Name, Family, Email, PhoneNumber, Username, Password, Fund);
            Lists.getLists().CustomerList.add(customer);
            CustomerFunctions.InsertCustonmer(customer.getId(), Name, Family, Email, PhoneNumber, Username, Password, Fund);
            System.out.println("                   [You have been successfully registered]");
            System.out.println("                   ============================");
            System.out.println("                   [1] Customer panel");
            System.out.println("                   [2] Main Menu");
            System.out.println("                   ============================");
            System.out.println("                   Please enter a number: ");

            try {
                InputMenu = input.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println(ex.toString());
                CustomerStuff.CustomerPanel();
            }

            switch (InputMenu) {
                case 1:
                    CustomerLoggedIn = Lists.getLists().CustomerList.get(Lists.getLists().CustomerList.size() - 1);
                    CustomerStuff.CustomerPanel();
                    break;

                case 2:
                    MainMenu();
                    break;

                default:
                    System.out.println("                 Please enter a valid number...");
                    CustomerSignUp();
                    break;
            }

        }
    }

    public static void SellerSignIn() throws IOException, SQLException {

        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n               ========= Seller SignIn ========= ");
        System.out.println("                   (1) Please enter your UserName:");
        String Username = input.nextLine();
        System.out.println("                   (2) Please enter your Password:");
        String Password = input.nextLine();
        System.out.println("                   ============================");
        boolean user_exist = false;
//        for (int i = 0; i < Lists.getLists().SellerList.size(); i++) {
//            if (Username.equals(Lists.getLists().SellerList.get(i).getUsername()) &&
//                    Password.equals(Lists.getLists().SellerList.get(i).getPassword())) {
//                SellerLoggedIn = Lists.getLists().SellerList.get(i);
//                SellerStuff.SellerPanel();
//                user_exist = true;
//                break;
//            }
//        }

        ResultSet rs = MySQL.getMySQL().ExecuteQuery("SELECT sellers.Name, sellers.Family," +
                " sellers.Username, sellers.Password, sellers.Fund, sellers.Company, " +
                "emails.Email, numbers.Number FROM numbers INNER JOIN sellers ON sellers.Id = numbers.Id" +
                " INNER JOIN emails ON emails.Id = numbers.Id");

        while (rs.next()) {
            if (Username.equals(rs.getString("Username")) && Password.equals(rs.getString("Password"))) {
                Seller seller = new Seller(rs.getString("Name"), rs.getString("Family"),
                        rs.getString("Email"), rs.getString("Number"), rs.getString("Username"),
                        rs.getString("Password"), rs.getInt("Fund"), rs.getString("Company"));
                Seller.setLastAccountId(Seller.getLastAccountId() - 1);
                seller.setId(seller.getId() - 1);
                SellerLoggedIn = seller;
                SellerStuff.SellerPanel();
            }
        }

        if (!user_exist) {
            System.out.println("========================== RezaKala ==========================");
            System.out.println("             ====================================");
            System.out.println("\n\n               ========= Seller SignIn ========= ");
            System.out.println("\n               [Username or Password is incorrect...]\n");
            System.out.println("               [1] Try signing in again");
            System.out.println("               [2] Main Menu");
            System.out.println("               ============================");
            System.out.println("               Please enter a number: ");

            try {
                InputMenu = input.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println(ex.toString());
                String SQLCom = String.format("INSERT INTO errorLogs (ErrorMessage)" +
                        " VALUES ('%s')", ex.toString());
                MySQL.getMySQL().Execute(SQLCom);
                SellerSignIn();
            }

            switch (InputMenu) {
                case 1:
                    SellerSignIn();
                    break;

                case 2:
                    MainMenu();
                    break;

                default:
                    System.out.println("                 Please enter a valid number...");
                    SellerSignIn();
                    break;
            }

        }

    }

    public static void SellerSignUp() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n                   ========= Seller SignUpCL ========= ");
        System.out.println("                   (1) Please enter your UserName:");
        String Username = input.next();
        System.out.println("                   (2) Please enter your Password:");
        String Password = input.next();
        System.out.println("                   (3) Please enter your Name:");
        String Name = input.next();
        System.out.println("                   (4) Please enter your Family:");
        String Family = input.next();
        System.out.println("                   (5) Please enter your Phone number:");
        String PhoneNumber = input.next();
        System.out.println("                   (6) Please enter your Email:");
        String Email = input.next();
        System.out.println("                   (7) Please enter your Fund:");
        int Fund = 0;
        try {
            Fund = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
            String SQLCom = String.format("INSERT INTO errorLogs (ErrorMessage)" +
                    " VALUES ('%s')", ex.toString());
            MySQL.getMySQL().Execute(SQLCom);
            SellerSignUp();
        }
        System.out.println("                   (8) Please enter your Company name:");
        String Company = input.next();
        System.out.println("                   ============================");
        boolean username_exist = false;

        ResultSet rs_check = MySQL.getMySQL().ExecuteQuery("SELECT Username FROM sellers");
        while (rs_check.next())
        {
            if(Username.equals(rs_check.getString("Username")))
            {
                System.out.println("                   The Username is already taken please re-register... ");
                username_exist = true;
                break;
            }
        }
//        for (int i = 0; i < Lists.getLists().SellerList.size(); i++) {
//            if (Username.equals(Lists.getLists().SellerList.get(i).getUsername())) {
//                System.out.println("                   The Username is already taken please re-register... ");
//                username_exist = true;
//                break;
//            }
//        }
        if(!username_exist)
        {
            Seller seller = new Seller(Name, Family, Email, PhoneNumber, Username, Password, Fund, Company);
            Lists.getLists().SellerRegisterList.add(seller);
            System.out.println("                   [Your request have been successfully sent to review]");
            System.out.println("                   ============================");
            MainMenu();
        }

        else CustomerSignUp();
    }

    public static void ManagerSignIn() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n               ========= Manager SignIn ========= ");
        System.out.println("                   (1) Please enter your UserName:");
        String Username = input.nextLine();
        System.out.println("                   (2) Please enter your Password:");
        String Password = input.nextLine();
        System.out.println("                   ============================");
        boolean user_exist = false;
        if (Username.equals("admin") && Password.equals("admin")) {
            ManagerStuff.ManagerPanel();
            user_exist = true;
        }

        if (!user_exist) {
            System.out.println("========================== RezaKala ==========================");
            System.out.println("             ====================================");
            System.out.println("\n\n               ========= Manager SignIn ========= ");
            System.out.println("\n               [Username or Password is incorrect...]\n");
            System.out.println("               [1] Try signing in again");
            System.out.println("               [2] Main Menu");
            System.out.println("               ============================");
            System.out.println("               Please enter a number: ");

            try {
                InputMenu = input.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println(ex.toString());
                String SQLCom = String.format("INSERT INTO errorLogs (ErrorMessage)" +
                        " VALUES ('%s')", ex.toString());
                MySQL.getMySQL().Execute(SQLCom);
                ManagerSignIn();
            }

            switch (InputMenu) {
                case 1:
                    ManagerSignIn();
                    break;

                case 2:
                    MainMenu();
                    break;

                default:
                    System.out.println("                 Please enter a valid number...");
                    ManagerSignIn();
                    break;
            }

        }
    }

    //Main pages
    public static void MainMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n                 ========= MainMenu ========= ");
        System.out.println("                 [1] Sign in & Sign up");
        System.out.println("                 [2] Products");
        System.out.println("                 ============================");
        System.out.println("                 Please enter a number: ");

        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
            String SQLCom = String.format("INSERT INTO errorLogs (ErrorMessage)" +
                    " VALUES ('%s')", ex.toString());
            MySQL.getMySQL().Execute(SQLCom);
            MainMenu();
        }

        switch (InputMenu) {
            case 1:
                AccountMenu();
                break;

            case 2:
                ProductMenu();
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                MainMenu();
                break;
        }

    }

    public static void AccountMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n                  ========= Account ========= ");
        System.out.println("                  [1] Sign in");
        System.out.println("                  [2] Sign up");
        System.out.println("                  [3] Main menu");
        System.out.println("                  ============================");
        System.out.println("                  Please enter a number: ");

        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
            AccountMenu();
        }

        switch (InputMenu) {
            case 1:
                SignInMenu();
                break;

            case 2:
                SignUpMenu();
                break;

            case 3:
                MainMenu();
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                AccountMenu();
                break;
        }
    }

    public static void ProductMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n             ========= ProductsCategory ========= ");
        System.out.println("             [1] Digital");
        System.out.println("             [2] Home Appliances");
        System.out.println("             [3] Clothing");
        System.out.println("             [4] Food");
        System.out.println("             [5] Main menu");
        System.out.println("             ====================================");
        System.out.println("             Please enter a number: ");

        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
            ProductMenu();
        }

        switch (InputMenu) {
            case 1:
                DigitalMenu();
                break;

            case 2:
                HomeAppliancesMenu();
                break;

            case 3:
                ClothingMenu();
                break;

            case 4:
                FoodMenu();
                break;

            case 5:
                MainMenu();
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                ProductMenu();
                break;
        }
    }

    public static void DigitalMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n              ========= Product.Digital Products ========= ");
        System.out.println("              [1] Show Products");
        System.out.println("              [2] Search by name of the product");
        System.out.println("              [3] Filters");
        System.out.println("              [4] Mobile");
        System.out.println("              [5] Laptop");
        System.out.println("              [6] Back to categories");
        System.out.println("              ============================");
        System.out.println("              Please enter a number: ");

        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
            DigitalMenu();
        }

        switch (InputMenu) {
            case 1:
                ShowProductsMenu(Category.getDigitalItemList());
                break;

            case 2:
                SearchProductMenu(Category.getDigitalItemList());
                break;

            case 3:
                FiltersMenu(Category.getDigitalItemList());
                break;

            case 4:
                MobileMenu();
                break;

            case 5:
                LaptopMenu();
                break;

            case 6:
                ProductMenu();
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                DigitalMenu();
                break;
        }
    }

    public static void MobileMenu() throws IOException, SQLException {
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
            MobileMenu();
        }

        switch (InputMenu) {
            case 1:
                ShowProductsMenu(Lists.getLists().MobileItems);
                break;

            case 2:
                SearchProductMenu(Lists.getLists().MobileItems);
                break;

            case 3:
                FiltersMenu(Lists.getLists().MobileItems);
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                MobileMenu();
                break;
        }
    }

    public static void LaptopMenu() throws IOException, SQLException {
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
            LaptopMenu();
        }

        switch (InputMenu) {
            case 1:
                ShowProductsMenu(Lists.getLists().LaptopItems);
                break;

            case 2:
                SearchProductMenu(Lists.getLists().LaptopItems);
                break;

            case 3:
                FiltersMenu(Lists.getLists().LaptopItems);
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                LaptopMenu();
                break;
        }
    }

    public static void ClothingMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n              ========= Clothing Products ========= ");
        System.out.println("              [1] Show Products");
        System.out.println("              [2] Search by name of the product");
        System.out.println("              [3] Filters");
        System.out.println("              [4] Cloth");
        System.out.println("              [5] Shoes");
        System.out.println("              [6] Back to categories");
        System.out.println("              ============================");
        System.out.println("              Please enter a number: ");

        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
            ClothingMenu();
        }

        switch (InputMenu) {
            case 1:
                ShowProductsMenu(Category.getClothingItemList());
                break;

            case 2:
                SearchProductMenu(Category.getClothingItemList());
                break;

            case 3:
                FiltersMenu(Category.getClothingItemList());
                break;

            case 4:
                ClothMenu();
                break;

            case 5:
                ShoesMenu();
                break;

            case 6:
                ProductMenu();
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                ClothingMenu();
                break;
        }
    }

    public static void ClothMenu() throws IOException, SQLException {
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
            ClothMenu();
        }

        switch (InputMenu) {
            case 1:
                ShowProductsMenu(Lists.getLists().ClothItems);
                break;

            case 2:
                SearchProductMenu(Lists.getLists().ClothItems);
                break;

            case 3:
                FiltersMenu(Lists.getLists().ClothItems);
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                ClothMenu();
                break;
        }
    }

    public static void ShoesMenu() throws IOException, SQLException {
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
            ShoesMenu();
        }

        switch (InputMenu) {
            case 1:
                ShowProductsMenu(Lists.getLists().ShoesItems);
                break;

            case 2:
                SearchProductMenu(Lists.getLists().ShoesItems);
                break;

            case 3:
                FiltersMenu(Lists.getLists().ShoesItems);
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                ShoesMenu();
                break;
        }
    }

    public static void HomeAppliancesMenu() throws IOException, SQLException {
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
        System.out.println("           [7] Back to categories");
        System.out.println("           ============================");
        System.out.println("           Please enter a number: ");

        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
            HomeAppliancesMenu();
        }

        switch (InputMenu) {
            case 1:
                ShowProductsMenu(Category.getHomeAppliancesItemList());
                break;

            case 2:
                SearchProductMenu(Category.getHomeAppliancesItemList());
                break;

            case 3:
                FiltersMenu(Category.getHomeAppliancesItemList());
                break;

            case 4:
                StoveMenu();
                break;

            case 5:
                RefrigeratorMenu();
                break;

            case 6:
                TVMenu();
                break;

            case 7:
                ProductMenu();
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                HomeAppliancesMenu();
                break;
        }
    }

    public static void TVMenu() throws IOException, SQLException {
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
            TVMenu();
        }

        switch (InputMenu) {
            case 1:
                ShowProductsMenu(Lists.getLists().TVItems);
                break;

            case 2:
                SearchProductMenu(Lists.getLists().TVItems);
                break;

            case 3:
                FiltersMenu(Lists.getLists().TVItems);
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                TVMenu();
                break;
        }
    }

    public static void StoveMenu() throws IOException, SQLException {
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
            StoveMenu();
        }

        switch (InputMenu) {
            case 1:
                ShowProductsMenu(Lists.getLists().StoveItems);
                break;

            case 2:
                SearchProductMenu(Lists.getLists().StoveItems);
                break;

            case 3:
                FiltersMenu(Lists.getLists().StoveItems);
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                StoveMenu();
                break;
        }
    }

    public static void RefrigeratorMenu() throws IOException, SQLException {
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
            RefrigeratorMenu();
        }

        switch (InputMenu) {
            case 1:
                ShowProductsMenu(Lists.getLists().RefrigeratorItems);
                break;

            case 2:
                SearchProductMenu(Lists.getLists().RefrigeratorItems);
                break;

            case 3:
                FiltersMenu(Lists.getLists().RefrigeratorItems);
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                RefrigeratorMenu();
                break;
        }
    }

    static void FoodMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n              ========= Food Products ========= ");
        System.out.println("              [1] Show Products");
        System.out.println("              [2] Search by name of the product");
        System.out.println("              [3] Filters");
        System.out.println("              [4] Back to categories");
        System.out.println("              ============================");
        System.out.println("              Please enter a number: ");

        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
            FoodMenu();
        }

        switch (InputMenu) {
            case 1:
                ShowProductsMenu(Category.getFoodItemList());
                break;

            case 2:
                SearchProductMenu(Category.getFoodItemList());
                break;

            case 3:
                FiltersMenu(Category.getFoodItemList());
                break;

            case 4:
                ProductMenu();
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                FoodMenu();
                break;
        }
    }


    //Show products options
    public static void ShowProductsMenu(ArrayList<Item> ItemList) throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n                ========= Products ========= ");
        for (Item item : ItemList) {
            System.out.println(item.toString());
            System.out.println("------------------------------------------------");
        }
        System.out.println("[1] Back to categories");
        System.out.println("[2] Main Menu");
        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
            ShowProductsMenu(ItemList);
        }

        switch (InputMenu) {
            case 1:
                ProductMenu();
                break;

            case 2:
                MainMenu();
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                ShowProductsMenu(ItemList);
                break;
        }

    }

    public static void SearchProductMenu(ArrayList<Item> ItemList) throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n              ========= Search Product ========= ");
        System.out.println("              [ ] Please enter name of the product");
        System.out.println("              ============================");

        String InputMenu = input.next();

        for (Item item : ItemList) {
            if (InputMenu.equals(item.getName())) {
                System.out.println(item.toString());
                System.out.println("--------------------------------------------");
            }
        }
        System.out.println("[1] Back to categories");
        System.out.println("[2] Main Menu");
        try {
            Input2Menu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
        }

        switch (Input2Menu) {
            case 1:
                ProductMenu();
                break;

            case 2:
                MainMenu();
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                SearchProductMenu(ItemList);
                break;
        }

    }

    public static void FiltersMenu(ArrayList<Item> ItemList) throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n              ========= Food Products ========= ");
        System.out.println("              [1] By Price");
        System.out.println("              [2] By Alphabet");
        System.out.println("              [3] By Rate");
        System.out.println("              [4] Back to categories");
        System.out.println("              [5] Main Menu");
        System.out.println("              ============================");
        System.out.println("              Please enter a number: ");

        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
            FiltersMenu(ItemList);
        }

        switch (InputMenu) {
            case 1:
                FilterByPrice(ItemList);
                break;

            case 2:
                FilterByAlphabet(ItemList);
                break;

            case 3:
                FilterByRate(ItemList);
                break;

            case 4:
                ProductMenu();
                break;

            case 5:
                MainMenu();
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                FiltersMenu(ItemList);
                break;
        }
    }

    public static void FilterByPrice(ArrayList<Item> ItemList) throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        ArrayList<Item> FilterList = new ArrayList<>();
        Collections.copy(FilterList, ItemList);

        for (int i = 0; i < FilterList.size(); i++) {
            for (int j = 0; j < FilterList.size() - 1; j++) {
                if (FilterList.get(j).getPrice() > FilterList.get(j + 1).getPrice()) {
                    Item TempItem = FilterList.get(j);
                    FilterList.remove(j);
                    FilterList.add(j + 1, TempItem);
                }
            }
        }

        for (Item item : FilterList) {
            System.out.println(item.toString());
            System.out.println("------------------------------------------------");
        }
        System.out.println("[1] Back to categories");
        System.out.println("[2] Main Menu");
        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
            FilterByPrice(ItemList);
        }

        switch (InputMenu) {
            case 1:
                ProductMenu();
                break;

            case 2:
                MainMenu();
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                ShowProductsMenu(ItemList);
                break;
        }
    }

    public static void FilterByAlphabet(ArrayList<Item> ItemList) throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        ArrayList<Item> FilterList = new ArrayList<>();
        Collections.copy(FilterList, ItemList);

        for (int i = 0; i < FilterList.size(); i++) {
            for (int j = 0; j < FilterList.size() - 1; j++) {
                if (FilterList.get(j).getName().compareTo(FilterList.get(j + 1).getName()) > 0) {
                    Item TempItem = FilterList.get(j);
                    FilterList.remove(j);
                    FilterList.add(j + 1, TempItem);
                }
            }
        }

        for (Item item : FilterList) {
            System.out.println(item.toString());
            System.out.println("------------------------------------------------");
        }
        System.out.println("[1] Back to categories");
        System.out.println("[2] Main Menu");
        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
            FilterByAlphabet(ItemList);
        }

        switch (InputMenu) {
            case 1:
                ProductMenu();
                break;

            case 2:
                MainMenu();
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                ShowProductsMenu(ItemList);
                break;
        }
    }

    public static void FilterByRate(ArrayList<Item> ItemList) throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        ArrayList<Item> FilterList = new ArrayList<>();
        Collections.copy(FilterList, ItemList);

        for (int i = 0; i < FilterList.size(); i++) {
            for (int j = 0; j < FilterList.size() - 1; j++) {
                if (FilterList.get(j).getPrice() > FilterList.get(j + 1).getRate()) {
                    Item TempItem = FilterList.get(j);
                    FilterList.remove(j);
                    FilterList.add(j + 1, TempItem);
                }
            }
        }

        for (Item item : FilterList) {
            System.out.println(item.toString());
            System.out.println("------------------------------------------------");
        }
        System.out.println("[1] Back to categories");
        System.out.println("[2] Main Menu");
        try {
            InputMenu = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println(ex.toString());
            FilterByRate(ItemList);
        }

        switch (InputMenu) {
            case 1:
                ProductMenu();
                break;

            case 2:
                MainMenu();
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                ShowProductsMenu(ItemList);
                break;
        }
    }
}
