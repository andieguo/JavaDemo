package com.andieguo.jsondemo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

public class GsonDemo {
	public static void main(String[] args) {
		jsonToObject();
	}

	@SuppressWarnings("unused")
	private static void objectToJson() {
		Book book = new Book("科技","en","转基因","andy",2013,45.0);
		Gson gson = new Gson();

		//将java对象转换为Json格式字符串
		String json = gson.toJson(book);
		try {
			//将Json格式字符串写入文件
			FileWriter writer = new FileWriter("src/com/andieguo/jsondemo/book.json");
			writer.write(json);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(json);
	}

	private static void jsonToObject() {
		Gson gson = new Gson();
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/com/andieguo/jsondemo/book.json"));
			// 将Json字符串转化为Book对象
			Book book = gson.fromJson(br, Book.class);
			System.out.println(book.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
