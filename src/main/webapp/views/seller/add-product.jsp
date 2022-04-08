<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>


<div class="container-fluid mt-0 mb-10">
	<div class="row">
		<div class="col-xl-12">
			<div class="card">

				<!-- Form Elements -->
				<div class="panel panel-default">
					<div class="card-header border-0">
						<div class="row align-items-center">
							<div class="col">
								<h2 class="mb-2 text-center text-success">THÊM SẢN PHẨM MỚI</h2>
								
							</div>
						</div>
					</div>

					<div class="panel-body">
						<div class="row">
							<div class="col-md-12">
								<form role="form" action="add-product" method="post" enctype="multipart/form-data">
								
									<div class="form-group row justify-content-center">
										<label class="col-sm-2 col-form-label"> Tên sản phẩm</label>
										<div class="col-sm-4 ">
											<input class="form-control " placeholder="Nhập tên sản phẩm" name="name" required/>
										</div>
										<label class="col-sm-1 col-form-label text-right">Hình ảnh</label>
										<div class="col-sm-3 ">
											<input type="file" name="image" class="form-control" required/>
										</div>
									</div>								
								
									<div class="form-group row justify-content-center mb-0">									
										
										<label class="col-sm-2 col-form-label">Danh mục</label>
										<div class="form-group col-md-3">											
											<select name="category" class="form-control" required >
												<option value="">Chọn danh mục...</option>
												<c:forEach items="${listCateStatus1}" var="c">
													<option value="${c.id}">${c.name}</option>
												</c:forEach> 
											</select>
										</div>
										<label class="col-sm-2 col-form-label text-right">Nhãn hàng</label>
										<div class="form-group col-md-3">											
											<select name="brand" class="form-control" required>
												<option value="" >Chọn nhãn hàng...</option>
												<c:forEach items="${listBrandStatus1}" var="b">
													<option value="${b.id}">${b.name}</option>
												</c:forEach> 
											</select>
										</div>										
									</div>
									
									<div class="form-group row justify-content-center">
										<label class="col-sm-2 col-form-label">Giá tiền (VNĐ)</label>
										<div class="col-sm-3 ">
											<input class="form-control" type="number"
												placeholder="Nhập giá tiền sản phẩm" name="price" min="0"
												step="500" required/>
										</div>
										<label class="col-sm-2 col-form-label text-right"> Giá khuyến mãi</label>
										<div class="col-sm-3 ">
											<input class="form-control" type="number"
												placeholder="Nhập giá khuyến mãi (0% - 99%)" name="salePrice"
												min="0" max="99.9" step="0.1" required/>
										</div>
									</div>
									<div class="form-group row justify-content-center mt--3 ">
										<label class="col-sm-2"></label>
										<h5 class="col-sm-8 text-left text-danger">
										*Nhập giá tiền 0đ nếu sản phẩm sắp bán và chưa có giá cụ thể || 
										Dung lượng file tối đa 1MB || Định dạng hình ảnh: .PNG, .JPG</h5>
									</div>									
									<div class="form-group row justify-content-center ">
										<label class="col-sm-2 col-form-label">Mô tả sản phẩm </label>
										<div class="col-sm-8 ">
											<textarea  rows="5" cols="105" name="description" id="editer" value="null"></textarea>
										</div>
									</div>
									
									
									
									<!-- <div class="form-group row  mb-4 justify-content-center">
										
										<label class="col-sm-2 col-form-label ">Trạng thái sản phẩm</label>
										<div class="form-check-inline col-sm-8 justify-content-center">
											<div class="col-sm-4">
												<input class="" type="radio" id="status1" name="status" value="1" required/>
												<label for="status1" class="col-sm-4 col-form-label ">Mở bán</label>
											</div>
											<div class="col-sm-4">
												<input class="" type="radio" id="status2" name="status" value="3" required/>
												<label for="status2" class="col-sm-4 col-form-label ">Sắp bán</label>
											</div>
											
										</div>
									</div> -->
									
																						
									<div class="col mb-4 mt-4">
										<div class="row">
											<div class="col-sm-12  col-md-6">
												<button type="submit" class="btn btn-success btn-block text-uppercase">Thêm sản phẩm</button>
											</div>
											<div class="col-sm-12  col-md-6">
												<button type="reset" class="btn btn-danger btn-block text-uppercase">Hủy bỏ</button>
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
				<!-- End Form Elements -->
			</div>
		</div>
	</div>
</div>