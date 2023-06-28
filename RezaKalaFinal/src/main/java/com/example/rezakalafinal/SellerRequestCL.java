package com.example.rezakalafinal;

import Users.Lists;
import Users.Seller;
import Users.SellerFunctions;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class SellerRequestCL implements Initializable {
    @FXML
    private ListView<Seller> SellerList;

    @FXML
    void AdminPanelBTN(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminPanel.fxml"));
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        s.setScene(scene);
        s.show();
    }

    @FXML
    private TextField AcceptIdBTN;

    @FXML
    private TextField RejectIdBTN;


    @FXML
    void AcceptBTN(MouseEvent event) throws SQLException {
        Seller seller = Lists.getLists().SellerRegisterList.get(parseInt(AcceptIdBTN.getText()) - 1);
        Lists.getLists().getSellerList().add(seller);

        SellerFunctions.InsertSeller(seller.getId(), seller.getName(), seller.getFamily(), seller.getEmail(), seller.getNumber(),
                seller.getUsername(), seller.getPassword(), seller.getCompany(), seller.getFund());

        Lists.getLists().SellerRegisterList.remove(parseInt(AcceptIdBTN.getText()) - 1);
    }

    @FXML
    void RejectBTN(MouseEvent event) {
        Lists.getLists().SellerRegisterList.remove(parseInt(RejectIdBTN.getText()) - 1);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SellerList.setItems(FXCollections.observableArrayList(Lists.getLists().getSellerRegisterList()));
    }
}