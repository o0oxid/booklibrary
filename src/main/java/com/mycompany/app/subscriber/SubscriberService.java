package com.mycompany.app.subscriber;

import com.mycompany.app.catalog.CatalogEntryAbstract;

import java.util.Set;

/**
 * Created by okhoruzhenko on 4/24/17.
 */
interface SubscriberService {
    SubscriberAbstract registerNewSubscriber(String name, String lastName, String address, String phone);
    Set<SubscriberAbstract> lookUpSubscriber(String name, String lastName);
    void setOrder(SubscriberAbstract subscriber, CatalogEntryAbstract entry);
}
