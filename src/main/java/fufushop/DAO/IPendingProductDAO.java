package fufushop.DAO;

import java.util.List;

import fufushop.Model.ProductModel;

public interface IPendingProductDAO {
	
	List<ProductModel> getProductByUserID(int userID, int index, int rowsOfPage);
	
	int countProduct(int userID); //Đếm tổng số pending product của user
	
	ProductModel getProduct (int productID, int userID);	//get product by product id and user id
	
	void insertPendingProduct(ProductModel product);

	void deletePendingProduct(int productID, int userID);

	ProductModel getProductByNameAndUserID(String name, int userID); //Used to check if the product name exists
}
