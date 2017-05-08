package com.mycompany.app.subscriber;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import java.util.Set;
import org.bson.Document;

import java.net.UnknownHostException;


/**
 * Created by okhoruzhenko on 4/20/17.
 */


@Singleton
class SubscriberCatalogMongo implements SubscriberCatalog {

    private MongoCollection<Document> collection;
    @Inject
    public SubscriberCatalogMongo(MongoCollection collection) {
        this.collection = collection;
    }
    public void add(SubscriberAbstract subscriber) {
        //
    }
    public void remove(SubscriberAbstract subscriber) {
       //
    }
    public Set<SubscriberAbstract> lookUp(SubscriberAbstract subscriber){
        return null;
    }
}
