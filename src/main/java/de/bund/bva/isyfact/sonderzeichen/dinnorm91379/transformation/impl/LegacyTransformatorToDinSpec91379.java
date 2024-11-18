package de.bund.bva.isyfact.sonderzeichen.dinnorm91379.transformation.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.bund.bva.isyfact.sonderzeichen.dinnorm91379.konstanten.TransformationsKonstanten;
import de.bund.bva.isyfact.sonderzeichen.dinnorm91379.transformation.Transformation;

/**
 * Legacy transformator that converts texts containing characters of the DIN Norm 91379 into texts that
 * are compatible with DIN SPEC 91379.
 */
public class LegacyTransformatorToDinSpec91379 extends AbstractTransformator {

    /**
     * Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(LegacyTransformatorToDinSpec91379.class);

    @Override
    protected String getStandardTransformationsTabelle() {
        return TransformationsKonstanten.TRANSFORMATIONS_TABELLE_LEGACY_DINSPEC;
    }

    @Override
    protected String getKategorieTabelle() {
        return TransformationsKonstanten.KATEGORIE_TABELLE;
    }

    @Override
    protected Logger getLogger() {
        return LOG;
    }

    @Override
    public String transformiere(String zeichenkette, int maximaleLaenge) {
        throw new UnsupportedOperationException("Diese Funktion wird nicht unterstützt.");
    }

    @Override
    public Transformation transformiereMitMetadaten(String zeichenkette, int maximaleLaenge) {
        throw new UnsupportedOperationException("Diese Funktion wird nicht unterstützt.");
    }
}
