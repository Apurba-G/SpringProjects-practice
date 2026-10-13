package com.example.strategy.spring.javaconfig;

import com.example.strategy.common.SortingStrategy;

public class SorterService {

	private final SortingStrategy strategy;

    public SorterService(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(int[] data) {
        strategy.sort(data);
    }
}
