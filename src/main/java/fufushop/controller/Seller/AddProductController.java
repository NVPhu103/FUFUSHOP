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
		req.setAttribute("tagHeader", 1); 	//1 = thêm sản phẩm
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
			//Lấy file name của image do user gửi lên
			String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
			//Đường dẫn lưu file hình ảnh
			String realPath = req.getServletContext().getRealPath(Constant.SAVE_DIR_PRODUCT);
			
			//Kiểm tra file ảnh
			if(!fileName.contains(".jpg") && !fileName.contains(".png")){
				alert = "Dung lượng file tối đa 1MB || Định dạng ảnh: .PNG, .JPG";
				ResponseError(req, resp, alert);				
				return;
			}else {
				//Kiểm tra tên sản phẩm có tồn tại hay chưa
				if(productService.checkExistence(name, user.getId()) == false) {
					ProductModel product = new ProductModel();
					product.setName(name);
					product.setPrice(price);
					product.setSalePrice(salePrice);
					product.setTotalQuantity(0);
					product.setDescription(description);
					//Cập nhật lại tên image để lưu xuống database
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
						alert = "Tên sản phẩm đã tồn tại trong hàng chờ để duyệt !! Vui lòng nhập tên sản phẩm khác";
						ResponseError(req, resp, alert);				
						return;
					}
					
				}else {
					alert = "Tên sản phẩm đã tồn tại !! Vui lòng nhập tên sản phẩm khác";
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
		
		//Không sử dụng được sendRedirect do phải gửi các tham số lên trang jsp
	    //Do không chuyển hướng được nên phải gửi lại 2 tham số tag
	    req.setAttribute("tagHeader", 1); 	//1 = thêm sản phẩm
		req.setAttribute("tagActiveSideNav", 1);
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/seller/add-product.jsp");
		rd.forward(req,resp);
	}
}
