package com.example.demo;

import org.hibernate.annotations.DialectOverride.GeneratedColumns;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue()
    private String Name;
    private int ID;


    public Customer(String name, int iD) {
        this.Name = name;
        this.ID = iD;
    }


    public String getName() {
        return Name;
    }


    public void setName(String name) {
        Name = name;
    }


    public int getID() {
        return ID;
    }


    public void setID(int iD) {
        ID = iD;
    }


    protected Customer(){}


}
