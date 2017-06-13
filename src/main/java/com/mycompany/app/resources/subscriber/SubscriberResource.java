package com.mycompany.app.resources.subscriber;

import java.util.HashSet;
import java.util.Set;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.mycompany.app.core.models.SubscriberAbstract;
import com.mycompany.app.core.models.SubscriberPerson;
import com.mycompany.app.core.subscriber.Subscription;


/**
 * Created by okhoruzhenko on 5/8/17.
 */
@Path("api/v1/subscriber")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SubscriberResource {
    Subscription service;

    @Inject
    public SubscriberResource(Subscription service) {
        this.service = service;
    }

    @GET
    public Set<SubscriberAbstract> getSubscriber(@QueryParam("name")  String name,
                                               @QueryParam("lastname") String lastName) {
        return service.lookUpSubscriber(name,lastName);
    }

    @GET
    @Path("/{id}")
    public SubscriberAbstract getSubscriberById(@PathParam("id") long id) {
        return service.lookUpSubscriber("","").iterator().next();
    }

    @POST
    public SubscriberAbstract registerSubscriber(SubscriberPerson subscriber) {
        return service.registerNewSubscriber(subscriber);
    }

    @PUT
    public SubscriberAbstract registerSubscriber(@QueryParam("name")  String name,
                                                 @QueryParam("lastname") String lastName,
                                                 @QueryParam("address") String address,
                                                 @QueryParam("phone") String phone) {
        return service.registerNewSubscriber(name, lastName, address, phone);
    }

    @DELETE
    public Boolean deleteSubscriber() {
        return true;
    }
}
