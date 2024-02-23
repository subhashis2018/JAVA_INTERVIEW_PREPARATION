package com.myapp.java8.streams;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

import java.math.BigDecimal;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.myapp.java8.beans.Item;

public class StreamPractices {

	public static void main(String[] args) {
		// Find all the even numbers from the list without duplicate ,
		List<Integer> numbers = Arrays.asList(1, 2, 3, 1, 3, 2, 4, 4, 5, 6, 4);
		numbers.stream().filter(i -> i % 2 == 0).distinct().collect(toList());

		// Given list return square of each numbers.
		List<Integer> numbers1 = Arrays.asList(5, 3, 7, 55, 19);
		numbers.stream().map(x -> x * x).collect(toList());

		// Find the first square that is divisible by 3
		List<Integer> someNumbers = Arrays.asList(5, 34, 7, 55, 19, 18, 34, 27);
		Optional<Integer> firstSquareDivisibleByThree = someNumbers.stream().map(x -> x * x).filter(x -> x % 3 == 0)
				.findFirst();

		// Given two list return all pairs of numbers.
		List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4);
		List<Integer> numbers3 = Arrays.asList(6, 7);

		// List<int[]> pairs=numbers.stream().flatMap().collect(toList());

		// Write down fibonacci series using stream .
		Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1] }).limit(10).map(t -> t[0])
				.forEach(System.out::println);

		// 3 apple, 2 banana, others 1
		List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");

		Map<String, Long> result = items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		Map<String, Long> finalMap = new LinkedHashMap<>();

		// Sort a map and add to finalMap
		result.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
				.forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

		System.out.println(finalMap);

		// 3 apple, 2 banana, others 1
		List<Item> items1 = Arrays.asList(new Item("apple", 10, new BigDecimal("9.99")),
				new Item("banana", 20, new BigDecimal("19.99")), new Item("orang", 10, new BigDecimal("29.99")),
				new Item("watermelon", 10, new BigDecimal("29.99")), new Item("papaya", 20, new BigDecimal("9.99")),
				new Item("apple", 10, new BigDecimal("9.99")), new Item("banana", 10, new BigDecimal("19.99")),
				new Item("apple", 20, new BigDecimal("9.99")));

		Map<String, Long> counting = items1.stream().collect(Collectors.groupingBy(Item::getName, Collectors.counting()));
		System.out.println(counting);

		Map<String, Integer> sum = items1.stream().collect(Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));
		System.out.println(sum);
	}
}
