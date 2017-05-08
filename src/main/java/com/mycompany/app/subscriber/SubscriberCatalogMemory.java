package com.mycompany.app.subscriber;

import com.google.inject.Singleton;
import org.eclipse.jetty.util.ConcurrentHashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by okhoruzhenko on 4/20/17.
 */
@Singleton
class SubscriberCatalogMemory implements SubscriberCatalog {
    private Set<SubscriberAbstract> collection = new ConcurrentHashSet<>();

    public void add(SubscriberAbstract subscriber) {
        collection.add(subscriber);
    }
    public void remove(SubscriberAbstract subscriber) {
        collection.remove(subscriber);
    }
    public Set<SubscriberAbstract> lookUp(SubscriberAbstract subscriber){
        return collection.stream().filter(s -> s.matches(subscriber)).collect(Collectors.toSet());
    }
}
