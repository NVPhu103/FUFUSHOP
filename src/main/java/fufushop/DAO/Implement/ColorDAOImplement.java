package fufushop.DAO.Implement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fufushop.Connection.DBConnection;
import fufushop.DAO.IColorDAO;
import fufushop.Model.ColorModel;

public class ColorDAOImplement implements IColorDAO{
	public Connection conn = null;
	public PreparedStatement ps = null;
	public CallableStatement cs = null;
	ResultSet rs = null;
	
	
	@Override
	public List<ColorModel> getAllColor(int productID) {
		List<ColorModel> listColor = new ArrayList<ColorModel>();
		String query = "SELECT * FROM Func_GetAllColor(?)";
		try {
			conn = new DBConnection().getConnect();
			ps = conn.prepareStatement(query);
			ps.setInt(1, productID);
			rs = ps.executeQuery();
			while(rs.next()) {
				listColor.add(new ColorModel(rs.getString(1), rs.getInt(2), rs.getInt(3)));
			}
		}catch (Exception e) {
			
		}
		return listColor;
	}


	@Override
	public ColorModel getColor(String name, int productID) {
		ColorModel color = null;
		String query = "SELECT * FROM Func_GetColor(?,?)";
		try {
			conn = new DBConnection().getConnect();
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setInt(2, productID);
			rs = ps.executeQuery();
			while(rs.next()) {
				color = new ColorModel(rs.getString(1), rs.getInt(2), rs.getInt(3));
			}
		}catch (Exception e) {
			
		}
		return color;
	}


	@Override
	public void insertColor(ColorModel color) {
		String query = "{call dbo.PROC_InsertColor(?,?,?)}";
		try {
			conn = new DBConnection().getConnect();
			conn.setAutoCommit(false);
			cs = conn.prepareCall(query);
			cs.setString(1, color.getName());
			cs.setInt(2, color.getQuantity());
			cs.setInt(3, color.getProductID());
			if(cs.executeUpdate() == 1) {
				conn.commit();
			}else {
				conn.rollback();
			}
		}catch (Exception e) {
			
		}
	}


	@Override
	public void deleteColor(String name, int productID) {
		String query = "{call dbo.PROC_DeleteColor(?,?)}";
		try {
			conn = new DBConnection().getConnect();
			conn.setAutoCommit(false);
			cs = conn.prepareCall(query);
			cs.setString(1, name);
			cs.setInt(2, productID);
			if(cs.executeUpdate() == 1) {
				conn.commit();
			}else {
				conn.rollback();
			}
		}catch (Exception e) {
			
		}
		
	}


	@Override
	public void editColor(ColorModel color) {
		String query = "{call dbo.PROC_EditColor(?,?,?)}";
		try {
			conn = new DBConnection().getConnect();
			conn.setAutoCommit(false);
			cs = conn.prepareCall(query);
			cs.setString(1, color.getName());
			cs.setInt(2, color.getQuantity());
			cs.setInt(3, color.getProductID());
			if(cs.executeUpdate() == 1) {
				conn.commit();
			}else {
				conn.rollback();
			}
		}catch (Exception e) {
			
		}
		
	}
	
}
