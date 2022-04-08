package fufushop.Service.Implement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fufushop.Constant.Constant;
import fufushop.DAO.IPendingProductDAO;
import fufushop.DAO.Implement.PendingProductDAOImplement;
import fufushop.Model.ProductModel;
import fufushop.Service.IPendingProductService;

public class PendingProductServiceImplement implements IPendingProductService{
	IPendingProductDAO pendingProductDAO = new PendingProductDAOImplement();
	@Override
	public int getEndPage(int userID) {
		int count = pendingProductDAO.countProduct(userID);
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
	public List<ProductModel> getProductByUserID(int userID, int index) {
		return pendingProductDAO.getProductByUserID(userID, index, 4);	//Lấy 4 sản phẩm một lần, vị trí sẽ lấy = index
	}
	@Override
	public ProductModel getProduct(int productID, int userID) {
		return pendingProductDAO.getProduct(productID, userID);
	}
	
	@Override
	public void insertPendingProduct(ProductModel product) {
		pendingProductDAO.insertPendingProduct(product);
	}
	@Override
	public void deletePendingProduct(int productID, int userID, HttpServletRequest req) throws IOException {
		String productImage = pendingProductDAO.getProduct(productID, userID).getImage();
		pendingProductDAO.deletePendingProduct(productID, userID);
		String realPath = req.getServletContext().getRealPath(Constant.SAVE_DIR_PRODUCT);
		if(Files.exists(Paths.get(realPath+"/"+productImage))) {
			Files.delete(Paths.get(realPath+"/"+productImage));
			Files.delete(Paths.get(Constant.SAVE_DIR_PRODUCT_BACKUP+productImage));
		}
	}
	@Override
	public boolean checkExistence(String name, int userID) {
		if(pendingProductDAO.getProductByNameAndUserID(name, userID) != null) {
			return true;
		}else {
			return false;
		}
	}

}
