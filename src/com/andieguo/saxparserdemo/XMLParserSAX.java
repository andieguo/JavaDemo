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
	//ʹ��SAXParser������ 
	public static List<Book> saxParser(File file) {
		try {
			// 1.������������
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();// ��ȡ����
			// 2.�õ�������
			SAXParser saxParser = saxParserFactory.newSAXParser();
			// 3.�õ����ݴ�����
			SaxHandler saxHandler = new SaxHandler();
			// 4.�����������ݴ�������������xml�ļ�
			saxParser.parse(file, saxHandler);
			List<Book> books = saxHandler.getBookList();
			return books;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//ʹ��XMLReader ������ 
	public static List<Book> xmlReader(File file) {
		try {
			// 1.�½�һ��������SAXParserFactory
			SAXParserFactory factory = SAXParserFactory.newInstance();
			// 2.�ù��������һ��SAX�Ľ�����SAXParser
			SAXParser parser = factory.newSAXParser();
			// 3.��SAXPsrser�еõ�һ��XMLReaderʵ��
			XMLReader reader = parser.getXMLReader();
			// 4.�õ����ݴ�����
			SaxHandler saxHandler = new SaxHandler();
			// 5.���Լ�д��handlerע�ᵽXMLReader�У�һ������Ҫ�ľ���ContentHandler
			reader.setContentHandler(saxHandler);
			// 6.��һ��xml�ĵ�������Դ���һ��java���Դ����InputStream���󣬽�����ʽ��ʼ
			reader.parse(new InputSource(new FileInputStream(file)));
			List<Book> books = saxHandler.getBookList();
			return books;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
