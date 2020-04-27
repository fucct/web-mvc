package spring5.webmvc.controller;

public class EventsException extends RuntimeException {
    public EventsException() {
    }

    public EventsException(final String message) {
        super(message);
    }
}
