package ba.bitcamp.share;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Article {

	private int id;
	private String title;
	private int pubDate;
	private int autorID;
	private String content;

	/**
	 * Constructor for Article with five parameters: id, title, pubDate,
	 * autorID, content.
	 * 
	 * @param id
	 * @param title
	 * @param pubDate
	 * @param autorID
	 * @param content
	 */
	public Article(int id, String title, int pubDate, int autorID,
			String content) {
		super();
		this.id = id;
		this.title = title;
		this.pubDate = pubDate;
		this.autorID = autorID;
		this.content = content;
	}

	/**
	 * Constructor for Article.
	 * 
	 * @param node
	 *            - node from w3c package.
	 */
	public Article(Node node) {
		if (node instanceof Element) {

			Element nodeElement = (Element) node;
			this.id = Integer.parseInt(nodeElement.getAttribute("id"));
			NodeList childNode = nodeElement.getChildNodes();

			for (int i = 0; i < childNode.getLength(); i++) {
				Node current = childNode.item(i);

				if (current instanceof Element) {
					Element element = (Element) current;

					if (element.getNodeName().equals("title")) {
						this.title = element.getTextContent();
					}
					if (element.getNodeName().equals("pubDate")) {
						this.pubDate = Integer.parseInt(element
								.getTextContent());
					}
					if (element.getNodeName().equals("autor")) {
						this.autorID = Integer.parseInt(element
								.getAttribute("id"));
					}
					if (element.getNodeName().equals("clanak")) {
						this.content = element.getTextContent();
					}
				} 
			}
		} else {
			System.err.println("Not instance of Element!");
		}
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the pubDate
	 */
	public int getPubDate() {
		return pubDate;
	}

	/**
	 * @return the autorID
	 */
	public int getAutorID() {
		return autorID;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", pubDate="
				+ pubDate + ", autorID=" + autorID + ", content=" + content
				+ "]";
	}

}
