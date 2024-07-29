package de.bund.bva.isyfact.sonderzeichen.dinnorm91379.transformation.impl;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import de.bund.bva.isyfact.testutil.LoggingTest;
import de.bund.bva.isyfact.testutil.TestAppender;
import org.junit.Test;

import java.util.List;

import static de.bund.bva.isyfact.sonderzeichen.dinnorm91379.konstanten.EreignisSchluessel.TRANSFORMATION;
import static de.bund.bva.isyfact.sonderzeichen.logging.CombinedMarkerFactory.DATENTYP;
import static de.bund.bva.isyfact.sonderzeichen.logging.CombinedMarkerFactory.KATEGORIE;
import static de.bund.bva.isyfact.sonderzeichen.logging.CombinedMarkerFactory.KATEGORIE_JOURNAL;
import static de.bund.bva.isyfact.sonderzeichen.logging.CombinedMarkerFactory.SCHLUESSEL;
import static de.bund.bva.isyfact.sonderzeichen.logging.CombinedMarkerFactory.TECHNIKDATEN;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Tests for correct logging in class IdentischerTransformator.
 */
public class IdentischerTransformatorLoggingTest extends LoggingTest {
    IdentischerTransformator transformator;

    /**
     * Tests for correct logging in method initialise; without RuntimeException.
     */

    @Test
    public void testLogInitialisiere() {
        transformator = new IdentischerTransformator();

        transformator.initialisiere(null);

        List<ILoggingEvent> events = TestAppender.events;

        assertFalse(events.isEmpty());
        assertEquals(2, countAllLogEvents());
        ILoggingEvent event0 = events.get(0);
        assertEquals(Level.INFO, event0.getLevel());
        assertEquals("Initialisiere Transformator.", event0.getFormattedMessage());
        assertEventContainsMarker(event0, KATEGORIE, KATEGORIE_JOURNAL);
        assertEventContainsMarker(event0, SCHLUESSEL, TRANSFORMATION);
        assertEventContainsMarker(event0, DATENTYP, TECHNIKDATEN);

        ILoggingEvent event1 = events.get(1);
        assertEquals(Level.INFO, event1.getLevel());
        assertEquals("Lade Transformationstabelle: /resources/tabellen/transformation_dinnorm91379.transform",
                event1.getFormattedMessage());
        assertEventContainsMarker(event1, KATEGORIE, KATEGORIE_JOURNAL);
        assertEventContainsMarker(event1, SCHLUESSEL, TRANSFORMATION);
        assertEventContainsMarker(event1, DATENTYP, TECHNIKDATEN);
    }

    /**
     * Tests for correct logging in method initialise; with exception should occur.
     */
    @Test
    public void testLogInitialisiereMitException() {
        transformator = new IdentischerTransformator();
        String zusaetzlicheTabelle = "Nicht vorhandene Tabelle";
        try {
            transformator.initialisiere(zusaetzlicheTabelle);
        } catch (RuntimeException e) {
            List<ILoggingEvent> events = TestAppender.events;

            assertFalse(events.isEmpty());
            assertEquals(4, countAllLogEvents());

            ILoggingEvent event0 = events.get(0);
            assertEquals(Level.INFO, event0.getLevel());
            assertEquals("Initialisiere Transformator.", event0.getFormattedMessage());
            assertEventContainsMarker(event0, KATEGORIE, KATEGORIE_JOURNAL);
            assertEventContainsMarker(event0, SCHLUESSEL, TRANSFORMATION);
            assertEventContainsMarker(event0, DATENTYP, TECHNIKDATEN);

            ILoggingEvent event1 = events.get(1);
            assertEquals(Level.INFO, event1.getLevel());
            assertEquals("Lade Transformationstabelle: /resources/tabellen/transformation_dinnorm91379.transform",
                    event1.getFormattedMessage());
            assertEventContainsMarker(event1, KATEGORIE, KATEGORIE_JOURNAL);
            assertEventContainsMarker(event1, SCHLUESSEL, TRANSFORMATION);
            assertEventContainsMarker(event1, DATENTYP, TECHNIKDATEN);

            ILoggingEvent event2 = events.get(2);
            assertEquals(Level.INFO, event1.getLevel());
            assertEquals("Lade Transformationstabelle: " + zusaetzlicheTabelle,
                    event2.getFormattedMessage());
            assertEventContainsMarker(event2, KATEGORIE, KATEGORIE_JOURNAL);
            assertEventContainsMarker(event2, SCHLUESSEL, TRANSFORMATION);
            assertEventContainsMarker(event2, DATENTYP, TECHNIKDATEN);

            ILoggingEvent event3 = events.get(3);
            assertEquals(Level.ERROR, event3.getLevel());
            assertEquals("Fehler beim Laden der Transformationstabelle => Abbruch",
                    event3.getFormattedMessage());
            assertEventContainsMarker(event3, SCHLUESSEL, TRANSFORMATION);
        }
    }
}