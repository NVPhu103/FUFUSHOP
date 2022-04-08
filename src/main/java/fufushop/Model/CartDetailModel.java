package fufushop.Model;

public class CartDetailModel {
	private int productID;
	private String color;
	private int quantity;
	private int userID;
	ProductModel product;
	
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public ProductModel getProduct() {
		return product;
	}
	public void setProduct(ProductModel product) {
		this.product = product;
	}
	public CartDetailModel(int productID, String color, int quantity, int userID) {
		super();
		this.productID = productID;
		this.color = color;
		this.quantity = quantity;
		this.userID = userID;
	}
	public CartDetailModel() {
		super();
	}
	@Override
	public String toString() {
		return "CartDetailModel [productID=" + productID + ", color=" + color + ", quantity=" + quantity + ", userID="
				+ userID + ", product=" + product + "]";
	}
	
	
	
}
