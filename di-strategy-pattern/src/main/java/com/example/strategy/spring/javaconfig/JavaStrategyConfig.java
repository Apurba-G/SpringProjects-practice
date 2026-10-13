package com.example.strategy.spring.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.strategy.common.BubbleSort;
import com.example.strategy.common.QuickSort;
import com.example.strategy.common.SortingStrategy;

@Configuration
public class JavaStrategyConfig {
	@Bean
    public SortingStrategy bubbleSort() {
        return new BubbleSort();
    }

    @Bean
    public SortingStrategy quickSort() {
        return new QuickSort();
    }

    // SorterService needs a strategy – we'll choose bubbleSort here.
    @Bean
    public SorterService sorterService() {
        return new SorterService(bubbleSort());
    }
}
