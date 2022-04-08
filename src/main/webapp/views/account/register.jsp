<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/templates/" var="url"></c:url>

<!-- Begin Li's Breadcrumb Area -->
<div class="breadcrumb-area">
	<div class="container">
		<div class="breadcrumb-content">
			<ul>
				<li><a href="${pageContext.request.contextPath }/home">Home</a></li>
				<li class="active">Đăng ký tài khoản</li>
			</ul>
		</div>
	</div>
</div>
<!-- Li's Breadcrumb Area End Here -->
<!-- Begin Login Content Area -->
<div class="page-section mb-40">
	<div class="container ">
		<div class="row justify-content-center">
			<div class="col-sm-12 col-md-12 col-lg-6 col-xs-12">
				<form action="register" method="post">
					<div class="login-form">
						<h4 class="login-title">Đăng Ký</h4>
						<c:if test="${alertMess != null }">
							<div class="text-danger mb-10 ">
								<h7>${alertMess }</h7> 
							</div>	
						</c:if>
						<div class="row">
							<div class="col-md-6 col-12 mb-20">
								<label>Họ*</label> <input class="mb-0" type="text"
									placeholder="Nhập họ và tên lót" name="lastName" required>
							</div>
							<div class="col-md-6 col-12 mb-20">
								<label>Tên*</label> <input class="mb-0" type="text"
									placeholder="Nhập tên"  name="firstName" required>
							</div>
							<div class="col-md-12 mb-20">
								<label>Tên đăng nhập*</label> <input class="mb-0" type="text"
									placeholder="Nhập tên đăng nhập" name="username" required>
							</div>
							<div class="col-md-12 mb-20">
								<label>Số điện thoại*</label> <input class="mb-0" type="text"
									placeholder="Nhập số điện thoại" name="phone" required maxlength="12">
							</div>
							<div class="col-md-6 mb-20">
								<label>Mật khẩu*</label> <input class="mb-0" type="password"
									placeholder="Nhập mật khẩu" name="password" required>
							</div>
							<div class="col-md-6 mb-20">
								<label>Xác nhận mật khẩu*</label> <input class="mb-0" type="password" 
									placeholder="Nhập lại mật khẩu" name="confirmPassword" required> 
							</div>
							<div class="col-md-12 mb-10 text-right text-md-right">
								<a href="${pageContext.request.contextPath }/account/login" 
								class="">Bấm vào đây để đăng nhập</a>
							</div>
							<div class="col-12 ">
								<button type="submit" class="register-button mt-0">Đăng ký</button>
							</div>
						</div>
					</div>
				</form>
			</div>	
		</div>
	</div>
</div>
<!-- Login Content Area End Here -->