package com.andieguo.utildemo;

public class HexTest {
	static int[] blooddata = new int[4];
	public static void main(String[] args) {
		blooddata[0] = (0x3D & 0xff) | ((0x00 << 8) & 0xff00);
		blooddata[1] = (0x6A & 0xff) | ((0x00 << 8) & 0xff00);
		blooddata[2] = (blooddata[0]+blooddata[1])/2;
		blooddata[3] = (0x3e & 0xff);
		for(int i : blooddata){
			System.out.println(i);
		}
	}
}
