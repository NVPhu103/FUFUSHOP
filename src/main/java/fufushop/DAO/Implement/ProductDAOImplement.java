package fufushop.DAO.Implement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fufushop.Connection.DBConnection;
import fufushop.DAO.IProductDAO;
import fufushop.Model.ProductModel;

public class ProductDAOImplement implements IProductDAO{
	public Connection conn = null;
	public Statement s = null;
	public PreparedStatement ps = null;
	public CallableStatement cs = null;
	ResultSet rs = null;
	
	@Override
	public List<ProductModel> getProductByUserID(int userID, int index, int rowsOfPage) {
		String query = "SELECT * FROM Func_GetProductPaging(?,?,?)";
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
	public int countProduct(int userID) {
		String query = "SELECT COUNT(*) FROM Product WHERE UserID=?";
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
	public ProductModel getProductByNameAndUserID(String name, int userID) {
		String query = "SELECT * FROM Func_GetProductByNameAndUserID(?,?)";
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
	
	public static void main(String[] args) {
		/*ProductDAOImplement prodao = new ProductDAOImplement();
		ProductModel product = new ProductModel("Chua co",120000, 10, 100, "OKE OKE OKE", "OKE", 1, 2, 8, 5);
		prodao.insertPendingProduct(product);*/
		
		
	}

	@Override
	public void insertProduct(ProductModel product) {
		String query = "{call dbo.PROC_InsertProduct(?,?,?,?,?,?,?,?,?,?)}";
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
	public ProductModel getProduct(int productID, int userID) {
		String query = "SELECT * FROM Func_GetProductByProductIDAndUserID(?,?)";
		ProductModel Product = null;
		try {
			conn = new DBConnection().getConnect();
			ps = conn.prepareStatement(query);
			ps.setInt(1, productID);
			ps.setInt(2, userID);
			rs = ps.executeQuery();
			if (rs.next()) {
				Product = new ProductModel(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getFloat(4), rs.getInt(5), 
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11));
			}
		} catch (Exception e) {
			return null;
		}
		return Product;
	}

	@Override
	public void editQuantity(int productID, int quantity) {
		String query = "{call dbo.PROC_EditQuantityProduct(?,?)}";
		try {
			conn = new DBConnection().getConnect();
			conn.setAutoCommit(false);
			cs = conn.prepareCall(query);
			cs.setInt(1, productID);
			cs.setInt(2, quantity);
			if(cs.executeUpdate() == 1) {
				conn.commit();
			}else {
				conn.rollback();
			}
		}catch (Exception e) {
			
		}
		
	}

	@Override
	public void editStatus(int status, int productID) {
		String query = "{call dbo.PROC_EditStatusProduct(?,?)}";
		try {
			conn = new DBConnection().getConnect();
			conn.setAutoCommit(false);
			cs = conn.prepareCall(query);
			cs.setInt(1, productID);
			cs.setInt(2, status);
			if(cs.executeUpdate() == 1) {
				conn.commit();
			}else {
				conn.rollback();
			}
		}catch (Exception e) {
			
		}
		
	}

	@Override
	public List<ProductModel> getNewArrivalProductHomePage() {
		String query = "SELECT * FROM Func_NewArrivalProductHomePage()";
		List<ProductModel> listProduct = new ArrayList<ProductModel>();
		try {
			conn = new DBConnection().getConnect();
			cs = conn.prepareCall(query);
			rs = cs.executeQuery();
			while(rs.next()) {
				listProduct.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getDouble(3), 
						rs.getFloat(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
			}
		} catch (Exception e) {
			return listProduct;
		}
		return listProduct;
	}

	@Override
	public List<ProductModel> getAllProductHomePage() {
		String query = "SELECT * FROM VIEW_Product_HomePage ORDER BY ID DESC";
		List<ProductModel> listProduct = new ArrayList<ProductModel>();
		try {
			conn = new DBConnection().getConnect();
			s = conn.createStatement();
			rs = s.executeQuery(query);
			while(rs.next()) {
				listProduct.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getDouble(3), 
						rs.getFloat(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
			}
		} catch (Exception e) {
			return listProduct;
		}
		return listProduct;
	}

	@Override
	public ProductModel getProduct(int productID) {
		String query = "SELECT * FROM Func_GetProductByProductID(?)";
		ProductModel Product = null;
		try {
			conn = new DBConnection().getConnect();
			ps = conn.prepareStatement(query);
			ps.setInt(1, productID);
			rs = ps.executeQuery();
			if (rs.next()) {
				Product = new ProductModel(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getFloat(4), rs.getInt(5), 
						rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11));
			}
		} catch (Exception e) {
			return null;
		}
		return Product;
	}

	@Override
	public List<ProductModel> get10ProductProductDetailPage(int categoryID) {
		String query = "SELECT TOP 10 * FROM Func_GetProductByCategoryID(?) ORDER BY ID DESC";
		List<ProductModel> listProduct = new ArrayList<ProductModel>();
		try {
			conn = new DBConnection().getConnect();
			cs = conn.prepareCall(query);
			cs.setInt(1, categoryID);
			rs = cs.executeQuery();
			while(rs.next()) {
				listProduct.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getDouble(3), 
						rs.getFloat(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
			}
		} catch (Exception e) {
			return listProduct;
		}
		return listProduct;
	}

	

}
