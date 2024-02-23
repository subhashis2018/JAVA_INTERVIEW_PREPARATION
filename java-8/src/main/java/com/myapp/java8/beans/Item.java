package com.myapp.java8.beans;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {
	 private String name;
	    private int qty;
	    private BigDecimal price;

}
