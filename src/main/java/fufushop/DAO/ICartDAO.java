package fufushop.DAO;

import fufushop.Model.CartModel;

public interface ICartDAO {

	CartModel getCart(int userID);

	void insertCart(int userID);

}
