package com.example.rezakalafinal;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class SignInCL {
    @FXML
    void AdminSignInBTN(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminSignIn.fxml"));
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        s.setScene(scene);
        s.show();
    }

    @FXML
    void CustomerSignInBTN(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CustomerSignIn.fxml"));
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        s.setScene(scene);
        s.show();
    }

    @FXML
    void SellerSignInBTN(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SellerSignIn.fxml"));
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        s.setScene(scene);
        s.show();
    }

    @FXML
    void UserAreaBTN(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("UserArea.fxml"));
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        s.setScene(scene);
        s.show();
    }
}
