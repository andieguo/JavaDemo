package com.andieguo.propertiesdemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import junit.framework.TestCase;

public class PropertiesTester extends TestCase {

	public void writeProperties() {
		Properties properties = new Properties();
		OutputStream output = null;
		try {
			output = new FileOutputStream("config.properties");
			properties.setProperty("url", "jdbc:mysql://localhost:3306/");
			properties.setProperty("username", "root");
			properties.setProperty("password", "root");
			properties.setProperty("database", "bbs");//保存键值对到内存
			properties.store(output, "andieguo modify" + new Date().toString());// 保存键值对到文件中
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void loadProperties() {
		Properties properties = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("config.properties");
			properties.load(input);// 加载属性文件
			System.out.println("url:" + properties.getProperty("url"));
			System.out.println("username:" + properties.getProperty("username"));
			System.out.println("password:" + properties.getProperty("password"));
			System.out.println("database:" + properties.getProperty("database"));
		} catch (IOException io) {
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	//如果我们要读取的properties文件是放到classpath目录下(即放到src目录下，eclipse会将其自动编译到bin\目录下)
	public void loadClassPath() {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			String filename = "config.properties";
			input = PropertiesTester.class.getClassLoader().getResourceAsStream(filename);
			if (input == null) {
				System.out.println("Sorry, unable to find " + filename);
				return;
			}
			prop.load(input);
			System.out.println(prop.getProperty("KEY"));
			System.out.println(prop.getProperty("ID"));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void readFile(){
		//从当前类文件所在目录开始加载
		System.err.println(PropertiesTester.class.getResource("config.properties"));  
		//从classpath目录开始加载：项目的classpath的根文件夹
        System.err.println(PropertiesTester.class.getResource("/config.properties"));  
        /**
         * output
         * file:/E:/workspace_zonesion_5/JavaDemo/bin/com/andieguo/propertiesdemo/
         * file:/E:/workspace_zonesion_5/JavaDemo/bin/
         * 分析：
         * 1、如果加载文件时:文件名以""开头，则从类路径加载；
         * 2、如果加载文件时:文件名以"/"开头，则从
        **/
	}
	
	public void printAll() {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			String filename = "config.properties";
			input = getClass().getClassLoader().getResourceAsStream(filename);
			if (input == null) {
				System.out.println("Sorry, unable to find " + filename);
				return;
			}
			prop.load(input);
			//方法一：
			Set<Object> keys = prop.keySet();//返回属性key的集合
			for(Object key:keys){
				System.out.println("key:"+key.toString()+",value:"+prop.get(key));
			}
			//方法二：
			Set<Entry<Object, Object>> entrys =	prop.entrySet();//返回的属性键值对实体
			for(Entry<Object, Object> entry:entrys){
				System.out.println("key:"+entry.getKey()+",value:"+entry.getValue());
			}
			//方法三：
			Enumeration<?> e = prop.propertyNames();
			while (e.hasMoreElements()) {
				String key = (String) e.nextElement();
				String value = prop.getProperty(key);
				System.out.println("Key : " + key + ", Value : " + value);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
