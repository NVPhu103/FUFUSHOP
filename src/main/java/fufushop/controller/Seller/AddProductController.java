package fufushop.controller.Seller;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.xml.ws.Response;

import fufushop.Constant.Constant;
import fufushop.Model.BrandModel;
import fufushop.Model.CategoryModel;
import fufushop.Model.ProductModel;
import fufushop.Model.UserModel;
import fufushop.Service.IBrandService;
import fufushop.Service.ICategoryService;
import fufushop.Service.IPendingProductService;
import fufushop.Service.IProductService;
import fufushop.Service.Implement.BrandServiceImplement;
import fufushop.Service.Implement.CategoryServiceImplement;
import fufushop.Service.Implement.PendingProductServiceImplement;
import fufushop.Service.Implement.ProductServiceImplement;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/seller/add-product"})
@MultipartConfig(maxFileSize = 1024 * 1024 * 1)	// 1MB
public class AddProductController extends HttpServlet{
	IBrandService brandService = new BrandServiceImplement();
	ICategoryService categoryService = new CategoryServiceImplement();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		
		
		List<BrandModel> listBrandStatus1 = brandService.getAllBrandStatus1();
		List<CategoryModel> listCateStatus1 = categoryService.getAllCategoryStatus1();
		
		req.setAttribute("listBrandStatus1", listBrandStatus1);
		req.setAttribute("listCateStatus1", listCateStatus1);
		req.setAttribute("tagHeader", 1); 	//1 = th??m s???n ph???m
		req.setAttribute("tagActiveSideNav", 1);
		
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/seller/add-product.jsp");
		rd.forward(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String alert= "";
		try {
			HttpSession session = req.getSession();			
			UserModel user = (UserModel)session.getAttribute("user");
			IPendingProductService pendingProductService = new PendingProductServiceImplement();
			IProductService productService = new ProductServiceImplement();
			
			int status = 6;
			double price = Double.parseDouble(req.getParameter("price"));
			String name = req.getParameter("name");
			int categoryID = Integer.parseInt(req.getParameter("category"));
			int brandID = Integer.parseInt(req.getParameter("brand"));
			float salePrice = Float.parseFloat(req.getParameter("salePrice"));
			String description = req.getParameter("description");
			Part part = req.getPart("image");
			//L???y file name c???a image do user g???i l??n
			String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
			//???????ng d???n l??u file h??nh ???nh
			String realPath = req.getServletContext().getRealPath(Constant.SAVE_DIR_PRODUCT);
			
			//Ki???m tra file ???nh
			if(!fileName.contains(".jpg") && !fileName.contains(".png")){
				alert = "Dung l?????ng file t???i ??a 1MB || ?????nh d???ng ???nh: .PNG, .JPG";
				ResponseError(req, resp, alert);				
				return;
			}else {
				//Ki???m tra t??n s???n ph???m c?? t???n t???i hay ch??a
				if(productService.checkExistence(name, user.getId()) == false) {
					ProductModel product = new ProductModel();
					product.setName(name);
					product.setPrice(price);
					product.setSalePrice(salePrice);
					product.setTotalQuantity(0);
					product.setDescription(description);
					//C???p nh???t l???i t??n image ????? l??u xu???ng database
					int index = fileName.lastIndexOf(".");
					String tail = fileName.substring(index);
					fileName = name+"Product" + tail;
					product.setImage(fileName);
					product.setCategoryID(categoryID);
					product.setBrandID(brandID);
					product.setUserID(user.getId());
					product.setStatus(status);
					if(!Files.exists(Paths.get(realPath))) {
						Files.createDirectories(Paths.get(realPath));	
					}
					if(pendingProductService.checkExistence(product.name, user.getId()) == false ) {
						part.write(realPath+"/"+fileName);
						Files.copy(Paths.get(realPath+"/"+fileName), Paths.get(Constant.SAVE_DIR_PRODUCT_BACKUP+fileName), REPLACE_EXISTING);
						pendingProductService.insertPendingProduct(product);			
						resp.sendRedirect("list-pendingProduct?index=1");			
						return;
					}else {
						alert = "T??n s???n ph???m ???? t???n t???i trong h??ng ch??? ????? duy???t !! Vui l??ng nh???p t??n s???n ph???m kh??c";
						ResponseError(req, resp, alert);				
						return;
					}
					
				}else {
					alert = "T??n s???n ph???m ???? t???n t???i !! Vui l??ng nh???p t??n s???n ph???m kh??c";
					ResponseError(req, resp, alert);				
					return;
				}
			}
		} catch (Exception e) {
			alert = e.toString();
			ResponseError(req, resp, alert);				
			return;
		}
		
		
		
	}
	
	void ResponseError(HttpServletRequest req, HttpServletResponse resp,String alert) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("<script type=\"text/javascript\">");
	    out.println("alert('"+alert+"');");		    
	    out.println("</script>");
	    
		List<BrandModel> listBrandStatus1 = brandService.getAllBrandStatus1();
		List<CategoryModel> listCateStatus1 = categoryService.getAllCategoryStatus1();
		
		req.setAttribute("listBrandStatus1", listBrandStatus1);
		req.setAttribute("listCateStatus1", listCateStatus1);
		
		//Kh??ng s??? d???ng ???????c sendRedirect do ph???i g???i c??c tham s??? l??n trang jsp
	    //Do kh??ng chuy???n h?????ng ???????c n??n ph???i g???i l???i 2 tham s??? tag
	    req.setAttribute("tagHeader", 1); 	//1 = th??m s???n ph???m
		req.setAttribute("tagActiveSideNav", 1);
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/seller/add-product.jsp");
		rd.forward(req,resp);
	}
}
