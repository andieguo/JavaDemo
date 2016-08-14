package com.andieguo.saxparserdemo;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.helpers.AttributesImpl;

public class CreateXMLFile {


	public static void main(String[] args) {
		List<Book> books = XMLParserSAX.xmlReader(new File("src/com/andieguo/saxparserdemo/books.xml"));
		createXML(books);
		
	}

	public static void createXML(List<Book> books) {

		try {
			SAXTransformerFactory factory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
			TransformerHandler handler = factory.newTransformerHandler();
			Transformer info = handler.getTransformer();
			info.setOutputProperty(OutputKeys.INDENT, "yes");
			info.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			info.setOutputProperty(OutputKeys.VERSION, "1.0");
			StreamResult result = new StreamResult(new FileOutputStream(new File("src/com/andieguo/saxparserdemo/saxbooks.xml")));
			handler.setResult(result);
			handler.startDocument();
			AttributesImpl impl = new AttributesImpl();
			impl.clear();
			handler.startElement("", "", "bookstore", impl);
			for(int i=0;i<books.size();i++){
				Book book = books.get(i);
				impl.clear(); 
	            impl.addAttribute("", "", "category", "", book.getCategory());
	            handler.startElement("", "", "book", impl); 
	            impl.addAttribute("", "", "lang", "", book.getTitleLang());
	            handler.startElement("", "", "title", impl); 
	            String title = book.getTitle();
	            handler.characters(title.toCharArray(), 0, title.length()); 
	            handler.endElement("", "", "title"); 
	            String[] author = book.getAuthor().split("/");
	            for(int j=0;j<author.length;j++){
	            	impl.clear(); 
	            	handler.startElement("", "", "author", impl); 
	            	handler.characters(author[j].toCharArray(), 0, author[j].length()); 
	 	            handler.endElement("", "", "author"); 
	            }
	            impl.clear(); 
	            handler.startElement("", "", "year", impl); 
	            String year = book.getYear().toString();
	            handler.characters(year.toCharArray(), 0, year.length()); 
	            handler.endElement("", "", "year"); 
	            impl.clear(); 
	            handler.startElement("", "", "price", impl); 
	            String price = book.getPrice().toString();
	            handler.characters(price.toCharArray(), 0, price.length()); 
	            handler.endElement("", "", "price"); 
	            handler.endElement("", "", "book");
			}
			handler.endElement("", "", "bookstore");
			handler.endDocument();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
