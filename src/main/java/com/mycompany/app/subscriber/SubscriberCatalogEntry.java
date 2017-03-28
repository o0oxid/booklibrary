package com.mycompany.app.subscriber;

import java.io.Serializable;

/**
 * Created by okhoruzhenko on 3/26/17.
 */
public abstract class SubscriberCatalogEntry implements Serializable{
    private String name;
    private String lastName;
    private String address;
    private String phone;

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
