package spring5.webmvc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import spring5.webmvc.model.Event;
import spring5.webmvc.model.Events;

public class EventsValidator implements Validator {
    @Override
    public boolean supports(final Class<?> clazz) {
        return Events.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(final Object target, final Errors errors) {
        Events events = (Events)target;
        if(events.getName().equals("ddd")){
            errors.rejectValue("name", "wrongValue", "the name is not validate");
        }
    }
}
