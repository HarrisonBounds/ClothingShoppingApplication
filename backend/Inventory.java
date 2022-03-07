package backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class Inventory {

	private ArrayList<Clothing> clothes;
	private String fileName;
	
	public Inventory() {
	//default constructor
	clothes = new ArrayList<Clothing>();
	fileName = null;
	}

	public Inventory(String fn)
	{
		this();
		fileName = fn;
		readFile();
	}
	
	public ArrayList<String> getCategories(){
		ArrayList<String> collection = new ArrayList<String>();
		
		while(clothes.iterator().hasNext()) {
			Clothing c = clothes.iterator().next();
			
			if (!collection.contains(c.getType())) {
				collection.add(c.getType());
			}
		}
		
		return collection;
		
	}

	public void add(Clothing c)
	{
		clothes.add(c);
	}

	public Clothing remove(String n)
	{
		Clothing removed_item = this.retrieveProduct(n);
		clothes.remove(removed_item);
		return removed_item;
	}

	public Clothing retrieveProduct(String n) {
		int index = 0;

		while (index < clothes.size() && !clothes.get(index).getProduct_num().equals(n))
		{
			index++;
		}

		if (index == clothes.size())
		{
			return null;
		}

		else
		{
			Clothing toReturn = clothes.get(index);
			return toReturn;
		}


	}
	
	public ArrayList<Clothing> retrieveCollection(){
			
			return clothes;
		}
	
	public ArrayList<Clothing> retrieveType(String category){
		
		ArrayList<Clothing> collection = new ArrayList<Clothing>();
		while(clothes.iterator().hasNext()) {
			Clothing c = clothes.iterator().next();
			
			if(c.getType().equals(category)) {
				collection.add(c);
			}
		}
		
		return collection;
	}

	public int retrieveTypenum(String t) {
		int index = 0;
		int total = 0;

		while (index < clothes.size()) {
			if(clothes.get(index).getType().equals(t)) {
				total = clothes.get(index).getQuantity();
			}
			index++;
		}

		if(total == 0) {
			return 0;
		}
		else {
			return total;
		}
	}
	
	public ArrayList<Clothing> retreivePrices(int p) {
		ArrayList<Clothing> collection = new ArrayList<Clothing>();
		while(clothes.iterator().hasNext()) {
			Clothing c = clothes.iterator().next();
			
			if(c.getPrice() <= p) {
				collection.add(c);
			}
		}
		
		return collection;
	}
	
	public int purchase(String n) {
		Clothing updated_quantity = retrieveProduct(n);
		if(updated_quantity != null) {
			updated_quantity.setQuantity(updated_quantity.getQuantity() - 1);
			return updated_quantity.getQuantity();
		}
		else {
			return 0;
		}
		
		
	}
	
	public ArrayList<Clothing> getSuggestions(Clothing c){
		ArrayList<Clothing> suggestion = new ArrayList<Clothing>();
		int index = 0;
		
		
			if(c.getType().equals("tshirt")) {
				while(index < clothes.size() && !clothes.get(index).getType().equals("shorts")) {
					index++;
				}
				suggestion.add(clothes.get(index));
			}
			else if(c.getType().equals("sweatshirt")) {
				while(index < clothes.size() && !clothes.get(index).getType().equals("pants")) {
					index++;
				}
				suggestion.add(clothes.get(index));
			}
			else if(c.getType().equals("underwear")) {
				while(index < clothes.size() && !clothes.get(index).getType().equals("socks")) {
					index++;
				}
				suggestion.add(clothes.get(index));
			}
		return suggestion;
		
	}

	public String toString()
	{
		return clothes.toString() + "\n";
	}

	private void readFile () {
		BufferedReader lineReader = null;
		try {
			FileReader fr = new FileReader(fileName);
			lineReader = new BufferedReader(fr);
			String line = null; //The line is going to be the type of clothing
			while ((line = lineReader.readLine())!=null) {
				String size = lineReader.readLine();
				String priceString = lineReader.readLine();
				double price = Double.parseDouble(priceString);
				String quantityString = lineReader.readLine();
				int quantity = Integer.parseInt(quantityString);
				String product_num = lineReader.readLine();

				add(new Clothing(line, size, price, quantity, product_num));
			}	
	} catch (Exception e) {
		System.err.println("there was a problem with the file reader, try different read type.");
		try {
			lineReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(fileName.substring(1))));
			String line = null;
			while ((line = lineReader.readLine())!=null) {
				String size = lineReader.readLine();
				String priceString = lineReader.readLine();
				double price = Double.parseDouble(priceString);
				String quantityString = lineReader.readLine();
				int quantity = Integer.parseInt(quantityString);
				String product_num = lineReader.readLine();

				add(new Clothing(line, size, price, quantity, product_num));
				}
		} catch (Exception e2) {
			System.err.println("there was a problem with the file reader, try again.  either no such file or format error");
		} finally {
			if (lineReader != null)
				try {
					lineReader.close();
				} catch (IOException e2) {
					System.err.println("could not close BufferedReader");
				}
		}			
	} finally {
		if (lineReader != null)
			try {
				lineReader.close();
			} catch (IOException e) {
				System.err.println("could not close BufferedReader");
			}
	}
} // end of readFile method	

public void writeFile () {
	// overloaded method: this calls doWrite with file used to read data
	// use this for saving data between runs
	doWrite(fileName);
} // end of writeFile method

public void writeFile(String altFileName) {
	// overloaded method: this calls doWrite with different file name 
	// use this for testing write
	doWrite(altFileName);		
}// end of writeFile method

public void doWrite(String fn) {
	// this method writes all of the data in the persons array to a file
	try
	{

		FileWriter fw = new FileWriter(fn);
		BufferedWriter myOutfile = new BufferedWriter(fw);			

		for (int i = 0; i < clothes.size(); i++) {
			Clothing clothing = clothes.get(i);
			
				myOutfile.write (clothing.getType()+"\n");
				myOutfile.write (clothing.getSize()+"\n");
				myOutfile.write (clothing.getPrice()+"\n");
				myOutfile.write (clothing.getQuantity()+"\n");
				myOutfile.write (clothing.getProduct_num()+"\n");
			
		}
		myOutfile.flush();
		myOutfile.close();
	}
	catch (Exception e) {
		e.printStackTrace();
		System.err.println("Didn't save to " + fn);
	}
}	
}