package com.mycompany.app.restEndpoints.subscriber;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.mycompany.app.models.SubscriberAbstract;
import com.mycompany.app.subscriber.SubscriptionService;

import java.util.Optional;


/**
 * Created by okhoruzhenko on 5/8/17.
 */
@Path("api/v1/sub/register")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public class SubscriptionResource {
    SubscriptionService service;

    @Inject
    public SubscriptionResource(@Named("SubscriptionService") SubscriptionService service) {
        this.service = service;
    }

    @POST
    public SubscriberAbstract registerSubscriber(@QueryParam("name")  String name,
                                                 @QueryParam("lastname") String lastName,
                                                 @QueryParam("address") String address,
                                                 @QueryParam("phone") String phone) {
        return service.registerNewSubscriber(name, lastName, address, phone);
    }
}
