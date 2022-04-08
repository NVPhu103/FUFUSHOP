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
											<c:when test="${p.status == 5 }"><h5 class="text-uppercase text-warning">Đang chờ duyệt</h5></c:when>
											<c:when test="${p.status == 6 }"><h5 class="text-uppercase text-success">Đã duyệt</h5></c:when>	
											<c:when test="${p.status == 7 }"><h5 class="text-uppercase text-danger">Không được duyệt</h5></c:when>										
										</c:choose>					
									</th>
									<th scope="col" class="text-center">
										<div class="col">
											
											<c:choose>
												<c:when test="${p.status == 6 }">
													<div class="rol">
														<a href="handleProduct?action=confirm&productID=${p.id }" class="btn btn-sm btn-success">Xác nhận</a>
													</div>
												</c:when>
												<c:otherwise>
													<div class="rol">
														<a href="handleProduct?action=cancel&productID=${p.id }" class="btn btn-sm btn-danger">Hủy</a>
													</div>
												</c:otherwise>
												
											</c:choose>
											<!--  Nếu chưa bán đơn nào thì có thêm nút xóa sản phẩm  -->
										</div> 
										
										
									</th>

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<c:if test="${listAllProduct.size() != 0}">
					<nav aria-label="Page navigation example">
					<ul class="pagination justify-content-center" >
						<c:if test="${index > 1}">
							<li class="page-item "><a class="page-link fas fa-angle-left"
								href="list-pendingProduct?index=${index-1 }"></a></li>
						</c:if>
						<c:forEach begin="1" end="${endP }" var="i">
							<li class="page-item  ${index==i ? "active" : "" }"><a
								class="page-link" href="list-pendingProduct?index=${i}">${i}</a></li>
						</c:forEach>
						<c:if test="${index < endP}">
							<li class="page-item "><a class="page-link fas fa-angle-right"
								href="list-pendingProduct?index=${index+1 }"></a></li>
						</c:if>
					</ul>
				</nav>
				</c:if>
				
			</div>
		</div>
	</div>
</div>

