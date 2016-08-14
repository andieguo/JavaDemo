package com.andieguo.thread;

import java.util.Timer;

public class TimerDemo {
	public static void main(String args[]){
		Timer timer = new Timer();
		System.out.println("-----------");
		timer.schedule(new TimerTaskDemo(), 2000, 1000);
	}
}
