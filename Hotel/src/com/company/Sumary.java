package com.company;

public class Sumary {
    String IDCardOrder;
    String fullname;
    Integer numberofbookings;
    Integer revenue;

    public Sumary(String IDCardOrder, String fullname, Integer numberofbookings, Integer revenue) {
        this.IDCardOrder = IDCardOrder;
        this.fullname = fullname;
        this.numberofbookings = numberofbookings;
        this.revenue = revenue;
    }

    public void setIDCardOrder(String IDCardOrder) {
        this.IDCardOrder = IDCardOrder;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setNumberofbookings(Integer numberofbookings) {
        this.numberofbookings = numberofbookings;
    }

    public void setRevenue(Integer revenue) {
        this.revenue = revenue;
    }

    public String getIDCardOrder() {
        return IDCardOrder;
    }

    public String getFullname() {
        return fullname;
    }

    public Integer getNumberofbookings() {
        return numberofbookings;
    }

    public Integer getRevenue() {
        return revenue;
    }
}
