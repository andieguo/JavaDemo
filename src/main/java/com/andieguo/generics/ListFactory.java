package com.andieguo.generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListFactory<T extends List>{

	private T t;
	
	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	/**
	 * 限制泛型可用类型
	 * 在定义泛型类别时，预设可以使用任何的类型来实例化泛型类型中的类型。
	 * 但是如果想限制使用泛型类别时，只能用某个特定类型或者是其子类型才能实例化该类型时，可以在定义类型时，使用extends关键字指定这个类型必须是继承某个类，或者实现某个接口，也可以是这个类或接口本身。
	 * 　此处注意，虽然List是一个接口，但是关键字仍然是extends而不是implements。
	 * @param args
	 */
	public static void main(String[] args) {
		ListFactory<ArrayList> listFactory = new ListFactory<ArrayList>();
		ListFactory<LinkedList> listFactory2 = new ListFactory<LinkedList>();

	}
	
}
