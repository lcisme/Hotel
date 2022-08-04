package com.company;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class HomeCTL {
    public void roomsModule(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("room.fxml"));
        Main.rootStage.setScene(new Scene(root,1200,800));
    }

    public void customerModule(ActionEvent event)throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("customer.fxml"));
        Main.rootStage.setScene(new Scene(root,1200,800));
    }

    public void orderroomsModule(ActionEvent event)throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("order.fxml"));
        Main.rootStage.setScene(new Scene(root,1200,800));
    }

    public void sumary(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sumary.fxml"));
        Main.rootStage.setScene(new Scene(root,1200,800));

    }
}