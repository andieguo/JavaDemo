package com.andieguo.collectionsdemo;

import java.util.Stack;
/**
 * ���ż��ƥ�䣨ʹ����ջ��
 * @author andieguo
 *
 */
public class ArithmeticTester {

	public static void expIsCorrect(String[] exp, int n) throws Exception {
		Stack mystack = new Stack();
		for (int i = 0; i < n; i++) {
			if ((exp[i].equals(new String("("))) || (exp[i].equals(new String("["))) || (exp[i].equals(new String("{")))) {
				mystack.push(exp[i]);
			} else {
				if ((exp[i].equals(new String(")"))) && mystack.empty() && mystack.peek().equals(new String("("))) {
					mystack.pop();
				} else {
					if ((exp[i].equals(new String(")"))) && mystack.empty() && !mystack.peek().equals(new String("("))) {
						System.out.println("��������ƥ�������ȷ��");
						return;
					} else {
						if ((exp[i].equals(new String("]"))) && mystack.empty() && mystack.peek().equals(new String("["))) {
							mystack.pop();
						} else {
							if ((exp[i].equals(new String("]"))) && mystack.empty() && !mystack.peek().equals(new String("["))) {
								System.out.println("��������ƥ�������ȷ��");
								return;
							} else {
								if ((exp[i].equals(new String("}"))) && mystack.empty() && mystack.peek().equals(new String("{"))) {
									mystack.pop();
								} else {
									if ((exp[i].equals(new String("}"))) && mystack.empty() && !mystack.peek().equals(new String("{"))) {
										System.out.println("��������ƥ�������ȷ��");
										return;
									} else {
										if (((exp[i].equals(new String(")"))) || (exp[i].equals(new String("]"))) || (exp[i].equals(new String("}")))) && !mystack.empty()) {
											System.out.println("�����Ŷ��������ţ�");
											return;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		if (mystack.empty()) {
			System.out.println("�����Ŷ��������ţ�");
		} else {
			System.out.println("����ƥ����ȷ��");
		}
	}
}
