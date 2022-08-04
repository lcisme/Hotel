package com.company;

import java.util.ArrayList;

public interface ICustomerInterface {
    ArrayList<Customer> list();
    void create(Customer customer);
    void update(Customer customer);
    void delete(Customer customer);
}