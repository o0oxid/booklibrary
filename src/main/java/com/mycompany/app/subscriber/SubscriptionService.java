package com.mycompany.app.subscriber;

import com.mycompany.app.models.CatalogEntryAbstract;
import com.mycompany.app.models.CatalogEntryBook;
import com.mycompany.app.models.CatalogEntryMagazine;
import com.mycompany.app.catalog.Catalog;
import com.mycompany.app.models.SubscriberAbstract;
import com.mycompany.app.models.SubscriberPerson;

import javax.inject.Inject;
import java.util.Set;

/**
 * Created by okhoruzhenko on 4/21/17.
 */
public class SubscriptionService implements Subscription {
    com.mycompany.app.subscriber.Catalog subscribers;
    Catalog<CatalogEntryBook> books;
    Catalog<CatalogEntryMagazine> magazines;

    @Inject
    public SubscriptionService(com.mycompany.app.subscriber.Catalog subscribers, Catalog<CatalogEntryBook> books, Catalog<CatalogEntryMagazine> magazines) {
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
