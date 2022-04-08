<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/templates/" var="url"></c:url>

<!-- Begin Header Top Area -->
<div class="header-top">
	<div class="container">
		<div class="row">
			<!-- Begin Header Top Left Area -->
			<div class="col-lg-3 col-md-4">
				<div class="header-top-left">
					<ul class="phone-wrap">
						<li><span>Điện thoại liên hệ: </span><a>(+84) 379 921 203</a></li>
					</ul>
				</div>
			</div>
			<!-- Header Top Left Area End Here -->
			<!-- Begin Header Top Right Area -->
			<div class="col-lg-9 col-md-8">
				<div class="header-top-right">
					<ul class="ht-menu">
						<c:choose>
							<c:when test="${sessionScope.user != null && sessionScope.user.roleID == 1}">
								<li><a href="${pageContext.request.contextPath }/user/edit-role" 
										class="font-weight-bold ">Đăng ký bán hàng</a></li>
								<li>
									<div class="ht-setting-trigger">
										<span>${user.firstName } </span>
									</div>
									<div class="setting ht-setting">
										<ul class="ht-setting-list">
											<li><a href="${pageContext.request.contextPath }/user/profile">Tài khoản của tôi</a></li>											
											<li><a href="#">Đơn hàng của tôi</a></li>
											<li><a href="${pageContext.request.contextPath }/account/logout">Đăng xuất</a></li>
										</ul>
									</div>
								</li>
							</c:when>
							<c:when test="${sessionScope.user != null && sessionScope.user.roleID == 2}">
								<li><a href="${pageContext.request.contextPath }/seller/home" 
									class="font-weight-bold ">Cửa hàng của tôi</a></li>
								<li>
									<div class="ht-setting-trigger">
										<span>${user.firstName } </span>
									</div>
									<div class="setting ht-setting">
										<ul class="ht-setting-list">
											<li><a href="${pageContext.request.contextPath }/user/profile">Tài khoản của tôi</a></li>											
											<li><a href="#">Đơn hàng của tôi</a></li>
											<li><a href="${pageContext.request.contextPath }/account/logout">Đăng xuất</a></li>
										</ul>
									</div>
								</li>
							</c:when>
							<c:otherwise>
								<li><a href="${pageContext.request.contextPath }/account/register" 
									class="text-uppercase font-weight-bold ">Đăng ký </a></li>
								<li><a href="${pageContext.request.contextPath }/account/login" 
									class="text-uppercase font-weight-bold ">Đăng nhập </a></li>
							</c:otherwise>	
						</c:choose>
							
					</ul>
				</div>
			</div>
			<!-- Header Top Right Area End Here -->
		</div>
	</div>
</div>
<!-- End Header Top Area -->