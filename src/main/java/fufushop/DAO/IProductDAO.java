package fufushop.DAO;

import java.util.List;

import fufushop.Model.ProductModel;

public interface IProductDAO {
	List<ProductModel> getProductByUserID(int userID, int index, int rowsOfPage);
	
	int countProduct(int userID); //Đếm tổng số product của user
	
	ProductModel getProductByNameAndUserID(String name, int userID);	//Lấy sản phẩm với userid và name 

	void insertProduct(ProductModel product);

	ProductModel getProduct(int productID, int userID);

	void editQuantity(int productID, int quantity);

	void editStatus(int status, int productID);
	
	List<ProductModel> getNewArrivalProductHomePage();

	List<ProductModel> getAllProductHomePage();

	ProductModel getProduct(int productID);

	List<ProductModel> get10ProductProductDetailPage(int categoryID);	
	
	
}
