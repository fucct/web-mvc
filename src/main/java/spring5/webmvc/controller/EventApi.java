package spring5.webmvc.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring5.webmvc.model.Event;
import spring5.webmvc.model.Events;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/events")
public class EventApi {


    @PostMapping
    public ResponseEntity<Events> createEvent(@RequestBody @Valid Events events, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<Events>(events, HttpStatus.CREATED);
        }
        return ResponseEntity.ok(events);
    }
}
