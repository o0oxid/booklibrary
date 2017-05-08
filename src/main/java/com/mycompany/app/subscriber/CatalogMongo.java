package com.mycompany.app.subscriber;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.mongodb.client.MongoCollection;
import java.util.Set;

import com.mycompany.app.models.SubscriberAbstract;
import org.bson.Document;


/**
 * Created by okhoruzhenko on 4/20/17.
 */


@Singleton
class CatalogMongo implements Catalog {

    private MongoCollection<Document> collection;
    @Inject
    public CatalogMongo(MongoCollection collection) {
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
