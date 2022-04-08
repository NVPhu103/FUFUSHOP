package fufushop.DAO;

import fufushop.Model.UserModel;

public interface IUserDAO{
	UserModel getUser(String userName, String password);
	
	int checkUsernameORPhone(String username, String phone);
	
	void insert(UserModel user);
	
	void edit(UserModel user);

	void editRole(int roleID, int userID);
}
