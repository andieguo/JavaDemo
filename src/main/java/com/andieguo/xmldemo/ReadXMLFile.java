package com.andieguo.xmldemo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXMLFile {

	public static void main(String[] args) {
		File file = new File("src/com/andieguo/xmldemo/books.xml");
		List<Book> books = readXMLFile(file);
		for (Book book : books) {
			System.out.println(book.toString());
		}
	}

	public static List<Book> readXMLFile(File file) {
		List<Book> lists = new ArrayList<Book>();
		try {

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			NodeList bookList = doc.getElementsByTagName("book");
			for (int i = 0; i < bookList.getLength(); i++) {
				Node bookNode = bookList.item(i);
				if (bookNode.getNodeType() == Node.ELEMENT_NODE) {
					Element bookElement = (Element) bookNode;
					Book book = new Book();
					book.setCategory(bookElement.getAttribute("category"));
					Element titleElement = (Element) bookElement.getElementsByTagName("title").item(0);
					book.setTitle(titleElement.getTextContent());
					book.setTitleLang(titleElement.getAttribute("lang"));
					NodeList authorList = bookElement.getElementsByTagName("author");
					String author = "";
					for (int j = 0; j < authorList.getLength(); j++) {
						author = author + authorList.item(j).getTextContent() + "/";
					}
					author = author.substring(0, author.length() - 1);
					book.setAuthor(author);
					book.setYear(Integer.valueOf(bookElement.getElementsByTagName("year").item(0).getTextContent()));
					book.setPrice(Double.valueOf(bookElement.getElementsByTagName("price").item(0).getTextContent()));
					lists.add(book);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lists;
	}
}
