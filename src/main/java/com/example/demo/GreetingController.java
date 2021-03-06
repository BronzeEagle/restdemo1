package com.example.demo;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	 private static final String template = "User info, %s!";
	 private final AtomicLong counter = new AtomicLong();

	    @RequestMapping("/getuser")
	    public Greeting greeting(@RequestParam(value="name", defaultValue="Krysta") String name,@RequestParam(value="lastname")String lastname) {
	        
	    	return new Greeting(counter.incrementAndGet(),String.format(template, name + " " + lastname));
	    }
}
