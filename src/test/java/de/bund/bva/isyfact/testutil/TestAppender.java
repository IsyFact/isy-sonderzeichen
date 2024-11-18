package de.bund.bva.isyfact.testutil;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.slf4j.Marker;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;

/**
 * Logback appender for usage in JUnit tests. Gathers events like normal appenders.
 * These events can be accessed in tests wth <code>TestAppender.events</code>.
 * The TestAppender must be registered, e.g. in logback-test.xml.
 * The class contains many convenience methods for accessing and checking log events,
 * which can be static-imported into a test class.
 */
public class TestAppender extends ListAppender<ILoggingEvent> {
    /**
     * The internal list of events, which can be directly accessed in tests.
     */
    private static List<ILoggingEvent> events = new ArrayList<>();

    /**
     * Creates a list of all events with a given level.
     *
     * @param logLevel The desired log level.
     *
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
     * Checks if an event contains a marker with a given value.
     *
     * @param event       The event.
     * @param markerName  The name of the marker.
     * @param markerValue The value of the marker.
     *
     * @return true, if event contains marker, else false.
     */
    private static boolean eventContainsMarker(ILoggingEvent event, String markerName, String markerValue) {
        Marker rootmarker = event.getMarkerList().get(0);

        Stream<Marker> markers = StreamSupport.stream(Spliterators.spliteratorUnknownSize(rootmarker.iterator(),
            Spliterator.ORDERED), false);

        return markers.anyMatch(m -> m.getName().equals(markerName) &&
            m.iterator().next().getName().equals(markerValue));
    }

    /**
     * Asserts if a given log event contains a marker with a given name and value.
     *
     * @param event       The log event.
     * @param markerName  The name of the marker.
     * @param markerValue The value of the marker.
     */
    public static void assertEventContainsMarker(ILoggingEvent event, String markerName, String markerValue) {
        assertTrue(eventContainsMarker(event, markerName, markerValue));
    }

    /**
     * Returns the number of log events.
     *
     * @param level The desired log level.
     *
     * @return The number of log events.
     */
    public static int countLogEvents(Level level) {
        return getLogEvents(level).size();
    }

    /**
     * Returns all log events with a given level.
     *
     * @param level The desired log level.
     *
     * @return All log events with the specified level.
     */
    public static List<ILoggingEvent> getLogEvents(Level level) {
        return events.stream().filter(e -> e.getLevel() == level).collect(Collectors.toList());
    }

    /**
     * Returns all log events.
     *
     * @return All log events.
     */
    public static List<ILoggingEvent> getLogEvents() {
        return events;
    }

    /**
     * Returns the number of log events.
     *
     * @return The number of log events.
     */
    public static int countLogEvents() {
        return events.size();
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

