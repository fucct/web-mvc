package spring5.webmvc.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring5.webmvc.model.Events;

@RestController
@RequestMapping("/api/events")
public class EventApi {


    @PostMapping
    public Events createEvent(HttpEntity<Events> request) {
        MediaType mediaType = request.getHeaders().getContentType();
        System.out.println(mediaType);
        return request.getBody();
    }
}
