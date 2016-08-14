package com.andieguo.thread;

public class ThreadTest2 {
	public static void main(String[] args) {
		final Business business = new Business();
		new Thread(new Runnable() {
			public void run() {
				threadExecute(business, "sub");
			}
		}).start();
		threadExecute(business, "main");

 	}	
	public static void threadExecute(Business business, String threadType) {
		for(int i = 0; i < 10; i++) {
			try {
				if("main".equals(threadType)) {
					business.main(i);
				} else {
					business.sub(i);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
/**
sub thread seq of 0, loop of 0
sub thread seq of 1, loop of 0
main thread seq of 0, loop of 0
main thread seq of 1, loop of 0
main thread seq of 2, loop of 0
main thread seq of 3, loop of 0

sub thread seq of 0, loop of 1
sub thread seq of 1, loop of 1
main thread seq of 0, loop of 1
main thread seq of 1, loop of 1
main thread seq of 2, loop of 1
main thread seq of 3, loop of 1
 * @author Administrator
 *
 */
class Business {
	private boolean bool = true;
	public synchronized void main(int loop) throws InterruptedException {
		while(bool) {
			this.wait();
		}
		for(int i = 0; i < 4; i++) {
			System.out.println("main thread seq of " + i + ", loop of " + loop);
		}
		bool = true;
		this.notify();
	}	
	public synchronized void sub(int loop) throws InterruptedException {
		while(!bool) {
			this.wait();
		}
		for(int i = 0; i < 2; i++) {
			System.out.println("sub thread seq of " + i + ", loop of " + loop);
		}
		bool = false;
		this.notify();
	}
}
