package com.company;

import database.Connector;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.sql.PreparedStatement;

public class Rooms {
    public Integer IDRoom;
    public String nameRoom;
    public Integer roomVip;
    public Integer price;
    public Button edit;
    public Button remove;

    public Rooms(Integer IDRoom, String nameRoom, Integer roomVip, Integer price) throws Exception{
        this.IDRoom = IDRoom;
        this.nameRoom = nameRoom;
        this.roomVip = roomVip;
        this.price = price;
        this.edit = new Button("Edit");
        this.edit.setOnAction(event -> {
            try {
               FXMLLoader loader = new FXMLLoader(getClass().getResource("addroom.fxml"));
                Parent root =loader.load();
                AddRoomCTL d = loader.getController();
                d.setEditData(this);
                Main.rootStage.setScene(new Scene(root,1200,800));
            }catch (Exception e){
                System.out.println(e.getMessage());

            }

        });
        this.remove = new Button("Remove");
        this.remove.setOnAction(event -> {
            try {
                RoomsRepository sr = new RoomsRepository();
                sr.delete(this);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("room.fxml"));
                Parent root =loader.load();
                Main.rootStage.setScene(new Scene(root,1200,800));

            }catch (Exception e){
                System.out.println(e.getMessage());
            }


        });
    }


    public void setIDRoom(Integer IDRoom) {
        this.IDRoom = IDRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public void setRoomVip(Integer roomVip) {
        this.roomVip = roomVip;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }

    public void setRemove(Button remove) {
        this.remove = remove;
    }

    public Integer getIDRoom() {
        return IDRoom;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public Integer getRoomVip() {
        return roomVip;
    }

    public Integer getPrice() {
        return price;
    }

    public Button getEdit() {
        return edit;
    }

    public Button getRemove() {
        return remove;
    }

    @Override
    public String toString() {
        return this.getIDRoom().toString();
    }

}
