package com.andieguo.arraydemo;

import junit.framework.TestCase;

/**
 * 
 * 类ArrayTester.java的实现描述：java数组遍历
 * @author andyguo.gd 2016年8月6日 下午1:12:36
 */
public class ArrayTester extends TestCase {

	public void test() {
		int[][] numbers = new int[][] { { 2, 3, 4, 5, 7, 8 }, { 20, 30, 40 }, { 200, 300 }, { 2000, 3000 } };
		//使用增强for循环
		for (int i[] : numbers) {
			for (int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	public void test2() {
		int[][] numbers = new int[][] { { 2, 3, 4, 5, 7, 8 }, { 20, 30, 40 }, { 200, 300 }, { 2000, 3000 } };
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[i].length; j++) {
				System.out.print(numbers[i][j] + " ");
			}
			System.out.println();
		}
	}

}
