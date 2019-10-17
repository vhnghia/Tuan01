package com.example.bai5;

import java.util.ArrayList;
import java.util.List;

public class dsCustomer {
    private List<Customer> customers = new ArrayList<Customer>();

    public void them(Customer c){
        customers.add(c);
    }

    public List<Customer> ds(){
        return  customers;
    }

    public float TongTien(){
        float tongtien=0;
        for(int i=0; i<customers.size(); i++)
        {
            tongtien+=customers.get(i).getTongTien();
        }
        return tongtien;
    }
}
