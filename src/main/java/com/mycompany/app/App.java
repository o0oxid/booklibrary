package com.mycompany.app;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.mycompany.app.models.SubscriberAbstract;
import com.mycompany.app.subscriber.SubscriberModule;
import com.mycompany.app.subscriber.SubscriptionService;

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
        SubscriptionService subscriberService = injector.getInstance(SubscriptionService.class);
        subscriberService.registerNewSubscriber("Oleg", "Khoruzhenko", "", "");

        Set<SubscriberAbstract> result =  subscriberService.lookUpSubscriber("Oleg", "");

        System.out.print(result);
    }
}
