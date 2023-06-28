package com.example.rezakalafinal;

import Users.MySQL;
import Users.Seller;
import Users.SellerStuff;
import Users.pages;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SellerSignInCL {

    @FXML
    private TextField PasswordTXT;

    @FXML
    private TextField UserNameTXT;

    @FXML
    void SellerSignInCheckBTN(MouseEvent event) throws SQLException, IOException {
        boolean UserExist = false;
        ResultSet rs = MySQL.getMySQL().ExecuteQuery("SELECT sellers.Name, sellers.Family," +
                " sellers.Username, sellers.Password, sellers.Fund, sellers.Company, " +
                "emails.Email, numbers.Number FROM numbers INNER JOIN sellers ON sellers.Id = numbers.Id" +
                " INNER JOIN emails ON emails.Id = numbers.Id");

        while (rs.next()) {
            if (UserNameTXT.getText().equals(rs.getString("Username")) && PasswordTXT.getText().equals(rs.getString("Password"))) {
                UserExist = true;
                Seller seller = new Seller(rs.getString("Name"), rs.getString("Family"),
                        rs.getString("Email"), rs.getString("Number"), rs.getString("Username"),
                        rs.getString("Password"), rs.getInt("Fund"), rs.getString("Company"));
                Seller.setLastAccountId(Seller.getLastAccountId() - 1);
                seller.setId(seller.getId() - 1);
                pages.SellerLoggedIn = seller;
                Parent root = FXMLLoader.load(getClass().getResource("SellerPanel.fxml"));
                Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                s.setScene(scene);
                s.show();
            }
        }
        if(!UserExist)
        {
            UserNameTXT.clear();
            PasswordTXT.clear();
            JOptionPane.showMessageDialog(null, "Username or password is wrong!");
        }
    }

    @FXML
    void SignInBTN(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        s.setScene(scene);
        s.show();
    }

}
