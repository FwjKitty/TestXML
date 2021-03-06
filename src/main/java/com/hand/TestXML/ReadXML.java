package com.hand.TestXML;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXML {

	public static void main(String[] args) {
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("languages.xml"));
			Element root = document.getDocumentElement();
			System.out.println("cat = "+root.getAttribute("cat"));
			NodeList list = root.getElementsByTagName("lan");
			System.out.println(root.getAttributeNode("cat"));
			//System.out.println(root.getNodeName()+root.getTagName()+root.getTextContent());
			for(int i=0; i<list.getLength(); i++){
				Element lan = (Element) list.item(i);
				System.out.println("-------");
				System.out.println("id = "+lan.getAttribute("id"));
				
				/*Element name = (Element) lan.getElementsByTagName("name").item(0);
				System.out.println("name = "+name.getTextContent());
				Element ide = (Element) lan.getElementsByTagName("ide").item(0);
				System.out.println("ide = "+ide.getTextContent());*/
				
				NodeList clist = lan.getChildNodes();
				System.out.println("*******"+clist.getLength());
				for(int j=0; j<clist.getLength(); j++){
					Node c = clist.item(j);
					if(c instanceof Element){
						System.out.println(c.getNodeName()+" = "+c.getTextContent());
						//System.out.println(c.getNodeName());
					}
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}