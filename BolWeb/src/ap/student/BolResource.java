package ap.student;

import java.util.List;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import JSONParser.JSONParser;

public class BolResource extends ServerResource{
	@Get
	public List<String[]> getProducts() {
		JSONParser jsonp = new JSONParser();
		return jsonp.getProducts();
	}
	@Post
	public List<String[]> addProduct(String[] product) {
		JSONParser jsonp = new JSONParser();
		return jsonp.addProduct(product);
	}
}
