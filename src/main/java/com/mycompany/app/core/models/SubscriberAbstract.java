package com.mycompany.app.core.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * Created by okhoruzhenko on 4/19/17.
 */
public abstract class SubscriberAbstract implements Serializable {
    protected Set<Order> orderList;
    public void setOrder(CatalogEntryAbstract entry) {
        Order o = new Order(entry, LocalDate.now(),LocalDate.now().plusDays(14));
        orderList.add(o);
    }
    public void renewOrder(Order order, LocalDate date){
        order.setExpireDate(date);
    }
    public void closeOrder(Order order) {
        order.setCloseDate(LocalDate.now());
        order.setClosed(true);
    }
    public abstract boolean matches(SubscriberAbstract subscriber);
}
