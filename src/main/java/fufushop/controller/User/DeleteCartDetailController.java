package fufushop.controller.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fufushop.Model.CartDetailModel;
import fufushop.Model.CartModel;
import fufushop.Model.ProductModel;
import fufushop.Model.UserModel;
import fufushop.Service.ICartDetailService;
import fufushop.Service.ICartService;
import fufushop.Service.Implement.CartDetailServiceImplement;
import fufushop.Service.Implement.CartServiceImplement;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/delete-cartdetail"})
public class DeleteCartDetailController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		HttpSession session = req.getSession();			
		UserModel user = (UserModel)session.getAttribute("user");
		
		ICartDetailService cartDetailService = new CartDetailServiceImplement();
		ICartService cartService = new CartServiceImplement();
		
		
		int productID = Integer.parseInt(req.getParameter("productID"));
		String colorName = req.getParameter("color");
		int quantity = -1;
		ProductModel product = new ProductModel();
		CartModel cart = cartService.getCart(user.getId());
		
		for(int i = 0; i < cart.getListCartDetail().size(); i++) {
			if(colorName.equals(cart.getListCartDetail().get(i).getColor()) && productID == cart.getListCartDetail().get(i).getProductID()){
				quantity = cart.getListCartDetail().get(i).getQuantity();
				product = cart.getListCartDetail().get(i).getProduct();
			}
		}
		
		CartDetailModel cartDetail = new CartDetailModel(productID, colorName, quantity, user.getId());
		double money = Math.round((double)(product.getPrice() * (1 - product.getSalePrice()/100))/100)*100 * quantity;
		cart.setTotalMoney(cart.getTotalMoney()-money);
		cart.setQuantity(cart.getQuantity()-1);
		if(cartDetailService.deleteCartDetail(cartDetail, cart)) {
			
		}else {
			
		}
		resp.sendRedirect(req.getContextPath()+"/user/cart-detail");
		return;
		
	}
}
