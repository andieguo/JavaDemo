package com.andieguo.arraydemo;

import junit.framework.TestCase;

public class ArrayTester extends TestCase {

	public void test() {
		int[][] numbers = new int[][] { { 2, 3, 4, 5, 7, 8 }, { 20, 30, 40 }, { 200, 300 }, { 2000, 3000 } };

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
