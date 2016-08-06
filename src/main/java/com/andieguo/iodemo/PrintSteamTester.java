package com.andieguo.iodemo;

import java.io.PrintStream;

public class PrintSteamTester {
	public static void main(String[] args) {
		String s = "Hello World";
		PrintStream ps = new PrintStream(System.out);
		//特别注意：1、System.out返回的是一个PrintStream对象；2、PrintStream对象调用Println()方法打印字符串信息到console.
		ps.printf("This is a %s application", s);
		ps.flush();

	}
}
