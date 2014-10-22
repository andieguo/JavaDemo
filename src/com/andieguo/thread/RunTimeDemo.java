package com.andieguo.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunTimeDemo {

	public static void main(String[] args){
		//runCommand();
		runCommand2();
	}
	/**
	 * û�з�����Ϣ
	 */
	private static void runCommand2() {
		try {
			//windows����
			//String cmd = "cmd.exe /c start F:\\hello.txt";
			String [] cmd={"cmd","/C","start F:\\hello.txt"};//��F:\\hello.txt
			Process proc =Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ִ��������ӡ������Ϣ
	 */
	private static void runCommand() {
		String command = "ipconfig";
		Runtime run = Runtime.getRuntime();
		try {
			Process p = run.exec(command);
			BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String strline;
			while((strline = in.readLine())!=null){
				System.out.println(strline);
			}
			if (p.waitFor() != 0) {  
                if (p.exitValue() == 1)//p.exitValue()==0��ʾ����������1������������  
                    System.err.println("����ִ��ʧ��!");  
            }  
			in.close();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
