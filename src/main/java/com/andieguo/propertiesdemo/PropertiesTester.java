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
			properties.setProperty("database", "bbs");
			properties.store(output, "andieguo modify" + new Date().toString());
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
			properties.load(input);
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
		System.err.println(PropertiesTester.class.getResource("config.properties"));  
        System.err.println(PropertiesTester.class.getResource("/config.properties"));  
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
			Set<Object> keys = prop.keySet();
			for(Object key:keys){
				System.out.println("key:"+key.toString()+",value:"+prop.get(key));
			}
			Set<Entry<Object, Object>> entrys =	prop.entrySet();
			for(Entry<Object, Object> entry:entrys){
				System.out.println("key:"+entry.getKey()+",value:"+entry.getValue());
			}
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
