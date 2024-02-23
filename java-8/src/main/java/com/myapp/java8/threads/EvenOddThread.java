package com.myapp.java8.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class EvenOddThread {

	public static void main(String[] args) {
		AtomicInteger atom = new AtomicInteger(1);
		Runnable r = () -> {
			synchronized (atom) {
				while (atom.get() < 10) {
					if (Thread.currentThread().getName().equals("Even")) {
						System.out.println("Even" + atom.getAndIncrement());
					}
					System.out.println("Odd" + atom.getAndIncrement());
				}
			}
		};

		Thread t1 = new Thread(r, "Even");
		Thread t2 = new Thread(r, "Odd");
		t1.start();
		t2.start();
	}

}
