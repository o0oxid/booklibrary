package com.mycompany.app.subscriber;

import com.mycompany.app.catalog.CatalogEntryAbstract;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * Created by okhoruzhenko on 4/19/17.
 */
abstract class SubscriberAbstract implements Serializable {
    protected Set<Order> orderList;
    public void setOrder(CatalogEntryAbstract entry) {
        Order o = new Order(entry, LocalDate.now(),LocalDate.now().plusDays(14));
        orderList.add(o);
    }
    public void renewOrder(Order order, LocalDate date){
        order.expireDate = date;
    }
    public void closeOrder(Order order) {
        order.closeDate = LocalDate.now();
        order.isClosed = true;
    }
    public abstract boolean matches(SubscriberAbstract subscriber);
}
