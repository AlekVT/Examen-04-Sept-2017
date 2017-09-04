package ap.student;

import java.util.List;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import JSONParser.JSONParser;
import entities.Product;

public class BolResource extends ServerResource{
	@Get
	public List<Product> getProducts() {
		JSONParser jsonp = new JSONParser();
		return jsonp.getProducts();
	}
	@Post
	public List<Product> addProduct(Product product) {
		JSONParser jsonp = new JSONParser();
		System.out.println("getting...");
		return jsonp.addProduct(product);
	}
}
