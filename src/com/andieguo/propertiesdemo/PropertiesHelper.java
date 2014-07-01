package com.andieguo.propertiesdemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Map.Entry;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

public class PropertiesHelper {

	private static Properties prop;
	static {//静态类加载时会先加载静态块方法
		loadProperty("config.properties");
	}

	// 加载属性文件
	public static void loadProperty(String filename) {
		prop = new Properties();
		try {//如果我们要读取的properties文件是放到classpath目录下(即放到src目录下，eclipse会将其自动编译到bin\目录下)
			InputStream inputStream = PropertiesHelper.class.getClassLoader().getResourceAsStream(filename);
			if (inputStream == null) {
				System.out.println("Sorry, unable to find " + filename);
				return;
			}
			prop.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 获取属性值
	public static String getProperty(String property) {
		return prop.getProperty(property);
	}

	// 设置属性值：注意区别，setProperty方法也是调用的put方法
	public static void setProperty(String key, String value) {
		prop.setProperty(key, value);
	}

	// 注意：比较put方法与setProperty方法的区别
	public static void put(Object key, Object value) {
		prop.put(key, value);
	}

	// 存储属性值到文件
	public static void store(OutputStream out, String comments) {
		try {
			prop.store(out, comments);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 存储属性值到XML文件
	public static void storeXML(OutputStream out, String comments) {
		try {
			prop.storeToXML(out, comments);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 获取Entry实体
	public static Set<Entry<Object, Object>> entrySet() {
		return prop.entrySet();
	}

	// 获取Key实体，为什么是set,无重复key
	public static Set<Object> keySet() {
		return prop.keySet();
	}

	// 获取Enumeration
	public static Enumeration<?> propertyNames(){
		return prop.propertyNames();
	}
	
	// 打印属性集合到PrintStream
	public static void list(PrintStream out){
		prop.list(out);
	}
	
	// 遍历属性实体
	public static void printEntry() {
		Set<Entry<Object, Object>> props = PropertiesHelper.entrySet();
		for (Entry<Object, Object> entrys : props) {
			System.out.println(entrys.getKey() + ":" + entrys.getValue());
		}
	}

	// 遍历属性KEY
	public static void printKey() {
		Set<Object> keys = PropertiesHelper.keySet();
		for (Object obj : keys) {
			System.out.println(obj + ":" + PropertiesHelper.getProperty(obj.toString()));
		}
	}
	
	// 遍历属性Enumeration
	public static void printEnumeration(){
		Enumeration<?> e = PropertiesHelper.propertyNames();
		while(e.hasMoreElements()){
			String key = (String) e.nextElement();
			String value = PropertiesHelper.getProperty(key);
			System.out.println(key+":"+value);
		}
	}

}
