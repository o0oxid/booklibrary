package com.mycompany.app.subscriber;

import com.mycompany.app.catalog.CatalogEntryAbstract;
import com.mycompany.app.catalog.CatalogEntryBook;
import com.mycompany.app.catalog.CatalogEntryMagazine;
import com.mycompany.app.catalog.CatalogStorage;

import javax.inject.Inject;
import java.util.Set;

/**
 * Created by okhoruzhenko on 4/21/17.
 */
public class SubscriberServiceAPI implements SubscriberService {
    SubscriberCatalog subscribers;
    CatalogStorage<CatalogEntryBook> books;
    CatalogStorage<CatalogEntryMagazine> magazines;

    @Inject
    public SubscriberServiceAPI(SubscriberCatalog subscribers, CatalogStorage<CatalogEntryBook> books, CatalogStorage<CatalogEntryMagazine> magazines) {
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
