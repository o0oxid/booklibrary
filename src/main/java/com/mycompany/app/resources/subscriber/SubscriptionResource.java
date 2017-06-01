package com.mycompany.app.resources.subscriber;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.mycompany.app.core.models.SubscriberAbstract;
import com.mycompany.app.core.subscriber.Subscription;


/**
 * Created by okhoruzhenko on 5/8/17.
 */
@Path("api/v1/subscribers")
@Produces(MediaType.APPLICATION_JSON)
public class SubscriptionResource {
    Subscription service;

    @Inject
    public SubscriptionResource(@Named("SubscriptionService") Subscription service) {
        this.service = service;
    }

    @GET
    public SubscriberAbstract registerSubscriber(@QueryParam("name")  String name,
                                                 @QueryParam("lastname") String lastName,
                                                 @QueryParam("address") String address,
                                                 @QueryParam("phone") String phone) {
        return service.registerNewSubscriber(name, lastName, address, phone);
    }
}
