package com.myapp.java8.streams;

import java.util.Comparator;
import java.util.function.Function;

import com.myapp.java8.beans.Book;

public class StreamPractices1  {
	
	public static void main(String[] args) {
		
		Comparator<Book> byAuthor = Comparator.comparing(Book::getAuthor);
		Comparator<Book> byAuthorThenByPrice= Comparator.comparing(Book::getAuthor).thenComparing(Book::getPrice);
		//listOfBooks.sort(Comparator.comparing(Book::getAuthor).thenComparing(Book::getPrice));
		
		Function<String, Integer> func = x -> x.length();
		Function<Integer, Integer> func2 = x -> x * 2;
        Integer apply = func.apply("subhashis");   // 9
        System.out.println(apply);
		
	}

}
