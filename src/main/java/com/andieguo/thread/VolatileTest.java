package com.andieguo.thread;

/**
	���̣߳�-1
	�߳�2��100
	�߳�1��10
	�߳�2-1��1010
	�߳�1-1��2010
 * @author Administrator
 *
 */
public class VolatileTest {
	public static volatile int a = -1;
	
	public static void main(String[] args) {
		Thread thread1 = new Thread(){

			@Override
			public void run() {
				a = 10;
				System.out.println("�߳�1��"+a);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				a = a + 1000;
				System.out.println("�߳�1-1��"+a);
			}
		};
		thread1.start();
		
		Thread thread2 = new Thread(){

			@Override
			public void run() {
				a = 100;
				System.out.println("�߳�2��"+a);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				a = a + 1000;
				System.out.println("�߳�2-1��"+a);
			}
		};
		thread2.start();
		System.out.println("���̣߳�"+a);
		
	}
}
