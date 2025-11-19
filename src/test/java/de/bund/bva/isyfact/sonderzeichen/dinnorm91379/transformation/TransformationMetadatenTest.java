package de.bund.bva.isyfact.sonderzeichen.dinnorm91379.transformation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.bund.bva.isyfact.sonderzeichen.dinnorm91379.transformation.impl.LegacyTransformator;
import de.bund.bva.isyfact.sonderzeichen.dinnorm91379.transformation.impl.TranskriptionTransformator;

public class TransformationMetadatenTest {

    /** String that is not changed by the TranskriptionTransformator. */
    public static final String STRING_KEINE_AENDERUNG = "STRING";

    /** Expected result after use of the TranskriptionTransformator on the prior string. */
    public static final String STRING_KEINE_AENDERUNG_EXPECTED = "STRING";

    /** String with characters that are changed to empty strings by the TranskriptionTransformator. */
    public static final String STRING_TRANSFORMIERT_AUF_LEER = "™A™r";

    /** Expected result after use of the TranskriptionTransformator on the prior string. */
    public static final String STRING_TRANSFORMIERT_AUF_LEER_EXPECTED = "AR";

    /** String with leading characters that are trimmed after a transformation. */
    public static final String STRING_ENTFERNE_PRAEFIX = "ツKÄÖ";

    /** Expected result after use of the TranskriptionTransformator on the prior string. */
    public static final String STRING_ENTFERNE_PRAEFIX_EXPECTED = "KAEOE";

    /** String with trailing characters that are trimmed after a transformation. */
    public static final String STRING_ENTFERNE_SUFFIX = "Iツ";

    /** Expected result after use of the TranskriptionTransformator on the prior string. */
    public static final String STRING_ENTFERNE_SUFFIX_EXPECTED = "I";

    /** String with characters that are transformed to consecutive spaces that are replaced by a single space. */
    public static final String STRING_ENTFERNE_MEHRERE_LEERZEICHEN = "Zツツツrツr";

    /** Expected result after use of the TranskriptionTransformator on the prior string. */
    public static final String STRING_ENTFERNE_MEHRERE_LEERZEICHEN_EXPECTED = "Z R R";

    /** String that will be shortened by the LegacyTransformator. */
    public static final String STRING_LEGACY_KUERZEN = "R̥̄C̨̆";

    /** Expected result after use of the LegacyTransformator on the prior string. */
    public static final String STRING_LEGACY_KUERZEN_EXPECTED = "RC";

    /** String that will be extended by the LegacyTransformator. */
    public static final String STRING_LEGACY_ERWEITERN = "™‰";

    /** Expected result after use of the LegacyTransformator on the prior string. */
    public static final String STRING_LEGACY_ERWEITERN_EXPECTED = "(TM)permil";


    @Test
    public void testKeineAenderung() {
        TranskriptionTransformator transkriptionTransformator = new TranskriptionTransformator();
        transkriptionTransformator.initialisiere(null);

        Transformation transformation = transkriptionTransformator.transformiereMitMetadaten(STRING_KEINE_AENDERUNG);

        Assertions.assertEquals(STRING_KEINE_AENDERUNG_EXPECTED, transformation.getTransformierterText());
        Assertions.assertTrue(transformation.getMetadatenList().isEmpty());
    }

    @Test
    public void testMapAufLeerstring() {
        TranskriptionTransformator transkriptionTransformator = new TranskriptionTransformator();
        transkriptionTransformator.initialisiere(null);

        Transformation transformation = transkriptionTransformator.transformiereOhneTrimMitMetadaten(STRING_TRANSFORMIERT_AUF_LEER);

        Assertions.assertEquals(STRING_TRANSFORMIERT_AUF_LEER_EXPECTED, transformation.getTransformierterText());
        Assertions.assertEquals(3, transformation.getMetadatenList().size());

        Assertions.assertEquals("™", transformation.getMetadatenList().getFirst().getAltesZeichen());
        Assertions.assertEquals("2122", transformation.getMetadatenList().getFirst().getAlteCodepoints());
        Assertions.assertEquals("", transformation.getMetadatenList().getFirst().getNeuesZeichen());
        Assertions.assertEquals("", transformation.getMetadatenList().getFirst().getNeueCodepoints());
        Assertions.assertEquals(0, transformation.getMetadatenList().getFirst().getAltePosition());
        Assertions.assertEquals(0, transformation.getMetadatenList().getFirst().getNeuePosition());

        Assertions.assertEquals("™", transformation.getMetadatenList().get(1).getAltesZeichen());
        Assertions.assertEquals("2122", transformation.getMetadatenList().get(1).getAlteCodepoints());
        Assertions.assertEquals("", transformation.getMetadatenList().get(1).getNeuesZeichen());
        Assertions.assertEquals("", transformation.getMetadatenList().get(1).getNeueCodepoints());
        Assertions.assertEquals(2, transformation.getMetadatenList().get(1).getAltePosition());
        Assertions.assertEquals(1, transformation.getMetadatenList().get(1).getNeuePosition());

        Assertions.assertEquals("r", transformation.getMetadatenList().get(2).getAltesZeichen());
        Assertions.assertEquals("0072", transformation.getMetadatenList().get(2).getAlteCodepoints());
        Assertions.assertEquals("R", transformation.getMetadatenList().get(2).getNeuesZeichen());
        Assertions.assertEquals("0052", transformation.getMetadatenList().get(2).getNeueCodepoints());
        Assertions.assertEquals(3, transformation.getMetadatenList().get(2).getAltePosition());
        Assertions.assertEquals(1, transformation.getMetadatenList().get(2).getNeuePosition());
    }

    @Test
    public void testEntfernePraefix() {
        TranskriptionTransformator transkriptionTransformator = new TranskriptionTransformator();
        transkriptionTransformator.initialisiere(null);
        Transformation transformation = transkriptionTransformator.transformiereMitMetadaten(STRING_ENTFERNE_PRAEFIX);
        Assertions.assertFalse(transformation.getMetadatenList().isEmpty());

        Assertions.assertEquals(STRING_ENTFERNE_PRAEFIX_EXPECTED, transformation.getTransformierterText());
        Assertions.assertEquals(3, transformation.getMetadatenList().size());

        Assertions.assertEquals("ツ", transformation.getMetadatenList().getFirst().getAltesZeichen());
        Assertions.assertEquals("30C4", transformation.getMetadatenList().getFirst().getAlteCodepoints());
        Assertions.assertEquals(" ", transformation.getMetadatenList().getFirst().getNeuesZeichen());
        Assertions.assertEquals("0020", transformation.getMetadatenList().getFirst().getNeueCodepoints());
        Assertions.assertEquals(0, transformation.getMetadatenList().getFirst().getAltePosition());
        Assertions.assertEquals(-1, transformation.getMetadatenList().getFirst().getNeuePosition());

        Assertions.assertEquals("Ä", transformation.getMetadatenList().get(1).getAltesZeichen());
        Assertions.assertEquals("00C4", transformation.getMetadatenList().get(1).getAlteCodepoints());
        Assertions.assertEquals("AE", transformation.getMetadatenList().get(1).getNeuesZeichen());
        Assertions.assertEquals("0041 + 0045", transformation.getMetadatenList().get(1).getNeueCodepoints());
        Assertions.assertEquals(2, transformation.getMetadatenList().get(1).getAltePosition());
        Assertions.assertEquals(1, transformation.getMetadatenList().get(1).getNeuePosition());

        Assertions.assertEquals("Ö", transformation.getMetadatenList().get(2).getAltesZeichen());
        Assertions.assertEquals("00D6", transformation.getMetadatenList().get(2).getAlteCodepoints());
        Assertions.assertEquals("OE", transformation.getMetadatenList().get(2).getNeuesZeichen());
        Assertions.assertEquals("004F + 0045", transformation.getMetadatenList().get(2).getNeueCodepoints());
        Assertions.assertEquals(3, transformation.getMetadatenList().get(2).getAltePosition());
        Assertions.assertEquals(3, transformation.getMetadatenList().get(2).getNeuePosition());
    }

    @Test
    public void testEntferneSuffix() {
        TranskriptionTransformator transkriptionTransformator = new TranskriptionTransformator();
        transkriptionTransformator.initialisiere(null);
        Transformation transformation = transkriptionTransformator.transformiereMitMetadaten(STRING_ENTFERNE_SUFFIX);
        Assertions.assertFalse(transformation.getMetadatenList().isEmpty());

        Assertions.assertEquals(STRING_ENTFERNE_SUFFIX_EXPECTED, transformation.getTransformierterText());
        Assertions.assertEquals(1, transformation.getMetadatenList().size());

        Assertions.assertEquals("ツ", transformation.getMetadatenList().getFirst().getAltesZeichen());
        Assertions.assertEquals("30C4", transformation.getMetadatenList().getFirst().getAlteCodepoints());
        Assertions.assertEquals(" ", transformation.getMetadatenList().getFirst().getNeuesZeichen());
        Assertions.assertEquals("0020", transformation.getMetadatenList().getFirst().getNeueCodepoints());
        Assertions.assertEquals(1, transformation.getMetadatenList().getFirst().getAltePosition());
        Assertions.assertEquals(-2, transformation.getMetadatenList().getFirst().getNeuePosition());
    }

    @Test
    public void testEntferneMehrereLeerzeichen() {
        TranskriptionTransformator transkriptionTransformator = new TranskriptionTransformator();
        transkriptionTransformator.initialisiere(null);
        Transformation transformation = transkriptionTransformator.transformiereMitMetadaten(STRING_ENTFERNE_MEHRERE_LEERZEICHEN);
        Assertions.assertFalse(transformation.getMetadatenList().isEmpty());

        Assertions.assertEquals(STRING_ENTFERNE_MEHRERE_LEERZEICHEN_EXPECTED, transformation.getTransformierterText());
        Assertions.assertEquals(6, transformation.getMetadatenList().size());

        Assertions.assertEquals("ツ", transformation.getMetadatenList().getFirst().getAltesZeichen());
        Assertions.assertEquals("30C4", transformation.getMetadatenList().getFirst().getAlteCodepoints());
        Assertions.assertEquals(" ", transformation.getMetadatenList().getFirst().getNeuesZeichen());
        Assertions.assertEquals("0020", transformation.getMetadatenList().getFirst().getNeueCodepoints());
        Assertions.assertEquals(1, transformation.getMetadatenList().getFirst().getAltePosition());
        Assertions.assertEquals(1, transformation.getMetadatenList().getFirst().getNeuePosition());

        Assertions.assertEquals("ツ", transformation.getMetadatenList().get(1).getAltesZeichen());
        Assertions.assertEquals("30C4", transformation.getMetadatenList().get(1).getAlteCodepoints());
        Assertions.assertEquals(" ", transformation.getMetadatenList().get(1).getNeuesZeichen());
        Assertions.assertEquals("0020", transformation.getMetadatenList().get(1).getNeueCodepoints());
        Assertions.assertEquals(2, transformation.getMetadatenList().get(1).getAltePosition());
        Assertions.assertEquals(1, transformation.getMetadatenList().get(1).getNeuePosition());

        Assertions.assertEquals("ツ", transformation.getMetadatenList().get(2).getAltesZeichen());
        Assertions.assertEquals("30C4", transformation.getMetadatenList().get(2).getAlteCodepoints());
        Assertions.assertEquals(" ", transformation.getMetadatenList().get(2).getNeuesZeichen());
        Assertions.assertEquals("0020", transformation.getMetadatenList().get(2).getNeueCodepoints());
        Assertions.assertEquals(3, transformation.getMetadatenList().get(2).getAltePosition());
        Assertions.assertEquals(1, transformation.getMetadatenList().get(2).getNeuePosition());

        Assertions.assertEquals("r", transformation.getMetadatenList().get(3).getAltesZeichen());
        Assertions.assertEquals("0072", transformation.getMetadatenList().get(3).getAlteCodepoints());
        Assertions.assertEquals("R", transformation.getMetadatenList().get(3).getNeuesZeichen());
        Assertions.assertEquals("0052", transformation.getMetadatenList().get(3).getNeueCodepoints());
        Assertions.assertEquals(4, transformation.getMetadatenList().get(3).getAltePosition());
        Assertions.assertEquals(2, transformation.getMetadatenList().get(3).getNeuePosition());

        Assertions.assertEquals("ツ", transformation.getMetadatenList().get(4).getAltesZeichen());
        Assertions.assertEquals("30C4", transformation.getMetadatenList().get(4).getAlteCodepoints());
        Assertions.assertEquals(" ", transformation.getMetadatenList().get(4).getNeuesZeichen());
        Assertions.assertEquals("0020", transformation.getMetadatenList().get(4).getNeueCodepoints());
        Assertions.assertEquals(5, transformation.getMetadatenList().get(4).getAltePosition());
        Assertions.assertEquals(3, transformation.getMetadatenList().get(4).getNeuePosition());

        Assertions.assertEquals("r", transformation.getMetadatenList().get(5).getAltesZeichen());
        Assertions.assertEquals("0072", transformation.getMetadatenList().get(5).getAlteCodepoints());
        Assertions.assertEquals("R", transformation.getMetadatenList().get(5).getNeuesZeichen());
        Assertions.assertEquals("0052", transformation.getMetadatenList().get(5).getNeueCodepoints());
        Assertions.assertEquals(6, transformation.getMetadatenList().get(5).getAltePosition());
        Assertions.assertEquals(4, transformation.getMetadatenList().get(5).getNeuePosition());
    }

    @Test
    public void testDinNormKuerzen() {
        LegacyTransformator legacyTransformator = new LegacyTransformator();
        legacyTransformator.initialisiere(null);
        Transformation transformation = legacyTransformator.transformiereMitMetadaten(STRING_LEGACY_KUERZEN);
        Assertions.assertFalse(transformation.getMetadatenList().isEmpty());

        Assertions.assertEquals(STRING_LEGACY_KUERZEN_EXPECTED, transformation.getTransformierterText());
        Assertions.assertEquals(2, transformation.getMetadatenList().size());

        Assertions.assertEquals("R̥̄", transformation.getMetadatenList().getFirst().getAltesZeichen());
        Assertions.assertEquals("0052 + 0325 + 0304", transformation.getMetadatenList().getFirst().getAlteCodepoints());
        Assertions.assertEquals("R", transformation.getMetadatenList().getFirst().getNeuesZeichen());
        Assertions.assertEquals("0052", transformation.getMetadatenList().getFirst().getNeueCodepoints());
        Assertions.assertEquals(0, transformation.getMetadatenList().getFirst().getAltePosition());
        Assertions.assertEquals(0, transformation.getMetadatenList().getFirst().getNeuePosition());

        Assertions.assertEquals("C̨̆", transformation.getMetadatenList().get(1).getAltesZeichen());
        Assertions.assertEquals("0043 + 0328 + 0306", transformation.getMetadatenList().get(1).getAlteCodepoints());
        Assertions.assertEquals("C", transformation.getMetadatenList().get(1).getNeuesZeichen());
        Assertions.assertEquals("0043", transformation.getMetadatenList().get(1).getNeueCodepoints());
        Assertions.assertEquals(3, transformation.getMetadatenList().get(1).getAltePosition());
        Assertions.assertEquals(1, transformation.getMetadatenList().get(1).getNeuePosition());
    }

    @Test
    public void testDinNormErweitern() {
        LegacyTransformator legacyTransformator = new LegacyTransformator();
        legacyTransformator.initialisiere(null);
        Transformation transformation = legacyTransformator.transformiereMitMetadaten(STRING_LEGACY_ERWEITERN);
        Assertions.assertFalse(transformation.getMetadatenList().isEmpty());

        Assertions.assertEquals(STRING_LEGACY_ERWEITERN_EXPECTED, transformation.getTransformierterText());
        Assertions.assertEquals(2, transformation.getMetadatenList().size());

        Assertions.assertEquals("™", transformation.getMetadatenList().getFirst().getAltesZeichen());
        Assertions.assertEquals("2122", transformation.getMetadatenList().getFirst().getAlteCodepoints());
        Assertions.assertEquals("(TM)", transformation.getMetadatenList().getFirst().getNeuesZeichen());
        Assertions.assertEquals("0028 + 0054 + 004D + 0029", transformation.getMetadatenList().getFirst().getNeueCodepoints());
        Assertions.assertEquals(0, transformation.getMetadatenList().getFirst().getAltePosition());
        Assertions.assertEquals(0, transformation.getMetadatenList().getFirst().getNeuePosition());

        Assertions.assertEquals("‰", transformation.getMetadatenList().get(1).getAltesZeichen());
        Assertions.assertEquals("2030", transformation.getMetadatenList().get(1).getAlteCodepoints());
        Assertions.assertEquals("permil", transformation.getMetadatenList().get(1).getNeuesZeichen());
        Assertions.assertEquals("0070 + 0065 + 0072 + 006D + 0069 + 006C", transformation.getMetadatenList().get(1).getNeueCodepoints());
        Assertions.assertEquals(1, transformation.getMetadatenList().get(1).getAltePosition());
        Assertions.assertEquals(4, transformation.getMetadatenList().get(1).getNeuePosition());
    }

}
