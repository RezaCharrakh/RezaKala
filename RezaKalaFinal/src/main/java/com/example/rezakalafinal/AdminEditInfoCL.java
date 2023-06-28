package com.example.rezakalafinal;

import Users.Manager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class AdminEditInfoCL {

    @FXML
    private TextField EmailTXT;

    @FXML
    private TextField FamilyTXT;

    @FXML
    private TextField NameTXT;

    @FXML
    private TextField PhoneNumberTXT;

    @FXML
    private Label UserAreaLBL;

    @FXML
    void ApplyBTN(MouseEvent event) throws SQLException {
        if(!(Objects.equals(NameTXT.getText(), "")))
            Manager.getManager().setName(NameTXT.getText());

        if(!(Objects.equals(FamilyTXT.getText(), "")))
            Manager.getManager().setFamily(FamilyTXT.getText());

        if(!(Objects.equals(EmailTXT.getText(), "")))
            Manager.getManager().setEmail(EmailTXT.getText());

        if(!(Objects.equals(PhoneNumberTXT.getText(), "")))
            Manager.getManager().setNumber(PhoneNumberTXT.getText());

        System.out.println(Manager.getManager().toString());
        NameTXT.clear();
        FamilyTXT.clear();
        EmailTXT.clear();
        PhoneNumberTXT.clear();
        JOptionPane.showMessageDialog(null, "Information Successfully changed!");
        System.out.println(Manager.getManager().getName());
    }

    @FXML
    void AdminPanelBTN(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminPanel.fxml"));
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        s.setScene(scene);
        s.show();
    }

}
