package com.company;

import database.Connector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CustomerRepository implements ICustomerInterface {

    @Override
    public ArrayList<Customer> list() {
        try {
            String sql_txt = "select * from customer";
            database.Connector conn = database.Connector.getInstance();
            PreparedStatement stt = conn.getStatement(sql_txt);
            ResultSet rs = stt.executeQuery(sql_txt);

            ArrayList<Customer> list = new ArrayList<>();
            while (rs.next()){
                Customer ctm = new Customer(
                        rs.getString("IDCard"),
                        rs.getString("name"),
                        rs.getString("numberPhone"),
                        rs.getString("email"),
                        rs.getString("address")
                );
                list.add(ctm);
            }
            return list;
        }
        catch (Exception e){

        }
        return null;
    }

    @Override
    public void create(Customer customer) {
        String sql_txt = "insert into customer(IDCard,name,numberPhone,email,address) values(?,?,?,?,?)";
        try {
            database.Connector conn = database.Connector.getInstance();
            PreparedStatement stt = conn.getStatement(sql_txt);
            stt.setString(1,customer.getIDCard());
            stt.setString(2,customer.getName());
            stt.setString(3,customer.getNumberphone());
            stt.setString(4,customer.getEmail());
            stt.setString(5,customer.getAddress());
            stt.execute();
            System.out.println(stt);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Customer customer) {
        String sql_txt = "update customer set name=?,numberPhone=?,email=?,address=? where IDCard=?";
        try {
            database.Connector conn = database.Connector.getInstance();
            PreparedStatement stt = conn.getStatement(sql_txt);
            stt.setString(1,customer.getName());
            stt.setString(2,customer.getNumberphone());
            stt.setString(3,customer.getEmail());
            stt.setString(4,customer.getAddress());
            stt.setString(5,customer.getIDCard());
            stt.execute();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Customer customer) {
        String sql_txt = " Delete from customer where IDCard =?";
        try {
            database.Connector conn = Connector.getInstance();
            PreparedStatement stt = conn.getStatement(sql_txt);
            stt.setString(1,customer.getIDCard());
            stt.execute();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}