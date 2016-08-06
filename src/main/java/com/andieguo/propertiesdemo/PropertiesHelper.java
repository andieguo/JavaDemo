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
	static {//��̬�����ʱ���ȼ��ؾ�̬�鷽��
		loadProperty("config.properties");
	}

	// ���������ļ�
	public static void loadProperty(String filename) {
		prop = new Properties();
		try {//�������Ҫ��ȡ��properties�ļ��Ƿŵ�classpathĿ¼��(���ŵ�srcĿ¼�£�eclipse�Ὣ���Զ����뵽bin\Ŀ¼��)
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

	// ��ȡ����ֵ
	public static String getProperty(String property) {
		return prop.getProperty(property);
	}

	// ��������ֵ��ע������setProperty����Ҳ�ǵ��õ�put����
	public static void setProperty(String key, String value) {
		prop.setProperty(key, value);
	}

	// ע�⣺�Ƚ�put������setProperty����������
	public static void put(Object key, Object value) {
		prop.put(key, value);
	}

	// �洢����ֵ���ļ�
	public static void store(OutputStream out, String comments) {
		try {
			prop.store(out, comments);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// �洢����ֵ��XML�ļ�
	public static void storeXML(OutputStream out, String comments) {
		try {
			prop.storeToXML(out, comments);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ��ȡEntryʵ��
	public static Set<Entry<Object, Object>> entrySet() {
		return prop.entrySet();
	}

	// ��ȡKeyʵ�壬Ϊʲô��set,���ظ�key
	public static Set<Object> keySet() {
		return prop.keySet();
	}

	// ��ȡEnumeration
	public static Enumeration<?> propertyNames(){
		return prop.propertyNames();
	}
	
	// ��ӡ���Լ��ϵ�PrintStream
	public static void list(PrintStream out){
		prop.list(out);
	}
	
	// ��������ʵ��
	public static void printEntry() {
		Set<Entry<Object, Object>> props = PropertiesHelper.entrySet();
		for (Entry<Object, Object> entrys : props) {
			System.out.println(entrys.getKey() + ":" + entrys.getValue());
		}
	}

	// ��������KEY
	public static void printKey() {
		Set<Object> keys = PropertiesHelper.keySet();
		for (Object obj : keys) {
			System.out.println(obj + ":" + PropertiesHelper.getProperty(obj.toString()));
		}
	}
	
	// ��������Enumeration
	public static void printEnumeration(){
		Enumeration<?> e = PropertiesHelper.propertyNames();
		while(e.hasMoreElements()){
			String key = (String) e.nextElement();
			String value = PropertiesHelper.getProperty(key);
			System.out.println(key+":"+value);
		}
	}

}
