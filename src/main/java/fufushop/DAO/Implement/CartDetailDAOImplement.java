package fufushop.DAO.Implement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fufushop.Connection.DBConnection;
import fufushop.DAO.ICartDetailDAO;
import fufushop.Model.CartDetailModel;
import fufushop.Model.CartModel;

public class CartDetailDAOImplement implements  ICartDetailDAO{
	public Connection conn = null;
	public Statement s = null;
	public PreparedStatement ps = null;
	public CallableStatement cs = null;
	ResultSet rs = null;
	
	@Override
	public List<CartDetailModel> getAllCartDetail(int userID) {
		String query = "SELECT * FROM FUNC_GetCartDetail(?)";
		List<CartDetailModel> listCartDetail = new ArrayList<CartDetailModel>();
		try {
			conn = new DBConnection().getConnect();
			ps = conn.prepareStatement(query);
			ps.setInt(1, userID);
			rs = ps.executeQuery();
			while(rs.next()) {
				listCartDetail.add(new CartDetailModel(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
			}
		} catch (Exception e) {
			return null;
		}
		return listCartDetail;
	}

	@Override
	public boolean insertCartDetail(CartDetailModel cartDetail, CartModel cart) {
		String query1 = "{call dbo.PROC_InsertCartDetail(?,?,?,?)}";
		String query2 = "{call dbo.PROC_EditCart(?,?,?)}";
		try {
			conn = new DBConnection().getConnect();
			conn.setAutoCommit(false);
			cs = conn.prepareCall(query1);
			cs.setInt(1, cartDetail.getProductID());
			cs.setString(2, cartDetail.getColor());
			cs.setInt(3, cartDetail.getQuantity());
			cs.setInt(4, cartDetail.getUserID());
			if(cs.executeUpdate() == 1) {
				cs = conn.prepareCall(query2);
				cs.setInt(1, cart.getQuantity());
				cs.setDouble(2, cart.getTotalMoney());
				cs.setInt(3, cart.getUserID());
				if(cs.executeUpdate() == 1) {
					conn.commit();
					return true;
				}else {
					conn.rollback();
					return false;
				}
			}else {
				conn.rollback();
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean editCartDetail(CartDetailModel cartDetail, CartModel cart) {
		String query1 = "{call dbo.PROC_EditCartDetail(?,?,?,?)}";
		String query2 = "{call dbo.PROC_EditCart(?,?,?)}";
		try {
			conn = new DBConnection().getConnect();
			conn.setAutoCommit(false);
			cs = conn.prepareCall(query1);
			cs.setInt(1, cartDetail.getProductID());
			cs.setString(2, cartDetail.getColor());
			cs.setInt(3, cartDetail.getQuantity());
			cs.setInt(4, cartDetail.getUserID());
			if(cs.executeUpdate() == 1) {
				cs = conn.prepareCall(query2);
				cs.setInt(1, cart.getQuantity());
				cs.setDouble(2, cart.getTotalMoney());
				cs.setInt(3, cart.getUserID());
				if(cs.executeUpdate() == 1) {
					conn.commit();
					return true;
				}else {
					conn.rollback();
					return false;
				}
			}else {
				conn.rollback();
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteCartDetail(CartDetailModel cartDetail, CartModel cart) {
		String query1 = "{call dbo.PROC_DeleteCartDetail(?,?,?)}";
		String query2 = "{call dbo.PROC_EditCart(?,?,?)}";
		try {
			conn = new DBConnection().getConnect();
			conn.setAutoCommit(false);
			cs = conn.prepareCall(query1);
			cs.setInt(1, cartDetail.getProductID());
			cs.setString(2, cartDetail.getColor());
			cs.setInt(3, cartDetail.getUserID());
			if(cs.executeUpdate() == 1) {
				cs = conn.prepareCall(query2);
				cs.setInt(1, cart.getQuantity());
				cs.setDouble(2, cart.getTotalMoney());
				cs.setInt(3, cart.getUserID());
				if(cs.executeUpdate() == 1) {
					conn.commit();
					return true;
				}else {
					conn.rollback();
					return false;
				}
			}else {
				conn.rollback();
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
}
