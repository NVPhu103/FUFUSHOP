package fufushop.Service;

import fufushop.Model.CartModel;

public interface ICartService {
	CartModel getCart(int userID);
	
	void insertCart(int userID);
}
