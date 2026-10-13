package com.example.strategy.purejava;

import com.example.strategy.common.SortingStrategy;

public class Sorter {
	private final SortingStrategy strategy;

	// Strategy injected via constructor
	public Sorter(SortingStrategy strategy) {
		this.strategy = strategy;
	}

	public void sortNumbers(int[] data) {
		strategy.sort(data);
	}
}
