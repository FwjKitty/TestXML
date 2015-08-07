package com.hand.TestXML;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class CreateXML {

	public static void main(String[] args) throws SAXException, IOException {
		//--------------------create xml
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			Element root = document.createElement("Languages");
			root.setAttribute("cat", "it");
			
			Element lan1 = document.createElement("lan");
			lan1.setAttribute("id", "1");
			Element name1 = document.createElement("name");
			Element ide1 = document.createElement("ide");
			name1.setTextContent("Java");
			ide1.setTextContent("Eclipse");
			lan1.appendChild(name1);
			lan1.appendChild(ide1);
			
			Element lan2 = document.createElement("lan");
			lan1.setAttribute("id", "2");
			Element name2 = document.createElement("name");
			Element ide2 = document.createElement("ide");
			name2.setTextContent("Swift");
			ide2.setTextContent("Xcode");
			lan2.appendChild(name2);
			lan2.appendChild(ide2);
			
			Element lan3 = document.createElement("lan");
			lan1.setAttribute("id", "3");
			Element name3 = document.createElement("name");
			Element ide3 = document.createElement("ide");
			name3.setTextContent("C#");
			ide3.setTextContent("Visual Studio");
			lan3.appendChild(name3);
			lan3.appendChild(ide3);
			
			root.appendChild(lan1);
			root.appendChild(lan2);
			root.appendChild(lan3);
			document.appendChild(root);
			
			//--------------------transformer xml to string
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			StringWriter sw = new StringWriter();
			transformer.transform(new DOMSource(document), new StreamResult(sw));
			System.out.println(sw.toString());
			
			//--------------------transformer xml to xml
			transformer.transform(new DOMSource(document), new StreamResult(new File("languages2.xml")));
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		
	}
}