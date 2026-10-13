package com.example.templatemethod.purejava;

public class PureJavaRunner {
	public static void main(String[] args) {
        System.out.println("=== CSV Processing ===");
        DataProcessor processor = new CSVProcessor();
        processor.process();   // template method

        System.out.println("\n=== XML Processing ===");
        processor = new XMLProcessor();
        processor.process();
    }
}
