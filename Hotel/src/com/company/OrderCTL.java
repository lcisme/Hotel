package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class OrderCTL implements Initializable {
    public TableView tbOrder;
    public TableColumn<Order,String> sIDCardOrder;
    public TableColumn<Order,Integer> sIDRoom;
    public TableColumn<Order,String> scheckin;
    public TableColumn<Order,String> sIDCardCI;
    public TableColumn<Order,String> scheckout;
    public TableColumn<Order,String> sIDCardCO;
    public TableColumn<Order,Integer> sdeposite;
    public TableColumn<Order,String> snote;
    public TableColumn<Order, Button> sedit;
    public TableColumn<Order, Button> sremove;
    public ComboBox<String> scatalog;
    public TextField sSearch;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sIDCardOrder.setCellValueFactory(new PropertyValueFactory<>("IDCardOrder"));
        sIDRoom.setCellValueFactory(new PropertyValueFactory<>("IDRoom"));
        scheckin.setCellValueFactory(new PropertyValueFactory<>("checkin"));
        sIDCardCI.setCellValueFactory(new PropertyValueFactory<>("IDCardCI"));
        scheckout.setCellValueFactory(new PropertyValueFactory<>("checkout"));
        sIDCardCO.setCellValueFactory(new PropertyValueFactory<>("IDCardCO"));
        sdeposite.setCellValueFactory(new PropertyValueFactory<>("deposite"));
        snote.setCellValueFactory(new PropertyValueFactory<>("note"));
        sedit.setCellValueFactory(new PropertyValueFactory<>("edit"));
        sremove.setCellValueFactory(new PropertyValueFactory<>("remove"));
        ObservableList<String> ls = FXCollections.observableArrayList("IDCardOrder","IDRoom","checkin","IDCardCI","checkout","IDCardCO","deposite","note");
        scatalog.setItems(ls);
        try{
            OrderRepository sr = new OrderRepository();
            ArrayList<Order> as =  sr.list();
            ObservableList<Order> list = FXCollections.observableArrayList();
            list.addAll(as);
            tbOrder.setItems(list);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void BackHome(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Main.rootStage.setScene(new Scene(root,1200,800));
    }

    public void AddOrder(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addorder.fxml"));
        Main.rootStage.setScene(new Scene(root,1200,800));
    }

    public void search(ActionEvent actionEvent) {
        String selectedcatalog = scatalog.getSelectionModel().getSelectedItem();
        try{
            String sql_txt = "select * from orderrooms where "+ selectedcatalog + " like"+ " '%"+sSearch.getText()+"%' ";
            database.Connector conn = database.Connector.getInstance();
            PreparedStatement stt = conn.getStatement(sql_txt);
            ResultSet rs = stt.executeQuery(sql_txt);
            ArrayList<Order> list1 = new ArrayList<>();
            while (rs.next()){
                Order o = new Order(
                        rs.getInt("IDOrder"),
                        rs.getString("IDCardOrder"),
                        rs.getInt("IDRoom"),
                        Date.valueOf(rs.getString("checkin")),
                        rs.getString("IDCardCI"),
                        Date.valueOf(rs.getString("checkout")),
                        rs.getString("IDCardCO"),
                        rs.getString("deposite"),
                        rs.getString("note")
                );
                list1.add(o);
            }
            ObservableList<Order> list = FXCollections.observableArrayList();
            list.addAll(list1);
            tbOrder.setItems(list);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


}