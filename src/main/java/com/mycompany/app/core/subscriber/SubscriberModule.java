package com.mycompany.app.core.subscriber;

/**
 * Created by okhoruzhenko on 4/20/17.
 */
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mycompany.app.core.catalog.*;
import com.mycompany.app.core.models.CatalogEntryBook;
import com.mycompany.app.core.models.CatalogEntryMagazine;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class SubscriberModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(SubscriberCatalog.class).to(SubscriberCatalogMemory.class);
        //bind(SubscriberCatalog.class).to(SubscriberCatalogMongo.class);
    }

    @Provides
    LibraryCatalog<CatalogEntryBook> providesCatalogStorageBook() {
        LibraryCatalog<CatalogEntryBook> libraryCatalog = new LibraryCatalogBookInMemory(ConcurrentHashMap.newKeySet());
        CatalogEntryBook book = new CatalogEntryBook();

        book.setTitle("Harry Potter and the Sorcerer's Stone");
        List<String> authors = new ArrayList<>();
        authors.add("J. K. Rowling");
        book.setAuthors(authors);

        libraryCatalog.add(book);
        return libraryCatalog;
    }

    @Provides
    LibraryCatalog<CatalogEntryMagazine> providesCatalogStorageMagazie() {
        LibraryCatalog<CatalogEntryMagazine> libraryCatalog = new LibraryCatalogMagazineInMemory(ConcurrentHashMap.newKeySet());
        CatalogEntryMagazine magazine = new CatalogEntryMagazine();

        magazine.setTitle("Car");
        magazine.setCountry("United Kingdom");

        libraryCatalog.add(magazine);
        return libraryCatalog;
    }

    @Provides
    MongoCollection providesSubscribersMongoCollection() {
        MongoClient mongoClient = new MongoClient("localhost");
        MongoDatabase mongoDatabase = mongoClient.getDatabase("Library");
        return mongoDatabase.getCollection("Subscribers");
    }
}
