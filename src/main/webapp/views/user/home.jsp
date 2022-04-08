<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/templates/" var="url"></c:url>


<!-- Begin Body Wrapper -->
	<!-- Begin Header Area -->
		<!-- Begin Header Top Area -->
		<!-- Header Top Area End Here -->
		<!-- Begin Header Middle Area -->
		<!-- Header Middle Area End Here -->
		<!-- Begin Header Bottom Area -->
		<!-- Header Bottom Area End Here -->
		<!-- Begin Mobile Menu Area -->
		<!-- Mobile Menu Area End Here -->
	<!-- Header Area End Here -->
	
	<!-- Begin Slider With Banner Area -->
	<div class="slider-with-banner">
		<div class="container">
			<div class="row">
	
				<!-- Begin Slider Area -->
				<div class="col-lg-8 col-md-8">
					<div class="slider-area">
						<div class="slider-active owl-carousel">
							<!-- Begin Single Slide Area -->
							<div
								class="single-slide align-center-left  animation-style-01 bg-1">
								<div class="slider-progress"></div>
								<div class="slider-content">
									<h5>
										Sale Offer <span>-20% Off</span> This Week
									</h5>
									<h2>Chamcham Galaxy S9 | S9+</h2>
									<h3>
										Starting at <span>$1209.00</span>
									</h3>
									<div class="default-btn slide-btn">
										<a class="links" href="shop-left-sidebar.html">Shopping Now</a>
									</div>
								</div>
							</div>
							<!-- Single Slide Area End Here -->
							<!-- Begin Single Slide Area -->
							<div
								class="single-slide align-center-left animation-style-02 bg-2">
								<div class="slider-progress"></div>
								<div class="slider-content">
									<h5>
										Sale Offer <span>Black Friday</span> This Week
									</h5>
									<h2>Work Desk Surface Studio 2018</h2>
									<h3>
										Starting at <span>$824.00</span>
									</h3>
									<div class="default-btn slide-btn">
										<a class="links" href="shop-left-sidebar.html">Shopping Now</a>
									</div>
								</div>
							</div>
							<!-- Single Slide Area End Here -->
							<!-- Begin Single Slide Area -->
							<div
								class="single-slide align-center-left animation-style-01 bg-3">
								<div class="slider-progress"></div>
								<div class="slider-content">
									<h5>
										Sale Offer <span>-10% Off</span> This Week
									</h5>
									<h2>Phantom 4 Pro+ Obsidian</h2>
									<h3>
										Starting at <span>$1849.00</span>
									</h3>
									<div class="default-btn slide-btn">
										<a class="links" href="shop-left-sidebar.html">Shopping Now</a>
									</div>
								</div>
							</div>
							<!-- Single Slide Area End Here -->
						</div>
					</div>
				</div>
				<!-- Slider Area End Here -->
	
				<!-- Begin Li Banner Area -->
				<div class="col-lg-4 col-md-4 text-center pt-xs-30">
					<div class="li-banner">
						<a href="#"> <img src="${url }images/banner/1_1.jpg" alt="">
						</a>
					</div>
					<div class="li-banner mt-15 mt-sm-30 mt-xs-30">
						<a href="#"> <img src="${url }images/banner/1_2.jpg" alt="">
						</a>
					</div>
				</div>
				<!-- Li Banner Area End Here -->
			</div>
		</div>
	</div>
	<!-- Slider With Banner Area End Here -->
	
	
	<!-- Begin Product Area -->
	<div class="product-area pt-60 pb-50">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="li-product-tab">
						<ul class="nav li-product-menu"> 
							<li><a class="font-weight-bold ${tag == 'null' ? "active":"" }"  
								href="home"><span>Hàng mới về</span></a></li>
							<li><a class="font-weight-bold ${tag == 'bestseller' ? "active":"" }"  
								><span>Bestseller</span></a></li>
						</ul>
					</div>
					<!-- Begin Li's Tab Menu Content Area -->
				</div>
			</div>
			<div class="tab-content">
			
				<div id="li-new-product" class="tab-pane active show"
					role="tabpanel">
					<div class="row">
						<div class="product-active owl-carousel">
							<c:forEach items="${list10Product }" var="p">
								<div class="col-lg-12">
									<!-- single-product-wrap start -->
									<div class="single-product-wrap">
										<div class="product-image">
											<a href="product-detail?productID=${p.id }"> <img
												src="${urlProductImage }${p.image }"
												alt="Li's Product Image" style="width:211px;height:211px;">
											</a> 
											<c:if test="${tag == 'null' }">
												<span class="sticker font-weight-bold">New</span>
											</c:if>
											<c:if test="${tag == 'bestseller' }">
												<span class="sticker font-weight-bold" style="width:80px;height:40px;">Bestseller</span>
											</c:if>
										</div>
										<div class="product_desc">
											<div class="product_desc_info">
												<div class="product-review">
													<h5 class="manufacturer">
														<c:forEach items="${listBrand }" var="b">
															<c:if test="${b.id == p.brandID }">
																<a href="##">${b.name }</a>
															</c:if>
														</c:forEach>
													</h5>
													<div class="rating-box">
														<ul class="rating">
															<li><i class="fa fa-star-o"></i></li>
															<li><i class="fa fa-star-o"></i></li>
															<li><i class="fa fa-star-o"></i></li>
															<li class="no-star"><i class="fa fa-star-o"></i></li>
															<li class="no-star"><i class="fa fa-star-o"></i></li>
														</ul>
													</div>
												</div>
												<h4>
													<a class="product_name" href="product-detail?productID=${p.id }">${p.name }</a>
												</h4>
												<div class="price-box">
													<c:if test="${p.salePrice == 0}">
														<span class="new-price"> <fmt:setLocale
																value="vi_VN" /> <fmt:formatNumber type="currency"
																value="${p.price}">
															</fmt:formatNumber></span>
													</c:if>
													<c:if test="${p.salePrice != 0}">
														<span class="new-price new-price-2"> <fmt:setLocale
																value="vi_VN" /> <fmt:formatNumber type="currency"
																value="${p.price * (1 - p.salePrice/100) }"></fmt:formatNumber>
														</span>
														<span class="old-price"> <del>
																<fmt:setLocale value="vi_VN" />
																<fmt:formatNumber type="currency" value="${p.price }"></fmt:formatNumber>
															</del>
														</span>
														<span class="discount-percentage">-${p.salePrice }%</span>
													</c:if>
												</div>
											</div>
											<div class="add-actions">
												<ul class="add-actions-link">
													<li class="add-cart active">
														<a href="product-detail?productID=${p.id }">Thêm vào giỏ</a></li>
													<li><a class="links-details" href="wishlist.html"><i
															class="fa fa-heart-o"></i></a></li>
													<li><a href="#" title="quick view"
														class="quick-view-btn" data-toggle="modal"
														data-target="#exampleModalCenter"><i class="fa fa-eye"></i></a></li>
												</ul>
											</div>
										</div>
									</div>
									<!-- single-product-wrap end -->
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Product Area End Here -->
	
	<!-- Begin Li's Static Banner Area -->
	<div class="li-static-banner">
		<div class="container">
			<div class="row">
				<!-- Begin Single Banner Area -->
				<div class="col-lg-4 col-md-4 text-center">
					<div class="single-banner">
						<a href="#"> <img src="${url }images/banner/1_3.jpg"
							alt="Li's Static Banner">
						</a>
					</div>
				</div>
				<!-- Single Banner Area End Here -->
				<!-- Begin Single Banner Area -->
				<div class="col-lg-4 col-md-4 text-center pt-xs-30">
					<div class="single-banner">
						<a href="#"> <img src="${url }images/banner/1_4.jpg"
							alt="Li's Static Banner">
						</a>
					</div>
				</div>
				<!-- Single Banner Area End Here -->
				<!-- Begin Single Banner Area -->
				<div class="col-lg-4 col-md-4 text-center pt-xs-30">
					<div class="single-banner">
						<a href="#"> <img src="${url }images/banner/1_5.jpg"
							alt="Li's Static Banner">
						</a>
					</div>
				</div>
				<!-- Single Banner Area End Here -->
			</div>
		</div>
	</div>
	<!-- Li's Static Banner Area End Here -->
	
	<c:forEach items="${listCategory }" var="c">
		<!-- Begin Products by Category Area -->
		<section class="product-area li-laptop-product pt-60 pb-25">
			<div class="container">
				<div class="row">
					<!-- Begin Li's Section Area -->
					<div class="col-lg-12">
						<div class="li-section-title">
							<h2 >
								<span class="font-weight-bold">${c.name }</span>
							</h2>
						</div>
						<div class="row">
							<div class="product-active owl-carousel">
								<c:forEach items="${listAllProduct }" var="p">
									<c:if test="${c.id == p.categoryID }">
										<div class="col-lg-12">
											<!-- single-product-wrap start -->
											<div class="single-product-wrap">
												<div class="product-image">
													<a href="product-detail?productID=${p.id }"> <img
														src="${urlProductImage }${p.image}"
														alt="Li's Product Image" style="width:211px;height:211px;">
													</a>
												</div>
												<div class="product_desc">
													<div class="product_desc_info">
														<div class="product-review">
															<h5 class="manufacturer">
																<c:forEach items="${listBrand }" var="b">
																	<c:if test="${b.id == p.brandID }">
																		<a href="##">${b.name }</a>
																	</c:if>
																</c:forEach>
															</h5>
															<div class="rating-box">
																<ul class="rating">
																	<li><i class="fa fa-star-o"></i></li>
																	<li><i class="fa fa-star-o"></i></li>
																	<li><i class="fa fa-star-o"></i></li>
																	<li class="no-star"><i class="fa fa-star-o"></i></li>
																	<li class="no-star"><i class="fa fa-star-o"></i></li>
																</ul>
															</div>
														</div>
														<h4>
															<a class="product_name" href="product-detail?productID=${p.id }">${p.name }</a>
														</h4>
														<div class="price-box">
															<c:if test="${p.salePrice == 0}">
																<span class="new-price"> <fmt:setLocale
																		value="vi_VN" /> <fmt:formatNumber type="currency"
																		value="${p.price}">
																	</fmt:formatNumber></span>
															</c:if>
															<c:if test="${p.salePrice != 0}">
																<span class="new-price new-price-2"> <fmt:setLocale
																		value="vi_VN" /> <fmt:formatNumber type="currency"
																		value="${p.price * (1 - p.salePrice/100) }"></fmt:formatNumber>
																</span>
																<span class="old-price"> <del>
																		<fmt:setLocale value="vi_VN" />
																		<fmt:formatNumber type="currency" value="${p.price }"></fmt:formatNumber>
																	</del>
																</span>
																<span class="discount-percentage">-${p.salePrice }%</span>
															</c:if>
														</div>
													</div>
													<div class="add-actions">
														<ul class="add-actions-link">
															<li class="add-cart active">
																<a href="product-detail?productID=${p.id }">Thêm vào giỏ</a></li>
															<li><a class="links-details" href="wishlist.html"><i
																	class="fa fa-heart-o"></i></a></li>
															<li><a href="#" title="quick view"
																class="quick-view-btn" data-toggle="modal"
																data-target="#exampleModalCenter"><i class="fa fa-eye"></i></a></li>
														</ul>
													</div>
												</div>
											</div>
											<!-- single-product-wrap end -->
										</div>
										
									</c:if>
								</c:forEach> 
							</div>
						</div>
					</div>
					<!-- Li's Section Area End Here -->
				</div>
			</div>
		</section>
	</c:forEach>
	<!--  Products by Category Area End Here -->
	
	<!-- Begin Li's Static Home Area -->
	<div class="li-static-home mb-50 pt-60">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<!-- Begin Li's Static Home Image Area -->
					<div class="li-static-home-image"></div>
					<!-- Li's Static Home Image Area End Here -->
					<!-- Begin Li's Static Home Content Area -->
					<div class="li-static-home-content">
						<p>
							Sale Offer<span>-20% Off</span>This Week
						</p>
						<h2>Featured Product</h2>
						<h2>Meito Accessories 2018</h2>
						<p class="schedule">
							Starting at <span> $1209.00</span>
						</p>
						<div class="default-btn">
							<a href="shop-left-sidebar.html" class="links">Shopping Now</a>
						</div>
					</div>
					<!-- Li's Static Home Content Area End Here -->
				</div>
			</div>
		</div>
	</div>
	<!-- Li's Static Home Area End Here -->
	<!-- Begin Li's Trending Product Area -->
	
	<!-- Li's Trending Product Area End Here -->
	<!-- Begin Li's Trendding Products Area -->
	
	<!-- Li's Trendding Products Area End Here -->
	
	<!-- Begin Footer Area -->
	<!-- Footer Area End Here -->
	<!-- Begin Quick View | Modal Area -->
	<!-- Quick View | Modal Area End Here -->
<!-- Body Wrapper End Here -->

