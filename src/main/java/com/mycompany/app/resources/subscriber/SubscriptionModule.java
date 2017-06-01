package com.mycompany.app.resources.subscriber;

import com.google.inject.*;

import com.mycompany.app.core.subscriber.SubscriberModule;
import com.mycompany.app.core.subscriber.SubscriptionService;
import com.mycompany.app.core.subscriber.Subscription;

/**
 * Created by okhoruzhenko on 5/19/17.
 */
public class SubscriptionModule implements Module {
    @Override
    public void configure(Binder binder) {

    }

    @Provides
    @Singleton
    public Subscription provideSubscriptionService() {
        Injector injector = Guice.createInjector(new SubscriberModule());
        return injector.getInstance(SubscriptionService.class);
    }
}
