package com.andieguo.thread;

//0、子线程与主线程以时间片轮转的方式交换CPU，执行threadExecute方法；第一次执行的是threadExecute(business, "sub")方法，即执行business.sub(i)方法，因为business.sub(i)是synchronized方法

//1、是否有可能，sub（0）还没循环结束（即执行了一半），就开始执行main(0);
//不可能，sub(0)通过synchronized独占了资源，即使轮到main(0)执行，main(0)也是执行等待，让sub(0)继续执行；

//2、是否有可能，threadExecute(business, "sub");执行的时间足够长，将sub（0）执行完之后，继续执行sub(1),sub（2），之后再将CPU交给threadExecute(business, "main");
//不可能，sub（0）执行完之后，自己就一直处于等待状态，除非执行完main方法，将bool变为false；

//3、sub(0) main(0)执行完一轮后，如何执行到下一轮；
//threadExecute(business, "sub");执行完sub（0）之后，该线程并没有执行完，只是处于等待状态。等待main(0)执行完之后，结束等待执行sub(1);

//子线程：sub(0) sub(1) sub(2)
//主线程：main(0) main(1) main(2)

//t1.Join（）方法的加入使得线程t1具有优先执行权。
public class ThreadTest2 {
	public static void main(String[] args) {
		final Business business = new Business();
		new Thread(new Runnable() {
			@Override
			public void run() {
				threadExecute(business, "sub");
			}
		}).start();//子线程
		threadExecute(business, "main");//主线程

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
		/*临界区*/
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
		/*临界区*/
		for(int i = 0; i < 2; i++) {
			System.out.println("sub thread seq of " + i + ", loop of " + loop);
		}
		bool = false;
		this.notify();//使得在等待竞争资源的main线程开始执行。
	}
}
/**
 * 
 * 异常：java.lang.IllegalMonitorStateException
 * 首先你要了解这个异常为什么会抛出，这个异常会在三种情况下抛出：
	1>当前线程不含有当前对象的锁资源的时候，调用obj.wait()方法;
	2>当前线程不含有当前对象的锁资源的时候，调用obj.notify()方法。
	3>当前线程不含有当前对象的锁资源的时候，调用obj.notifyAll()方法。
 * 
 * 最新解释：
 * main首先执行到synchronized main（0）,获得锁对象资源（就绪队列为空），bool = true，执行this.wait（）方法  释放锁对象 进入等待区等待；
 * 时间片轮转到sub执行synchronized sub（0），获得锁对象资源（就绪队列为空），bool = false,顺利执行完2次循环，将bool = false,并通知main进入就绪队列（此时sub仍拥有着锁对象），执行sub（2），进入等候队列，释放锁对象；
 * main获取锁对象，执行main（0）4次for循环。。。。。。。。
 */
