package fufushop.controller.Account;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fufushop.Constant.Constant;
import fufushop.Model.UserModel;
import fufushop.Service.IUserService;
import fufushop.Service.Implement.UserServiceImplement;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/account/login"})
public class LoginController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		//check session
		HttpSession session = req.getSession(false);
		if(session != null && session.getAttribute("user") != null) {
			resp.sendRedirect(req.getContextPath()+"/waiting");
			return;
		}
		//check cookie (remember me)
		Cookie[] cookies = req.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals(Constant.COOKIE_REMEMBER)) {
					session = req.getSession(true);
					session.setAttribute(Constant.SESSION_REMEMBER, cookie.getValue());
				}
			}
		}
		
		req.getRequestDispatcher("/views/account/login.jsp").forward(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		IUserService userService = new UserServiceImplement();
		
		String usernameORphone = req.getParameter("usernameORphone").toString();
		String password = req.getParameter("password").toString();
		String remember_me = req.getParameter("remember_me");
		boolean isRememberMe = false;
		
		if("on".equals(remember_me)) {
			isRememberMe = true;
		}
		String alertMess= "";
		UserModel user = new UserModel();
		if(userService.CheckUser(usernameORphone, password)) {
			user = userService.getUser(usernameORphone, password);
			HttpSession session = req.getSession(true);
			session.setAttribute("user", user);
			user.setPassword(null);
			req.setAttribute("user", user);
			// Lưu cookie cho lần đăng nhập sau nếu tích remember me
			if(isRememberMe) {
				SaveRememberMe(resp, usernameORphone);
			}		
			resp.sendRedirect(req.getContextPath() + "/waiting");
		}else {
			alertMess = "Tên đăng nhập hoặc mật khẩu không chính xác !! Vui lòng đăng nhập lại";
			req.setAttribute("alertMess", alertMess);
			req.getRequestDispatcher("/views/account/login.jsp").forward(req,resp);
		}
	}
	public void SaveRememberMe(HttpServletResponse resp, String usernameORphone) {
		Cookie  cookie = new Cookie(Constant.COOKIE_REMEMBER,usernameORphone);
		//cookie.setMaxAge(0);	//xóa cookie
		resp.addCookie(cookie);
	}
}
