package com.company;

import java.util.ArrayList;

public interface IOrderInterface {
    ArrayList<Order> list();
    void create(Order order);
    void update(Order order);
    void remove(Order order);
}
