package spring5.webmvc.service;

import org.springframework.stereotype.Service;
import spring5.webmvc.model.Event;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class EventService {

    public List<Event> getEvents(){
        Event event1 = Event.builder()
                .name("스프링 웹 MVC 스터디 1차")
                .limitOfEnrollment(5)
                .startDateTime(LocalDateTime.of(2019, 1, 1, 1, 1, 1))
                .endDateTime(LocalDateTime.of(2020, 1, 1, 1, 1, 1))
                .build();
        Event event2 = Event.builder()
                .name("스프링 웹 MVC 스터디 2차")
                .limitOfEnrollment(5)
                .startDateTime(LocalDateTime.of(2020, 1, 1, 1, 1, 1))
                .endDateTime(LocalDateTime.of(2021, 1, 1, 1, 1, 1))
                .build();

        return Arrays.asList(event1, event2);
    }
}
