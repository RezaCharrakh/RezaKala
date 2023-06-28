package com.example.rezakalafinal;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpCL {
    @FXML
    private Button UserAreaBTN;

    @FXML
    private Button UserAreaBTN2;

    @FXML
    void CustomerSignUpBTN(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CustomerSignUp.fxml"));
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        s.setScene(scene);
        s.show();
    }

    @FXML
    void SellerSignUpBTN(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SellerSignUp.fxml"));
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
