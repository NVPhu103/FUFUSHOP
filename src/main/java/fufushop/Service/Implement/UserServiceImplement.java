package fufushop.Service.Implement;

import fufushop.DAO.IUserDAO;
import fufushop.DAO.Implement.UserDAOImplement;
import fufushop.Model.UserModel;
import fufushop.Service.IUserService;

public class UserServiceImplement implements IUserService{
	
	IUserDAO userDAO = new UserDAOImplement();
	
	@Override
	public boolean CheckUser(String username, String password) {
		UserModel user = userDAO.getUser(username, password);
		if(user != null) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public UserModel getUser(String username, String password) {
		return userDAO.getUser(username, password);
	}
	
	public static void main(String[] args) {
		/*IUserService userService = new UserServiceImplement();
		if(userService.CheckUser("vanphu", "1234")) {
			System.out.println("OKE");
		}else {
			System.out.println("NOT OKE");
		}*/
	}

	@Override
	public void insert(UserModel user) {
		userDAO.insert(user);
	}

	@Override
	public int checkUsernameORPhone(String username, String phone) {
		return userDAO.checkUsernameORPhone(username, phone);
	}

	@Override
	public void edit(UserModel user) {
		userDAO.edit(user);
	}

	@Override
	public void editRole(int roleID, int userID) {
		userDAO.editRole(roleID, userID);
		
	}
	
}
