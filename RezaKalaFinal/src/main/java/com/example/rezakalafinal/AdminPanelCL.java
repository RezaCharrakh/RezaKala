package com.example.rezakalafinal;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminPanelCL {

    @FXML
    void CustomerListBTN(MouseEvent event) {

    }

    @FXML
    void DeleteCustomerBTN(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DeleteCustomer.fxml"));
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        s.setScene(scene);
        s.show();
    }

    @FXML
    void DeleteSellerBTN(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DeleteSeller.fxml"));
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        s.setScene(scene);
        s.show();
    }

    @FXML
    void EditAdminInfoBTN(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminEditInfo.fxml"));
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        s.setScene(scene);
        s.show();
    }

    @FXML
    void MainMenuBTN(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        s.setScene(scene);
        s.show();
    }

    @FXML
    void ProductRequestBTN(MouseEvent event) {

    }

    @FXML
    void SellerListBTN(MouseEvent event) {

    }

    @FXML
    void SellerRequestsBTN(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SellerRequest.fxml"));
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        s.setScene(scene);
        s.show();
    }

    @FXML
    void ShowAdminInfoBTN(MouseEvent event) {

    }

}
