package fufushop.controller.User;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fufushop.Model.CartDetailModel;
import fufushop.Model.CartModel;
import fufushop.Model.ColorModel;
import fufushop.Model.ProductModel;
import fufushop.Model.UserModel;
import fufushop.Service.ICartDetailService;
import fufushop.Service.ICartService;
import fufushop.Service.IColorService;
import fufushop.Service.IProductService;
import fufushop.Service.Implement.CartDetailServiceImplement;
import fufushop.Service.Implement.CartServiceImplement;
import fufushop.Service.Implement.ColorServiceImplement;
import fufushop.Service.Implement.ProductServiceImplement;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/add-cart"})
public class AddCartController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		try {
			HttpSession session = req.getSession();			
			UserModel user = (UserModel)session.getAttribute("user");
			
			IColorService colorService = new ColorServiceImplement();
			IProductService productService = new ProductServiceImplement();
			ICartDetailService cartDetailService = new CartDetailServiceImplement();
			ICartService cartService = new CartServiceImplement();
			
			int productID = Integer.parseInt(req.getParameter("productID"));
			String colorName = req.getParameter("colorName");
			int quantity = Integer.parseInt(req.getParameter("quantity"));
			
			//Get color of Product and check
			ColorModel colorOfProduct = colorService.getColor(colorName, productID);
			
			if(colorOfProduct.getQuantity() >= quantity) {
				
				CartModel cart = cartService.getCart(user.getId());
				List<CartDetailModel> listCartDetail = cart.getListCartDetail();
				//Location of product in cart detail (= -1 ==> not in it)
				
				int flag = -1;
				for(int i = 0; i < listCartDetail.size(); i++) {
					if(productID == listCartDetail.get(i).getProductID() && colorName.equals(listCartDetail.get(i).getColor())) {
						flag = i;
					}
				}
				// Common attribute to both cases
				ProductModel product = productService.getProduct(productID);
				double money = Math.round((double)(product.getPrice() * (1 - product.getSalePrice()/100))/100)*100 * quantity;
				cart.setTotalMoney(cart.getTotalMoney()+money);	// set new Cart Money 
				
				if(flag == -1) {	//still not on listCartDetail
					cart.setQuantity(cart.getQuantity()+1);
					CartDetailModel cartDetail = new CartDetailModel(productID, colorName, quantity, user.getId());
					
					if(cartDetailService.insertCartDetail(cartDetail, cart) == true) {
						// Decrease quantity of color
						colorOfProduct.setQuantity(quantity);
						colorService.decreaseColor(colorOfProduct);
						resp.sendRedirect(req.getContextPath()+"/user/cart-detail");
						return;
					}else {
						resp.sendRedirect(req.getContextPath()+"/product-detail?productID="+productID);
						return;
					}
				}else {
					CartDetailModel cartDetail = listCartDetail.get(flag);
					int newCartDetailQuantity = cartDetail.getQuantity()+quantity;
					cartDetail.setQuantity(newCartDetailQuantity);
					
					if(cartDetailService.editCartDetail(cartDetail, cart) == true) {
						// Decrease quantity of color
						colorOfProduct.setQuantity(quantity);
						colorService.decreaseColor(colorOfProduct);
						resp.sendRedirect(req.getContextPath()+"/user/cart-detail");
						return;
					}else {
						resp.sendRedirect(req.getContextPath()+"/product-detail?productID="+productID);
						return;
					}
				}
			}else {
				resp.sendRedirect(req.getContextPath()+"/product-detail?productID="+productID);
				return;
			}
		}catch (Exception e) {
			
		}
		
		
	}
}
