package ap.student;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import JSONParser.JSONParser;
import entities.Product;

public class BolResource extends ServerResource{
	@Get
	public List<Product> getProducts() throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		JSONParser jsonp = new JSONParser();
		return jsonp.getProducts();
	}
	@Post
	public List<Product> addProduct(Product product) throws JsonSyntaxException, JsonIOException, IOException {
		JSONParser jsonp = new JSONParser();
		System.out.println("getting...");
		return jsonp.addProduct(product);
	}
}
