package org.sample.rest;

import org.omg.CORBA.Current;
import org.sample.rest.dto.GreetingDTO;
import org.sample.model.SampleData;
import org.sample.repository.SampleDataRepository;
import org.sample.service.currentuser.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Scott on 6/12/2015.
 */
@RestController
@RequestMapping(value = "/api/greeting")
public class GreetingController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    SampleDataRepository sampleDataRepository;


    @RequestMapping(value = "/{usage}", method = RequestMethod.GET )
    public GreetingDTO get(@PathVariable String usage) {

        SampleData data = sampleDataRepository.findByUsage(usage);
        return new GreetingDTO(data);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody GreetingDTO greetingDTO) {

        SampleData existing = sampleDataRepository.findByUsage(greetingDTO.usage);
        if(existing != null) {
            greetingDTO.toSampleData(existing);
            sampleDataRepository.save(existing);
            return new ResponseEntity<>(null, null, HttpStatus.OK);
        }
        SampleData data = new SampleData();
        greetingDTO.toSampleData(data);
        sampleDataRepository.save(data);

        return new ResponseEntity<>(null, null, HttpStatus.OK);
    }
}
