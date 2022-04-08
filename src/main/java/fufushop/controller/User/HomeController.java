package fufushop.controller.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fufushop.Model.BrandModel;
import fufushop.Model.CategoryModel;
import fufushop.Model.ProductModel;
import fufushop.Service.IBrandService;
import fufushop.Service.ICategoryService;
import fufushop.Service.IProductService;
import fufushop.Service.Implement.BrandServiceImplement;
import fufushop.Service.Implement.CategoryServiceImplement;
import fufushop.Service.Implement.ProductServiceImplement;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		IProductService productService = new ProductServiceImplement();
		IBrandService brandService = new BrandServiceImplement();
		ICategoryService categoryService = new CategoryServiceImplement();
		
		List<ProductModel> list10Product = new ArrayList<ProductModel>();
		List<ProductModel> listAllProduct = new ArrayList<ProductModel>();
		
		String tag = req.getParameter("tag");
		if ("bestseller".equals(tag)){
			tag = "bestseller";
			
		}else {
			tag = "null";
			list10Product = productService.getNewArrivalProductHomePage();
			listAllProduct = productService.getAllProductHomePage();
			
		}
		
		List<BrandModel> listBrand = brandService.getAllBrandStatus1();
		List<CategoryModel> listCategory = categoryService.getAllCategoryStatus1();
		
		req.setAttribute("list10Product", list10Product);
		req.setAttribute("listBrand", listBrand);
		req.setAttribute("listCategory", listCategory);
		req.setAttribute("listAllProduct", listAllProduct);
		req.setAttribute("count", 0);
		req.setAttribute("tag", tag);
		
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/user/home.jsp");
		rd.forward(req,resp); 

	}
}