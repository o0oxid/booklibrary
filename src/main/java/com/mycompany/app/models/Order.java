package com.mycompany.app.models;

import java.time.LocalDate;

/**
 * Created by okhoruzhenko on 4/21/17.
 */
public class Order {
    private CatalogEntryAbstract entry;
    private LocalDate orderDate;
    private LocalDate expireDate;
    private LocalDate closeDate;
    private Boolean isClosed = false;

    public Order(CatalogEntryAbstract entry, LocalDate orderDate, LocalDate expireDate) {
        this.entry = entry;
        this.orderDate = orderDate;
        this.expireDate = expireDate;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public LocalDate getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(LocalDate closeDate) {
        this.closeDate = closeDate;
    }

    public Boolean getClosed() {
        return isClosed;
    }

    public void setClosed(Boolean closed) {
        isClosed = closed;
    }
}
