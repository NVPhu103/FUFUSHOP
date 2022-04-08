package fufushop.Service;

import java.util.List;

import fufushop.Model.ProductModel;

public interface IProductService {
	List<ProductModel> getProductByUserID(int userID,int index);
	
	int getEndPage(int userID);
	
	boolean checkExistence(String name, int userID);
	
	void insertProduct(ProductModel product);

	boolean confirmProduct(int productID, int userID);
	
	ProductModel getProduct(int productID, int userID);		//take one particular product
	
	void editQuantity(int totalQuantity, int productID);	
	
	void editStatus(int Status, int productID);
	
	List<ProductModel> getNewArrivalProductHomePage();
	
	List<ProductModel> getAllProductHomePage();
	
	ProductModel getProduct(int productID);
	
	List<ProductModel> get10ProductProductDetailPage(int categoryID);
}
