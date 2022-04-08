package fufushop.controller.User;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fufushop.Model.UserModel;
import fufushop.Service.IUserService;
import fufushop.Service.Implement.UserServiceImplement;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/user/edit-role"})
public class EditRoleIDController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = req.getSession();
		UserModel user = (UserModel)session.getAttribute("user");
		
		IUserService userService = new UserServiceImplement();
		if(user.getRoleID() == 1) {
			userService.editRole(2, user.getId());
			user.setRoleID(2);
			session.setAttribute("user", user);
			user.setPassword(null);
			req.setAttribute("user", user);
			resp.sendRedirect(req.getContextPath()+"/home");
			return;
		}else {
			resp.sendRedirect(req.getContextPath()+"/waiting");
			return;
		}
	}
}
