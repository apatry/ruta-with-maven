package com.textjuicer.ruta.date;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.text.AnnotationFS;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.util.CasUtil;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.InvalidXMLException;
import org.junit.Test;

public class AppTest {

	@Test
	public void test() throws InvalidXMLException,
			ResourceInitializationException, IOException,
			AnalysisEngineProcessException {
		final AnalysisEngine engine = AnalysisEngineFactory
				.createEngine("com.textjuicer.ruta.date.NaiveDateExtractorEngine");
		final CAS cas = engine.newCAS();

		cas.setDocumentText(App.TEXT);
		engine.process(cas);

		AnnotationFS[] dates = CasUtil.select(cas,
				cas.getTypeSystem().getType(App.DATE_TYPE)).toArray(
				new AnnotationFS[0]);
		assertEquals(4, dates.length);

		assertEquals("September 2nd, 2013", dates[0].getCoveredText());
		assertEquals("September 20th, 2013", dates[1].getCoveredText());
		assertEquals("9/2/2013", dates[2].getCoveredText());
		assertEquals("9/20/13", dates[3].getCoveredText());
	}
}
