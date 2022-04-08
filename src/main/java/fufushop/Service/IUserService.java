package fufushop.Service;

import fufushop.Model.UserModel;

public interface IUserService {
	
	boolean CheckUser(String username, String password);
	
	UserModel getUser(String username, String password);
	
	void insert(UserModel user);
	
	int checkUsernameORPhone(String username, String phone);	//true nếu username hoặc phone đã có
	
	void edit(UserModel user);
	
	void editRole(int roleID, int userID);
}
