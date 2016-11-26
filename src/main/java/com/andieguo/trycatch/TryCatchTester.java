package com.andieguo.trycatch;

import junit.framework.TestCase;

public class TryCatchTester extends TestCase {

	public int add(int a,int b){
		System.out.println("执行add方法");
		throw new NullPointerException();
//		return a+b;
	}
	//除非调用system.exit()让程序退出或断电等因素致使程序中止，否则，无论任何因素，finally块都一定会执行！！
	public int add1(){
		try {
			//finally在return语句之后，跳转到上一级程序之前执行。
			System.out.println("执行test1的try方法");
			int result = add(1, 2);
			System.out.println("执行完add方法");
//			return result;
		} catch (Exception e) {
			System.out.println("执行catch方法");
			return -2;
		} finally {//finally一定会执行，在return之前。（准确说，应该是return ;语句）
			System.out.println("执行test1的finally方法");
		}
		return -1;
	}
	
	public void test1(){
		System.out.println(add1());
	}
}
