package ba.bitcamp.xmlbaza;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ba.bitcamp.share.Article;

public class TestClass {

	public static boolean testArticleConstructor()
			throws ParserConfigurationException, MalformedURLException,
			SAXException, IOException {
		DocumentBuilder docReader = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();
		Document xmldoc = docReader.parse(new File("./XML/Articles.xml"));
		Node testItem = xmldoc.getElementsByTagName("item").item(0);
		
		Article testArticle = new Article(testItem);
		if ( testArticle.getId() != 1){
			return false;
		}
		if ( testArticle.getAutorID()!= 1){
			return false;
		}
		if ( testArticle.getPubDate() != 0){
			return false;
		}

		return true;
	}
	
	public boolean testXMLQuery() throws XPathExpressionException, SAXException, IOException{
		XMLConnection xmlC = new XMLConnection();
		
		
		if (xmlC.query("Atricle", "nesto") instanceof NodeList == false){
			return false;
		}
		NodeList xmlNodelist = xmlC.query("Atricle", "//item");
		Node testItem = xmlNodelist.item(0);
		Article testArticle =  new Article(testItem);
		
		if( testArticle.getId() != 1){
			return false;
		}
		if( testArticle.getAutorID() != 1){
			return false;
		}
		if( testArticle.getPubDate() != 0){
			return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		
		try {
			if ( testArticleConstructor() == false){
				
			} else {
				System.out.println("Test article constructor true!");
			}
		} catch (MalformedURLException e) {
			System.err.println("Article test failed!");
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			System.err.println("Article test failed!");
			e.printStackTrace();
		} catch (SAXException e) {
			System.err.println("Article test failed!");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Article test failed!");
			e.printStackTrace();
		}
	}
}
