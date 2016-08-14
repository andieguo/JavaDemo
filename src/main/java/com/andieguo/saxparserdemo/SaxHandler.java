package com.andieguo.saxparserdemo;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxHandler extends DefaultHandler {

	private List<Book> bookList = null;
	private Book book = null;
	private boolean bTitle = false;
	private boolean bAuthor = false;
	private boolean bYear = false;
	private boolean bPrice = false;

	public List<Book> getBookList() {
		return bookList;
	}

	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase("book")) {
			String category = attributes.getValue("category");
			book = new Book();
			book.setCategory(category);
			if (bookList == null) {
				bookList = new ArrayList<Book>();
			}
		} else if (qName.equalsIgnoreCase("title")) {
			String titleLang = attributes.getValue("lang");
			book.setTitleLang(titleLang);
			bTitle = true;
		} else if (qName.equalsIgnoreCase("author")) {
			bAuthor = true;
		} else if (qName.equalsIgnoreCase("year")) {
			bYear = true;
		} else if (qName.equalsIgnoreCase("price")) {
			bPrice = true;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("book")) {
			bookList.add(book);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (bTitle) {
			book.setTitle(new String(ch, start, length));
			bTitle = false;
		} else if (bAuthor) {
			if (book.getAuthor() == null) {
				book.setAuthor(new String(ch, start, length));
			} else {
				book.setAuthor(book.getAuthor() + "/" + new String(ch, start, length));
			}
			bAuthor = false;
		} else if (bYear) {
			book.setYear(Integer.parseInt(new String(ch, start, length)));
			bYear = false;
		} else if (bPrice) {
			book.setPrice(Double.parseDouble(new String(ch, start, length)));
			bPrice = false;
		}
	}

	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
	}

}
