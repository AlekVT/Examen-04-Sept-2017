package ap.student;

import org.restlet.resource.ClientResource;

public class BolClient {
	public static void main(String[] args) {
        
        try {
        	ClientResource resource = new ClientResource("http://127.0.0.1:8182/bol/add");
           	// Post a new trash
        	resource.post(new String[] {"Jefke Vermeulen", "Eikenlei 17", "04/09-17", "Dell Laptopt", "66"});
        	
        	resource.post(new String[] {"Hunter S. Thompson", "L.V. Nevada", "12/11/1969", "waterpijp", "666"});
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }
	}
}
