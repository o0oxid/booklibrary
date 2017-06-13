package com.mycompany.app;


import com.hubspot.dropwizard.guice.GuiceBundle;
import com.mycompany.app.core.subscriber.SubscriberModule;
import com.mycompany.app.resources.ServerConfiguration;
import com.mycompany.app.resources.hello.HelloModule;
import com.mycompany.app.resources.subscriber.SubscriberResourceModule;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ServerApplication extends Application<ServerConfiguration> {
    @Override
    public void initialize(Bootstrap<ServerConfiguration> bootstrap) {
        
        GuiceBundle<ServerConfiguration> guiceBundle = GuiceBundle.<ServerConfiguration>newBuilder()
                .addModule(new HelloModule())
                .addModule(new SubscriberResourceModule())
                .setConfigClass(ServerConfiguration.class)
                .enableAutoConfig(getClass().getPackage().getName())
                .build();
        bootstrap.addBundle(guiceBundle);
    }

    @Override
    public void run(ServerConfiguration configuration, Environment environment) throws Exception {
    }

    public static void main(String[] args) throws Exception {
        new ServerApplication().run(args);
    }
}
