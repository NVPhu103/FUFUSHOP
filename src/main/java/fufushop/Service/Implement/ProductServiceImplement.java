package fufushop.Service.Implement;

import java.util.List;

import fufushop.DAO.IPendingProductDAO;
import fufushop.DAO.IProductDAO;
import fufushop.DAO.Implement.PendingProductDAOImplement;
import fufushop.DAO.Implement.ProductDAOImplement;
import fufushop.Model.ProductModel;
import fufushop.Service.IProductService;

public class ProductServiceImplement implements IProductService{
	IProductDAO productDAO = new ProductDAOImplement();
	IPendingProductDAO pendingProductDAO = new PendingProductDAOImplement();
	@Override
	public List<ProductModel> getProductByUserID(int userID, int index) {
		return productDAO.getProductByUserID(userID, index, 4);	//Lấy 4 sản phẩm một lần, vị trí sẽ lấy = index
	}
	@Override
	public int getEndPage(int userID) {
		int count = productDAO.countProduct(userID);
		if(count != 0) {
			if(count%4 == 0) {
				return count/4;
			}else {
				return (count/4)+1;
			}
			
		}else {
			//count == 0 end page là 1
			return 1;
		}
	}
	@Override
	public boolean checkExistence(String name, int userID) {
		if(productDAO.getProductByNameAndUserID(name, userID) != null) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public boolean confirmProduct(int productID, int userID) {
		try {
			ProductModel product = pendingProductDAO.getProduct(productID, userID);
			product.setStatus(3);
			//Add product into product table and then delete product in pendingProduct table
			productDAO.insertProduct(product);	
			pendingProductDAO.deletePendingProduct(product.getId(), product.getUserID());
			// The image has not been processed yet
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}
	@Override
	public void insertProduct(ProductModel product) {
		productDAO.insertProduct(product);
	}
	@Override
	public ProductModel getProduct(int productID, int userID) {
		return productDAO.getProduct(productID, userID);
	}
	@Override
	public void editQuantity(int totalQuantity, int productID) {
		productDAO.editQuantity(productID, totalQuantity);
	}
	@Override
	public void editStatus(int Status, int productID) {
		productDAO.editStatus(Status, productID);
	}
	@Override
	public List<ProductModel> getNewArrivalProductHomePage() {
		return productDAO.getNewArrivalProductHomePage();
	}
	@Override
	public List<ProductModel> getAllProductHomePage() {
		return productDAO.getAllProductHomePage();
	}
	@Override
	public ProductModel getProduct(int productID) {
		return productDAO.getProduct(productID);
	}
	@Override
	public List<ProductModel> get10ProductProductDetailPage(int categoryID) {
		return productDAO.get10ProductProductDetailPage(categoryID);
	}

}
