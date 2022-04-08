<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>



<!-- Page content -->
<div class="container-fluid mt-0 mb-10">

	<div class="row">
		<div class="col-xl-12">
			<div class="card">
				<div class="card-header border-0">
					<div class="row align-items-center">
						<div class="col">
							<h3 class="mb-0">Danh sách sản phẩm</h3>
						</div>
						<div class="col text-right">
							<a href="" class="btn btn-sm btn-primary">See all</a>
						</div>
					</div>
				</div>
				<div class="table-responsive">
					<!-- Projects table -->
					<table class="table align-items-center table-flush">
						<thead class="thead-light">
							<tr>
								<th scope="col">Hình ảnh</th>
								<th scope="col" class="text-center">Tên sản phẩm</th>
								<th scope="col" class="text-center">Giá tiền</th>
								<th scope="col" class="text-center">Giá khuyến mãi (%)</th>
								<th scope="col" class="text-center">Số lượng</th>
								<th scope="col" class="text-center">Trạng thái</th>
								<th scope="col" class="text-center">Hành động</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listAllProduct}" var="p">
								<tr>
									<th scope="col"><img src="${urlProductImage }${p.image }" width="80" height="80"></th>
									<th scope="col" class="text-center">${p.name } </th>
									<th scope="col" class="text-center">${p.price}</th>
									<th scope="col" class="text-center">${p.salePrice }</th>
									<th scope="col" class="text-center">${p.totalQuantity }</th>
									<th scope="col" class="text-center">
										<c:choose>
											<c:when test="${p.status == 1 }"><h5 class="text-uppercase text-success">MỞ BÁN</h5></c:when>
											<c:when test="${p.status == 2 }"><h5 class="text-uppercase text-warning">Hết hàng</h5></c:when>
											<c:when test="${p.status == 3 }"><h5 class="text-uppercase text-info">Sắp bán</h5></c:when>
											<c:otherwise> <a class="text-uppercase text-danger">Ngừng kinh doanh</a> </c:otherwise>
										</c:choose>					
									</th>
									<th scope="col" class="text-center">
										<div class="col">
											<a href="#" class="btn btn-sm btn-primary">Chi tiết</a>
											<c:choose>
												<c:when test="${p.status == 1 }">
													<a href="add-quantity?productID=${p.id }" 
														class="btn btn-sm btn-success">Thêm||Bớt</a>
													<div class="rol">
														<a href="handleProduct?action=stop&productID=${p.id }" 
															class="btn btn-sm btn-danger mt-1">Ngừng kinh doanh</a>
													</div>
												</c:when>
												<c:when test="${p.status == 2 }">
													<a href="add-quantity?productID=${p.id }" 
														class="btn btn-sm btn-success">Thêm||Bớt</a>
													<div class="rol  mt-1">
														<a href="handleProduct?action=stop&productID=${p.id }" 
															class="btn btn-sm btn-danger">Ngừng kinh doanh</a>
													</div>
												</c:when>
												<c:when test="${p.status == 3 }">											
													<div class="rol mt-1">
														<a href="handleProduct?action=open&productID=${p.id }" 
															class="btn btn-sm btn-info">Mở bán</a>
														<a href="${pageContext.request.contextPath }/seller/add-quantity?productID=${p.id }" 
															class="btn btn-sm btn-success">Thêm||Bớt</a>
													</div>
												</c:when>
												<c:when test="${p.status == 4 }">
													<a href="handleProduct?action=openAgain&productID=${p.id }" 
														class="btn btn-sm btn-info">Mở lại</a>
												</c:when>
											</c:choose>
											<!--  Nếu chưa bán đơn nào thì có thêm nút xóa sản phẩm  -->
										</div> 
										
										
									</th>

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<nav aria-label="Page navigation example">
					<ul class="pagination justify-content-center" >
						<c:if test="${index > 1}">
							<li class="page-item "><a class="page-link fas fa-angle-left"
								href="list-product?index=${index-1 }"></a></li>
						</c:if>
						<c:forEach begin="1" end="${endP }" var="i">
							<li class="page-item  ${index==i ? "active" : "" }"><a
								class="page-link" href="list-product?index=${i}">${i}</a></li>
						</c:forEach>
						<c:if test="${index < endP}">
							<li class="page-item "><a class="page-link fas fa-angle-right"
								href="list-product?index=${index+1 }"></a></li>
						</c:if>
					</ul>
				</nav>
			</div>
		</div>
	</div>
</div>

