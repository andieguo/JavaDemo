package com.andieguo.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

public class AnimalTest extends TestCase {
	
	private List<? extends Animal> animalList = new ArrayList<Animal>();
	
	//Cat是Animal的子类
	private List<? extends Animal> catList = new ArrayList<Cat>();
	
	//Bird是Magpie的父类
	private List<? super Magpie> birdList = new ArrayList<Bird>();
	
	//Animal是Magpie的父类
	private List<? super Magpie> magpieList = new ArrayList<Animal>();
	
	private List<? super Bird> birddList = new ArrayList<Bird>();

	//compare比较器
	public void testAct4(){
		birddList.add(new Magpie("mage"));
		birddList.add(new Bird("cat"));
		Arrays.asList("a", "b", "c");
		HashSet<String> s2 = new HashSet<String>(Arrays.asList("a", "b", "c"));
	}
	
	public void testAct3(){
		List<Animal> list = new ArrayList<Animal>();
		list.add(new Cat("cat1"));
		list.add(new Cat("bird1"));
		list.add(new Cat("magpie1"));
		List<? super Magpie> magpieList = list;
		Iterator<? super Magpie> iterator = magpieList.iterator();
		while(iterator.hasNext()){
			Cat cat = (Cat)iterator.next();
			cat.jump();
		}
	}


	public void act(List<Animal> list) {
		for (Animal animal : list) {
			animal.eat();
		}
	}
	
	/**
	 * 类型通配声明
	 * 使用<?>或是<? extends SomeClass>的声明方式，意味着您只能通过该名称来取得所参考的实例的信息，或者是移除某些信息，但不能增加或者改写它的信息。
	 * @param list
	 */
	public void act1(List<? extends Animal> list){
		list.add(null);
		//list.add(new Cat("cat1"));
		for (Animal animal : list) {
			animal.eat();
		}
	}
	
	public void testAct(){
		List<Animal> list = new ArrayList<Animal>();
		list.add(new Cat("cat1"));
		list.add(new Bird("bird1"));
		list.add(new Magpie("magpie1"));
		act(list);
		List<Cat> catList = new ArrayList<Cat>();
		catList.add(new Cat("cat1"));
		catList.add(new Cat("cat2"));
		catList.add(new Cat("cat3"));
		act(list);
	}
	
	public void testAct1(){
		List<Animal> list = new ArrayList<Animal>();
		list.add(new Cat("cat1"));
		list.add(new Bird("bird1"));
		list.add(new Magpie("magpie1"));
		act1(list);
		List<Cat> catList = new ArrayList<Cat>();
		catList.add(new Cat("cat1"));
		catList.add(new Cat("cat2"));
		catList.add(new Cat("cat3"));
		act1(catList);
	}
	
	

}
