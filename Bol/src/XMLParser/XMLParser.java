package XMLParser;

import java.io.File;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XMLParser {
	// TODO : replace with new absolute location
	private String INPUTFILE = "/home/alek/workspace/Bol/bol.xml";
	
	public String getOrders() {
		File inputFile = new File(INPUTFILE);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
	        doc.getDocumentElement().normalize();
	        String result = "<h2>Orders</h2>";
	        
	        NodeList trash = doc.getElementsByTagName("order");

	        for (int i = 0; i < trash.getLength(); i++) {
	        	 Node nNode = trash.item(i);
	        	 Element eElement = (Element) nNode;
	        	 
	        	 result += "<br/><b>naam klant : </b>" + eElement.getAttribute("name");
	        	 result += "<br/><b>adres : </b>" + eElement.getAttribute("address");
	        	 result += "<br/><b>datum : </b>" + eElement.getAttribute("date");
	        	 result += "<br/><b>product : </b>" + eElement.getAttribute("product");
	        	 result += "<br/><b>hoeveelheid : </b>" + eElement.getAttribute("ammount");
	        	 result += "<br/>";
	        }

	        return result;
		} 
		catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String addOrder(String[] order) {
		StringBuilder sb = new StringBuilder();
		sb.append("<order name=\"").append(order[0]).append("\" address=\"").append(order[1]).append("\" date=\"").append(order[2])
		.append("\" product=\"").append(order[3]).append("\" ammount=\"").append(order[4]).append("\" ></order>");
		
		File inputFile = new File(INPUTFILE);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        // set validating false to enable copying
        // node from one document to another
        dbFactory.setValidating(false);
        DocumentBuilder dBuilder;
        
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc1 = dBuilder.parse(inputFile);
	        Document doc2 = dBuilder.parse(new InputSource(new StringReader(sb.toString())));
	        Element element = (Element) doc2.getDocumentElement();
	        // imports a node from doc2 document to doc1, without altering
	        // or removing the source node from the original document
	        Node copiedNode = doc1.importNode(element, true);
	        // adds the node to the end of the list of children of this node
	        doc1.getDocumentElement().appendChild(copiedNode);
	        
	        /*FileWriter fw = new FileWriter(INPUTFILE);
	        fw.write(doc1.toString());
	        fw.close();*/
	        // write the new document to file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc1);
			StreamResult result = new StreamResult(new File(INPUTFILE));
			transformer.transform(source, result);
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return this.getOrders();
	}
}
