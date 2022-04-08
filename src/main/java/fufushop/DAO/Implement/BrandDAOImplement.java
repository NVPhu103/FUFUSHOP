package fufushop.DAO.Implement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fufushop.Connection.DBConnection;
import fufushop.DAO.IBrandDAO;
import fufushop.Model.BrandModel;


public class BrandDAOImplement implements IBrandDAO{
	public Connection conn = null;
	public PreparedStatement ps = null;
	public CallableStatement cs = null;
	ResultSet rs = null;
	
	@Override
	public List<BrandModel> getAllBrand() {
		String query = "SELECT * FROM [Brand]";
		List<BrandModel> listBrand = new ArrayList<BrandModel>();
		try {
			conn = new DBConnection().getConnect();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				listBrand.add(new BrandModel(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
		} catch (Exception e) {
			
		}
		return listBrand;
	}
	
}
