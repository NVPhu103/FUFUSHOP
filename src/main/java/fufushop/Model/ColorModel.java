package fufushop.Model;

public class ColorModel {
	public String name;
	public int quantity;
	public int productID;
	
	public ColorModel(String name, int quantity, int productID) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.productID = productID;
	}

	public ColorModel() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	@Override
	public String toString() {
		return "Color [name=" + name + ", quantity=" + quantity + ", productID=" + productID + "]";
	}
	
	
}
