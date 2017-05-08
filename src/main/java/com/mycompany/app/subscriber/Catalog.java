package com.mycompany.app.subscriber;

import com.mycompany.app.models.SubscriberAbstract;

import java.util.Set;

/**
 * Created by okhoruzhenko on 3/27/17.
 */
interface Catalog {
    void add(SubscriberAbstract entry);
    void remove(SubscriberAbstract entry);
    Set<SubscriberAbstract> lookUp(SubscriberAbstract subscriber);
}
