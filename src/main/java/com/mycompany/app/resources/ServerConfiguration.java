package com.mycompany.app.resources;

/**
 * Created by okhoruzhenko on 5/3/17.
 */

import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class ServerConfiguration extends Configuration {
    @NotEmpty
    private String message;

    public String getMessage() {
        return message;
    }
}
