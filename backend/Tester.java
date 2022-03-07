package backend;

public class Tester {

	public static void main(String[] args) {
		
		//Single Entity test
		Clothing c1 = new Clothing();
		System.out.println(c1);
		
		c1.setType("tshirt");
		System.out.println(c1.getType());
		c1.setSize("large");
		System.out.println(c1.getSize());
		c1.setPrice(12.0);
		System.out.println(c1.getPrice());
		c1.setQuantity(4);
		System.out.println(c1.getQuantity());
		c1.setProduct_num("9872");
		System.out.println(c1.getProduct_num());
		
		
		
		Clothing c2 = new Clothing("pants", "32/32", 24.0, 2, "7352");
		System.out.println(c2);
		Clothing c3 = new Clothing("shorts", "medium", 10.0, 4, "3876");
		System.out.println(c3);
		Clothing c4 = new Clothing("underwear", "small", 4.0, 20, "0789");
		System.out.println(c4);
		Clothing c5 = new Clothing("socks", "small", 5.0, 5, "3810");
		System.out.println(c5);
		Clothing c6 = new Clothing("sweatshirt", "extra large", 32.0, 3, "9115");
		System.out.println(c6);
		
		Inventory i1 = new Inventory();
		i1.add(c1);
	    i1.add(c2);
	    i1.add(c3);
	    i1.add(c4);
	    i1.add(c5);
	    i1.add(c6);
	    
	    System.out.println("You might like this item: " + i1.getSuggestions(c6)); 
		
		int update = i1.purchase("6789");
		if(update == 0) {
			System.out.println("This item does not exist");
		}
		else {
			System.out.println(update);
		}
		
		
		System.out.println(i1.retrieveType("shirt"));
		System.out.println(i1.retrieveType("shorts"));
		
		System.out.println(i1.retrieveProduct("7352"));
		
		i1.remove("7352");
		System.out.println(i1);
		
		
		
		
	}

}