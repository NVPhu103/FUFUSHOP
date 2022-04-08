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

import fufushop.Model.UserModel;



@WebFilter("/seller/*")
public class SellerFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		//Kiểm tra xem đã đăng nhập chưa
		if(session != null && session.getAttribute("user") != null) {
			UserModel user = (UserModel)session.getAttribute("user");
			//Kiểm tra xem có quyền người bán hay không
			//Nếu có thì vào còn không thì trở về trang login để chuyển đến trang của mình (admin hoặc user)
			if(user.getRoleID() == 2) {
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
