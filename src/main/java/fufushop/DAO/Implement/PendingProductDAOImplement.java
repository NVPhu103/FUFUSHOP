package fufushop.DAO.Implement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fufushop.Connection.DBConnection;
import fufushop.DAO.IPendingProductDAO;
import fufushop.Model.ProductModel;

public class PendingProductDAOImplement implements IPendingProductDAO{
	public Connection conn = null;
	public PreparedStatement ps = null;
	public CallableStatement cs = null;
	ResultSet rs = null;
	@Override
	public int countProduct(int userID) {
		String query = "SELECT COUNT(*) FROM PendingProduct WHERE UserID=?";
		try {
			conn = new DBConnection().getConnect();
			ps = conn.prepareStatement(query);
			ps.setInt(1, userID);
			rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}
	@Override
	public List<ProductModel> getProductByUserID(int userID, int index, int rowsOfPage) {
		String query = "SELECT * FROM Func_GetPendingProductPaging(?,?,?)";
		List<ProductModel> listProduct = new ArrayList<ProductModel>();
		try {
			conn = new DBConnection().getConnect();
			ps = conn.prepareStatement(query);
			ps.setInt(1, userID);
			ps.setInt(2, index);
			ps.setInt(3, rowsOfPage);
			rs = ps.executeQuery();
			while(rs.next()) {
				listProduct.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getFloat(4), rs.getInt(5), 
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11)));
			}
		} catch (Exception e) {
			return listProduct;
		}
		return listProduct;
	}
	@Override
	public ProductModel getProduct(int productID, int userID) {
		String query = "SELECT * FROM Func_GetPendingProductByIDAndUsername(?,?)";
		ProductModel Product = new ProductModel();
		try {
			conn = new DBConnection().getConnect();
			ps = conn.prepareStatement(query);
			ps.setInt(1, productID);
			ps.setInt(2, userID);
			rs = ps.executeQuery();
			if (rs.next()) {
				Product = new ProductModel(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getFloat(4), rs.getInt(5), 
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11));
			}else {
				Product = null;
			}
			
		} catch (Exception e) {
			return null;
		}
		return Product;
	}
	
	@Override
	public void insertPendingProduct(ProductModel product) {
		String query = "{call dbo.PROC_InsertPendingProduct(?,?,?,?,?,?,?,?,?,?)}";
		try {
			conn = new DBConnection().getConnect();
			conn.setAutoCommit(false);
			cs = conn.prepareCall(query);
			cs.setString(1, product.name);
			cs.setDouble(2, product.price);
			cs.setFloat(3, product.salePrice);
			cs.setInt(4, product.totalQuantity);
			cs.setString(5, product.description);
			cs.setString(6, product.Image);
			cs.setInt(7, product.categoryID);
			cs.setInt(8, product.brandID);
			cs.setInt(9, product.userID);
			cs.setInt(10, product.status);
			if(cs.executeUpdate() == 1) {
				conn.commit();
			}else {
				conn.rollback();
			}
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	@Override
	public void deletePendingProduct(int productID, int userID) {
		String query = "{call dbo.PROC_DeletePendingProduct(?,?)}";
		try {
			conn = new DBConnection().getConnect();
			conn.setAutoCommit(false);
			cs = conn.prepareCall(query);
			cs.setInt(1, productID);
			cs.setInt(2, userID);
			
			if(cs.executeUpdate() == 1) {
				conn.commit();
			}else {
				conn.rollback();
			}
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	@Override
	public ProductModel getProductByNameAndUserID(String name, int userID) {
		String query = "SELECT * FROM Func_GetPendingProductByNameAndUserID(?,?)";
		ProductModel Product = new ProductModel();
		try {
			conn = new DBConnection().getConnect();
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setInt(2, userID);
			rs = ps.executeQuery();
			if (rs.next()) {
				Product = new ProductModel(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getFloat(4), rs.getInt(5), 
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11));
			}else {
				Product = null;
			}
			
		} catch (Exception e) {
			return null;
		}
		return Product;
	}

}
