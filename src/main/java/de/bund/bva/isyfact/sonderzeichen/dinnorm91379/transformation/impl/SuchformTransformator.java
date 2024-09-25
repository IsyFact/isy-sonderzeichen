package de.bund.bva.isyfact.sonderzeichen.dinnorm91379.transformation.impl;

import de.bund.bva.isyfact.sonderzeichen.dinnorm91379.konstanten.TransformationsKonstanten;
import de.bund.bva.isyfact.sonderzeichen.dinnorm91379.transformation.Transformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Transformer that converts normative letters (datatype C) to the basic letters of the Latin alphabet (A-Z).
 * All other characters are transformed to space (0020). Implements Table 9 according to String.Latin+ 1.2.
 */
public class SuchformTransformator extends AbstractTransformator {

    /**
     * Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(SuchformTransformator.class);

    @Override
    protected String getStandardTransformationsTabelle() {
        return TransformationsKonstanten.TRANSFORMATIONS_TABELLE_SUCHFORM;
    }

    @Override
    protected Logger getLogger() {
        return SuchformTransformator.LOG;
    }

    @Override
    protected String getKategorieTabelle() {
        return TransformationsKonstanten.KATEGORIE_TABELLE;
    }

    @Override
    public Transformation transformiereMitMetadaten(String zeichenkette, int maximaleLaenge) {
        throw new UnsupportedOperationException("Diese Methode wird nicht unterstützt.");
    }

    @Override
    public String transformiere(String zeichenkette, int maximaleLaenge) {
        throw new UnsupportedOperationException("Diese Methode wird nicht unterstützt.");
    }

}
