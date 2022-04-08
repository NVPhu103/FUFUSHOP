<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>



<!--Shopping Cart Area Strat-->
<div class="Shopping-cart-area pt-60 pb-60">
	<div class="container">
		<div class="row">
			<div class="col-12">
				<form action="#">
					<div class="table-content table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th class="li-product-remove font-weight-bold">Xóa</th>
									<th class="li-product-thumbnail font-weight-bold">Hình ảnh</th>
									<th class="cart-product-name font-weight-bold">Sản phẩm</th>
									<th class="li-product-quantity font-weight-bold">Màu sắc</th>
									<th class="li-product-price font-weight-bold">Đơn giá</th>
									<th class="li-product-quantity font-weight-bold">Số lượng</th>
									<th class="li-product-subtotal font-weight-bold">Tổng tiền</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${cart.listCartDetail }" var="cd">	
									<tr>
										<td class="li-product-remove">
											<a href="${pageContext.request.contextPath }/delete-cartdetail?productID=${cd.product.id}&color=${cd.color}"><i
												class="fa fa-times"></i></a></td>
										<td class="li-product-thumbnail"><img
											src="${urlProductImage }${cd.product.image}"
											alt="Li's Product Image" style="width:150px;height:150px;"></td>
										<td class="li-product-name"><a href="${pageContext.request.contextPath }
												/product-detail?productID=${cd.productID }">${cd.product.name }</a></td>
										<td class="li-product-name"><span>${cd.color }</span></td>
										<td class="li-product-price"><span class="amount font-weight-bold">
											<fmt:setLocale value="vi_VN"/>
											<fmt:formatNumber type="currency" 
													value="${cd.product.price * (1 - cd.product.salePrice/100) }">
											</fmt:formatNumber></span></td>
										<td class="quantity">
											<div class="cart-plus-minus">
												<input class="cart-plus-minus-box" value="${cd.quantity }" type="number" min="1" required>
												<div class="dec qtybutton">
													<i class="fa fa-angle-down"></i>
												</div>
												<div class="inc qtybutton">
													<i class="fa fa-angle-up"></i>
												</div>
											</div>
										</td>
										<td class="product-subtotal"><span class="amount">
											<fmt:setLocale value="vi_VN"/>
											<fmt:formatNumber type="currency"
													value="${cd.product.price * (1 - cd.product.salePrice/100) * cd.quantity}">
													</fmt:formatNumber></span></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="row">
						<div class="col-12">
							<div class="coupon-all">
								<div class="coupon">
									<input id="coupon_code" class="input-text" name="coupon_code"
										value="" placeholder="Coupon code" type="text"> <input
										class="button" name="apply_coupon" value="Áp dụng mã" type="button">
								</div>
								<div class="coupon2">
									<input class="button" name="update_cart" value="Cập nhật giỏ hàng" 
										type="submit">
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-5 ml-auto">
							<div class="cart-page-total">
								<h2>Cart totals</h2>
								<ul>
									<li>Tổng tiền hàng <span><fmt:setLocale value="vi_VN"/>
											<fmt:formatNumber type="currency" value="${cart.totalMoney}"></fmt:formatNumber></span></li>
									<li>Phí vận chuyển <span>15.000 đ</span></li>
									<li>Tổng cộng<span><fmt:setLocale value="vi_VN"/>
											<fmt:formatNumber type="currency" 
											value="${cart.totalMoney + 15000}"></fmt:formatNumber></span></li>
								</ul>
								<a class="font-weight-bold text-uppercase" href="#">Tiếp tục thanh toán</a>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<!--Shopping Cart Area End-->
