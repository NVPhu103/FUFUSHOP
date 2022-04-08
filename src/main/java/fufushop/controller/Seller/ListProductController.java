package fufushop.controller.Seller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fufushop.Model.ProductModel;
import fufushop.Model.UserModel;
import fufushop.Service.IProductService;
import fufushop.Service.Implement.ProductServiceImplement;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/seller/list-product"})
public class ListProductController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		IProductService productService = new ProductServiceImplement();
		
		HttpSession session = req.getSession();
		UserModel user = (UserModel)session.getAttribute("user");
		//Paging
		int index = Integer.parseInt(req.getParameter("index").toString());
		int endP = productService.getEndPage(user.getId());
		
		
		List<ProductModel> listAllProduct = new ArrayList<ProductModel>();
		listAllProduct = productService.getProductByUserID(user.getId(), index);	//listProduct đã qua paging 
		
		req.setAttribute("listAllProduct", listAllProduct);
		req.setAttribute("index", index);
		req.setAttribute("endP", endP);
		
		req.setAttribute("tagHeader", 2); 	//2 = danh sách sản phẩm
		req.setAttribute("tagActiveSideNav", 2);
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/seller/list-product.jsp");
		rd.forward(req,resp);
	}
}
