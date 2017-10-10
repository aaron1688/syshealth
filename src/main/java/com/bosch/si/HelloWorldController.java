package com.bosch.si;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hi")
public class HelloWorldController {

    private static final String template = "Hello, %s!";
    private static final AtomicLong counter = new AtomicLong();

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody Greeting sayHello(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
    		long tempCounter = counter.incrementAndGet();
    		Date timeStamp = new Date();
    		String output = timeStamp.toString() + ": Got request: " + String.format(template, name) + " : " + tempCounter
    				+ " numberOfThreadInList:" + MemoryStressController.threadList.size() + " numberOfStringInList:" + MemoryStressController.memPressureList.size();
    		System.out.println(output);
        return new Greeting(tempCounter, output);
    }
     
}
