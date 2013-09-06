package com.textjuicer.ruta.date;

import java.util.Scanner;

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

    public static void main(String[] args) throws Exception {
        // create the annotation engine to annotate dates
        final AnalysisEngine engine =
                AnalysisEngineFactory.createEngine("com.textjuicer.ruta.date.NaiveDateExtractorEngine");


        // Process System.in line by line and print dates as they are found
        final CAS cas = engine.newCAS();
        final Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            final String line = input.nextLine();

            // run ruta on the line
            cas.setDocumentText(line);
            engine.process(cas);

            // print dates
            System.out.println("Dates:");
            for (AnnotationFS date : CasUtil.select(cas, cas.getTypeSystem().getType(DATE_TYPE))) {
                System.out.println("  - " + date.getCoveredText());
            }
            System.out.println();

            // clean up the cas
            cas.reset();
        }
    }
}
