package fufushop.Service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fufushop.Model.ProductModel;

public interface IPendingProductService {
	
	List<ProductModel> getProductByUserID(int userID,int index);
	
	int getEndPage(int userID);
	
	void insertPendingProduct(ProductModel product);
	
	boolean checkExistence(String name, int userID);
	
	ProductModel getProduct(int productID, int userID);
	
	//get ServletContext to create realPath to delete image
	void deletePendingProduct(int productID, int userID, HttpServletRequest req) throws IOException;	
}
