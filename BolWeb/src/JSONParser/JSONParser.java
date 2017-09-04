package JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import entities.Product;


public class JSONParser {
	// TODO : replace with new absolute location
	private String INPUTFILE = "/home/alek/workspace/BolWeb/bol.json";
	
	public List<Product> getProducts() throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		Gson json = new Gson();
		
		Product products = json.fromJson(new FileReader(INPUTFILE), Product.class);
		
		return products.getProducts();
	}
	
	public List<Product> addProduct(Product product) throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		List<Product> exist = this.getProducts();
		exist.add(product);
		return this.getProducts();
	}
	
	public List<String[]> findProducts(String query) {
		return null;
	}
}
