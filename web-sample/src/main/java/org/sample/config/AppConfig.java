package org.sample.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Scott on 6/8/2015.
 */
@Configuration
public class AppConfig {

    @Value("${app.hello-world-string}")
    public String helloWorldString;
}
