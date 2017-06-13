package com.mycompany.app.resources.subscriber;

import com.google.inject.*;

import com.mycompany.app.core.subscriber.SubscriberModule;
import com.mycompany.app.core.subscriber.SubscriptionService;
import com.mycompany.app.core.subscriber.Subscription;

/**
 * Created by okhoruzhenko on 5/19/17.
 */
public class SubscriberResourceModule extends AbstractModule {
    @Override
    public void configure() {
        install(new SubscriberModule());
        bind(Subscription.class).to(SubscriptionService.class).in(Singleton.class);
    }

    /*@Provides
    @Singleton
    public Subscription provideSubscriptionService() {
        Injector injector = Guice.createInjector(new SubscriberModule());
        return injector.getInstance(SubscriptionService.class);
    }*/

}
