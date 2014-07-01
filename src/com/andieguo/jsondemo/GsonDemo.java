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
		Book book = new Book("�Ƽ�","en","ת����","andy",2013,45.0);
		Gson gson = new Gson();

		//��java����ת��ΪJson��ʽ�ַ���
		String json = gson.toJson(book);
		try {
			//��Json��ʽ�ַ���д���ļ�
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
			// ��Json�ַ���ת��ΪBook����
			Book book = gson.fromJson(br, Book.class);
			System.out.println(book.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
