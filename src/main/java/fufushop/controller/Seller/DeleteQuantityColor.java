package fufushop.controller.Seller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fufushop.Model.ProductModel;
import fufushop.Model.UserModel;
import fufushop.Service.IColorService;
import fufushop.Service.IProductService;
import fufushop.Service.Implement.ColorServiceImplement;
import fufushop.Service.Implement.ProductServiceImplement;

@SuppressWarnings("serial")
@WebServlet({"/seller/delete-quantity"})
public class DeleteQuantityColor extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = req.getSession();			
		UserModel user = (UserModel)session.getAttribute("user");
		
		IColorService colorService = new ColorServiceImplement();
		IProductService productService = new ProductServiceImplement();
		
		int productID = Integer.parseInt(req.getParameter("productID"));
		String name = req.getParameter("name");
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		
		colorService.deleteColor(name, productID);
		
		ProductModel product = productService.getProduct(productID, user.getId());
		int totalQuantity = product.getTotalQuantity() - quantity;
		productService.editQuantity(totalQuantity, productID);
		// if total Quantity = 0 and status = 1, Set status = 2
		if(totalQuantity == 0 && product.status == 1) {
			productService.editStatus(2, productID);
		}
		resp.sendRedirect(req.getContextPath()+"/seller/add-quantity?productID="+productID);
		return;
	}
}
