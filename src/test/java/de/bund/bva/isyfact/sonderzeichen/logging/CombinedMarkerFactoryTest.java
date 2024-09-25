package de.bund.bva.isyfact.sonderzeichen.logging;

import junit.framework.TestCase;
import org.slf4j.Marker;

import static de.bund.bva.isyfact.sonderzeichen.logging.CombinedMarkerFactory.DATENTYP;
import static de.bund.bva.isyfact.sonderzeichen.logging.CombinedMarkerFactory.KATEGORIE;
import static de.bund.bva.isyfact.sonderzeichen.logging.CombinedMarkerFactory.SCHLUESSEL;

public class CombinedMarkerFactoryTest extends TestCase {
    static String TEST_KATEGORIE = "TestKategorie";
    static String TEST_SCHLUESSEL = "TestSchluessel";
    static String TEST_DATENTYP = "TestDatentyp";

    static String TEST_NAME = "TestName";
    static String TEST_VALUE = "TestValue";
    Marker rootMarker = CombinedMarkerFactory.createMarker(TEST_KATEGORIE, TEST_SCHLUESSEL, TEST_DATENTYP);
    Marker kategorieMarker = rootMarker.iterator().next();

    public void testGetKSDMarker() {
        Marker rootMarker = CombinedMarkerFactory.getKSDMarker(TEST_KATEGORIE, TEST_SCHLUESSEL, TEST_DATENTYP);
        Marker kategorieMarker = rootMarker.iterator().next();
        assertEquals(KATEGORIE, kategorieMarker.getName());
        Marker schluesselMarker = rootMarker.iterator().next();
        assertEquals(SCHLUESSEL, schluesselMarker.getName());
        Marker datentypMarker = rootMarker.iterator().next();
        assertEquals(DATENTYP, datentypMarker.getName());
    }

    public void testCreateMarker() {
        Marker rootMarker = CombinedMarkerFactory.createMarker(TEST_NAME, TEST_VALUE);
        Marker marker = rootMarker.iterator().next();
        assertEquals(TEST_NAME, marker.getName());
    }

    public void testCreateKategorieMarker() {
        Marker rootMarker = CombinedMarkerFactory.createKategorieMarker(KATEGORIE, CombinedMarkerFactory.KATEGORIE_JOURNAL);
        Marker kategorieMarker = rootMarker.iterator().next();
        assertEquals(KATEGORIE, kategorieMarker.getName());
    }

    public void testCreateSchluesselMarker() {
        Marker rootMarker = CombinedMarkerFactory.createSchluesselMarker(KATEGORIE, CombinedMarkerFactory.KATEGORIE_JOURNAL);
        Marker schluesselMarker = rootMarker.iterator().next();
        assertEquals(SCHLUESSEL, schluesselMarker.getName());
    }

    public void testCreateDatentypMarker() {
        Marker rootMarker = CombinedMarkerFactory.createDatentypMarker(KATEGORIE, CombinedMarkerFactory.KATEGORIE_JOURNAL);
        Marker datentypMarker = rootMarker.iterator().next();
        assertEquals(DATENTYP, datentypMarker.getName());
    }
}