package com.andieguo.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

public class TimerTaskDemo extends TimerTask{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		SimpleDateFormat simpleDateFormat=null;  
        simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        System.out.println("当前的系统时间为："+simpleDateFormat.format(new Date()));  
	}

}
