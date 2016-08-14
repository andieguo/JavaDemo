package com.andieguo.xmldemo;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateXMLFile {

	public static void main(String[] args) {
		File file = new File("src/com/andieguo/xmldemo/books.xml");
		List<Book> books = ReadXMLFile.readXMLFile(file);
		createXMLFile(books);
	}
	
	public static void createXMLFile(List<Book> books) {
		Document doc;
		Element bookstore;
		Element book;
		Element title;
		Element author;
		Element year;
		Element price;
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
			doc = dbBuilder.newDocument();
			if (doc != null) {
				bookstore = doc.createElement("bookstore");
				for (int i = 0; i < books.size(); i++) {
					book = doc.createElement("book");
					book.setAttribute("category", books.get(i).getCategory());
					title = doc.createElement("title");
					title.appendChild(doc.createTextNode(books.get(i).getTitle()));
					title.setAttribute("lang", books.get(i).getTitleLang());
					book.appendChild(title);
					String[] strAuthor = books.get(i).getAuthor().split("/");
					for(int j=0;j<strAuthor.length;j++){
						author = doc.createElement("author");
						author.appendChild(doc.createTextNode(strAuthor[j]));
						book.appendChild(author);
					}
					year = doc.createElement("year");
					year.appendChild(doc.createTextNode(books.get(i).getYear().toString()));
					book.appendChild(year);
					price = doc.createElement("price");
					price.appendChild(doc.createTextNode(books.get(i).getPrice().toString()));
					book.appendChild(price);
					bookstore.appendChild(book); 
				}
				doc.appendChild(bookstore);
				
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				transformer.setOutputProperty(OutputKeys.ENCODING, "GB2312");
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(new File("src/com/andieguo/xmldemo/createbooks.xml"));
		 	 
				transformer.transform(source, result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
