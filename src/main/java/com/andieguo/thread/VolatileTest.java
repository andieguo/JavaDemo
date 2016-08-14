package com.andieguo.thread;

public class VolatileTest {
	public static volatile int a = -1;
	
	public static void main(String[] args) {
		Thread thread1 = new Thread(){

			@Override
			public void run() {
				a = 10;
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				a = a + 1000;
			}
		};
		thread1.start();
		
		Thread thread2 = new Thread(){

			@Override
			public void run() {
				a = 100;
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				a = a + 1000;
			}
		};
		thread2.start();
		
	}
}
