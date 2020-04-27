package spring5.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spring5.webmvc.model.Events;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("events")
public class SampleController {

    private List<Events> eventList = new ArrayList<>();

    @GetMapping("/events/form/name")
    public String getName(Model model) {
        model.addAttribute("events", new Events("디디", 10));
        return "events/form-name";
    }

    @PostMapping("/events/form/name")
    public String postName(@Validated @ModelAttribute Events events, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "events/form-name";
        }
        return "redirect:/events/form/limit";
    }

    @GetMapping("/events/form/limit")
    public String getLimit(@ModelAttribute Events events, Model model) {
        model.addAttribute("events", events);
        return "events/form-limit";
    }

    @PostMapping("/events/form/limit")
    public String postLimit(@Validated @ModelAttribute Events events, BindingResult bindingResult,
                            SessionStatus sessionStatus,
                            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "events/form-limit";
        }
        eventList.add(events);
        redirectAttributes.addAttribute("name", events.getName());
        redirectAttributes.addAttribute("limit", events.getLimit());
        sessionStatus.setComplete();

        return "redirect:/events/list";
    }

    @GetMapping("/events/list")
    public String getEvents(Model model, @SessionAttribute("visitTime") LocalDateTime visitTime) {
        model.addAttribute("eventList", eventList);
        System.out.println(visitTime);
        return "events/list";
    }
}