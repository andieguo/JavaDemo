package com.andieguo.saxparserdemo;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

public class XMLParserSAX {

	public static void main(String[] args) {
		//List<Book> books = xmlReader(new File("src/com/andieguo/saxparserdemo/books.xml"));
		List<Book> books = saxParser(new File("src/com/andieguo/saxparserdemo/books.xml"));
		for (Book book : books) {
			System.out.println(book.toString());
		}
	}
	//使用SAXParser来解析 
	public static List<Book> saxParser(File file) {
		try {
			// 1.创建解析工厂
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();// 获取单例
			// 2.得到解析器
			SAXParser saxParser = saxParserFactory.newSAXParser();
			// 3.得到内容处理器
			SaxHandler saxHandler = new SaxHandler();
			// 4.解析器绑定内容处理器，并解析xml文件
			saxParser.parse(file, saxHandler);
			List<Book> books = saxHandler.getBookList();
			return books;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//使用XMLReader 来解析 
	public static List<Book> xmlReader(File file) {
		try {
			// 1.新建一个工厂类SAXParserFactory
			SAXParserFactory factory = SAXParserFactory.newInstance();
			// 2.让工厂类产生一个SAX的解析类SAXParser
			SAXParser parser = factory.newSAXParser();
			// 3.从SAXPsrser中得到一个XMLReader实例
			XMLReader reader = parser.getXMLReader();
			// 4.得到内容处理器
			SaxHandler saxHandler = new SaxHandler();
			// 5.把自己写的handler注册到XMLReader中，一般最重要的就是ContentHandler
			reader.setContentHandler(saxHandler);
			// 6.将一个xml文档或者资源变成一个java可以处理的InputStream流后，解析正式开始
			reader.parse(new InputSource(new FileInputStream(file)));
			List<Book> books = saxHandler.getBookList();
			return books;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
