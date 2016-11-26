package com.andieguo.generics;

public class Animal {
	
	private String name;
	
	private Integer size;
	
	private Integer weight;
	
	public Animal(String name){
		this.name = name;
	}
	
	public Animal(Integer size, Integer weight) {
		super();
		this.size = size;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public void eat(){
		System.out.println(this.getName() + " cat eat.");
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", size=" + size + ", weight=" + weight + "]";
	}
	

}
