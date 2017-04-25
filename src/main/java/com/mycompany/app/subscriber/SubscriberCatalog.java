package com.mycompany.app.subscriber;

import java.util.Set;

/**
 * Created by okhoruzhenko on 3/27/17.
 */
interface SubscriberCatalog {
    void add(SubscriberAbstract entry);
    void remove(SubscriberAbstract entry);
    Set<SubscriberAbstract> lookUp(SubscriberAbstract subscriber);
}
