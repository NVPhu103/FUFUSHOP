package fufushop.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fufushop.Model.CartModel;
import fufushop.Model.UserModel;
import fufushop.Service.ICartService;
import fufushop.Service.Implement.CartServiceImplement;

@WebFilter({"/user/*","/add-cart","/delete-cartdetail"})
public class UserFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		if(session != null && session.getAttribute("user") != null) {
			UserModel user = (UserModel)session.getAttribute("user");
			if(user.getRoleID() == 1 || user.getRoleID() == 2) {
				ICartService cartSerive = new CartServiceImplement();
				CartModel cart = cartSerive.getCart(user.getId());
				req.setAttribute("cart", cart);
				chain.doFilter(request, response);
			}else {
				resp.sendRedirect(req.getContextPath()+"/account/login");
			}
		}else {
			resp.sendRedirect(req.getContextPath()+"/account/login");
		}
	}

	@Override
	public void destroy() {
		
		
	}

}
