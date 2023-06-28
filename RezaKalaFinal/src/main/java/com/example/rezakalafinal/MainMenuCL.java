package com.example.rezakalafinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuCL {
    @FXML
    private Button ProductsBTN;

    @FXML
    private Button UserAreaBTN;


    @FXML
    void ProductsOA(MouseEvent event) {

    }

    @FXML
    void UserAreaOA(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("UserArea.fxml"));
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        s.setScene(scene);
        s.show();
    }

}
