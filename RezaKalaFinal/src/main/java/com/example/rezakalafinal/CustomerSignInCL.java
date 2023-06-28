package com.example.rezakalafinal;

import Users.Customer;
import Users.CustomerStuff;
import Users.MySQL;
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

public class CustomerSignInCL {

    @FXML
    private TextField PasswordTXT;

    @FXML
    private TextField UserNameTXT;

    @FXML
    void CustomerSignInCheckBTN(MouseEvent event) throws SQLException, IOException {
        boolean UserExist = false;
        ResultSet rs = MySQL.getMySQL().ExecuteQuery("SELECT customers.Name, customers.Family," +
                " customers.Username, customers.Password, customers.Fund, " +
                "emails.Email, numbers.Number FROM numbers INNER JOIN customers ON customers.Id = numbers.Id" +
                " INNER JOIN emails ON emails.Id = numbers.Id");
        while (rs.next()) {
            System.out.println("0");
            if (UserNameTXT.getText().equals(rs.getString("Username")) && PasswordTXT.getText().equals(rs.getString("Password")))
            {
                System.out.println("1");
                UserExist = true;
                Customer customer = new Customer(rs.getString("Name"), rs.getString("Family"),
                        rs.getString("Email"), rs.getString("Number"), rs.getString("Username"),
                        rs.getString("Password"), rs.getInt("Fund"));
                Customer.setLastAccountId(Customer.getLastAccountId() - 1);
                customer.setId(customer.getId() - 1);
                pages.CustomerLoggedIn = customer;
                Parent root = FXMLLoader.load(getClass().getResource("CustomerPanel.fxml"));
                Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                s.setScene(scene);
                s.show();
            }
        }
        if(!UserExist) {
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
