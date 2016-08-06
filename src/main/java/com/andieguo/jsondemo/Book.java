package com.andieguo.jsondemo;

public class Book {
	private String category;
	private String titleLang;
	private String title;
	private String author;
	private Integer year;
	private Double price;
	
	
	public Book(String category, String titleLang, String title, String author, Integer year, Double price) {
		super();
		this.category = category;
		this.titleLang = titleLang;
		this.title = title;
		this.author = author;
		this.year = year;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [category=" + category + ", titleLang=" + titleLang + ", title=" + title + ", author=" + author + ", year=" + year + ", price=" + price + "]";
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitleLang() {
		return titleLang;
	}
	public void setTitleLang(String titleLang) {
		this.titleLang = titleLang;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
