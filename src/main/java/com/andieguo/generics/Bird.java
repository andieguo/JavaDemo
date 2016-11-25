package com.andieguo.generics;

public class Bird extends Animal {

	public Bird(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public void fly(){
		System.out.println(this.getName() + " can fly.");
	}

}
