package Users;

import Enum.*;
import Product.*;
import exception.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static Users.pages.*;


abstract public class SellerStuff {
    static int Price;
    public static void SellerPanel() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n             ========= " + SellerLoggedIn.getName() + " " + SellerLoggedIn.getFamily() + " Panel ========= ");
        System.out.println("                [1] List of products");
        System.out.println("                [2] Sell history");
        System.out.println("                [3] Edit info");
        System.out.println("                [4] Add product");
        System.out.println("                [5] Edit product");
        System.out.println("                [6] Remove product");
        System.out.println("                [7] User & Company info");
        System.out.println("                [8] Log out");
        System.out.println("                ============================");
        System.out.println("                Please enter a number: ");

        int InputMenu = input.nextInt();

        switch (InputMenu) {
            case 1:
                SellerProductMenu();
                break;

            case 2:
                SellerHistoryMenu();
                break;

            case 3:
                SellerEditInfoMenu();
                break;

            case 4:
                SellerAddItemMenu();
                break;

            case 5:
                SellerEditItemMenu();
                break;
            case 6:
                SellerRemoveItemMenu();
                break;

            case 7:
                SellerInfoMenu();
                break;

            case 8:
                MainMenu();
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                SellerPanel();
                break;
        }
    }

    public static void SellerProductMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n              ========= Seller Products ========= ");
        for (int i = 0; i < SellerLoggedIn.getItemList().size(); i++) {
            System.out.println(SellerLoggedIn.getItemList().get(i).toString());
            System.out.println("-----------------------------------------");
        }
        System.out.println("              [1] Back to panel");
        System.out.println("              ============================");
        System.out.println("              Please enter a number: ");

        int InputMenu = input.nextInt();

        if (InputMenu == 1) {
            SellerPanel();
        } else {
            System.out.println("                 Please enter a valid number...");
            SellerProductMenu();
        }
    }

    public static void SellerHistoryMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n              ========= Sell History ========= ");
        for (int i = 0; i < SellerLoggedIn.getSellHistoryList().size(); i++) {
            System.out.println(SellerLoggedIn.getSellHistoryList().get(i).toString());
            System.out.println("-----------------------------------------");
        }
        System.out.println("              [1] Back to panel");
        System.out.println("              ============================");
        System.out.println("              Please enter a number: ");

        int InputMenu = input.nextInt();

        if (InputMenu == 1) {
            SellerPanel();
        } else {
            System.out.println("                 Please enter a valid number...");
            SellerHistoryMenu();
        }
    }

    public static void SellerEditInfoMenu() throws IOException, SQLException {
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
        System.out.println("                 [7] Company name");
        System.out.println("                 [8 + A character] Back to panel");
        System.out.println("                 ============================");
        System.out.println("                 Please enter a number & new your new info: ");

        int InputMenu = input.nextInt();
        String InputMenu2 = input.next();

        SellerFunctions.EditInfo(InputMenu, InputMenu2);

    } //Function

    public static void SellerAddItemMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n              ========= Add Product Panel ========= ");
        System.out.println("                 [1] Add Mobile");
        System.out.println("                 [2] Add Product.Laptop");
        System.out.println("                 [3] Add Cloth");
        System.out.println("                 [4] Add Shoes");
        System.out.println("                 [5] Add TV");
        System.out.println("                 [6] Add Refrigerator");
        System.out.println("                 [7] Add Stove");
        System.out.println("                 [8] Add Food");
        System.out.println("                 [9] Back to panel");
        System.out.println("                 ============================");
        System.out.println("                 Please enter a number: ");

        int InputMenu = input.nextInt();

        switch (InputMenu) {
            case 1:
                AddMobileMenu();
                break;

            case 2:
                AddLaptopMenu();
                break;

            case 3:
                AddClothMenu();
                break;

            case 4:
                AddShoesMenu();
                break;

            case 5:
                AddTVMenu();
                break;
            case 6:
                AddRefrigeratorMenu();
                break;

            case 7:
                AddStoveMenu();
                break;

            case 8:
                AddFoodMenu();
                break;

            case 9:
                SellerPanel();
                break;

            default:
                System.out.println("                 Please enter a valid number...");
                SellerAddItemMenu();
                break;
        }
    }

    public static void AddMobileMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n               ========= Add Mobile ========= ");
        System.out.println("                   (1) Please enter the product name:");
        String Name = input.next();
        System.out.println("                   (2) Please enter the product brand:");
        String Brand = input.next();
        System.out.println("                   (3) Please enter the product price:");
        try {
            int Price = input.nextInt();
        }catch (InputMismatchException ex)
        {
            System.out.println(ex.toString());
            AddMobileMenu();
        }
        System.out.println("                   (4) Please enter the product info:");
        String Info = input.next();
        System.out.println("                   (5) Please enter the product ram memory:");
        int RamMemory = 0;
        try {
            RamMemory = input.nextInt();
        }catch (InputMismatchException ex)
        {
            System.out.println(ex.toString());
            AddMobileMenu();
        }
        System.out.println("                   (6) Please enter the product OS:");
        String OS = input.next();
        System.out.println("                   (7) Please enter the product weight:");
        double Weight = 0;
        try {
            Weight = input.nextDouble();
        }catch (InputMismatchException ex)
        {
            System.out.println(ex.toString());
            AddMobileMenu();
        }
        System.out.println("                   (8) Please enter the product length:");
        double Length = 0;
        try {
            Length = input.nextDouble();
        }catch (InputMismatchException ex)
        {
            System.out.println(ex.toString());
            AddMobileMenu();
        }
        System.out.println("                   (9) Please enter the product width:");
        double Width = 0;
        try {
            Width = input.nextDouble();
        }catch (InputMismatchException ex)
        {
            System.out.println(ex.toString());
            AddMobileMenu();
        }
        System.out.println("                   (10) Please enter the product height:");
        double Height = 0;
        try {
            Height = input.nextDouble();
        }catch (InputMismatchException ex)
        {
            System.out.println(ex.toString());
            AddMobileMenu();
        }
        System.out.println("                   (11) Please enter the product sim-card number:");
        int SimcardNumber = 0;
        try {
            SimcardNumber = input.nextInt();
        }catch (InputMismatchException ex)
        {
            System.out.println(ex.toString());
            AddMobileMenu();
        }
        System.out.println("                   (12) Please enter the product camera pixels:");
        int CameraPixel = 0;
        try {
            CameraPixel = input.nextInt();
        }catch (InputMismatchException ex)
        {
            System.out.println(ex.toString());
            AddMobileMenu();
        }
        System.out.println("                   ============================");

        Lists.getLists().SellerAddList.add(new Mobile(Name, Brand, Price, true, Info, RamMemory,
                Os.valueOf(OS), Weight, Length, Width, Height, SimcardNumber, CameraPixel, SellerLoggedIn));
        System.out.println("                   [Your request have been successfully sent to review]");
        System.out.println("                   ============================");
        SellerPanel();
    }

    public static void AddLaptopMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n               ========= Add Laptop ========= ");
        System.out.println("                   (1) Please enter the product name:");
        String Name = input.next();
        System.out.println("                   (2) Please enter the product brand:");
        String Brand = input.next();
        System.out.println("                   (3) Please enter the product price:");
        try {
            int Price = input.nextInt();
        }catch (InputMismatchException ex)
        {
            System.out.println(ex.toString());
        }
        System.out.println("                   (4) Please enter the product info:");
        String Info = input.next();
        System.out.println("                   (5) Please enter the product ram memory:");
        int RamMemory = 0;
        try {
             RamMemory = input.nextInt();
        }catch (InputMismatchException ex)
        {
            System.out.println(ex.toString());
        }
        System.out.println("                   (6) Please enter the product OS:");
        String OS = input.next();
        System.out.println("                   (7) Please enter the product weight:");
        double Weight = 0;
        try {
            Weight = input.nextDouble();
        }catch (InputMismatchException ex)
        {
            System.out.println(ex.toString());
        }
        System.out.println("                   (8) Please enter the product length:");
        double Length = 0;
        try {
            Length = input.nextDouble();
        }catch (InputMismatchException ex)
        {
            System.out.println(ex.toString());
        }
        System.out.println("                   (9) Please enter the product width:");
        double Width = 0;
        try {
            Width = input.nextDouble();
        }catch (InputMismatchException ex)
        {
            System.out.println(ex.toString());
        }
        System.out.println("                   (10) Please enter the product height:");
        double Height = 0;
        try {
            Height = input.nextDouble();
        }catch (InputMismatchException ex)
        {
            System.out.println(ex.toString());
        }

        System.out.println("                   (11) Please enter 'true' if it's Gaming & if its not enter 'false':");
        boolean Gaming = false;
        try {
            Gaming = input.nextBoolean();
        }catch (InputMismatchException ex)
        {
            System.out.println(ex.toString());
        }
        System.out.println("                   (12) Please enter the Cpu model:");
        String cpu = input.next();
        System.out.println("                   ============================");

        Lists.getLists().SellerAddList.add(new Laptop(Name, Brand, Price, true, Info, RamMemory,
                Os.valueOf(OS), Weight, Length, Width, Height, Gaming, CPU.valueOf(cpu), SellerLoggedIn));
        System.out.println("                   [Your request have been successfully sent to review]");
        System.out.println("                   ============================");
        SellerPanel();
    }

    public static void AddClothMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n               ========= Add Cloth ========= ");
        System.out.println("                   (1) Please enter the product name:");
        String Name = input.next();
        System.out.println("                   (2) Please enter the product brand:");
        String Brand = input.next();
        System.out.println("                   (3) Please enter the product price:");
        try {
            int Price = input.nextInt();
        }catch (InputMismatchException ex)
        {
            System.out.println(ex.toString());
        }
        System.out.println("                   (4) Please enter the product info:");
        String Info = input.next();
        System.out.println("                   (5) Please enter the product Country:");
        String Country = input.next();
        System.out.println("                   (6) Please enter the product Material:");
        String Material = input.next();
        System.out.println("                   (7) Please enter the product Size:");
        String clothSize = input.next();
        System.out.println("                   (8) Please enter the product Type:");
        String Type = input.next();
        System.out.println("                   ============================");

        Lists.getLists().SellerAddList.add(new cloth(Name, Brand, Price, true, Info, Country,
                Material, ClothSize.valueOf(clothSize), ClothType.valueOf(Type), SellerLoggedIn));
        System.out.println("                   [Your request have been successfully sent to review]");
        System.out.println("                   ============================");
        SellerPanel();
    }

    public static void AddShoesMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n               ========= Add Shoes ========= ");
        System.out.println("                   (1) Please enter the product name:");
        String Name = input.next();
        System.out.println("                   (2) Please enter the product brand:");
        String Brand = input.next();
        System.out.println("                   (3) Please enter the product price:");
        try {
            int Price = input.nextInt();
        }catch (InputMismatchException ex)
        {
            System.out.println(ex.toString());
        }
        System.out.println("                   (4) Please enter the product info:");
        String Info = input.next();
        System.out.println("                   (5) Please enter the product Country:");
        String Country = input.next();
        System.out.println("                   (6) Please enter the product Material:");
        String Material = input.next();
        System.out.println("                   (7) Please enter the product Size:");
        int Size = 0;
        try {
            Size = input.nextInt();
        }catch (InputMismatchException ex)
        {
            System.out.println(ex.toString());
        }
        System.out.println("                   (8) Please enter the product Type:");
        String Type = input.next();
        System.out.println("                   ============================");

        Lists.getLists().SellerAddList.add(new Shoes(Name, Brand, Price, true, Info, Country,
                Material, Size, ShoesType.valueOf(Type), SellerLoggedIn));
        System.out.println("                   [Your request have been successfully sent to review]");
        System.out.println("                   ============================");
        SellerPanel();
    }

    public static void AddTVMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n               ========= Add TV ========= ");
        System.out.println("                   (1) Please enter the product name:");
        String Name = input.next();
        System.out.println("                   (2) Please enter the product brand:");
        String Brand = input.next();
        System.out.println("                   (3) Please enter the product price:");
        try {
            int Price = input.nextInt();
        }catch (InputMismatchException ex)
        {
            System.out.println(ex.toString());
        }
        System.out.println("                   (4) Please enter the product info:");
        String Info = input.next();
        System.out.println("                   (5) Please enter the product Energy:");
        String Energy = input.next();
        System.out.println("                   (6) Please enter 'true' if it has Warranty & if it hasn't enter 'false':");
        boolean Warranty = false;
        try {
            Warranty = input.nextBoolean();
        }catch (InputMismatchException ex)
        {
            System.out.println(ex.toString());
        }
        System.out.println("                   (7) Please enter the product Screen quality:");
        String ScreenQuality = input.next();
        System.out.println("                   (8) Please enter the product Monitor size:");
        int MonitorSize = 0;
        try {
            MonitorSize = input.nextInt();
        }catch (InputMismatchException ex)
        {
            System.out.println(ex.toString());
        }
        System.out.println("                   ============================");

        Lists.getLists().SellerAddList.add(new TV(Name, Brand, Price, true, Info, EnergyConsumption.valueOf(Energy),
                Warranty, ScreenQuality, MonitorSize, SellerLoggedIn));
        System.out.println("                   [Your request have been successfully sent to review]");
        System.out.println("                   ============================");
        SellerPanel();
    }

    public static void AddRefrigeratorMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n               ========= Add Refrigerator ========= ");
        System.out.println("                   (1) Please enter the product name:");
        String Name = input.next();
        System.out.println("                   (2) Please enter the product brand:");
        String Brand = input.next();
        System.out.println("                   (3) Please enter the product price:");
        try {
            int Price = input.nextInt();
        }catch (InputMismatchException ex)
        {
            System.out.println(ex.toString());
        }
        System.out.println("                   (4) Please enter the product info:");
        String Info = input.next();
        System.out.println("                   (5) Please enter the product Energy:");
        String Energy = input.next();
        System.out.println("                   (6) Please enter 'true' if it has Warranty & if it hasn't enter 'false':");
        boolean Warranty = false;
        try {
            Warranty = input.nextBoolean();
        }catch (InputMismatchException ex)
        {
            System.out.println(ex.toString());
        }
        System.out.println("                   (7) Please enter the product Capacity:");
        int Capacity = 0;
        try {
            Capacity = input.nextInt();
        }catch (InputMismatchException ex)
        {
            System.out.println(ex.toString());
        }
        System.out.println("                   (8) Please enter 'true' if it has Freezer & if it hasn't enter 'false':");
        boolean Freezer = false;
        try {
            Freezer = input.nextBoolean();
        }catch (InputMismatchException ex)
        {
            System.out.println(ex.toString());
        }
        System.out.println("                   (9) Please enter the product Type:");
        String Type = input.next();
        System.out.println("                   ============================");

        Lists.getLists().SellerAddList.add(new Refrigerator(Name, Brand, Price, true, Info, EnergyConsumption.valueOf(Energy),
                Warranty, Capacity, Freezer, Type, SellerLoggedIn));
        System.out.println("                   [Your request have been successfully sent to review]");
        System.out.println("                   ============================");
        SellerPanel();
    }

    public static void AddStoveMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n               ========= Add Stove ========= ");
        System.out.println("                   (1) Please enter the product name:");
        String Name = input.next();
        System.out.println("                   (2) Please enter the product brand:");
        String Brand = input.next();
        System.out.println("                   (3) Please enter the product price:");
        try {
            int Price = input.nextInt();
        }catch (InputMismatchException ex)
        {
            System.out.println(ex.toString());
        }
        System.out.println("                   (4) Please enter the product info:");
        String Info = input.next();
        System.out.println("                   (5) Please enter the product Energy:");
        String Energy = input.next();
        System.out.println("                   (6) Please enter 'true' if it has Warranty & if it hasn't enter 'false':");
        boolean Warranty = false;
        try {
            Warranty = input.nextBoolean();
        }catch (InputMismatchException ex)
        {
            System.out.println(ex.toString());
        }
        System.out.println("                   (7) Please enter the product Flame number:");
        int Flames = 0;
        try {
            Flames = input.nextInt();
        }catch (InputMismatchException ex)
        {
            System.out.println(ex.toString());
        }
        System.out.println("                   (8) Please enter 'true' if it has Oven & if it hasn't enter 'false':");
        boolean Oven = false;
        try {
            Oven = input.nextBoolean();
        }catch (InputMismatchException ex)
        {
            System.out.println(ex.toString());
        }
        System.out.println("                   (9) Please enter the product Material:");
        String Material = input.next();
        System.out.println("                   ============================");

        Lists.getLists().SellerAddList.add(new Stove(Name, Brand, Price, true, Info, EnergyConsumption.valueOf(Energy),
                Warranty, Flames, Material, Oven, SellerLoggedIn));
        System.out.println("                   [Your request have been successfully sent to review]");
        System.out.println("                   ============================");
        SellerPanel();
    }

    public static void AddFoodMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n               ========= Add Food ========= ");
        System.out.println("                   (1) Please enter the product name:");
        String Name = input.next();
        System.out.println("                   (2) Please enter the product brand:");
        String Brand = input.next();
        System.out.println("                   (3) Please enter the product price:");
        int Price = 0;
        try {
            Price = input.nextInt();
        }catch (InputMismatchException ex)
        {
            System.out.println(ex.toString());
        }
        System.out.println("                   (4) Please enter the product info:");
        String Info = input.next();
        System.out.println("                   (5) Please enter the product pr date:");
        String prDate = input.next();
        System.out.println("                   (5) Please enter the product ex date:");
        String exDate = input.next();
        System.out.println("                   ============================");
        Lists.getLists().SellerAddList.add(new Food(Name, Brand, Price, true, Info, prDate,
                exDate, SellerLoggedIn));
        System.out.println("                   [Your request have been successfully sent to review]");
        System.out.println("                   ============================");
        SellerPanel();
    }

    public static void SellerEditItemMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n              ========= Edit Products ========= ");
        for (int i = 0; i < SellerLoggedIn.getItemList().size(); i++) {
            System.out.println(SellerLoggedIn.getItemList().get(i).toString());
            System.out.println("-----------------------------------------");
        }
        System.out.println("              [ ] Please enter id of the product: ");
        int InputMenu = input.nextInt();
        for (int i = 0; i < SellerLoggedIn.getItemList().size(); i++) {
            if (SellerLoggedIn.getItemList().get(i).getId() == InputMenu) {
                System.out.println("                   (1) Please enter the new product name:");
                String Name = input.next();
                System.out.println("                   (2) Please enter the new product brand:");
                String Brand = input.next();
                System.out.println("                   (3) Please enter the new product price:");
                int Price = input.nextInt();
                System.out.println("                   (4) Please enter the new product info:");
                String Info = input.next();
                Lists.getLists().EditRequests.add(new Requests(SellerLoggedIn.getItemList().get(i), Name, Brand, Price, Info));
                System.out.println("                   [Your request have been successfully sent to review]");
                break;
            }
        }
        System.out.println("              [1] Back to panel");
        System.out.println("              ============================");
        System.out.println("              Please enter a number: ");

        int InputMenu2 = input.nextInt();

        if (InputMenu2 == 1) {
            SellerPanel();
        } else {
            System.out.println("                 Please enter a valid number...");
            SellerEditItemMenu();
        }
    }

    public static void SellerRemoveItemMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n              ========= Remove Products ========= ");
        for (int i = 0; i < SellerLoggedIn.getItemList().size(); i++) {
            System.out.println(SellerLoggedIn.getItemList().get(i).toString());
            System.out.println("-----------------------------------------");
        }
        System.out.println("              [ ] Please enter id of the product: ");
        int InputMenu = input.nextInt();

        SellerFunctions.SellerRemoveItem(InputMenu);

        System.out.println("              [1] Back to panel");
        System.out.println("              ============================");
        System.out.println("              Please enter a number: ");

        int InputMenu2 = input.nextInt();

        if (InputMenu2 == 1) {
            SellerPanel();
        } else {
            System.out.println("                 Please enter a valid number...");
            SellerEditItemMenu();
        }

    } //Function

    public static void SellerInfoMenu() throws IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("========================== RezaKala ==========================");
        System.out.println("             ====================================");
        System.out.println("\n\n              ========= Info Panel ========= ");
        System.out.println(SellerLoggedIn.toString());
        System.out.println("----------------------------------------");
        System.out.println("                 [1] Back to panel");
        System.out.println("                 Please enter a number: ");
        int InputMenu = input.nextInt();

        if (InputMenu == 1) {
            SellerPanel();
        } else {
            System.out.println("                 Please enter a valid number...");
            SellerInfoMenu();
        }
    }

}

