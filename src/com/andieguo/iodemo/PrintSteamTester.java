package com.andieguo.iodemo;

import java.io.PrintStream;

public class PrintSteamTester {
	public static void main(String[] args) {
		String s = "Hello World";
		PrintStream ps = new PrintStream(System.out);
		//�ر�ע�⣺1��System.out���ص���һ��PrintStream����2��PrintStream�������Println()������ӡ�ַ�����Ϣ��console.
		ps.printf("This is a %s application", s);
		ps.flush();

	}
}
