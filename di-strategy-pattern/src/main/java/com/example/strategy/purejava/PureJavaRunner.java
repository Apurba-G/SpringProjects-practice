package com.example.strategy.purejava;

import com.example.strategy.common.BubbleSort;
import com.example.strategy.common.QuickSort;

public class PureJavaRunner {
	public static void main(String[] args) {
		int[] numbers = {5, 2, 8, 1};
		
		Sorter bubbleSorter = new Sorter(new BubbleSort());
        bubbleSorter.sortNumbers(numbers);   // Bubble Sort

        Sorter quickSorter = new Sorter(new QuickSort());
        quickSorter.sortNumbers(numbers);    // Quick Sort
	}
}
