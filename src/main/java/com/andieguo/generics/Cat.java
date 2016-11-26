package com.andieguo.generics;

public class Cat extends Animal {
	
	public Cat(String name) {
		super(name);
	}
	
	public void jump(){
		System.out.println(this.getName() + " can jump.");
	}
	
	

}
