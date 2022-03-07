package backend;

public class Clothing {
	
	private String type;
	private String size;
	private double price;
	private int quantity;
	private String product_num;
	
	public Clothing()
	{
		type = "not set";
		size = "not set";
		price = 0.0;
		quantity = 0;
		product_num = "not set";
	}
	
	public Clothing(String t, String s, double p, int q, String n)
	{
		type = t;
		size = s;
		price = p;
		quantity = q;
		product_num = n;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	public String getProduct_num() {
		return product_num;
	}

	public void setProduct_num(String product_num) {
		this.product_num = product_num;
	}
	
public boolean equals(Object o) {
		
		return ((Clothing)o).getProduct_num().equals(this.product_num);
	}

	public String toString()
	{
		return type + " " + size + " " + String.valueOf(price) + " "
	           + String.valueOf(quantity) + " " + product_num;
	}
}
