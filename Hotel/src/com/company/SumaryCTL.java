package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SumaryCTL implements Initializable {
    public TableView<Sumary> ssumary;
    public TableColumn<Sumary,String> sIDCard;
    public TableColumn<Sumary,String> sfullname;
    public TableColumn<Sumary,Integer> snumber;
    public TableColumn<Sumary,Integer> srevenue;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sIDCard.setCellValueFactory(new PropertyValueFactory<>("IDCardOrder"));
        sfullname.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        snumber.setCellValueFactory(new PropertyValueFactory<>("numberofbookings"));
        srevenue.setCellValueFactory(new PropertyValueFactory<>("revenue"));
        try {
            String sql_txt = "SELECT customer.IDCard,customer.name as FullName, COUNT(*) as SoLanDat \n" +
                    "FROM orderrooms  INNER JOIN customer  ON orderrooms.IDCardOrder=customer.IDCard GROUP BY customer.IDCard,customer.name";
            String sql_txt1 = "SELECT orderrooms.IDCardOrder,SUM(rooms.price*DATEDIFF(orderrooms.checkout,orderrooms.checkin)) as revenue FROM orderrooms,rooms WHERE orderrooms.IDRoom=rooms.IDRoom GROUP BY orderrooms.IDCardOrder;";
            database.Connector conn = database.Connector.getInstance();
            PreparedStatement stt = conn.getStatement(sql_txt);
            PreparedStatement stt1 = conn.getStatement(sql_txt1);
            ResultSet rs = stt.executeQuery(sql_txt);
            ResultSet rs1= stt1.executeQuery(sql_txt1);
            ArrayList<Sumary> list = new ArrayList<>();
            while (rs.next() && rs1.next()){
                Sumary ctm = new Sumary(
                        rs.getString("IDCard"),
                        rs.getString("FullName"),
                        rs.getInt("SoLanDat"),
                        rs1.getInt("revenue")
                );
                list.add(ctm);
            }
            ObservableList<Sumary> as = FXCollections.observableArrayList();
            as.addAll(list);
            ssumary.setItems(as);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void back(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Main.rootStage.setScene(new Scene(root,1200,800));
    }
}
