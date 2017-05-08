package com.mycompany.app.models;


import java.util.concurrent.ConcurrentHashMap;


/**
 * Created by okhoruzhenko on 3/26/17.
 */
public class SubscriberPerson extends SubscriberAbstract {
    private String name;
    private String lastName;
    private String address;
    private String phone;
    
    public SubscriberPerson() {
        this.orderList = ConcurrentHashMap.newKeySet();
    }

    public boolean matches(SubscriberAbstract subscriber) {
        SubscriberPerson s = (SubscriberPerson) subscriber;
        return (name.matches(s.getName()) && lastName.matches(s.getLastName()));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
