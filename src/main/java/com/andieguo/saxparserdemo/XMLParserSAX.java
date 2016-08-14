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
	public static List<Book> saxParser(File file) {
		try {
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
			SAXParser saxParser = saxParserFactory.newSAXParser();
			SaxHandler saxHandler = new SaxHandler();
			saxParser.parse(file, saxHandler);
			List<Book> books = saxHandler.getBookList();
			return books;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static List<Book> xmlReader(File file) {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			XMLReader reader = parser.getXMLReader();
			SaxHandler saxHandler = new SaxHandler();
			reader.setContentHandler(saxHandler);
			reader.parse(new InputSource(new FileInputStream(file)));
			List<Book> books = saxHandler.getBookList();
			return books;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
