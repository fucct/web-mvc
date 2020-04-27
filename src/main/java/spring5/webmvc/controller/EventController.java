package spring5.webmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import spring5.webmvc.service.EventService;

import java.util.Arrays;

@Controller
public class EventController {

    @Autowired
    private EventService eventService;

    @ModelAttribute
    public void categories(Model model){
        model.addAttribute("categories", Arrays.asList("a", "b", "c", "d"));
    }

    @GetMapping("/events")
    public String events(Model model) {
        model.addAttribute("events", eventService.getEvents());
        return "events.html";
    }
}
