package com.andieguo.reflectiondemo;

import java.lang.reflect.Method;
import java.util.Stack;

import junit.framework.TestCase;

//需求：什么时候要用到反射，比如说application要用到Activity里的方法，但是当Application运行起来的时候，Activity还没有运行起来
//如何通过class文件来调用Activity里的方法了？那么现在就要用到反射了。
//java.lang.reflect.Methods 是用来描述某个类中单个方法的一个类
public class DumpMethods extends TestCase {
	public static void main(String[] args) {
		getDeclaredMethods("java.util.Stack");
		// getDeclaredMethods("com.andieguo.reflectiondemo.DumpMethods");
	}

	// 特别注意：反射可以读取编译后的class文件，并遍历出里面有哪些方法。
	private static void getDeclaredMethods(String className) {
		// 的各方法名以及它们的限制符和返回类型。
		try {
			Class<?> c = Class.forName(className);// 使用 Class.forName 载入指定的类
			Method m[] = c.getDeclaredMethods();// 调用 getDeclaredMethods 来获取这个类中定义了的方法列表
			for (int i = 0; i < m.length; i++) {
				System.out.println(m[i].toString());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 获得一个 Class 对象的方法
	public void getClassTester() {
		try {
			Class<?> stringClass = Class.forName("java.lang.String");
			Class<?> intClass = int.class;
			Class<?> integerClass = Integer.class;

			System.out.println(integerClass.getDeclaredMethods()[0].toString());
			System.out.println(Stack.class.getDeclaredMethods()[0].toString());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Class.isInstance 方法可以用于模拟 instanceof 操作符
	public void isInstanceTest() {
		Class<?> c = DumpMethods.class;
		boolean b = c.isInstance(new DumpMethods());
		System.out.println(b);
	}

	public void invokeTest(){
		Class<?> c = Person.class;
		try{
			Method setNameMethod = c.getMethod("setName", String.class);
			Method getNameMethod = c.getMethod("getName", null);
			Person p = (Person) c.newInstance();//实例化类
			setNameMethod.invoke(p, "andy");
			String name = (String) getNameMethod.invoke(p, null);
			System.out.println(name);
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
	}
}
