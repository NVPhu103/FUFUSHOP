package fufushop.controller.Seller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fufushop.Model.ProductModel;
import fufushop.Model.UserModel;
import fufushop.Service.IPendingProductService;
import fufushop.Service.IProductService;
import fufushop.Service.Implement.PendingProductServiceImplement;
import fufushop.Service.Implement.ProductServiceImplement;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/seller/handleProduct"})
public class HandleProduct extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		try {
			IProductService productService = new ProductServiceImplement();
			IPendingProductService pendingProductService = new PendingProductServiceImplement();
			HttpSession session = req.getSession();
			UserModel user = (UserModel)session.getAttribute("user");
			int productID = Integer.parseInt(req.getParameter("productID"));
			ProductModel product = productService.getProduct(productID, user.getId());
			String action = req.getParameter("action");
			switch (action) {
				case "confirm":
					if(productService.confirmProduct(productID, user.getId()) == true){
						
						
						resp.sendRedirect(req.getContextPath()+"/seller/list-product?index=1");
						return;
					}else {
						resp.sendRedirect(req.getContextPath()+"/seller/list-pendingProduct?index=1");
						return;
					}
				case "cancel":
					//Have to delete product and product image in PendingProduct table
					pendingProductService.deletePendingProduct(productID, user.getId(), req);
					resp.sendRedirect(req.getContextPath()+"/seller/list-pendingProduct?index=1");
					return;
				case "stop":
					if(product.status == 1 || product.status == 2) {
						productService.editStatus(4, productID);
					}
				case "open":
					if(product.status == 3) {
						if(product.totalQuantity != 0) {
							productService.editStatus(1, productID);
						}
					}
				case "openAgain":
					if(product.status == 4) {
						if(product.totalQuantity != 0) {
							productService.editStatus(1, productID);
						}else {
							productService.editStatus(2, productID);
						}
						
					}
			}
			
			resp.sendRedirect(req.getContextPath()+"/seller/list-product?index=1");
			return;
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
}
