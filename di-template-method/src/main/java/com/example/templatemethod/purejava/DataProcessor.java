package com.example.templatemethod.purejava;

public abstract class DataProcessor {

	// Template method – defines the skeleton, calls abstract steps
	public final void process() {
        readData();
        processData();
        writeData();
    }
	
	 // Steps to be implemented by subclasses
	protected abstract void readData();
	protected abstract void processData();
	
	// Hook – default implementation (can be overridden)
	protected void writeData() {
        System.out.println("Writing data to default output...");
    }
}
