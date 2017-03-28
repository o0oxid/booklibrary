package com.mycompany.app.subscriber;

/**
 * Created by okhoruzhenko on 3/27/17.
 */
public interface SubscriberCatalog {
    void add(SubscriberCatalogEntry entry);
    void remove(SubscriberCatalogEntry entry);
    SubscriberCatalogEntry lookup(String text);
}
