package ba.bitcamp.xmlbaza;

import java.io.IOException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLConnection {

	private DocumentBuilder docReader;
	private Document xmldoc;

	public void setDocumentBuilder() throws ParserConfigurationException {
		this.docReader = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();
	}

	public void setDocument(String tableName) throws SAXException, IOException {
		String path = "./XML/" + tableName + ".xml";
		xmldoc = docReader.parse(path);
	}

	public NodeList query(String fileName, String query)
			throws SAXException, IOException, XPathExpressionException {
		setDocument(fileName);
		query = "//item";
		XPath xPath = XPathFactory.newInstance().newXPath();
		NodeList xmlList = (NodeList)xPath.compile(query).evaluate(xmldoc, XPathConstants.NODESET);
		
		return xmlList;

	}
	
	
}
