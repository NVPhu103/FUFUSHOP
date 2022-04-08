package fufushop.DAO.Implement;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fufushop.Connection.DBConnection;
import fufushop.DAO.IUserDAO;
import fufushop.Model.UserModel;

public class UserDAOImplement implements IUserDAO {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public CallableStatement cs = null;
	ResultSet rs = null;
	
	@Override
	public UserModel getUser(String userName, String password) {
		String query = "SELECT * FROM FUNC_GetUser(?,?)";
		try {
			conn = new DBConnection().getConnect();
			ps = conn.prepareStatement(query);
			ps.setString(1, userName);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next()) {
				return new UserModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6),
						rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12));
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}
	
	public static void main(String[] args) throws SQLException{
		/*UserModel user = new UserModel();
		IUserDAO userDao = new UserDAOImplement();
		userDao.insert(user);
		System.out.println();*/
		
		
		/*Connection conn = null;
		CallableStatement cs = null;
		UserModel user = new UserModel("Nguyễn","A","nguyenvanA","123","025","image");
		UserModel user2 = new UserModel("Nguyễn","AB","vanphu1","123","0123456","image");
		String query = "{call dbo.PROC_RegisterUser(?,?,?,?,?,?)}";
		try {
			conn = new DBConnection().getConnect();
			conn.setAutoCommit(false);
			cs = conn.prepareCall(query);
			cs.setString(1, user.getLastName());
			cs.setString(2, user.getFirstName());
			cs.setString(3, user.getUserName());
			cs.setString(4, user.getPassword());
			cs.setString(5, user.getPhone());
			cs.setString(6, user.getImage());
			System.out.println("Bat dau");
			if(cs.executeUpdate() == 1) {	
				System.out.println("TC Buoc 1");
				cs.setString(1, user2.getLastName());
				cs.setString(2, user2.getFirstName());
				cs.setString(3, user2.getUserName());
				cs.setString(4, user2.getPassword());
				cs.setString(5, user2.getPhone());
				cs.setString(6, user2.getImage());
				if(cs.executeUpdate() == 1) {
					conn.commit();
					System.out.println("TC Buoc 2");
				}else {
					conn.rollback();
				}
			}
		} catch (Exception e) {
			conn.rollback();
		}*/
		
	}

	@Override
	//Return 1 => Trùng username, return 2 => trùng phone, return 0 => không trùng
	public int checkUsernameORPhone(String username, String phone) {
		String query = "SELECT dbo.Func_CheckUsernameORPhone(?,?)";
		int result = -1;
		try {
			conn = new DBConnection().getConnect();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, phone);
			rs = ps.executeQuery();	//trả về resultSet dành cho câu lệnh SELECT
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			
		}
		return result;
	}

	@Override
	public void insert(UserModel user) {
		String query = "{call dbo.PROC_RegisterUser(?,?,?,?,?)}";
		try {
			conn = new DBConnection().getConnect();
			cs = conn.prepareCall(query);
			cs.setString(1, user.getLastName());
			cs.setString(2, user.getFirstName());
			cs.setString(3, user.getUserName());
			cs.setString(4, user.getPassword());
			cs.setString(5, user.getPhone());
			cs.executeUpdate();		//Trả về số dòng bị tác động của câu lệnh Insert, Update, Delete
		} catch (Exception e) {
			
		}
	}

	@Override
	public void edit(UserModel user) {
		String query = "{call dbo.PROC_EditUser(?,?,?,?,?,?,?,?)}";
		try {
			conn = new DBConnection().getConnect();
			cs = conn.prepareCall(query);
			cs.setInt(1, user.getId());
			cs.setString(2, user.getLastName());
			cs.setString(3, user.getFirstName());
			cs.setDate(4, user.getBirthdate());
			cs.setString(5, user.getGender());
			cs.setString(6, user.getEmail());
			cs.setString(7, user.getAddress());
			cs.setString(8, user.getImage());
			cs.executeUpdate();		//Trả về số dòng bị tác động của câu lệnh Insert, Update, Delete
		} catch (Exception e) {
			
		}
		
	}

	@Override
	public void editRole(int roleID, int userID) {
		String query = "{call dbo.PROC_EditRoleIDOfUser(?,?)}";
		try {
			conn = new DBConnection().getConnect();
			conn.setAutoCommit(false);
			cs = conn.prepareCall(query);
			cs.setInt(1, roleID);
			cs.setInt(2, userID);
			if(cs.executeUpdate() == 1) {
				conn.commit();
			}
			else {
				conn.rollback();
			}
		} catch (Exception e) {
			
		}
		
	}
	
}
