package com.mycompany.app.subscriber;

/**
 * Created by okhoruzhenko on 4/20/17.
 */
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mycompany.app.catalog.*;
import com.mycompany.app.models.CatalogEntryBook;
import com.mycompany.app.models.CatalogEntryMagazine;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class SubscriberModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Catalog.class).to(CatalogMemory.class);
        //bind(Catalog.class).to(CatalogMongo.class);
    }

    @Provides
    com.mycompany.app.catalog.Catalog<CatalogEntryBook> providesCatalogStorageBook() {
        com.mycompany.app.catalog.Catalog<CatalogEntryBook> catalog = new CatalogBookInMemory(ConcurrentHashMap.newKeySet());
        CatalogEntryBook book = new CatalogEntryBook();

        book.setTitle("Harry Potter and the Sorcerer's Stone");
        List<String> authors = new ArrayList<>();
        authors.add("J. K. Rowling");
        book.setAuthors(authors);

        catalog.add(book);
        return catalog;
    }

    @Provides
    com.mycompany.app.catalog.Catalog<CatalogEntryMagazine> providesCatalogStorageMagazie() {
        com.mycompany.app.catalog.Catalog<CatalogEntryMagazine> catalog = new CatalogMagazineInMemory(ConcurrentHashMap.newKeySet());
        CatalogEntryMagazine magazine = new CatalogEntryMagazine();

        magazine.setTitle("Car");
        magazine.setCountry("United Kingdom");

        catalog.add(magazine);
        return catalog;
    }

    @Provides
    MongoCollection providesSubscribersMongoCollection() {
        MongoClient mongoClient = new MongoClient("localhost");
        MongoDatabase mongoDatabase = mongoClient.getDatabase("Library");
        return mongoDatabase.getCollection("Subscribers");
    }
}
