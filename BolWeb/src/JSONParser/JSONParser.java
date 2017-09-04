package JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
	
	public List<Product> addProduct(Product product) throws JsonSyntaxException, JsonIOException, IOException {
		List<Product> exist = this.getProducts();
		//add product to list
		exist.add(product);
		//writes list to json file
		Writer w = new FileWriter(INPUTFILE);
		Gson json = new GsonBuilder().create();
		json.toJson(exist, w);
		
		return this.getProducts();
	}
	
	public List<Product> findProducts(String query) {
		return null;
	}
}
