<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/templates/" var="url"></c:url>


<!-- content-wraper start -->
<div class="content-wraper">
	<div class="container">
		<div class="row single-product-area pt-50">
			<div class="col-lg-5 col-md-6">
				<!-- Product Details Left -->
				<div class="product-details-left">
					<div class="product-details-images slider-navigation-1">
						<div class="lg-image">
							<a class="popup-img venobox vbox-item"
								href="${urlProductImage }${product.image}" data-gall="myGallery">
								<img src="${urlProductImage }${product.image}" alt="product image" style="width:420px;height:420px;">
							</a>
						</div>	
					</div>
				</div>
			</div>

			<div class="col-lg-7 col-md-6">
				<div class="product-details-view-content ">
					<div class="product-info">
						<h1 class="font-weight-bold">${product.name }</h1>
						<div class="rating-box pt-20">
							<ul class="rating rating-with-review-item">
								<li><i class="fa fa-star-o"></i></li>
								<li><i class="fa fa-star-o"></i></li>
								<li><i class="fa fa-star-o"></i></li>
								<li class="no-star"><i class="fa fa-star-o"></i></li>
								<li class="no-star"><i class="fa fa-star-o"></i></li>
								<li class="review-item"><a >Read Review</a></li>
								<li class="review-item"><a >Write Review</a></li>
							</ul>
						</div>
						<div class="price-box pt-20">
							<c:if test="${product.salePrice == 0}">
								<span class="new-price text-dark">
									<fmt:setLocale value="vi_VN"/>
									<fmt:formatNumber type="currency" 
											value="${product.price}">
									</fmt:formatNumber></span>
							</c:if>
							<c:if test="${product.salePrice != 0}">
								<span class="new-price new-price-2">
									<fmt:setLocale value="vi_VN"/>
									<fmt:formatNumber type="currency" 
										value="${product.price * (1 - product.salePrice/100) }"></fmt:formatNumber>
								</span>
								<span class="new-price new-price-2 text-dark pl-30">
									<del><fmt:setLocale value="vi_VN"/><fmt:formatNumber type="currency" 
											value="${product.price }"></fmt:formatNumber></del></span>
							</c:if>
						</div>
						<form action="add-cart" method="post" class="cart-quantity mt-0">
							<div class="product-variants">
								<div class="produt-variants-size">
									<label class="font-weight-bold">MÀU SẮC</label> 
									<select class="nice-select" name="colorName">
										<c:forEach items="${product.listColor }" var="color">
											<option value="${color.name }">${color.name }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="single-add-to-cart mt-5">
								<div class="quantity">
									<label class="font-weight-bold">SỐ LƯỢNG</label>
									<div class="cart-plus-minus">
										<input class="cart-plus-minus-box" name="quantity" value="1" type="number" min="1" required>
										<div class="dec qtybutton">
											<i class="fa fa-angle-down"></i>
										</div>
										<div class="inc qtybutton">
											<i class="fa fa-angle-up"></i>
										</div>
									</div>
								</div>
								<input type="hidden" name="productID" value="${product.id }">
								<button class="add-to-cart font-weight-bold" type="submit" >Thêm vào giỏ</button>
							</div>
						</form>
						<div class="product-additional-info pt-25">
							
							<div class="product-social-sharing pt-25">
								<ul>
									<li class="facebook"><a href="#"><i
											class="fa fa-facebook"></i>Facebook</a></li>
									<li class="twitter"><a href="#"><i
											class="fa fa-twitter"></i>Twitter</a></li>
									<li class="google-plus"><a href="#"><i
											class="fa fa-google-plus"></i>Google +</a></li>
									<li class="instagram"><a href="#"><i
											class="fa fa-instagram"></i>Instagram</a></li>
								</ul>
							</div>
						</div>
						<div class="block-reassurance">
							<ul>
								<li>
									<div class="reassurance-item">
										<div class="reassurance-icon">
											<i class="fa fa-check-square-o"></i>
										</div>
										<p>Security policy (edit with Customer reassurance module)</p>
									</div>
								</li>
								<li>
									<div class="reassurance-item">
										<div class="reassurance-icon">
											<i class="fa fa-truck"></i>
										</div>
										<p>Delivery policy (edit with Customer reassurance module)</p>
									</div>
								</li>
								<li>
									<div class="reassurance-item">
										<div class="reassurance-icon">
											<i class="fa fa-exchange"></i>
										</div>
										<p>Return policy (edit with Customer reassurance module)</p>
									</div>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- content-wraper end -->
<!-- Begin Product Area -->
<div class="product-area pt-35">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="li-product-tab">
					<ul class="nav li-product-menu">
						<li><a class="active" data-toggle="tab" href="#description"><span class="font-weight-bold">Description</span></a></li>
						<li><a data-toggle="tab" href="#reviews"><span class="font-weight-bold">Reviews</span></a></li>
					</ul>
				</div>
				<!-- Begin Li's Tab Menu Content Area -->
			</div>
		</div>
		<div class="tab-content">
			<div id="description" class="tab-pane active show" role="tabpanel">
				<div class="product-description">
					<span>${product.description }</span>
				</div>
			</div>
			
			<div id="reviews" class="tab-pane" role="tabpanel">
				<div class="product-reviews">
					<div class="product-details-comment-block">
						<div class="comment-review">
							<span>Grade</span>
							<ul class="rating">
								<li><i class="fa fa-star-o"></i></li>
								<li><i class="fa fa-star-o"></i></li>
								<li><i class="fa fa-star-o"></i></li>
								<li class="no-star"><i class="fa fa-star-o"></i></li>
								<li class="no-star"><i class="fa fa-star-o"></i></li>
							</ul>
						</div>
						<div class="comment-author-infos pt-25">
							<span>HTML 5</span> <em>01-12-18</em>
						</div>
						<div class="comment-details">
							<h4 class="title-block">Demo</h4>
							<p>Plaza</p>
						</div>
						<div class="review-btn">
							<a class="review-links" href="#" data-toggle="modal"
								data-target="#mymodal">Write Your Review!</a>
						</div>
						<!-- Begin Quick View | Modal Area -->
						
						<!-- Quick View | Modal Area End Here -->
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Product Area End Here -->
<!-- Begin Li's Laptop Product Area -->
<section class="product-area li-laptop-product pt-30 pb-80">
	<div class="container">
		<div class="row">
			<!-- Begin Li's Section Area -->
			<div class="col-lg-12">
				<div class="li-section-title">
					<h2>
						<span class="font-weight-bold">Các sản phẩm khác cùng danh mục</span>
					</h2>
				</div>
				<div class="row">
					<div class="product-active owl-carousel">
						<c:forEach items="${list10Product }" var="p">
							<div class="col-lg-12">
								<!-- single-product-wrap start -->
								<div class="single-product-wrap">
									<div class="product-image">
										<a href="product-detail?productID=${p.id }"> 
											<img src="${urlProductImage }${p.image }" alt="Li's Product Image" 
												style="width:211px;height:211px;">
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
													<span class="old-price">
														<del>
															<fmt:setLocale value="vi_VN" />
															<fmt:formatNumber type="currency"
																value="${p.price }"></fmt:formatNumber>
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
												<li><a href="#" title="quick view"
													class="quick-view-btn" data-toggle="modal"
													data-target="#exampleModalCenter"><i class="fa fa-eye"></i></a></li>
												<li><a class="links-details" href="wishlist.html"><i
														class="fa fa-heart-o"></i></a></li>
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
			<!-- Li's Section Area End Here -->
		</div>
	</div>
</section>
<!-- Li's Laptop Product Area End Here -->
