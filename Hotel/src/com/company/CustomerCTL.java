package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CustomerCTL implements Initializable {
    public TableView<Customer> tbCustomer;
    public TableColumn<Customer, String> sIDCard;
    public TableColumn<Customer, String> sName;
    public TableColumn<Customer, String> sPhone;
    public TableColumn<Customer, String> sEmail;
    public TableColumn<Customer, String> sAddress;
    public TableColumn<Customer, Button> sEdit;
    public TableColumn<Customer, String> sRemove;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sIDCard.setCellValueFactory(new PropertyValueFactory<>("IDCard"));
        sName.setCellValueFactory(new PropertyValueFactory<>("name"));
        sPhone.setCellValueFactory(new PropertyValueFactory<>("numberphone"));
        sEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        sAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        sEdit.setCellValueFactory(new PropertyValueFactory<>("edit"));
        sRemove.setCellValueFactory(new PropertyValueFactory<>("remove"));
        try {
            CustomerRepository cr = new CustomerRepository();
            ArrayList<Customer> ac = cr.list();
            ObservableList<Customer> ctm = FXCollections.observableArrayList();
            ctm.addAll(ac);
            tbCustomer.setItems(ctm);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void backHome(ActionEvent event)  throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Main.rootStage.setScene(new Scene(root,1200,800));
    }

    public void addCustomer(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("addcustomer.fxml"));
        Main.rootStage.setScene(new Scene(root,1200,800));
    }
}