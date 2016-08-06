package com.andieguo.stringdemo;

import junit.framework.TestCase;

public class StringTester extends TestCase{

	public void subStringTest(){
		String channel = "00:12:4B:00:02:60:E5:3D_A0";
		String mac = channel.substring(0, channel.length()-3);
		System.out.println(mac);//00:12:4B:00:02:60:E5:3D
	}
	
	public void  splitTest(){
		String channel = "00:12:4B:00:02:60:E5:3D_A0";
		String[] dat = channel.split("_");
		String mac = dat[0];// 00:12:4B:00:02:60:E5:3D
		String command = dat[1];//A0
		System.out.println("mac:"+mac+",command:"+command);
	}
	
	public String getChannel(){
		String command = "{A0=?}";
		String[] array = command.split("=");
		System.out.println(array[0].substring(1));
		return array[0].substring(0);
	}
}
