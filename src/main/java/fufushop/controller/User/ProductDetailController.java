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
import fufushop.Model.ColorModel;
import fufushop.Model.ProductModel;
import fufushop.Service.IBrandService;
import fufushop.Service.IColorService;
import fufushop.Service.IProductService;
import fufushop.Service.Implement.BrandServiceImplement;
import fufushop.Service.Implement.ColorServiceImplement;
import fufushop.Service.Implement.ProductServiceImplement;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/product-detail"})
public class ProductDetailController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		IProductService productService = new ProductServiceImplement();
		IColorService colorService = new ColorServiceImplement();
		IBrandService brandService = new BrandServiceImplement();
		
		int productID = Integer.parseInt(req.getParameter("productID"));
		
		ProductModel product = productService.getProduct(productID);
		List<ColorModel> listColor = new ArrayList<ColorModel>();
		List<ProductModel> list10Product = new ArrayList<ProductModel>();
		List<BrandModel> listBrand = new ArrayList<BrandModel>();
		if(product != null) {
			listColor = colorService.getAllColor(productID);
			for(int i = 0; i < listColor.size(); i++) {
				if(listColor.get(i).quantity == 0) {
					listColor.remove(i);
					i--;
				}
			}
			product.setListColor(listColor);
			list10Product = productService.get10ProductProductDetailPage(product.getCategoryID());
			listBrand = brandService.getAllBrandStatus1();
		}else {
			resp.sendRedirect(req.getContextPath()+"/home");
			return;
		}
		
		req.setAttribute("listBrand", listBrand);
		req.setAttribute("list10Product", list10Product);
		req.setAttribute("product", product);
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/user/product-detail.jsp");
		rd.forward(req,resp);
	}
}
