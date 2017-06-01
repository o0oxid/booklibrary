package com.mycompany.app.core.subscriber;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.mongodb.client.MongoCollection;
import java.util.Set;

import com.mycompany.app.core.models.SubscriberAbstract;
import org.bson.Document;


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
