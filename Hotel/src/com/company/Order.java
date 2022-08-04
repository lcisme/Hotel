package com.company;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.sql.Date;

public class Order{
    public Order(Integer IDOrder,String IDCardOrder, Integer IDRoom, Date checkin, String IDCardCI, Date checkout, String IDCardCO, String deposite, String note) throws Exception{
        this.IDOrder = IDOrder;
        this.IDCardOrder = IDCardOrder;
        this.IDRoom = IDRoom;
        this.checkin = checkin;
        this.IDCardCI = IDCardCI;
        this.checkout = checkout;
        this.IDCardCO = IDCardCO;
        this.deposite = deposite;
        this.note = note;
        this.edit = new Button("Edit");
        this.edit.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("addorder.fxml"));
                Parent root =loader.load();
                AddOrderCTL d = loader.getController();
                d.setEditData(this);
                Main.rootStage.setScene(new Scene(root,1200,800));
            }catch (Exception e){
                System.out.println(e.getMessage());

            }

        });
        this.remove = new Button("Remove");
        this.remove.setOnAction(event -> {
            try {
                OrderRepository sr = new OrderRepository();
                sr.remove(this);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("order.fxml"));
                Parent root =loader.load();
                Main.rootStage.setScene(new Scene(root,1200,800));

            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        });
    }



    public Integer getIDOrder() {
        return IDOrder;
    }

    public void setIDOrder(Integer IDOrder) {
        this.IDOrder = IDOrder;
    }

    public String getIDCardOrder() {
        return IDCardOrder;
    }

    public void setIDCardOrder(String IDCardOrder) {
        this.IDCardOrder = IDCardOrder;
    }

    public Integer getIDRoom() {
        return IDRoom;
    }

    public void setIDRoom(Integer IDRoom) {
        this.IDRoom = IDRoom;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public String getIDCardCI() {
        return IDCardCI;
    }

    public void setIDCardCI(String IDCardCI) {
        this.IDCardCI = IDCardCI;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public String getIDCardCO() {
        return IDCardCO;
    }

    public void setIDCardCO(String IDCardCO) {
        this.IDCardCO = IDCardCO;
    }

    public String getDeposite() {
        return deposite;
    }

    public void setDeposite(String deposite) {
        this.deposite = deposite;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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


    public Integer IDOrder;
    public String IDCardOrder;
    public Integer IDRoom;
    public Date checkin;
    public String IDCardCI;
    public Date checkout;
    public String IDCardCO;
    public String deposite;
    public String note;
    public Button edit;
    public Button remove;
}