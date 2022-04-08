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
				<li class="active">Đăng nhập</li>
			</ul>
		</div>
	</div>
</div>
<!-- Li's Breadcrumb Area End Here -->
<!-- Begin Login Content Area -->
<div class="page-section mb-40">
	<div class="container ">
		<div class="row justify-content-center">
			<div class="col-sm-12 col-md-12 col-xs-12 col-lg-6 mb-10 ">
				<!-- Login Form  -->
				<form action="login" method="post">
					<div class="login-form">
						<h4 class="login-title">Đăng nhập</h4>
						<c:if test="${alertMess != null }">
							<c:if test="${textColor != null }">
								<div class="${textColor } mb-10 ">
								<h7>${alertMess }</h7> </div>
							</c:if>
							<c:if test="${textColor == null }">
								<div class="text-danger mb-10 ">
								<h7>${alertMess }</h7> </div>
							</c:if>
						</c:if>
						<div class="row">
							<div class="col-md-12 col-12 mb-10">
								<c:choose>
									<c:when test="${cookie.usernameORphone != null }">
										<label>Tên đăng nhập / Số điện thoại*</label> <input class="mb-0" type="text"
										name="usernameORphone" placeholder="Nhập tên tài khoản / số điện thoại"
										value="${cookie.usernameORphone.getValue() }" required>
									</c:when>
									<c:otherwise>
										<label>Tên đăng nhập / Số điện thoại*</label> <input class="mb-0" type="text"
										name="usernameORphone" placeholder="Nhập tên tài khoản / số điện thoại" required>
									</c:otherwise>
								</c:choose>						
							</div>
							<div class="col-12 mb-10">
								<label>Mật khẩu*</label> <input class="mb-0" type="password" 
									name="password" placeholder="Nhập mật khẩu" required>
							</div>
							<div class="col-md-12  text-right text-md-right">
								<a href="${pageContext.request.contextPath }/account/register" 
								class=""> Bạn chưa có tài khoản? Bấm vào đây để đăng ký</a>
							</div>
							<div class="col-md-8">
								<div class="check-box d-inline-block ml-0 ml-md-2 mt-10">
									<input type="checkbox" id="remember_me" name="remember_me" value="on"> <label class=" font-weight-bold"
										for="remember_me">Remember me!</label>
								</div>
							</div>
							<div class="col-md-4 mt-10 mb-20 text-left text-md-right">
								<a href="#" class=""> Quên mật khẩu?</a>
							</div>
							
							<div class="col-md-12">
								<button type="submit" class="register-button mt-0 " >Đăng nhập</button>
							</div>
						</div>
					</div>
				</form>
			</div>					
		</div>
	</div>
</div>
<!-- Login Content Area End Here -->