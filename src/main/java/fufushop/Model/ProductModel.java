package fufushop.Model;

import java.util.List;

public class ProductModel {
	public int id;  
	public String name;
	public	double price;
	public	float salePrice;
	public	int totalQuantity;
	public	String description;
	public	String Image;
	public	int categoryID;
	public	int brandID;
	public	int userID;
	public	int status;
	public List<ColorModel> listColor;
	
	public ProductModel(int id, String name, double price, float salePrice, int totalQuantity, String description,
			String image, int categoryID, int brandID, int userID, int status) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.salePrice = salePrice;
		this.totalQuantity = totalQuantity;
		this.description = description;
		Image = image;
		this.categoryID = categoryID;
		this.brandID = brandID;
		this.userID = userID;
		this.status = status;
	}
	
	public ProductModel(String name, double price, float salePrice, int totalQuantity, String description,
			String image, int categoryID, int brandID, int userID, int status) {
		super();
		this.name = name;
		this.price = price;
		this.salePrice = salePrice;
		this.totalQuantity = totalQuantity;
		this.description = description;
		Image = image;
		this.categoryID = categoryID;
		this.brandID = brandID;
		this.userID = userID;
		this.status = status;
	}
	
	public ProductModel(int id, String name, String description, String image, int categoryID, int brandID, int userID, int status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		Image = image;
		this.categoryID = categoryID;
		this.brandID = brandID;
		this.userID = userID;
		this.status = status;
	}
	
	public ProductModel(int id, String name, double price, float salePrice, int totalQuantity, String description,
			String image, int categoryID, int brandID, int userID, int status, List<ColorModel> listColor) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.salePrice = salePrice;
		this.totalQuantity = totalQuantity;
		this.description = description;
		Image = image;
		this.categoryID = categoryID;
		this.brandID = brandID;
		this.userID = userID;
		this.status = status;
		this.listColor = listColor;
	}
	
	public ProductModel(int id, String name, double price, float salePrice, String image, int categoryID, int brandID) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.salePrice = salePrice;
		Image = image;
		this.categoryID = categoryID;
		this.brandID = brandID;
	}
	
	public List<ColorModel> getListColor() {
		return listColor;
	}

	public void setListColor(List<ColorModel> listColor) {
		this.listColor = listColor;
	}

	public ProductModel() {
		super();
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public float getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(float salePrice) {
		this.salePrice = salePrice;
	}
	public int getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public int getBrandID() {
		return brandID;
	}
	public void setBrandID(int brandID) {
		this.brandID = brandID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "ProductModel [id=" + id + ", name=" + name + ", price=" + price + ", salePrice=" + salePrice
				+ ", totalQuantity=" + totalQuantity + ", description=" + description + ", Image=" + Image
				+ ", categoryID=" + categoryID + ", brandID=" + brandID + ", userID=" + userID + ", status=" + status
				+ "]";
	}
	
	
}
