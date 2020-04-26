package spring5.webmvc.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class SampleController {

    @GetMapping("/events")
    public String events() {
        return "hello";
    }

    @GetMapping("/events/{id}")
    public String eventsByPath(@PathVariable Integer id) {
        return "hello " + id;
    }

    @PostMapping(value = "/events", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String content(){
        return "hello";
    }

    @DeleteMapping("/events/{id}")
    public String deleteByPath(@PathVariable Integer id) {
        return "delete " + id;
    }

}
