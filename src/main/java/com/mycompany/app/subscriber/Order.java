package com.mycompany.app.subscriber;

import com.mycompany.app.catalog.CatalogEntryAbstract;

import java.time.LocalDate;

/**
 * Created by okhoruzhenko on 4/21/17.
 */
class Order {
    CatalogEntryAbstract entry;
    LocalDate orderDate;
    LocalDate expireDate;
    LocalDate closeDate;
    Boolean isClosed = false;

    Order(CatalogEntryAbstract entry, LocalDate orderDate, LocalDate expireDate) {
        this.entry = entry;
        this.orderDate = orderDate;
        this.expireDate = expireDate;
    }
}
