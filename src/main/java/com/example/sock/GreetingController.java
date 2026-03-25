package com.example.sock;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {


    @MessageMapping("/hello") // input
    @SendTo("/topic/greetings") // output
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000);

        Greeting greeting = new Greeting();
        greeting.setContent("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
        return greeting;
    }

}
