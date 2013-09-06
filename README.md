# Naive Date Extractor using Ruta

A small showcase on how to use [Ruta](http://uima.apache.org/ruta) inside a
maven project.

This project uses a Ruta script to annotate dates. The following type
of dates are recognized:

* 10/02/2013
* October 2nd, 2013
* October 2, 2013

You can run the extractor with the command `mvn compile
exec:java`. You will be asked to type some text from which to extract
dates. Here is an example session:

	mvn compile exec:java
	[INFO] Scanning for projects...
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building Naive Date Extractor 1.0.0-SNAPSHOT
	[INFO] ------------------------------------------------------------------------
	[INFO] 
	...
	Type in your text:
	I will be out of office from September 2nd 2013 to September 16th 2013.
	Dates:
	  - September 2nd 2013
      - September 16th 2013

	Shorter dates like 10/2/2013 and 10/16/2013 are also recognized
	Dates:
	  - 10/2/2013
	  - 10/16/2013
	[EOF]

The application reads line until you type the EOF character for your
operating system (ctrl-z for linux and ctrl-d for windows).
