package de.bund.bva.isyfact.testutil;

import ch.qos.logback.classic.spi.ILoggingEvent;
import org.slf4j.Marker;

import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.junit.Assert.assertTrue;


/**
 * Abstract base class for Unit tests which test logging.
 * <p>
 * Provides convenience methods to access log events. Mor convenience method should be added if desired.
 */

public abstract class LoggingTest {

    /**
     * Checks if an event contains a marker with a given value.
     *
     * @param event       The event.
     * @param markerName  The name of the marker.
     * @param markerValue The value of the marker.
     * @return true, if event contains marker, else false.
     */
    private static boolean eventContainsMarker(ILoggingEvent event, String markerName, String markerValue) {
        Marker rootmarker = event.getMarkerList().get(0);

        Stream<Marker> markers = StreamSupport.stream(Spliterators.spliteratorUnknownSize(rootmarker.iterator(),
                Spliterator.ORDERED), false);

        Marker mark = rootmarker.iterator().next().iterator().next();

        return markers.anyMatch(m -> m.getName().equals(markerName) &&
                m.iterator().next().getName().equals(markerValue));
    }

    public static void assertEventContainsMarker(ILoggingEvent event, String markerName, String markerValue) {
        assertTrue(eventContainsMarker(event, markerName, markerValue));
    }

    public List<ILoggingEvent> getLogEvents(final String message, final String level) {
        return TestAppender.getLogEvents(message, level);
    }


    public int countLogEvents(final String message, final String level) {
        return TestAppender.countLogEvents(message, level);
    }

    public boolean checkLogEvent(final String message, final String level) {
        return TestAppender.checkLogEvent(message, level);
    }


    public List<ILoggingEvent> getAllLogEvents() {
        return TestAppender.getAllLogEvents();
    }


    public int countAllLogEvents() {
        return TestAppender.countAllLogEvents();
    }

    public void deleteLogEvents() {
        TestAppender.clearAllLogEvents();
    }

    public List<ILoggingEvent> getLogEvents(final String logLevel) {
        return TestAppender.getLogEvents(logLevel);
    }
}
