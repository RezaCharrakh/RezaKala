package com.example.rezakalafinal;

import Users.MySQL;
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
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class DeleteSellerCL {

    @FXML
    private TextField SellerIdTXT;

    @FXML
    void AdminPanelBTN(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminPanel.fxml"));
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        s.setScene(scene);
        s.show();
    }

    @FXML
    void DeleteSellerBTN(MouseEvent event) throws SQLException {
        String SqlCmd = String.format("DELETE FROM sellers WHERE Id = %d", parseInt(SellerIdTXT.getText()));
        if(MySQL.getMySQL().Execute(SqlCmd))
        {
            JOptionPane.showMessageDialog(null, "Successfully deleted!");
            SellerIdTXT.clear();
        }
        else {
            JOptionPane.showMessageDialog(null, "This id doesn't exist!");
            SellerIdTXT.clear();
        }
    }

}
