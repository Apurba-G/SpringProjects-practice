package com.example.strategy.spring.xml;

import com.example.strategy.common.SortingStrategy;

public class XmlSorter {
	private final SortingStrategy strategy;

    public XmlSorter(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(int[] data) {
        strategy.sort(data);
    }
}
