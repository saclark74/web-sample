package org.sample.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.sample.model.SampleData;

/**
 * Created by Scott on 6/12/2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GreetingDTO {

    public long id;
    public String usage;
    public String greeting;

    public GreetingDTO() {

    }

    public GreetingDTO(SampleData data) {

        this.id = data.getId();
        this.usage = data.getUsage();
        this.greeting = data.getGreeting();
    }

    public void toSampleData(SampleData data) {
        data.setGreeting(greeting);
        data.setUsage(usage);
    }
}
