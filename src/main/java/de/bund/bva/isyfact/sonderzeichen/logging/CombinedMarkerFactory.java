package de.bund.bva.isyfact.sonderzeichen.logging;

import java.util.Arrays;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * Factory for the construction of combinations of logging markers. Hierarchies of named markers may be built.
 */
public class CombinedMarkerFactory {

    public static final String KATEGORIE_JOURNAL = "JOURNAL";
    public static final String KATEGORIE_METRIK = "METRIK";
    public static final String KATEGORIE_PROFILING = "PROFILING";
    public static final String KATEGORIE_SICHERHEIT = "SICHERHEIT";
    public static final String TECHNIKDATEN = "Technikdaten";
    public static final String KATEGORIE = "kategorie";
    public static final String SCHLUESSEL = "schluessel";
    public static final String DATENTYP = "datentyp";
    private static final String ROOTMARKER = "rootmarker";

    /**
     * Return a root marker containing markers for Kategorie, Schluessel and Datentyp.
     *
     * @param kategorie  The value for the Kategorie.
     * @param schluessel The value for the Schluessel.
     * @param datentyp   The value for the Datentyp.
     *
     * @return The root marker.
     */
    public static Marker getKSDMarker(final String kategorie, final String schluessel, final String datentyp) {
        Marker rootMarker = createRootMarker();
        rootMarker.add(createMarker(KATEGORIE, kategorie));
        rootMarker.add(createMarker(SCHLUESSEL, schluessel));
        rootMarker.add(createMarker(DATENTYP, datentyp));
        return rootMarker;
    }

    /**
     * Returns a root marker.
     *
     * @return Root marker.
     */
    private static Marker createRootMarker() {
        Marker rootMarker = MarkerFactory.getMarker(ROOTMARKER);
        rootMarker.remove(MarkerFactory.getMarker(KATEGORIE));
        rootMarker.remove(MarkerFactory.getMarker(SCHLUESSEL));
        rootMarker.remove(MarkerFactory.getMarker(DATENTYP));
        return rootMarker;
    }

    /**
     * Creates a marker along with submarkers.
     *
     * @param name   Name of the main marker.
     * @param values Names of all submarkers.
     *
     * @return The marker containing its submarkers.
     */
    public static Marker createMarker(String name, String... values) {
        Marker marker = MarkerFactory.getMarker(name);
        Arrays.stream(values).forEach(value -> marker.add(MarkerFactory.getMarker(value)));
        return marker;
    }

    /**
     * Returns a category marker along with submarkers.
     *
     * @return The category marker containing its submarkers.
     */
    public static Marker createKategorieMarker(String... values) {
        Marker rootMarker = createRootMarker();
        rootMarker.add(createMarker(KATEGORIE, values));
        return rootMarker;
    }

    /**
     * Returns a key marker along with submarkers.
     *
     * @return The key marker containing its submarkers.
     */
    public static Marker createSchluesselMarker(String... values) {
        Marker rootMarker = createRootMarker();
        rootMarker.add(createMarker(SCHLUESSEL, values));
        return rootMarker;
    }

    /**
     * Returns a datatype marker along with submarkers.
     *
     * @return The datatype marker containing its submarkers.
     */
    public static Marker createDatentypMarker(String... values) {
        Marker rootMarker = createRootMarker();
        rootMarker.add(createMarker(DATENTYP, values));
        return rootMarker;
    }
}
