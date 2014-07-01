package com.andieguo.collectionsdemo;

import java.util.Stack;

import junit.framework.TestCase;

public class StackDemo extends TestCase {

	public void push(Stack<Integer> st, int a) {
		st.push(new Integer(a));
	}

	public Integer pop(Stack<Integer> st) {
		if (!st.isEmpty()) {
			Integer a = st.pop();
			return a;
		}
		return null;

	}

	public void pushTest() {
		Stack<Integer> st = new Stack<Integer>();
		push(st, 1);
		push(st, 2);
		push(st, 3);
		push(st, 4);
		push(st, 5);
		System.out.println(st);
		pop(st);
		System.out.println(st);
		pop(st);
		pop(st);
		System.out.println(st);
		pop(st);
		pop(st);
		pop(st);
		System.out.println(st);
	}
}
