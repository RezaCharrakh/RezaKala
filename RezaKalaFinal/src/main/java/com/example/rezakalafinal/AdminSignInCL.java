package com.example.rezakalafinal;

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

public class AdminSignInCL {

    @FXML
    private TextField PasswordTXT;

    @FXML
    private TextField UserNameTXT;

    @FXML
    void AdminSignInCheckBTN(MouseEvent event) throws IOException {
        if(PasswordTXT.getText().equals("admin") && UserNameTXT.getText().equals("admin"))
        {
            Parent root = FXMLLoader.load(getClass().getResource("AdminPanel.fxml"));
            Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            s.setScene(scene);
            s.show();
        }
        else {
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
