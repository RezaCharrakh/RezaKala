package Users;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;

public class CreateFile  {
    public static void files() throws IOException, FileNotFoundException {

        File saveData = new File("saveData");
        if(!saveData.exists())
            saveData.mkdirs();

        File users = new File(saveData,"users");
        if(!users.exists())
            users.mkdirs();

        File admin = new File(users,"admin");
        if(!admin.exists())
            admin.mkdirs();

        File buyers = new File(users,"buyers");
        if(!buyers.exists())
            buyers.mkdirs();

        File sellers = new File(users,"sellers");
        if(!sellers.exists())
            sellers.mkdirs();

        File category = new File(saveData,"category");
        if(!category.exists())
            category.mkdirs();

        File clothing = new File(category,"clothing");
        if(!clothing.exists())
            clothing.mkdirs();

        File food = new File(category,"food");
        if(!food.exists())
            food.mkdirs();

        File foodspecialInfo = new File(food,"specialInfo.txt");
        foodspecialInfo.createNewFile();
        Formatter x = new Formatter(foodspecialInfo);
        x.format("%s","ّFood");
        x.flush();
        x.close();


        File fo_list = new File(food,"foodList");
        if(!fo_list.exists())
            fo_list.mkdirs();

        File digipro = new File(category,"digiProduct");
        if(!digipro.exists())
            digipro.mkdirs();

        File homeAppliances = new File(category,"homeAppliances");
        if(!homeAppliances.exists())
            homeAppliances.mkdirs();

        File shoes = new File(clothing,"shoes");
        if(!shoes.exists())
            shoes.mkdirs();

        File shoespecialInfo = new File(shoes,"specialInfo.txt");
        shoespecialInfo.createNewFile();
        Formatter z = new Formatter(shoespecialInfo);
        z.format("%s","Shoes");
        z.flush();
        z.close();

        File sh_list = new File(shoes,"shoesList");
        if(!sh_list.exists())
            sh_list.mkdirs();

        File clothes = new File(clothing,"clothes");
        if(!clothes.exists())
            clothes.mkdirs();

        File clothesspecialInfo = new File(clothes,"specialInfo.txt");
        clothesspecialInfo.createNewFile();
        Formatter u = new Formatter(clothesspecialInfo);
        u.format("%s","Cloth");
        u.flush();
        u.close();

        File cl_list = new File(clothes,"clothesList");
        if(!cl_list.exists())
            cl_list.mkdirs();

        File laptop = new File(digipro,"laptop");
        if(!laptop.exists())
            laptop.mkdirs();

        File laptopspecialInfo = new File(laptop,"specialInfo.txt");
        laptopspecialInfo.createNewFile();
        Formatter b = new Formatter(laptopspecialInfo);
        b.format("%s","LapTop");
        b.flush();
        b.close();

        File la_list = new File(laptop,"laptopList");
        if(!la_list.exists())
            la_list.mkdirs();

        File mobile = new File(digipro,"mobile");
        if(!mobile.exists())
            mobile.mkdirs();

        File mobilespecialInfo = new File(mobile,"specialInfo.txt");
        mobilespecialInfo.createNewFile();
        Formatter y = new Formatter(mobilespecialInfo);
        y.format("%s","Mobile");
        y.flush();
        y.close();

        File mo_list = new File(mobile,"mobileList");
        if(!mo_list.exists())
            mo_list.mkdirs();

        File tv = new File(homeAppliances,"tv");
        if(!tv.exists())
            tv.mkdirs();

        File tvspecialInfo = new File(tv,"specialInfo.txt");
        tvspecialInfo.createNewFile();
        Formatter w = new Formatter(tvspecialInfo);
        w.format("%s","Tv");
        w.flush();
        w.close();

        File tv_list = new File(tv,"tvList");
        if(!tv_list.exists())
            tv_list.mkdirs();

        File stove = new File(homeAppliances,"stove");
        if(!stove.exists())
            stove.mkdirs();

        File stovespecialInfo = new File(stove,"specialInfo.txt");
        stovespecialInfo.createNewFile();
        Formatter k = new Formatter(stovespecialInfo);
        k.format("%s","Stove");
        k.flush();
        k.close();

        File st_list = new File(stove,"stoveList");
        if(!st_list.exists())
            st_list.mkdirs();

        File refrigerator = new File(homeAppliances,"refrigerator");
        if(!refrigerator.exists())
            refrigerator.mkdirs();

        File refspecialInfo = new File(refrigerator,"specialInfo.txt");
        refspecialInfo.createNewFile();
        Formatter v = new Formatter(refspecialInfo);
        v.format("%s","Ref");
        v.flush();
        v.close();

        File ref_list = new File(refrigerator,"refrigeratorList");
        if(!ref_list.exists())
            ref_list.mkdirs();



    }


}
