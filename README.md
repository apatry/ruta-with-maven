# Naive Date Extractor using Ruta

A small showcase on how to use [Ruta](http://uima.apache.org/ruta) inside a
maven project.

## Running the Extractor

To run the extractor you can use the command `mvn compile
exec:java`. You will then be asked to type some text from which the
system will search dates. Here is an example :

	mvn compile exec:java
	[maven output]
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
