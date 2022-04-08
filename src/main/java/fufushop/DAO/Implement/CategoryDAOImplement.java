package fufushop.DAO.Implement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fufushop.Connection.DBConnection;
import fufushop.DAO.ICategoryDAO;

import fufushop.Model.CategoryModel;

public class CategoryDAOImplement implements ICategoryDAO{
	public Connection conn = null;
	public PreparedStatement ps = null;
	public CallableStatement cs = null;
	ResultSet rs = null;
	
	@Override
	public List<CategoryModel> getAllCategory() {
		String query = "SELECT * FROM [Category]";
		List<CategoryModel> listCate = new ArrayList<CategoryModel>();
		try {
			conn = new DBConnection().getConnect();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				listCate.add(new CategoryModel(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
		} catch (Exception e) {
			
		}
		return listCate;
	}

}
