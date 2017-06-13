package com.mycompany.app.core.subscriber;

import com.mycompany.app.core.models.CatalogEntryAbstract;
import com.mycompany.app.core.models.SubscriberAbstract;

import java.util.Set;

/**
 * Created by okhoruzhenko on 4/24/17.
 */
public interface Subscription {
    SubscriberAbstract registerNewSubscriber(String name, String lastName, String address, String phone);
    SubscriberAbstract registerNewSubscriber(SubscriberAbstract subscriber);
    Set<SubscriberAbstract> lookUpSubscriber(String name, String lastName);
    void setOrder(SubscriberAbstract subscriber, CatalogEntryAbstract entry);
}
