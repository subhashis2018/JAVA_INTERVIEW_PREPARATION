package com.myapp.java8.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Player implements Comparable<Player> {
	private int ranking;
	private String name;
	private int age;

	@Override
	public int compareTo(Player otherPlayer) {
		return Integer.compare(getRanking(), otherPlayer.getRanking());
	}
}
