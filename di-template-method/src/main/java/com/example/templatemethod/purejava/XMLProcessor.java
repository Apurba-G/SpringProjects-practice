package com.example.templatemethod.purejava;

public class XMLProcessor extends DataProcessor{
	 @Override
	    protected void readData() {
	        System.out.println("Reading data from XML file.");
	    }

	    @Override
	    protected void processData() {
	        System.out.println("Processing XML data (DOM parsing).");
	    }

	    @Override
	    protected void writeData() {
	        System.out.println("Writing transformed XML to database.");
	    }
}
