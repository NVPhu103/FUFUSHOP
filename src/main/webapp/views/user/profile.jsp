<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/templates/assets/" var="url"></c:url>
<c:url value="/uploads/avatar/" var="urlAvatar"></c:url>

<div class="container rounded bg-white mt-5 mb-15">
	<form action="" method="post" enctype="multipart/form-data">
	    <div class="row">
	        <div class="col-md-4 border-right mt-5">
	            <div class="d-flex flex-column align-items-center text-center p-3 py-5">
	            	<c:if test="${user.image == null }">
		            	<img class="rounded-circle mt-5 mb-10" src="${url }img/theme/DefaultUserImage1.png" width="200" height="200">
	            	</c:if>
	            	<c:if test="${user.image != null }">
	            		<img class="rounded-circle mt-5 mb-10" src="${urlAvatar }${user.image}" width="200" height="200">
	            	</c:if>		            
		            <span class="font-weight-bold "><h5>${user.lastName } ${user.firstName }</h5></span>
		            <div class="form-group mb-2"> 
		            	<input type="file" name="image" class="form-control">
		            </div>
					<span>Dung lượng file tối đa 1MB</span>
					<span>Định dạng: .PNG, .JPG</span>
					<c:if test="${alertMess != null }">
						<span class="text-danger">${alertMess }</span>
					</c:if>
	            </div>
	        </div>
	        <div class="col-md-8">
	            <div class="p-3 py-5">
	                <div class="d-flex justify-content-between align-items-center mb-3">
	                    <h4>Chỉnh sửa hồ sơ</h4>
	                    <div class="text-right ">
	                    	<a href="#"><button class="btn btn-success" type="button">Đổi mật khẩu</button></a>
	                    	<a href="#"><button class="btn btn-success" type="button">Đổi số điện thoại</button></a>
	                    </div>
	                </div>
	                <div class="row mt-2">
	                	<div class="col-md-6">
	                		<label class="font-weight-bold">Họ và tên lót</label><input type="text" name="lastName"  class="form-control"
	                			value="${user.lastName }" placeholder="${user.lastName }" required>
	                	</div>
	                    <div class="col-md-6">
	                    	<label class="font-weight-bold">Tên</label><input type="text" name="firstName" class="form-control"
	                    		placeholder="${user.firstName }" value="${user.firstName }" required>
	                    </div>
	
	                </div>
	                <div class="row mt-3">
		                	<div class="col-md-6">
		                		<c:if test="${user.email == null}">
		                			<label class="font-weight-bold">Email</label><input type="email" name="email"  class="form-control"
		                				placeholder="Nhập địa chỉ email" required>
		                		</c:if>
		                		<c:if test="${user.email != null}">
		                			<label class="font-weight-bold">Email</label><input type="email" name="email"  class="form-control"
		                			value="${user.email }" placeholder="Nhập email của bạn" required>
		                		</c:if>
		                	</div>
	                    <div class="col-md-6">
	                    	<label class="font-weight-bold">Số điện thoại</label><input type="text" class="form-control"  
	                    		value="${user.phone }" placeholder="${user.phone }" disabled>
	                    </div>
	                </div>
	                <div class="row mt-3">
	                    <div class="col-md-12">
							<c:if test="${user.address == null}">
								<label class="font-weight-bold">Địa chỉ</label>
								<input type="text" name="address" class="form-control"
									placeholder="Nhập địa chỉ của bạn" required>
							</c:if>
							<c:if test="${user.address != null}">
								<label class="font-weight-bold">Địa chỉ</label>
								<input type="text" name="address" class="form-control"
									value="${user.address }" placeholder="Nhập địa chỉ của bạn" required>
							</c:if>
	                    </div>
	                </div>
	                <div class="row mt-3">
						<div class="col-md-6">
							<div class="form-group">
								<c:if test="${user.gender == null}">
									<label class="font-weight-bold">Giới tính</label>
									<select class="form-control" name="gender">
										<option value="null" selected>Chọn giới tính</option>
										<option value="Nam">Nam</option>
										<option value="Nữ">Nữ</option>
										<option value="Khác">Khác</option>
									</select>
								</c:if>
								<c:if test="${user.gender != null}">
									<label class="font-weight-bold">Giới tính</label>
									<select class="form-control" name="gender" >
										<option ${user.gender == "Nam" ? "selected":"" } value="Nam">Nam</option>
										<option ${user.gender == "Nữ" ? "selected":"" } value="Nữ">Nữ</option>
										<option ${user.gender == "Khác" ? "selected":"" } value="Khác">Khác</option>
									</select>
								</c:if>
							</div>
						</div>
						<div class="col-md-6">
							<c:if test="${user.birthdate == null }">
								<label class="font-weight-bold">Ngày sinh</label>
								<input type="date" name="birthdate" class="form-control" required>
							</c:if>
							<c:if test="${user.birthdate != null }">
								<label class="font-weight-bold">Ngày sinh</label>
								<input type="date" name="birthdate" class="form-control"
									value="${user.birthdate }" placeholder="${user.birthdate }">
							</c:if>
							
						</div>
					</div>
	                <div class="mt-20 text-center "><button class="btn btn-warning" type="submit">Lưu thông tin</button></div>	                
				</div>
			</div>
		</div>
	</form>
</div>
