package fufushop.controller.User;



import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.*;
import java.nio.file.Paths;
import java.sql.Date;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;



import fufushop.Constant.Constant;
import fufushop.Model.UserModel;
import fufushop.Service.IUserService;
import fufushop.Service.Implement.UserServiceImplement;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/user/profile"})
@MultipartConfig(maxFileSize = 1024 * 1024 * 1) // 1MB
public class EditProfile extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		
		
		req.getRequestDispatcher("/views/user/profile.jsp").forward(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		IUserService userService = new UserServiceImplement();
		try {
			
			HttpSession session = req.getSession();			
			UserModel user = (UserModel)session.getAttribute("user");
			//Sử dụng MultipartConfig
			//Lấy gender
			String gender = null;			
			if(!"NULL".equals(req.getParameter("gender"))) {
				gender = req.getParameter("gender").toString();
			}
			//Lấy birthdate
			String bd = req.getParameter("birthdate");
			Date birthdate = Date.valueOf(bd);
			//Lấy các tham số khác
			String lastName = req.getParameter("lastName");
			String firstName = req.getParameter("firstName");
			String email = req.getParameter("email");
			
			String address = req.getParameter("address");
			String image = user.getImage();
			
			//Lấy image và upload lên server
			Part part = req.getPart("image");
			String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
			if(!fileName.isEmpty()) {
				String realPath = req.getServletContext().getRealPath(Constant.SAVE_DIR_AVATAR);
				if(!fileName.contains(".jpg") && !fileName.contains(".png")) {
					String alertMess = "File phải có định dạng: .PNG, .JPG và dung lượng tối đa 1MB";
					req.setAttribute("alertMess", alertMess);
					req.getRequestDispatcher("/views/user/profile.jsp").forward(req,resp);
					return;	//Dừng không thực hiện các dòng phía dưới
				}else {
					//Tạo đường dẫn /uploads/avatar nếu chưa có
					if(!Files.exists(Paths.get(realPath))) {
						Files.createDirectories(Paths.get(realPath));	
					}
					//Cập nhật lại tên image để lưu xuống database
					int index = fileName.lastIndexOf(".");
					String tail = fileName.substring(index);
					fileName = user.getUserName()+"Avatar" + tail;								
					part.write(realPath+"/"+fileName);
					//Lưu lại file hình ảnh phòng khi delete server sẽ xóa hết file
					//REPLACE_EXISTING ghi đè nếu file đã tồn tại
					Files.copy(Paths.get(realPath+"/"+fileName), Paths.get(Constant.SAVE_DIR_AVATAR_BACKUP+fileName), REPLACE_EXISTING);
					image = fileName;
				}
				
			}else {
				//Không cập nhật ảnh mới
				//Sử dụng ảnh cũ trong user
			}
			user.setLastName(lastName);
			user.setFirstName(firstName);
			user.setBirthdate(birthdate);
			user.setAddress(address);
			user.setEmail(email);			
			user.setGender(gender);
			user.setImage(image);
			userService.edit(user);
			//req.getRequestDispatcher("/views/user/profile.jsp").forward(req,resp);
			
			resp.sendRedirect(req.getContextPath()+"/user/profile");
			return;
			
			/*//Sử dụng thư viện Common file upload 
			//==> Chưa biết cách sử dụng hình ảnh nên khi uploads lên thư mục khác phải load lại trang
			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
			ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
			List<FileItem> items = servletFileUpload.parseRequest(req);
			// Lấy các parameter
			String lastName = items.get(1).getString("UTF-8");
			String firstName = items.get(2).getString("UTF-8");
			String email = items.get(3).getString("UTF-8");
			String address = items.get(4).getString("UTF-8");
			String gender = items.get(5).getString("UTF-8");
			String bd = items.get(6).getString();
			Date birthdate = Date.valueOf(bd);
			String image = user.getImage();
			
			//Xử lý file ảnh
			if(items.get(0).getSize()>0) {
				String oriFileName = items.get(0).getName();
				int maxFileSize = 1024*1024*1; //1MB
				//Not .PNG, .JPG file and file size > 1MB
				if(!oriFileName.contains(".jpg") && !oriFileName.contains(".png")) {
					String alertMess = "File phải có định dạng: .PNG, .JPG và dung lượng tối đa 1MB";
					req.setAttribute("alertMess", alertMess);
					req.getRequestDispatcher("/views/user/profile.jsp").forward(req,resp);
					return;
				}else {
					int index = oriFileName.lastIndexOf(".");
					String tail = oriFileName.substring(index);
					String fileName = user.getUserName()+"Avatar"+tail;
					File file = new File(Constant.DIR_AVATAR+"/"+fileName);
					items.get(0).write(file);
					image = fileName;
				}
			}else {
				//Don't update new image
				//Use old image in USER
			}
			user.setLastName(lastName);
			user.setFirstName(firstName);
			user.setBirthdate(birthdate);
			user.setAddress(address);
			user.setEmail(email);			
			user.setGender(gender);
			user.setImage(image);
			userService.edit(user);
			*/
					
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			/*String alertMess = "File phải có định dạng: .PNG, .JPG và dung lượng tối đa 1MB";
			req.setAttribute("alertMess", alertMess);
			req.getRequestDispatcher("/views/user/profile.jsp").forward(req,resp);*/
		}
		
	}
	
	
}
