package com.example.sock;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Controller
public class GreetingController {


    @MessageMapping("/hello") // input
    @SendTo("/topic/greetings") // output
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000);


        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");
        String time = LocalTime.now().format(fmt);

        Greeting greeting = new Greeting();
        greeting.setContent(time + " - " + HtmlUtils.htmlEscape(message.getName()));

        return greeting;
    }

}
