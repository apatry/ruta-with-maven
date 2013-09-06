# Naive Date Extractor using Ruta

A small showcase on how to use [Ruta](http://uima.apache.org/ruta) inside a
maven project.

This project uses a Ruta script to annotate dates. The following type
of dates are recognized:

* 10/02/2013
* October 2nd, 2013
* October 2, 2013

You can run the extractor with the command `mvn compile
exec:java`. The output will look like:

	mvn compile exec:java
	[INFO] Scanning for projects...
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building Naive Date Extractor 1.0.0-SNAPSHOT
	[INFO] ------------------------------------------------------------------------
	[INFO] 
	...
	Extracting date from
	I will be out of office from September 2nd, 2013 to September 20th, 2013.
	Dates like 9/2/2013 and 9/20/13 are also recognized.
	Found: September 2nd, 2013
	Found: September 20th, 2013
	Found: 9/2/2013
	Found: 9/20/13
	...

You can update the `TEXT` constants in
`src/main/java/com/textjuicer/ruta/date/App.java` and rerun `mvn
compile exec:java` to test the system on your own text.
