/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * The Federal Office of Administration (Bundesverwaltungsamt, BVA)
 * licenses this file to you under the Apache License, Version 2.0 (the
 * License). You may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
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
