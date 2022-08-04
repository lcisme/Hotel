package com.company;

import database.Connector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RoomsRepository implements IRoomsInterface {
    @Override
    public ArrayList<Rooms> list() {
        try{
            String txt_sql = "select * from Rooms";
            Connector conn = Connector.getInstance();
            PreparedStatement stt = conn.getStatement(txt_sql);
            ResultSet rs = stt.executeQuery(txt_sql);

            ArrayList<Rooms> list = new ArrayList<>();
            while (rs.next()){
                Rooms s =new Rooms(
                        rs.getInt("IDRoom"),
                        rs.getString("nameRoom"),
                        rs.getInt("roomVip"),
                        rs.getInt("price")
                );
                list.add(s);
            }
            return list;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void create(Rooms rooms) {
        String sql_txt="insert into rooms(IDRoom,nameRoom,roomVip,price) values(?,?,?,?)";
        try {
            Connector conn= Connector.getInstance();
            PreparedStatement stt = conn.getStatement(sql_txt);
            stt.setString(1,rooms.getIDRoom().toString());
            stt.setString(2,rooms.getNameRoom());
            stt.setString(3,rooms.getRoomVip().toString());
            stt.setString(4,rooms.getPrice().toString());
            stt.execute();

        }catch (Exception e){
        }
    }

    @Override
    public void update(Rooms rooms) {
        String sql_txt="update rooms set nameRoom =?,roomVip=?,price=? where IDRoom=?";
        try {
            Connector conn= Connector.getInstance();
            PreparedStatement stt = conn.getStatement(sql_txt);
            stt.setString(1,rooms.getNameRoom());
            stt.setString(2,rooms.getRoomVip().toString());
            stt.setString(3,rooms.getPrice().toString());
            stt.setString(4,rooms.getIDRoom().toString());
            stt.execute();
        }catch (Exception e){

        }


    }

    @Override
    public void delete(Rooms rooms) {
        String sql_txt = " Delete from rooms where IDRoom ='"+rooms.getIDRoom()+"'";
        try {
            Connector conn= Connector.getInstance();
            PreparedStatement stt = conn.getStatement(sql_txt);
            stt.execute();

        }catch (Exception e){

        }

    }
}
