package com.myapp.java8.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Book implements Comparable<Book> {

	private String title;
	private String author;
	private int price;

	@Override
	public int compareTo(Book b) {
		int i = this.title.compareTo(b.title);
		if (i != 0)
			return i;
		i = this.author.compareTo(b.author);
		if (i != 0)
			return i;
		return Integer.compare(this.price, b.price);
	}

}
