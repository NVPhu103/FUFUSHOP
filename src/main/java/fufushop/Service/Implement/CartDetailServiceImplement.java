package fufushop.Service.Implement;

import java.util.List;

import fufushop.DAO.ICartDetailDAO;
import fufushop.DAO.Implement.CartDetailDAOImplement;
import fufushop.Model.CartDetailModel;
import fufushop.Model.CartModel;
import fufushop.Model.ProductModel;
import fufushop.Service.ICartDetailService;
import fufushop.Service.IProductService;

public class CartDetailServiceImplement implements ICartDetailService{
	ICartDetailDAO cartDetailDAO = new CartDetailDAOImplement();
	IProductService productSerivce = new ProductServiceImplement();
	
	@Override
	public List<CartDetailModel> getAllCartDetail(int userID) {
		List<CartDetailModel> listCartDetail = cartDetailDAO.getAllCartDetail(userID);
		for(int i = 0; i < listCartDetail.size(); i++) {
			ProductModel product= productSerivce.getProduct(listCartDetail.get(i).getProductID());
			listCartDetail.get(i).setProduct(product);
		}
		return listCartDetail;
	}
	

	@Override
	public boolean insertCartDetail(CartDetailModel cartDetail, CartModel cart) {
		return cartDetailDAO.insertCartDetail(cartDetail, cart);
	}

	@Override
	public boolean editCartDetail(CartDetailModel cartDetail, CartModel cart) {
		return cartDetailDAO.editCartDetail(cartDetail, cart);
	}

	@Override
	public boolean deleteCartDetail(CartDetailModel cartDetail, CartModel cart) {
		return cartDetailDAO.deleteCartDetail(cartDetail, cart);
	}
	
}
