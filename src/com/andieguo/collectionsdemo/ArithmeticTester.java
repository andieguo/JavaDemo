package com.andieguo.collectionsdemo;

import java.util.Stack;
/**
 * ¿®∫≈ºÏ≤‚∆•≈‰£® π”√¡À’ª£©
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
						System.out.println("◊Û”“¿®∫≈∆•≈‰¥Œ–Ú≤ª’˝»∑£°");
						return;
					} else {
						if ((exp[i].equals(new String("]"))) && mystack.empty() && mystack.peek().equals(new String("["))) {
							mystack.pop();
						} else {
							if ((exp[i].equals(new String("]"))) && mystack.empty() && !mystack.peek().equals(new String("["))) {
								System.out.println("◊Û”“¿®∫≈∆•≈‰¥Œ–Ú≤ª’˝»∑£°");
								return;
							} else {
								if ((exp[i].equals(new String("}"))) && mystack.empty() && mystack.peek().equals(new String("{"))) {
									mystack.pop();
								} else {
									if ((exp[i].equals(new String("}"))) && mystack.empty() && !mystack.peek().equals(new String("{"))) {
										System.out.println("◊Û”“¿®∫≈∆•≈‰¥Œ–Ú≤ª’˝»∑£°");
										return;
									} else {
										if (((exp[i].equals(new String(")"))) || (exp[i].equals(new String("]"))) || (exp[i].equals(new String("}")))) && !mystack.empty()) {
											System.out.println("”“¿®∫≈∂‡”⁄◊Û¿®∫≈£°");
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
			System.out.println("◊Û¿®∫≈∂‡”⁄”“¿®∫≈£°");
		} else {
			System.out.println("¿®∫≈∆•≈‰’˝»∑£°");
		}
	}
}
