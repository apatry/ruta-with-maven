package com.textjuicer.ruta.date;

import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.text.AnnotationFS;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.util.CasUtil;

/**
 * Sample application to extract dates and date ranges from texts.
 * <p/>
 * This application reads System.in one line at a time. For each line, it prints the dates that were extracted.
 */
public class App {
    /**
     * UIMA type holding dates.
     */
    private static final String DATE_TYPE = "com.textjuicer.ruta.date.NaiveDateExtractor.Date";

    /**
     * Text to process.
     */
    private static final String TEXT =
            "I will be out of office from September 2nd, 2013 to September 20th, 2013.\n" +
                    "Dates like 9/2/2013 and 9/20/13 are also recognized.";

    public static void main(String[] args) throws Exception {
        final AnalysisEngine engine =
                AnalysisEngineFactory.createEngine("com.textjuicer.ruta.date.NaiveDateExtractorEngine");
        final CAS cas = engine.newCAS();

        cas.setDocumentText(TEXT);
        engine.process(cas);

        System.out.println("Extracting date from");
        System.out.println(TEXT);
        for (AnnotationFS date : CasUtil.select(cas, cas.getTypeSystem().getType(DATE_TYPE))) {
            System.out.println("Found: " + date.getCoveredText());
        }
    }
}
