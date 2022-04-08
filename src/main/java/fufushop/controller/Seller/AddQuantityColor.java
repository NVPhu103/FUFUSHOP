package fufushop.controller.Seller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fufushop.Model.ColorModel;
import fufushop.Model.ProductModel;
import fufushop.Model.UserModel;
import fufushop.Service.IColorService;
import fufushop.Service.IProductService;
import fufushop.Service.Implement.ColorServiceImplement;
import fufushop.Service.Implement.ProductServiceImplement;

@SuppressWarnings("serial")
@WebServlet({"/seller/add-quantity"})
public class AddQuantityColor extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		int productID = Integer.parseInt(req.getParameter("productID"));
		
		IColorService colorService = new ColorServiceImplement();
		
		List<ColorModel> listColor = new ArrayList<ColorModel>();
		listColor = colorService.getAllColor(productID);
		
		
		Cookie productIDCookie = new Cookie("productID", String.valueOf(productID));	//Đưa productid lên để thực hiện các hành động phía sau
		productIDCookie.setMaxAge(60*60);
		resp.addCookie(productIDCookie);
		
		req.setAttribute("listColor", listColor);
		req.setAttribute("tagHeader", 6); 	//6 = thêm số lượng
		req.setAttribute("tagActiveSideNav", 2); // 2 = danh sách sản phẩm
		
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/seller/add-quantity.jsp");
		rd.forward(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		HttpSession session = req.getSession();			
		UserModel user = (UserModel)session.getAttribute("user");
		int productID = -1;
		IColorService colorService = new ColorServiceImplement();
		IProductService productService = new ProductServiceImplement();
		
		try {
			//get cookie has productID
			Cookie[] pIDCookie = req.getCookies();
			
			for(Cookie cookie: pIDCookie) {
				if(cookie.getName().equals("productID")) {
					productID = Integer.parseInt(cookie.getValue());
				}
			}
			String colorName = req.getParameter("color");
			int quantity = Integer.parseInt(req.getParameter("quantity"));
			ColorModel color = new ColorModel(colorName, quantity, productID);
			// Get action of form and check its value
			String action = req.getParameter("action");
			//Check value of action
			if("add-new".equals(action)) {
				if(productID != -1) {
					if(colorService.checkNameExist(colorName, productID) == false) {
						colorService.insertColor(color);
						//Get totalquantity from product => and then add quantity to totalQuantity
						ProductModel product = productService.getProduct(productID, user.getId());
						int totalQuantity = product.getTotalQuantity() + quantity;
						product.setTotalQuantity(totalQuantity);
						productService.editQuantity(totalQuantity, productID);
						if(totalQuantity != 0 && product.status == 2) {
							productService.editStatus(1, productID);
						}
					}
				}
			}else if("add-old".equals(action)) {
				colorService.addOldColor(color);
				// add extra quantity to totalQuantity
				ProductModel product = productService.getProduct(productID, user.getId());
				int totalQuantity = product.getTotalQuantity() + quantity;
				product.setTotalQuantity(totalQuantity);
				productService.editQuantity(totalQuantity, productID);
				if(totalQuantity != 0 && product.status == 2) {
					productService.editStatus(1, productID);
				}
			}else if("decrease".equals(action)) {
				if(colorService.decreaseColor(color) == true) {
					ProductModel product = productService.getProduct(productID, user.getId());
					int totalQuantity = product.getTotalQuantity() - quantity;
					product.setTotalQuantity(totalQuantity);
					productService.editQuantity(totalQuantity, productID);
					// Set status = 2 if totalQuantity = 0 and status = open for sale (=1)
					if(totalQuantity == 0 && product.status == 1) {
						productService.editStatus(2, productID);
					}
				}
			}
			
			
		}catch (Exception e) {
			
		}
		
		
		
		resp.sendRedirect(req.getContextPath()+"/seller/add-quantity?productID="+productID);
		return;
	}
}
