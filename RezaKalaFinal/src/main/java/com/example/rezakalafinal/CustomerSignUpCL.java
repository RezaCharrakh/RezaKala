package com.example.rezakalafinal;

import Users.Customer;
import Users.CustomerFunctions;
import Users.CustomerStuff;
import Users.MySQL;
import exception.InvalidPhoneNumber;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class CustomerSignUpCL {
    @FXML
    private TextField EmailTXT;

    @FXML
    private TextField FamilyTXT;

    @FXML
    private TextField FundTXT;

    @FXML
    private TextField NameTXT;

    @FXML
    private TextField PasswordTXT;

    @FXML
    private TextField PhoneNumberTXT;

    @FXML
    private Label UserAreaLBL;

    @FXML
    private TextField UserNameTXT;

    @FXML
    void SignUpBTN(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        s.setScene(scene);
        s.show();
    }

    @FXML
    void SubmitBTN(MouseEvent event) throws IOException, SQLException {
        String RegexNumber = "\\d{11}$";
        Pattern patternNumber = Pattern.compile(RegexNumber);
        Matcher matcherNumber = patternNumber.matcher(PhoneNumberTXT.getText());

        String RegexEmail = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern patternEmail = Pattern.compile(RegexEmail);
        Matcher matcherEmail = patternEmail.matcher(EmailTXT.getText());

        boolean action1 = false;
        if (!matcherNumber.matches() || !matcherEmail.matches()) {
            JOptionPane.showMessageDialog(null,"Invalid email or phonenumber!");
            UserNameTXT.clear();
            PasswordTXT.clear();
            NameTXT.clear();
            FamilyTXT.clear();
            EmailTXT.clear();
            PhoneNumberTXT.clear();
            FundTXT.clear();
            action1 = true;
        }

        boolean username_exist = false;
        ResultSet rs_check = MySQL.getMySQL().ExecuteQuery("SELECT Username FROM customers");
        while (rs_check.next())
        {
            if(UserNameTXT.getText().equals(rs_check.getString("Username")))
            {
                username_exist = true;
                JOptionPane.showMessageDialog(null,"This username already exist!");
                break;
            }
        }
        if(!username_exist && !action1)
        {
            Customer customer = new Customer(NameTXT.getText(), FamilyTXT.getText(), EmailTXT.getText(),
                    PhoneNumberTXT.getText(), UserNameTXT.getText(), PasswordTXT.getText(), parseInt(FundTXT.getText()));

            CustomerFunctions.InsertCustonmer(customer.getId(), customer.getName(), customer.getFamily(),
                    customer.getEmail(), customer.getNumber(), customer.getUsername(), customer.getPassword(), customer.getFund());

            JOptionPane.showMessageDialog(null,"Successfully registered!");
            Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
            Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            s.setScene(scene);
            s.show();
        }

    }
}
