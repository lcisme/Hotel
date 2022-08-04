package com.company;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;

public class AddCustomerCTL {
    public void backCustomer() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("customer.fxml"));
        Main.rootStage.setScene(new Scene(root,1200,800));
    }

    public TextField sIDCard;
    public TextField sName;
    public TextField sPhone;
    public TextField sEmail;
    public TextArea sAddress;

    public Customer editData;

    public void setEditData(Customer editData){
        this.editData = editData;
        sIDCard.setText(editData.getIDCard());
        sName.setText(editData.getName());
        sPhone.setText(editData.getNumberphone());
        sEmail.setText(editData.getEmail());
        sAddress.setText(editData.getAddress());
    }

    public void submit(ActionEvent event) {
        String idcard = this.sIDCard.getText();
        String name = this.sName.getText();
        String phone = this.sPhone.getText();
        String email = this.sEmail.getText();
        String address = this.sAddress.getText();

        try {
            CustomerRepository cr = new CustomerRepository();
            if (this.editData == null){
                Customer c = new Customer(idcard,name,phone,email,address);
                cr.create(c);
            }
            else {
                Customer c = new Customer(idcard,name,phone,email,address);
                cr.update(c);
            }
            this.backCustomer();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}