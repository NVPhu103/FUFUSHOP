<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/templates/" var="url"></c:url>

<!-- Begin Header Middle Area -->
<div class="header-middle pl-sm-0 pr-sm-0 pl-xs-0 pr-xs-0">
	<div class="container">
		<div class="row">

			<!-- Begin Header Logo Area -->
			<div class="col-lg-3">
				<div class="logo pb-sm-30 pb-xs-30">
					<a href="${pageContext.request.contextPath }/home"> <img
						src="${url }images/menu/logo/1.jpg" alt="">
					</a>
				</div>
			</div>
			<!-- Header Logo Area End Here -->

			<!-- Begin Header Middle Right Area -->
			<div class="col-lg-9 pl-0 ml-sm-15 ml-xs-15">
				<!-- Begin Header Middle Searchbox Area -->
				<form action="#" class="hm-searchbox">
					<select class="nice-select select-search-category">
						<option value="0">All</option>
						<option value="10">Laptops</option>
						<option value="13">Cameras</option>
						<option value="14">headphone</option>
						<option value="15">Smartwatch</option>
						<option value="0">All</option>
						<option value="10">Laptops</option>

					</select> <input type="text"
						placeholder="Nhập sản phẩm bạn muốn tìm kiếm ..."
						name="textSearch">
					<button class="li-btn" type="submit">
						<i class="fa fa-search"></i>
					</button>
				</form>
				<!-- Header Middle Searchbox Area End Here -->

				<!-- Begin Header Middle Right Area -->
				<div class="header-middle-right">
					<ul class="hm-menu">
						<!-- Begin Header Middle Wishlist Area -->
						
						<!-- Header Middle Wishlist Area End Here -->
						<!-- Begin Header Mini Cart Area -->
						<li class="hm-minicart">
							<div class="hm-minicart-trigger">
								<span class="item-icon"></span> 
								<span class="item-text font-weight-bold">
									<fmt:setLocale value="vi_VN"/>
									<fmt:formatNumber type="currency" value="${cart.totalMoney }"></fmt:formatNumber>
									<span class="cart-item-count">${cart.quantity }</span>
								</span>
							</div> <span></span>
							<div class="minicart">
								<ul class="minicart-product-list">
									<c:forEach items="${cart.listCartDetail }" var="cd">
										<li><a href="single-product.html"
											class="minicart-product-image"> <img
												src="${urlProductImage }${cd.product.image }"
												alt="cart products" style="width:48px;height:48px;">
										</a>
											<div class="minicart-product-details">
												<h6>
													<a>${cd.product.name }</a>
												</h6>
												<span>
													<fmt:setLocale value="vi_VN"/>
													<fmt:formatNumber type="currency" 
													value="${cd.product.price * (1 - cd.product.salePrice/100) }">
													</fmt:formatNumber>      x ${cd.quantity }
												 </span>
											</div>
										</li>
									</c:forEach>
								</ul>
								<p class="minicart-total">
									TỔNG CỘNG: <span><fmt:formatNumber type="number" maxFractionDigits="0" 
										value="${cart.totalMoney }"></fmt:formatNumber> đ</span>
								</p>
								<div class="minicart-button">
									<a href="${pageContext.request.contextPath }/user/cart-detail"
										class="li-button li-button-fullwidth li-button-dark font-weight-bold"> <span>Xem
											giỏ hàng</span>
									</a> <a href="#"
										class="li-button li-button-fullwidth li-button-dark font-weight-bold"> <span>Thanh
											toán </span>
									</a>
								</div>
							</div>
						</li>
						<!-- Header Mini Cart Area End Here -->
					</ul>
				</div>
				<!-- Header Middle Right Area End Here -->
			</div>
			<!-- Header Middle Right Area End Here -->
		</div>
	</div>
</div>
<!-- End Header Middle Area -->
