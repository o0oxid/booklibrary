package com.mycompany.app;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.mycompany.app.catalog.*;
import com.mycompany.app.subscriber.SubscriberAbstract;
import com.mycompany.app.subscriber.SubscriberModule;
import com.mycompany.app.subscriber.SubscriberServiceAPI;

import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Injector injector = Guice.createInjector(new SubscriberModule());
        SubscriberServiceAPI subscriberService = injector.getInstance(SubscriberServiceAPI.class);
        subscriberService.registerNewSubscriber("Oleg", "Khoruzhenko", "", "");

        Set<SubscriberAbstract> result =  subscriberService.lookUpSubscriber("Oleg", "");

        System.out.print(result);
    }
}
