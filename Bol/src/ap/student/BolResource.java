package ap.student;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import XMLParser.XMLParser;

public class BolResource extends ServerResource{
	@Get
	public String getOrders() {
		XMLParser xmlp = new XMLParser();
		return xmlp.getOrders();
	}
	@Post
	public String addOrder(String[] order) {
		XMLParser xmlp = new XMLParser();
		return xmlp.addOrder(order);
	}
}
