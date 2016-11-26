package com.andieguo.lang3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;

import com.andieguo.generics.Animal;
import com.andieguo.generics.Bird;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * 来源于 http://www.programcreek.com
 * @author andyguo.gd
 *
 */
public class SimpleJavaTester extends TestCase {
	
	@SuppressWarnings("unused")
	public void testArrayDefine(){
		String[] aArray = new String[5];//指定长度
		String[] bArray = {"a","b","c", "d", "e"};
		String[] cArray = new String[]{"a","b","c","d","e"};//直接初始化，间接指定长度
	}
	
	/**
	 * 数组转型
	 */
	public void testArrayPrimitive(){
		// convert Integer[] to int[]
		Integer[] array = new Integer[]{1,2,3,4,5,6,6};
		int[] primitive = ArrayUtils.toPrimitive(array);
		System.out.println(ArrayUtils.toString(primitive));
		// convert int[] to Integer
		Integer[] arrayNew = ArrayUtils.toObject(primitive);
		System.out.println(ArrayUtils.toString(arrayNew));
	}
	
	/**
	 * convert List<Integer> to int[]
	 * 1)将List<Integer> to Integer[]
	 * 2)将Integer[] to int[]
	 */
	public void testConvert1(){
		Integer[] array = new Integer[]{1,2,3,4,5,6,6};
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(array));
		Integer[] arrayNew = new Integer[list.size()];//指定数组长度
		list.toArray(arrayNew);
		int[] primitiveNew = ArrayUtils.toPrimitive(arrayNew);
		System.out.println(ArrayUtils.toString(primitiveNew));
	}
	
	/**
	 * convert int[] to List<Integer>
	 * 1 将int[] to Integer[]
	 * 2 将Integer[] to List<Integer>
	 */
	public void testConvert2(){
		int[] array = new int[]{1,2,3,4,5,6,6};
		Integer[] arrayNew = ArrayUtils.toObject(array);
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(arrayNew));
		System.out.println(list);
	}

	/**
	 * 将array转换成List/set
	 */
	public void testArrayToList(){
		Integer[] array = new Integer[]{1,2,3,4,5,6,6};
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(array));
		Set<Integer> set = new HashSet<Integer>(Arrays.asList(array));
		list.add(7);//supported
		System.out.println(list);
		System.out.println(set);
	}
	
	/**
	 * Covnert an ArrayList to an array
	 */
	public void testListToArray(){
		ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));
		String[] array = new String[list.size()];//指定数组长度
		list.toArray(array);
		System.out.println(ArrayUtils.toString(array));
	}
	
	/**
	 * asList的使用误区
	 */
	public void testAsList(){
		Integer[] array = new Integer[]{1,2,3,4,5,6};
		List<Integer> list = Arrays.asList(array);
		Assert.assertEquals(true, list.contains(6));//supported
		list.add(7);//java.lang.UnsupportedOperationException
		System.out.println(list);
	}
	
	/**
	 * 从array中remove元素
	 */
	public void testRemoveElemFromArray(){
        String[] array = {"one", "three", "two", "four"};
        array = ArrayUtils.remove(array, 0);
        array = ArrayUtils.removeElement(array, "four");//一定要重新赋值给array
        System.out.println(ArrayUtils.toString(array));
	}
	
	/**
	 * 从List中remove元素
	 */
	public void testRemoveElemFromList(){
		ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()){
			String elm = iterator.next();
			if(elm.equals("a")){
				iterator.remove();
			}
		}
		System.out.println(list);
	}
	
	/**
	 * Reverse an array
	 */
	public void testReverseArray(){
        String[] array = {"one", "three", "two", "four"};
		ArrayUtils.reverse(array);
		System.out.println(ArrayUtils.toString(array));
	}
	
	/**
	 * Reverse an list
	 */
	public void testReverseList(){
		//TODO
	}
	
	public void testSortArray(){
        String[] array = {"one", "three", "two", "four"};
        //打印字符串数组
        System.out.println("source:"+ArrayUtils.toString(array));
        //binarySearch使用的是compareTo比较方法
        System.out.println("index:"+Arrays.binarySearch(array, "one"));
        Arrays.sort(array);
        System.out.println("sort1:"+ArrayUtils.toString(array));
        System.out.println("index:"+Arrays.binarySearch(array, "one"));
        Arrays.sort(array, new Comparator<String>() {

			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
			
		});
        System.out.println("sort2:"+ArrayUtils.toString(array));
        System.out.println("index:"+Arrays.binarySearch(array, "one"));
	}
	
	public void testSortArrayObject(){
		//public static <T> void sort(T[] a,Comparator<? super T> c)
		Animal[] array = {new Animal(1,2),new Animal(2,3),new Animal(3,4)};
		List<Animal> list = new ArrayList<Animal>(Arrays.asList(array));
		Comparator<Animal> comparator = new Comparator<Animal>() {

			public int compare(Animal o1, Animal o2) {
				// TODO Auto-generated method stub
				return o2.getSize().compareTo(o1.getSize());
			}
		};
		list.sort(comparator);
		System.out.println(list);
		
		Bird[] birdArray = {new Bird(10,20),new Bird(30,40),new Bird(50,60)};
		List<Bird> birdList = new ArrayList<Bird>(Arrays.asList(birdArray));
		birdList.sort(comparator);
		System.out.println(birdList);
	}
	
	public void testCollection(){
		Collections.emptyList();
		Collections.copy(null, null);
		Collections.sort(null);
	}
}
