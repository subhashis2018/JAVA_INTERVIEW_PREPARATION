package com.myapp.java8.java_practices;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class JavaPracticesOne {

	public static int generateFib(int n) {
		if (n <= 1) {
			return n;
		}
		return generateFib(n - 1) + generateFib(n - 2);
	}

	public static int[] getFib(int n) {
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = generateFib(i);
			System.out.println(generateFib(i));
		}
		return result;
	}

	public void getKeyFromValue() {
		Map<String, String> map = new HashMap<String, String>();

		map.put("abc", "123");
		map.put("xyz", "456");

		for (Entry<String, String> entry : map.entrySet()) {
			if (entry.getValue().equalsIgnoreCase("456")) {
				System.out.println(entry.getKey());
			}
		}
	}

	public static void main(String[] args) {
		getFib(5);
	}

}
