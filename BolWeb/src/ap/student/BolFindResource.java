package ap.student;

import java.io.FileNotFoundException;

import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import JSONParser.JSONParser;
import entities.Product;

public class BolFindResource extends ServerResource{
	@Post
	public Product search(String name) throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		JSONParser jsonp = new JSONParser();
		return jsonp.findProducts(name);
	}
}
