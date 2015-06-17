package org.sample.ui;

import org.omg.CORBA.Current;
import org.sample.model.QSampleData;
import org.sample.service.currentuser.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.WebRequest;
import org.sample.config.AppConfig;
import org.sample.model.SampleData;
import org.sample.repository.SampleDataRepository;

/**
 * Created by Scott on 6/5/2015.
 */
@Controller
public class HelloWorldController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private AppConfig appConfig;

    @Autowired
    private WebApplicationContext context;


    @Autowired
    SampleDataRepository sampleDataRepository;


    @PreAuthorize("hasAuthority('ADMIN')")
//    @PreAuthorize("hasRole('ADMIN')") -- same thing
    @RequestMapping(value="/private")
    public String privateIndex(Model model, WebRequest request,
        @RequestParam(defaultValue = "Web")String usage ) {

        return index(model, request, usage);
    }


    @RequestMapping(value="/")
    public String  index(Model model, WebRequest request,
        @RequestParam(defaultValue = "Web")String usage ) {

        model.addAttribute("HelloWorldString", appConfig.helloWorldString);

        String profiles = String.join(",", context.getEnvironment().getActiveProfiles());
        model.addAttribute("ActiveProfiles", profiles);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();
        if(principal instanceof CurrentUser)
            model.addAttribute("User", ((CurrentUser) principal).getUser());
        else
            model.addAttribute("Name", principal);

        SampleData data;

        data = sampleDataRepository.findByUsage(usage);
        model.addAttribute("SampleDataGreetingConvention", data != null ? data.getGreeting() :
            "not-found");

        data = sampleDataRepository.findByUsageViaImplClass(usage);
        model.addAttribute("SampleDataGreetingImpl", data != null ? data.getGreeting() :
            "not-found");

        data = sampleDataRepository.findByUsageViaQueryAttribute(usage);
        model.addAttribute("SampleDataGreetingAttr", data != null ? data.getGreeting() :
            "not-found");

        data = sampleDataRepository.findByUsageViaQueryDSL(usage);
        model.addAttribute("SampleDataGreetingDSL", data != null ? data.getGreeting() :
            "not-found");

        QSampleData sampleData = QSampleData.sampleData;
        data = sampleDataRepository.findOne(sampleData.usage.eq(usage));
        model.addAttribute("SampleDataGreetingClientDSL", data != null ? data.getGreeting
            () :
            "not-found");

        log.trace("Hello World called - trace");
        log.debug("Hello World called - debug");
        log.info("Hello World called - info");
        log.warn("Hello World called - warn");
        log.error("Hello World called - error");

        return "hello-world";
    }
}
