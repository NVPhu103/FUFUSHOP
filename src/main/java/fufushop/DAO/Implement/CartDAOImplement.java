package fufushop.DAO.Implement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


import fufushop.Connection.DBConnection;
import fufushop.DAO.ICartDAO;
import fufushop.Model.CartModel;

public class CartDAOImplement implements ICartDAO{
	public Connection conn = null;
	public Statement s = null;
	public PreparedStatement ps = null;
	public CallableStatement cs = null;
	ResultSet rs = null;
	
	@Override
	public CartModel getCart(int userID) {
		String query = "SELECT * FROM FUNC_GetCart(?)";
		CartModel cart = new CartModel();
		try{
			conn = new DBConnection().getConnect();
			ps = conn.prepareStatement(query);
			ps.setInt(1, userID);
			rs = ps.executeQuery();
			while(rs.next()) {
				cart = new CartModel(rs.getInt(1), rs.getDouble(2), rs.getInt(3));
			}
		} catch (Exception e) {
			return null;
		}
		return cart;
	}

	@Override
	public void insertCart(int userID) {
		String query = "{call dbo.PROC_InsertCart(?)}";
		try {
			conn = new DBConnection().getConnect();
			conn.setAutoCommit(false);
			cs = conn.prepareCall(query);
			cs.setInt(1, userID);
			if(cs.executeUpdate() == 1) {
				conn.commit();
			}else {
				conn.rollback();
			}
		} catch (Exception e) {
			
		}
		
	}
	
}
