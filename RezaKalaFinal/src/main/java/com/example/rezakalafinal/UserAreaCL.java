package com.example.rezakalafinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class UserAreaCL {

    @FXML
    private Button SgnInBTN;

    @FXML
    private Button SignUpBTN;

    @FXML
    private Label UserAreaLBL;

    @FXML
    void MainMenuBTN(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        s.setScene(scene);
        s.show();
    }

    @FXML
    void SgnInOA(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        s.setScene(scene);
        s.show();
    }

    @FXML
    void SignUpOA(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        s.setScene(scene);
        s.show();
    }

    @FXML
    void UserAreaBTN(MouseEvent event) {

    }

}
