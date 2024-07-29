package de.bund.bva.isyfact.testutil;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Logback appender for usage in Junit tests. Gathers events like normal appenders. These events can be accessed in
 * tests. The TestAppender must be registered in logback-test.xml.
 */
public class TestAppender extends ListAppender<ILoggingEvent> {
    /**
     * The internal list of events, which can be directly accessed in tests.
     */
    public static List<ILoggingEvent> events = new ArrayList<>();

    public static List<ILoggingEvent> getLogEvents(String message, String level) {
        return events;
    }

    public static int countLogEvents(String message, String level) {
        return events.size();
    }

    public static boolean checkLogEvent(String message, String level) {
        return false;
    }

    public static List<ILoggingEvent> getAllLogEvents() {
        return events;
    }

    public static int countAllLogEvents() {
        return events.size();
    }

    /**
     * Creates a list of all events with a given level.
     *
     * @param logLevel The desired log level.
     * @return A list of all events with this level.
     */
    public static List<ILoggingEvent> getLogEvents(String logLevel) {
        return events.stream().filter(e -> e.getLevel().levelStr.equals(logLevel)).collect(Collectors.toList());
    }

    /**
     * Clears all events from the list.
     */
    public static void clearAllLogEvents() {
        events = new ArrayList<>();
    }

    /**
     * Hooks into the logging mechanism of logback. New events are added to the public events list.
     *
     * @param event The event to be added.
     */
    @Override
    public synchronized void doAppend(ILoggingEvent event) {
        events.add(event);
    }

}