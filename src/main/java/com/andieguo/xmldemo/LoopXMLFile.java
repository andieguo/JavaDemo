package com.andieguo.xmldemo;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LoopXMLFile {
	public static void main(String[] args) {
		loopXMLFile();
	}
	
	private static void loopXMLFile(){
		try {
			File file = new File("src/com/andieguo/xmldemo/books.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			if(doc.hasChildNodes()){
				printNote(doc.getChildNodes());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void printNote(NodeList nodeList){
		for(int i=0; i<nodeList.getLength();i++){
			Node node = nodeList.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE){
				System.out.println("<"+node.getNodeName()+">");
				System.out.println(node.getTextContent());
				if(node.hasAttributes()){
					NamedNodeMap nodeMap = node.getAttributes();
					for(int j=0;j<nodeMap.getLength();j++){
						Node nd = nodeMap.item(j);
						System.out.println(nd.getNodeName()+"="+nd.getNodeValue());
					}
				}
				if(node.hasChildNodes()){
					printNote(node.getChildNodes());
				}
				System.out.println("<" + node.getNodeName() + "/>");
			}
			
			
		}
	}
}
