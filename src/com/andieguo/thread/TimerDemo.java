package com.andieguo.thread;

import java.util.Timer;
/**
 * 
 * void cancel()   
          ��ֹ�˼�ʱ�����������е�ǰ�Ѱ��ŵ�����   
 int purge()   
          �Ӵ˼�ʱ��������������Ƴ�������ȡ��������   
 void schedule(TimerTask task, Date time)   
          ������ָ����ʱ��ִ��ָ��������   
 void schedule(TimerTask task, Date firstTime, long period)   
          ����ָ����������ָ����ʱ�俪ʼ�����ظ��Ĺ̶��ӳ�ִ�С�   
 void schedule(TimerTask task, long delay)   
          ������ָ���ӳٺ�ִ��ָ��������   
 void schedule(TimerTask task, long delay, long period)   
          ����ָ���������ָ�����ӳٺ�ʼ�����ظ��Ĺ̶��ӳ�ִ�С�   
 void scheduleAtFixedRate(TimerTask task, Date firstTime, long period)   
          ����ָ����������ָ����ʱ�俪ʼ�����ظ��Ĺ̶�����ִ�С�   
 void scheduleAtFixedRate(TimerTask task, long delay, long period)   
          ����ָ����������ָ�����ӳٺ�ʼ�����ظ��Ĺ̶�����ִ�С�   
 * @author Administrator
 *
 */
public class TimerDemo {
	/**
	 *   Timer����һ���߳���ʩ����������ʵ��ĳһ��ʱ���ĳһ��ʱ�����ĳһ������ִ��һ�λ����ظ�ִ�С��ù��ܺ�TimerTask���ʹ�á�TimerTask������ʵ����Timer���ŵ�һ�λ��ظ�ִ�е�ĳ������ÿһ��Timer�����Ӧ����һ���̣߳���˼�ʱ����ִ�е�����Ӧ��Ѹ����ɣ�������ӳٺ���������ִ�С� 
	 * @param args
	 */
	public static void main(String args[]){
		Timer timer = new Timer();
		//timer.schedule(new TimerTaskDemo(), 1000);//�ӳ�1s��ִ�и�����
		System.out.println("-----------");
		timer.schedule(new TimerTaskDemo(), 2000, 1000);//�ӳ�1s��ִ�и�����ÿ��1sִ�и�����
	}
}
