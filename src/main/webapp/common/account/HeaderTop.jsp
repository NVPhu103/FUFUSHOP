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
						<li><a href="${pageContext.request.contextPath }/account/register" class="text-uppercase font-weight-bold ">Đăng ký </a></li>
						<li><a href="${pageContext.request.contextPath }/account/login" class="text-uppercase font-weight-bold ">Đăng nhập </a></li>
					</ul>
				</div>
			</div>
			<!-- Header Top Right Area End Here -->
		</div>
	</div>
</div>
<!-- End Header Top Area -->