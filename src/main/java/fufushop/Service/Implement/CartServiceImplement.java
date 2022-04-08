package fufushop.Service.Implement;

import java.util.ArrayList;
import java.util.List;

import fufushop.DAO.ICartDAO;
import fufushop.DAO.Implement.CartDAOImplement;
import fufushop.Model.CartDetailModel;
import fufushop.Model.CartModel;
import fufushop.Service.ICartDetailService;
import fufushop.Service.ICartService;

public class CartServiceImplement implements ICartService{
	ICartDAO cartDAO = new CartDAOImplement();
	@Override
	public CartModel getCart(int userID) {
		//get Cart
		CartModel cart = cartDAO.getCart(userID);
		//get list CartDetail
		ICartDetailService cartDetailService = new CartDetailServiceImplement();
		List<CartDetailModel> listCartDetail = new ArrayList<CartDetailModel>();
		listCartDetail = cartDetailService.getAllCartDetail(userID);
		//set list CartDetail into Cart
		cart.setListCartDetail(listCartDetail);
		
		return cart;
	}
	@Override
	public void insertCart(int userID) {
		cartDAO.insertCart(userID);
		
	}

}
