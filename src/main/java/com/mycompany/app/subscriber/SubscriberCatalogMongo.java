package com.mycompany.app.subscriber;

import com.google.inject.Singleton;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;

import java.net.UnknownHostException;


/**
 * Created by okhoruzhenko on 4/20/17.
 */


@Singleton
class SubscriberCatalogMongo implements SubscriberCatalog {

    MongoCollection<Document> collection;
    public SubscriberCatalogMongo(MongoClient mongoClient) throws UnknownHostException{
        collection = mongoClient.getDatabase("Library").getCollection("Subscribers");
    }
    public void add(SubscriberAbstract subscriber) {
        //


    }
    public void remove(SubscriberAbstract subscriber) {
       //
    }
    public SubscriberAbstract lookup(String text){
        return null;
    }
}
