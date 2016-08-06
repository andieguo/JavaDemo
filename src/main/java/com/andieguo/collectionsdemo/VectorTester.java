package com.andieguo.collectionsdemo;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class VectorTester {
	
	
	public static void main(String args[]) {
		
		vectortest();
	}
	//很值得注意的是:Vector可以填充不同类型的元素,那么List集合是否能做到了
	//capacity 与size的区别
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void vectortest() {
		// initial size is 3, increment is 2
		Vector v = new Vector(3, 2);
		System.out.println("Initial size: " + v.size());
		System.out.println("Initial capacity: " + v.capacity());
		v.addElement(new Integer(1));
		v.addElement(new Integer(2));
		v.addElement(new Integer(3));
		v.addElement(new Integer(4));
		System.out.println("Capacity after four additions: " + v.capacity());

		v.addElement(new Double(5.45));
		System.out.println("Current capacity: " + v.capacity());
		v.addElement(new Double(6.08));
		v.addElement(new Integer(7));
		System.out.println("Current capacity: " + v.capacity());
		v.addElement(new Float(9.4));
		v.addElement(new Integer(10));
		System.out.println("Current capacity: " + v.capacity());
		v.addElement(new Integer(11));
		v.addElement(new Integer(12));
		System.out.println("First element: " + (Integer) v.firstElement());
		System.out.println("Last element: " + (Integer) v.lastElement());
		if (v.contains(new Integer(3)))
			System.out.println("Vector contains 3.");
		// enumerate the elements in the vector.
		Enumeration vEnum = v.elements();
		System.out.println("\nElements in vector:");
		while (vEnum.hasMoreElements())
			System.out.print(vEnum.nextElement() + " ");
		System.out.println();
	}
	
	//很值得注意的是:Vector可以填充不同类型的元素,那么List集合是否能做到了
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void listTest(){
		List list = new ArrayList();
		list.add(new Integer(11));
		list.add(new Double(12.0));
		Iterator it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	

}
