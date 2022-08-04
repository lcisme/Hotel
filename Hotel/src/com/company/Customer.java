package com.company;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.sql.PreparedStatement;

public class Customer {
    public Customer(String IDCard, String name, String numberphone, String email, String address) throws Exception {
        this.IDCard = IDCard;
        this.name = name;
        this.numberphone = numberphone;
        this.email = email;
        this.address = address;
        this.edit = new Button("Edit");
        this.edit.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("addcustomer.fxml"));
                Parent root = loader.load();
                AddCustomerCTL d = loader.getController();
                d.setEditData(this);
                Main.rootStage.setScene(new Scene(root,1200,800));
            }
            catch (Exception e){

            }
        });
        this.remove = new Button("Remove");
        this.remove.setOnAction(event -> {
            try {
                CustomerRepository cr = new CustomerRepository();
                cr.delete(this);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("customer.fxml"));
                Parent root =loader.load();
                Main.rootStage.setScene(new Scene(root,1200,800));
            }catch (Exception e){

            }
        });
    }

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberphone() {
        return numberphone;
    }

    public void setNumberphone(String numberphone) {
        this.numberphone = numberphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }

    public Button getRemove() {
        return remove;
    }

    public void setRemove(Button remove) {
        this.remove = remove;
    }

    public String IDCard;
    public String name;
    public String numberphone;
    public String email;
    public String address;
    public Button edit;
    public Button remove;

    @Override
    public String toString() {
       return this.getIDCard();
    }
}