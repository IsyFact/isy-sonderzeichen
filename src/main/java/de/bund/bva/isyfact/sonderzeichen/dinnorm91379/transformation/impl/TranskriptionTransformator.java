package de.bund.bva.isyfact.sonderzeichen.dinnorm91379.transformation.impl;

import de.bund.bva.isyfact.sonderzeichen.dinnorm91379.konstanten.TransformationsKonstanten;
import de.bund.bva.isyfact.sonderzeichen.dinnorm91379.transformation.Transformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The transcription transformer.
 */
public class TranskriptionTransformator extends AbstractTransformator {

    /**
     * Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(TranskriptionTransformator.class);

    @Override
    protected String getStandardTransformationsTabelle() {
        return TransformationsKonstanten.TRANSFORMATIONS_TABELLE_TRANSKRIPTION;
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
