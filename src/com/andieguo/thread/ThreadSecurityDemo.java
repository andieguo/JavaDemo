package com.andieguo.thread;

public class ThreadSecurityDemo {
	private static   int sum = 10;
    
    public static void main(String[] args){
    	
    	Runnable runnable1 = new Runnable() {  
            public void run() {  
            	sum = sum + 1;
            } 
        }; 
        
    	Runnable runnable2 = new Runnable() {  
            public void run() {  
            	sum = sum - 1;
            } 
        }; 
        
        Thread thread2 = new Thread(runnable2);
    	Thread thread1 = new Thread(runnable1);
    	thread1.start();
    	thread2.start();
    	System.out.println(sum);
    }
}
