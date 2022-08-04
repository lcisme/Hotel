package com.company;

import database.Connector;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class OrderRepository implements IOrderInterface{
    @Override
    public ArrayList<Order> list() {
        try {
            String sql_txt = "select * from orderrooms";
            database.Connector conn = database.Connector.getInstance();
            PreparedStatement stt = conn.getStatement(sql_txt);
            ResultSet rs = stt.executeQuery(sql_txt);

            ArrayList<Order> list = new ArrayList<>();
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
                list.add(o);
            }
            return list;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }



    @Override
    public void create(Order order) {
        String sql_txt="insert into orderrooms(IDOrder,IDCardOrder,IDRoom,checkin,IDCardCI,checkout,IDCardCO,deposite,note) values(?,?,?,?,?,?,?,?,?)";
        try {
            database.Connector conn = database.Connector.getInstance();
            PreparedStatement stt = conn.getStatement(sql_txt);
            stt.setString(1,order.getIDOrder().toString());
            stt.setString(2,order.getIDCardOrder());
            stt.setString(3,order.getIDRoom().toString());
            stt.setString(4,order.getCheckin().toString());
            stt.setString(5,order.getIDCardCI());
            stt.setString(6,order.getCheckout().toString());
            stt.setString(7,order.getIDCardCO());
            stt.setString(8,order.getDeposite());
            stt.setString(9,order.getNote());
            stt.execute();

        }catch (Exception e){
        }

    }

    @Override
    public void update(Order order) {
        String sql_txt="update orderrooms set IDCardOrder=?, IDRoom=?,checkin=?,IDCardCI=?,checkout=?,IDCardCO=?,deposite=?,note=? where IDOrder=?" ;
        try {
            database.Connector conn = database.Connector.getInstance();
            PreparedStatement stt = conn.getStatement(sql_txt);
            stt.setString(1,order.getIDCardOrder());
            stt.setString(2,order.getIDRoom().toString());
            stt.setString(3,order.getCheckin().toString());
            stt.setString(4,order.getIDCardCI());
            stt.setString(5,order.getCheckout().toString());
            stt.setString(6,order.getIDCardCO());
            stt.setString(7,order.getDeposite());
            stt.setString(8,order.getNote());
            stt.setString(9, order.getIDOrder().toString());
            stt.execute();

        }catch (Exception e){
        }

    }

    @Override
    public void remove(Order order) {
        String sql_txt="DELETE FROM orderrooms WHERE IDOrder = ?";
        try {
            database.Connector conn = database.Connector.getInstance();
            PreparedStatement stt = conn.getStatement(sql_txt);
            stt.setString(1,order.getIDOrder().toString());
            System.out.println(order.getIDOrder());
            stt.execute();
        }catch (Exception e){
        }

    }
}