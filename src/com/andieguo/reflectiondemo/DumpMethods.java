package com.andieguo.reflectiondemo;

import java.lang.reflect.Method;
import java.util.Stack;

import junit.framework.TestCase;

//����ʲôʱ��Ҫ�õ����䣬����˵applicationҪ�õ�Activity��ķ��������ǵ�Application����������ʱ��Activity��û����������
//���ͨ��class�ļ�������Activity��ķ����ˣ���ô���ھ�Ҫ�õ������ˡ�
//java.lang.reflect.Methods ����������ĳ�����е���������һ����
public class DumpMethods extends TestCase {
	public static void main(String[] args) {
		getDeclaredMethods("java.util.Stack");
		// getDeclaredMethods("com.andieguo.reflectiondemo.DumpMethods");
	}

	// �ر�ע�⣺������Զ�ȡ������class�ļ�������������������Щ������
	private static void getDeclaredMethods(String className) {
		// �ĸ��������Լ����ǵ����Ʒ��ͷ������͡�
		try {
			Class<?> c = Class.forName(className);// ʹ�� Class.forName ����ָ������
			Method m[] = c.getDeclaredMethods();// ���� getDeclaredMethods ����ȡ������ж����˵ķ����б�
			for (int i = 0; i < m.length; i++) {
				System.out.println(m[i].toString());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// ���һ�� Class ����ķ���
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

	// Class.isInstance ������������ģ�� instanceof ������
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
			Person p = (Person) c.newInstance();//ʵ������
			setNameMethod.invoke(p, "andy");
			String name = (String) getNameMethod.invoke(p, null);
			System.out.println(name);
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
	}
}
