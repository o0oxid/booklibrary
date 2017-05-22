package com.mycompany.app.restEndpoints.subscriber;

import com.google.inject.*;

import javax.inject.Named;

import com.mycompany.app.subscriber.SubscriberModule;
import com.mycompany.app.subscriber.SubscriptionService;

/**
 * Created by okhoruzhenko on 5/19/17.
 */
public class SubscriptionModule implements Module {
    @Override
    public void configure(Binder binder) {
    }

    @Provides
    @Named("SubscriptionService")
    public SubscriptionService provideSubscriptionService() {
        Injector injector = Guice.createInjector(new SubscriberModule());
        return injector.getInstance(SubscriptionService.class);
    }
}
