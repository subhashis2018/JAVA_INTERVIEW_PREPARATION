package com.myapp.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

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

	}
}
