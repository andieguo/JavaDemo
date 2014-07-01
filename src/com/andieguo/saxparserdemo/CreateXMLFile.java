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
			// 创建工厂
			SAXTransformerFactory factory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
			TransformerHandler handler = factory.newTransformerHandler();
			Transformer info = handler.getTransformer();
			// 是否自动添加额外的空白
			info.setOutputProperty(OutputKeys.INDENT, "yes");
			// 设置字符编码
			info.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			info.setOutputProperty(OutputKeys.VERSION, "1.0");
			// 保存创建的saxbooks.xml
			StreamResult result = new StreamResult(new FileOutputStream(new File("src/com/andieguo/saxparserdemo/saxbooks.xml")));
			handler.setResult(result);
			// 开始xml
			handler.startDocument();
			AttributesImpl impl = new AttributesImpl();
			impl.clear();
			handler.startElement("", "", "bookstore", impl);
			for(int i=0;i<books.size();i++){
				Book book = books.get(i);
				//生成<book category="xx">
				impl.clear(); //清空属性
	            impl.addAttribute("", "", "category", "", book.getCategory());//为book元素添加category属性
	            handler.startElement("", "", "book", impl); 
	            //生成<title lang="xx">xx</title>元素
	            impl.addAttribute("", "", "lang", "", book.getTitleLang());//为title元素添加lang属性
	            handler.startElement("", "", "title", impl); 
	            String title = book.getTitle();
	            handler.characters(title.toCharArray(), 0, title.length()); //为title元素添加文本
	            handler.endElement("", "", "title"); 
	            //生成<author>xx</author>元素
	            String[] author = book.getAuthor().split("/");
	            for(int j=0;j<author.length;j++){
	            	impl.clear(); 
	            	handler.startElement("", "", "author", impl); 
	            	handler.characters(author[j].toCharArray(), 0, author[j].length()); 
	 	            handler.endElement("", "", "author"); 
	            }
	            //生成<year>xx</year>元素
	            impl.clear(); 
	            handler.startElement("", "", "year", impl); 
	            String year = book.getYear().toString();
	            handler.characters(year.toCharArray(), 0, year.length()); 
	            handler.endElement("", "", "year"); 
	            //生成<price>xx</price>元素
	            impl.clear(); 
	            handler.startElement("", "", "price", impl); 
	            String price = book.getPrice().toString();
	            handler.characters(price.toCharArray(), 0, price.length()); 
	            handler.endElement("", "", "price"); 
	            //生成</book>
	            handler.endElement("", "", "book");
			}
			//生成</bookstore>
			handler.endElement("", "", "bookstore");
			handler.endDocument();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
