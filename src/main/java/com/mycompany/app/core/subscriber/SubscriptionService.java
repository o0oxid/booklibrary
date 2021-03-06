package com.mycompany.app.core.subscriber;

import com.mycompany.app.core.models.CatalogEntryAbstract;
import com.mycompany.app.core.models.CatalogEntryBook;
import com.mycompany.app.core.models.CatalogEntryMagazine;
import com.mycompany.app.core.catalog.LibraryCatalog;
import com.mycompany.app.core.models.SubscriberAbstract;
import com.mycompany.app.core.models.SubscriberPerson;

import javax.inject.Inject;
import java.util.Set;

/**
 * Created by okhoruzhenko on 4/21/17.
 */
public class SubscriptionService implements Subscription {
    SubscriberCatalog subscribers;
    LibraryCatalog<CatalogEntryBook> books;
    LibraryCatalog<CatalogEntryMagazine> magazines;

    @Inject
    public SubscriptionService(SubscriberCatalog subscribers, LibraryCatalog<CatalogEntryBook> books, LibraryCatalog<CatalogEntryMagazine> magazines) {
        this.subscribers = subscribers;
        this.books = books;
        this.magazines = magazines;
    }

    @Override
    public SubscriberAbstract registerNewSubscriber(String name, String lastName, String address, String phone) {
        SubscriberPerson s = new SubscriberPerson();
        s.setName(name);
        s.setLastName(lastName);
        s.setAddress(address);
        s.setPhone(phone);
        subscribers.add(s);
        return s;
    }

    public SubscriberAbstract registerNewSubscriber(SubscriberAbstract subscriber) {
        subscribers.add(subscriber);
        return subscriber;
    }

    @Override
    public Set<SubscriberAbstract> lookUpSubscriber(String name, String lastName) {
        SubscriberPerson subscriber = new SubscriberPerson();
        subscriber.setName(name);
        subscriber.setLastName(lastName);
        return subscribers.lookUp(subscriber);
    }

    @Override
    public void setOrder(SubscriberAbstract subscriber, CatalogEntryAbstract entry) {
        subscriber.setOrder(entry);
    }

}
