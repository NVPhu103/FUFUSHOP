package fufushop.Service;

import java.util.List;

import fufushop.Model.CartDetailModel;
import fufushop.Model.CartModel;

public interface ICartDetailService {
	
	List<CartDetailModel> getAllCartDetail(int userID);
	
	boolean insertCartDetail(CartDetailModel cartDetail, CartModel cart);

	boolean editCartDetail(CartDetailModel cartDetail, CartModel cart);
	
	boolean deleteCartDetail(CartDetailModel cartDetail, CartModel cart);
}
