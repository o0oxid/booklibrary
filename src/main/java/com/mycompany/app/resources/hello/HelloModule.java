package com.mycompany.app.resources.hello;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.mycompany.app.resources.ServerConfiguration;

import javax.inject.Named;

public class HelloModule implements Module{
    @Override
    public void configure(Binder binder) {
    }

    @Provides
    @Named("message")
    public String provideMessage(ServerConfiguration serverConfiguration) {
        return serverConfiguration.getMessage();
    }
}
