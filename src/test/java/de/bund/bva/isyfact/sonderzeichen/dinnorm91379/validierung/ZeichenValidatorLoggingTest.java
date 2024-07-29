package de.bund.bva.isyfact.sonderzeichen.dinnorm91379.validierung;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.LoggingEvent;
import de.bund.bva.isyfact.testutil.LoggingTest;
import org.junit.Test;

import java.util.List;

import static de.bund.bva.isyfact.sonderzeichen.dinnorm91379.konstanten.EreignisSchluessel.VALIDIERUNG;
import static de.bund.bva.isyfact.sonderzeichen.logging.CombinedMarkerFactory.DATENTYP;
import static de.bund.bva.isyfact.sonderzeichen.logging.CombinedMarkerFactory.KATEGORIE;
import static de.bund.bva.isyfact.sonderzeichen.logging.CombinedMarkerFactory.KATEGORIE_JOURNAL;
import static de.bund.bva.isyfact.sonderzeichen.logging.CombinedMarkerFactory.SCHLUESSEL;
import static de.bund.bva.isyfact.sonderzeichen.logging.CombinedMarkerFactory.TECHNIKDATEN;
import static org.junit.Assert.assertEquals;

/**
 * Test for the logging output of ZeichensatzValidator.
 */
public class ZeichenValidatorLoggingTest extends LoggingTest {
    ZeichenValidator validator;

    @Test
    public void testConstructorLog() {
        validator = new ZeichenValidator();
        List<ILoggingEvent> events = getAllLogEvents();
        assertEquals(1, countAllLogEvents());
        LoggingEvent event = (LoggingEvent) events.get(0);
        assertEquals(Level.INFO, event.getLevel());
        assertEquals("Erstelle ZeichenValidator.", event.getMessage());
        assertEventContainsMarker(event, KATEGORIE, KATEGORIE_JOURNAL);
        assertEventContainsMarker(event, SCHLUESSEL, VALIDIERUNG);
        assertEventContainsMarker(event, DATENTYP, TECHNIKDATEN);
    }
}
