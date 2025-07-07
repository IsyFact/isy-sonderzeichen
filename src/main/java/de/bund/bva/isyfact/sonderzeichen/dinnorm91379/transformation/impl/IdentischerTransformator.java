package de.bund.bva.isyfact.sonderzeichen.dinnorm91379.transformation.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.bund.bva.isyfact.sonderzeichen.dinnorm91379.konstanten.TransformationsKonstanten;
import de.bund.bva.isyfact.sonderzeichen.dinnorm91379.transformation.Transformation;

/**
 * The transformer for identical string Latin characters.
 */
public class IdentischerTransformator extends AbstractTransformator {

    /**
     * Logger.
     */

    private static final Logger LOG = LoggerFactory.getLogger(IdentischerTransformator.class);

    @Override
    public String transformiere(String zeichenkette, int maximaleLaenge) {
        throw new UnsupportedOperationException("Diese Funktion wird nicht unterstützt.");
    }

    @Override
    public Transformation transformiereMitMetadaten(String zeichenkette, int maximaleLaenge) {
        throw new UnsupportedOperationException("Diese Funktion wird nicht unterstützt.");
    }

    @Override
    protected String getStandardTransformationsTabelle() {
        return TransformationsKonstanten.TRANSFORMATIONS_TABELLE_IDENTISCH;
    }

    @Override
    protected Logger getLogger() {
        return LOG;
    }

    @Override
    protected String getKategorieTabelle() {
        return TransformationsKonstanten.KATEGORIE_TABELLE;
    }

}
