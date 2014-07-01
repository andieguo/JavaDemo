package com.andieguo.utildemo;

import java.text.DecimalFormat;

public class DecimalFormatTest {
	public static void main(String[] args) {
		DecimalFormat df2= new DecimalFormat("0.0");
		System.out.println(df2.format(11111.111111));//1230.10
		
		DecimalFormat df4 = new DecimalFormat("#.00");
		System.out.println(df4.format(1230.1));//1230.10
		
		DecimalFormat df3 = new DecimalFormat("#.##");
		System.out.println(df3.format(1230.1));//1230.10
	}
}
