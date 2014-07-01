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
			// 得到DOM解析器的工厂实例
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			// 从DOM工厂中获得DOM解析器
			DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
			// 创建文档树模型对象
			doc = dbBuilder.newDocument();
			if (doc != null) {
				bookstore = doc.createElement("bookstore");
				for (int i = 0; i < books.size(); i++) {
					book = doc.createElement("book");
					//设置元素book的属性值
					book.setAttribute("category", books.get(i).getCategory());
					//创建名称为title的元素
					title = doc.createElement("title");
					//创建文本节点并作为子节点添加到title元素中
					title.appendChild(doc.createTextNode(books.get(i).getTitle()));
					//设置元素title的属性值
					title.setAttribute("lang", books.get(i).getTitleLang());
					//将title子元素添加到book中
					book.appendChild(title);
					String[] strAuthor = books.get(i).getAuthor().split("/");
					for(int j=0;j<strAuthor.length;j++){
						author = doc.createElement("author");
						author.appendChild(doc.createTextNode(strAuthor[j]));
						book.appendChild(author);//将多个author子元素添加到book中
					}
					year = doc.createElement("year");
					year.appendChild(doc.createTextNode(books.get(i).getYear().toString()));
					book.appendChild(year);//将year子元素添加到book中
					price = doc.createElement("price");
					price.appendChild(doc.createTextNode(books.get(i).getPrice().toString()));
					book.appendChild(price);//将price子元素添加到book中
					bookstore.appendChild(book); //将book作为子元素添加到树的根节点bookstore
				}
				doc.appendChild(bookstore);//添加到文档树中
				
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
