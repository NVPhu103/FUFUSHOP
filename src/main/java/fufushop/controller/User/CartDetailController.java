package fufushop.controller.User;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import fufushop.Model.CartModel;
import fufushop.Model.UserModel;
import fufushop.Service.ICartService;
import fufushop.Service.Implement.CartServiceImplement;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/user/cart-detail"})
public class CartDetailController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = req.getSession();			
		UserModel user = (UserModel)session.getAttribute("user");
		
		ICartService cartSerive = new CartServiceImplement();
		CartModel cart = cartSerive.getCart(user.getId());
				
		
		
		req.setAttribute("cart", cart);		
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/user/cart-detail.jsp");
		rd.forward(req,resp);
	}
}
