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
        System.out.println("��ǰ��ϵͳʱ��Ϊ��"+simpleDateFormat.format(new Date()));  
	}

}
