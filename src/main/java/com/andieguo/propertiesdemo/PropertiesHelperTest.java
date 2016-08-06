package com.andieguo.propertiesdemo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;

import junit.framework.TestCase;

public class PropertiesHelperTest extends TestCase {

	public void getProperty() {
		System.out.println(PropertiesHelper.getProperty("KEY"));
	}

	public void store() {
		PropertiesHelper.setProperty("database", "bbs");// ��key-value�洢��prop�У�
		try {
			OutputStream out = new FileOutputStream("config.properties");
			PropertiesHelper.store(out, "modify" + new Date());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void storeXML(){
		try {
			OutputStream out = new FileOutputStream("config.xml");
			PropertiesHelper.storeXML(out, "modify" + new Date());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void setProperties(){
		PropertiesHelper.setProperty("Weight", "70");//ֻ�Ǵ洢�����ڴ棬��û�д洢���ļ�
		PropertiesHelper.printEntry();
	}
	
	public void put(){
		PropertiesHelper.put("Height", 20);//ֻ�Ǵ洢�����ڴ棬��û�д洢���ļ�
		PropertiesHelper.put("Scannable", true);
		PropertiesHelper.put("Weight", 70.0);
		PropertiesHelper.put("Weight", 80.0);//�滻
		PropertiesHelper.printEntry();
	}
	
	public void list(){
		PropertiesHelper.list(System.out);//ͨ������̨��ӡ����
	}

	public void printEntry() {
		PropertiesHelper.printEntry();
	}
	
	public void printKey(){
		PropertiesHelper.printKey();
	}
	
	public void printEnumeration(){
		PropertiesHelper.printEnumeration();
	}
}
