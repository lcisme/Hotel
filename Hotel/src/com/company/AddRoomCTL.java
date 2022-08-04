package com.company;

import database.Connector;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.PreparedStatement;


public class AddRoomCTL {
    public TextField sIDRoom;
    public TextField sNameRoom;
    public TextField sRoomVip;
    public TextField sPrice;

    public Rooms editData;
    public void setEditData(Rooms editData){
        this.editData = editData;
        this.sIDRoom.setText(editData.getIDRoom().toString());
        this.sNameRoom.setText(editData.getNameRoom());
        this.sRoomVip.setText(editData.getRoomVip().toString());
        this.sPrice.setText(editData.getPrice().toString());
    }



    public void submit (ActionEvent actionEvent) throws Exception{
        String IDRoom = this.sIDRoom.getText();
        String nameRoom = this.sNameRoom.getText();
        String roomVip =this.sRoomVip.getText();
        String price = this.sPrice.getText();
        try{

            RoomsRepository sr = new RoomsRepository();
            if(this.editData==null){
                Rooms s = new Rooms(Integer.valueOf(IDRoom), nameRoom,Integer.valueOf(roomVip),Integer.valueOf(price));
                sr.create(s);

            }
            else {
                Rooms s = new Rooms(Integer.valueOf(IDRoom), nameRoom,Integer.valueOf(roomVip),Integer.valueOf(price));
                sr.update(s);
            }
            
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        Parent root = FXMLLoader.load(getClass().getResource("room.fxml"));
        Main.rootStage.setScene(new Scene(root,1200,800));

    }

    public void backRooms(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("room.fxml"));
        Main.rootStage.setScene(new Scene(root,1200,800));
    }
}
