package com.andieguo.generics;

public class Magpie extends Bird {

	public Magpie(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public void sing(){
		System.out.println(getName() + " can not only eat,but sing");
	}

}
