package com.andieguo.thread;

import java.util.Timer;
/**
 * 
 * void cancel()   
          终止此计时器，丢弃所有当前已安排的任务。   
 int purge()   
          从此计时器的任务队列中移除所有已取消的任务。   
 void schedule(TimerTask task, Date time)   
          安排在指定的时间执行指定的任务。   
 void schedule(TimerTask task, Date firstTime, long period)   
          安排指定的任务在指定的时间开始进行重复的固定延迟执行。   
 void schedule(TimerTask task, long delay)   
          安排在指定延迟后执行指定的任务。   
 void schedule(TimerTask task, long delay, long period)   
          安排指定的任务从指定的延迟后开始进行重复的固定延迟执行。   
 void scheduleAtFixedRate(TimerTask task, Date firstTime, long period)   
          安排指定的任务在指定的时间开始进行重复的固定速率执行。   
 void scheduleAtFixedRate(TimerTask task, long delay, long period)   
          安排指定的任务在指定的延迟后开始进行重复的固定速率执行。   
 * @author Administrator
 *
 */
public class TimerDemo {
	/**
	 *   Timer类是一种线程设施，可以用来实现某一个时间或某一段时间后安排某一个任务执行一次或定期重复执行。该功能和TimerTask配合使用。TimerTask类用于实现由Timer安排的一次或重复执行的某个任务。每一个Timer对象对应的是一个线程，因此计时器所执行的任务应该迅速完成，否则会延迟后续的任务执行。 
	 * @param args
	 */
	public static void main(String args[]){
		Timer timer = new Timer();
		//timer.schedule(new TimerTaskDemo(), 1000);//延迟1s后执行该任务
		System.out.println("-----------");
		timer.schedule(new TimerTaskDemo(), 2000, 1000);//延迟1s后执行该任务，每隔1s执行该任务；
	}
}
