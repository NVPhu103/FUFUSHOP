<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>



<div class="container-fluid mt-0 mb-5">
	<div class="row">
		<div class="col-xl-12">
			<div class="card">

				<!-- Form Elements -->
				<div class="panel panel-default">
					<div class="card-header border-0">
						<div class="row align-items-center">
							<div class="col">
								<h2 class="mb-2 text-center text-success">THÊM SỐ LƯỢNG SẢN PHẨM</h2>							
							</div>
						</div>
					</div>

					<div class="panel-body">
						<div class="row">
							<div class="col-md-12">
								<form role="form" action="add-quantity" method="post">
								
									<div class="form-group row justify-content-center">
										<label class="col-sm-1 col-form-label"> Màu sắc</label>
										<div class="col-sm-3 ">
											<input class="form-control" size="50" placeholder="Nhập màu sắc của sản phẩm" 
												name="color" required/>
										</div>
										<label class="col-sm-1 col-form-label text-right">Số lượng</label>
										<div class="col-sm-3 ">
											<input class="form-control" type="number"
												placeholder="Nhập số lượng cho màu sắc sản phẩm" name="quantity" min="1"
												step="1" required/>
										</div>
									</div>								
								
																		
									<div class="col mb-4 mt-4 ">
										<div class="row">
											<div class="col-sm-12  col-md-2 justify content center ml-2">
												<button type="submit" name="action" value="add-new" 
												class="btn btn-success btn-block text-uppercase">Thêm mới</button>
											</div>										
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
					
					<div class="panel-body">
						<div class="row">
							<div class="col-md-12">
								<form role="form" action="add-quantity" method="post" >
								
									<div class="form-group row justify-content-center">
										<label class="col-sm-1 col-form-label"> Màu sắc</label>
										<div class="form-group col-md-3">											
											<select name="color" class="form-control" required>
												<option value="">Chọn danh mục...</option>												
												<c:forEach items="${listColor}" var="cName">
													<option value="${cName.name}">${cName.name}</option>
												</c:forEach> 
											</select>
										</div>
										<label class="col-sm-1 col-form-label text-right">Số lượng</label>
										<div class="col-sm-3 ">
											<input class="form-control" type="number"
												placeholder="Nhập số lượng cho màu sắc sản phẩm" name="quantity" min="0" 
												step="1" required/>
										</div>
									</div>								
								
																		
									<div class="col mb-4 mt--4">
										<div class="row">
											<div class="col-sm-12  col-md-1 justify content center ml--5">
												<button type="submit" name="action" value="add-old" 
												class="btn btn-success btn-block text-uppercase">Thêm</button>
											</div>
											<div class="col-sm-12  col-md-1 justify content center">
												<button type="submit" name="action" value="decrease" 
												class="btn btn-danger btn-block text-uppercase">Giảm</button>
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
					
				</div>
				<!-- End Form Elements -->
				
				<div class="card-header border-0">
					<div class="row align-items-center">
						<div class="col">
							<h3 class="mb-0 text-center">Danh sách số lượng sản phẩm</h3>
						</div>
					</div>
				</div>
				<div class="table-responsive mb-1">
					<!-- Projects table -->
					<table class="table align-items-center table-flush">
						<thead class="thead-light">
							<tr>
								<th scope="col" class="text-center">Màu sắc</th>
								<th scope="col" class="text-center">Số lượng</th>
								<th scope="col" class="text-center">Hành động</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listColor}" var="c">
								<tr>
									<th scope="col" class="text-center">${c.name } </th>
									<th scope="col" class="text-center">${c.quantity }</th>							
									<th scope="col" class="text-center">
										<a href="delete-quantity?productID=${c.productID }&name=${c.name }&quantity=${c.quantity }" 
											class="btn btn-sm btn-danger">Xóa</a></th>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>