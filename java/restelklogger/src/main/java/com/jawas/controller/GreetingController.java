package com.jawas.controller;

import com.jawas.model.Greeting;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController
{
    private static Logger log = LogManager.getLogger(GreetingController.class);
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name)
    {
        if (counter.incrementAndGet() >= 3)
        {
            counter.set(0);
            log.warn("Counter overhead!!");
        }

        Greeting greeting = new Greeting(counter.get(), String.format(template, name));
        log.debug("Returned: " + greeting.toString());

        return greeting;
    }
}
