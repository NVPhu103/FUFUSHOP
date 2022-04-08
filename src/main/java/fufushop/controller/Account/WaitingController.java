package fufushop.controller.Account;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fufushop.Model.UserModel;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/waiting"})
public class WaitingController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = req.getSession(true);
		if(session != null && session.getAttribute("user") != null) {
			UserModel user = (UserModel)session.getAttribute("user");
			if(user.getRoleID() == 3) {
				resp.sendRedirect(req.getContextPath() + "/admin/home");
			}else if(user.getRoleID() == 1 || user.getRoleID() == 2) {
				resp.sendRedirect(req.getContextPath() + "/home");
			}else {
				resp.sendRedirect(req.getContextPath() + "/account/login");
			}
			
		}
		
	}
}
