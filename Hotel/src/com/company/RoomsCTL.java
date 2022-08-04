package com.company;

import database.Connector;
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

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RoomsCTL implements Initializable {
    public TableView<Rooms> tbRoom;
    public TableColumn<Rooms,Integer> sIDRoom;
    public TableColumn<Rooms,String> sNameRoom;
    public TableColumn<Rooms,Integer> sRoomVip;
    public TableColumn<Rooms,Integer> sPrice;
    public TableColumn<Rooms, Button> sEdit;
    public TableColumn<Rooms, Button> sRemove;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    sIDRoom.setCellValueFactory(new PropertyValueFactory<>("IDRoom"));
    sNameRoom.setCellValueFactory(new PropertyValueFactory<>("nameRoom"));
    sRoomVip.setCellValueFactory(new PropertyValueFactory<>("roomVip"));
    sPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
    sEdit.setCellValueFactory(new PropertyValueFactory<>("edit"));
    sRemove.setCellValueFactory(new PropertyValueFactory<>("remove"));

        try{
            RoomsRepository sr = new RoomsRepository();
            ArrayList<Rooms> as =  sr.list();

            ObservableList<Rooms> list = FXCollections.observableArrayList();
            list.addAll(as);
            tbRoom.setItems(list);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void addRooms(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addroom.fxml"));
        Main.rootStage.setScene(new Scene(root,1200,800));
    }

    public void backHome(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Main.rootStage.setScene(new Scene(root,1200,800));
    }
}
