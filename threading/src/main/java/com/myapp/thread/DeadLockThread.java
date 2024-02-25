package com.myapp.thread;

public class DeadLockThread {

	final static String R1 = "abc";
	final static String R2 = "xyz";

	public static void main(String[] args) {

		Thread T1 = new Thread() {
			@Override
			public void run() {
				synchronized (R1) {
					System.out.println("Thread T1 locked ->   Resource R1");
					synchronized (R2) {
						System.out.println("This will not execute because od dead-lock condition");
					}
				}
			}
		};

		Thread T2 = new Thread() {
			@Override
			public void run() {
				synchronized (R2) {
					System.out.println("Thread T2 locked ->   Resource R2");
					synchronized (R1) {
						System.out.println("This will not execute because od dead-lock condition");
					}
				}
			}
		};

		T1.start();
		T2.start();

	}

}
