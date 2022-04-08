package fufushop.controller.Account;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fufushop.Model.UserModel;
import fufushop.Service.ICartService;
import fufushop.Service.IUserService;
import fufushop.Service.Implement.CartServiceImplement;
import fufushop.Service.Implement.UserServiceImplement;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/account/register"})
public class RegisterController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		  
		RequestDispatcher rd = req.getRequestDispatcher("/views/account/register.jsp");
		rd.forward(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		IUserService userService = new UserServiceImplement();
		ICartService cartService = new CartServiceImplement();
		
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String username = req.getParameter("username");
		String phone = req.getParameter("phone");
		String password = req.getParameter("password");
		String confirmPassword = req.getParameter("confirmPassword");
		
		String alertMess = "";
		if(password.equals(confirmPassword)) {
			if(userService.checkUsernameORPhone(username, phone) == 1) {
				alertMess = "Tên đăng nhập đã tồn tại !! Vui lòng chọn tên đăng nhập khác";
			}else if(userService.checkUsernameORPhone(username, phone) == 2) {
				alertMess = "Số điện thoại đã được sử dụng !! Vui lòng nhập số điện thoại khác";
			}else if(userService.checkUsernameORPhone(username, phone) == 0){
				UserModel user = new UserModel(lastName, firstName, username, password, phone);
				userService.insert(user);
				//Get userID to create user's Cart
				user = userService.getUser(username, password);
				cartService.insertCart(user.getId());
				alertMess = "Đã đăng ký thành công !!";
				String textColor = "text-success";
				req.setAttribute("alertMess", alertMess);
				req.setAttribute("textColor", textColor);
				req.getRequestDispatcher("/views/account/login.jsp").forward(req, resp);
			}
			else {
				alertMess = "Đã xảy ra lỗi !! Vui lòng đăng ký lại";
			}
		}else {
			alertMess = "Mật khẩu không giống nhau !! Vui lòng nhập lại mật khẩu";
					
		}
		req.setAttribute("alertMess", alertMess);
		req.getRequestDispatcher("/views/account/register.jsp").forward(req, resp);
	}
}
