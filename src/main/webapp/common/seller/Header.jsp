<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!-- Header -->
<div class="header bg-primary pb-0">
  <div class="container-fluid">
    <div class="header-body">
      <div class="row align-items-center py-4">
        <div class="col-lg-6 col-7">
          <h6 class="h2 text-white d-inline-block mb-0">ARGON</h6>
          <nav aria-label="breadcrumb" class="d-none d-md-inline-block ml-md-4">
            <ol class="breadcrumb breadcrumb-links breadcrumb-dark">
              <li class="breadcrumb-item"><a href=""><i class="fas fa-home"></i></a></li>
              <li class="breadcrumb-item"><a>Người bán</a></li>
              <c:choose>
             	<c:when test="${tagHeader == 1 }">
             		<li class="breadcrumb-item active" aria-current="page">Thêm sản phẩm</li>
             	</c:when>
             	<c:when test="${tagHeader == 2 }">
             		<li class="breadcrumb-item active" aria-current="page">Danh sách sản phẩm</li>
             	</c:when>
             	<c:when test="${tagHeader == 3 }">
             		<li class="breadcrumb-item active" aria-current="page">Tài khoản của tôi</li>
             	</c:when>
             	<c:when test="${tagHeader == 4 }">
             		<li class="breadcrumb-item active" aria-current="page">Thống kê</li>
             	</c:when>
             	<c:when test="${tagHeader == 5 }">
             		<li class="breadcrumb-item active" aria-current="page">Danh sách sản phẩm chờ</li>
             	</c:when>
             	<c:when test="${tagHeader == 6 }">
             		<li class="breadcrumb-item active" aria-current="page">Thêm số lượng</li>
             	</c:when>
             	<c:when test="${tagHeader == 0 }">
             		<li class="breadcrumb-item active" aria-current="page">Danh sách sản phẩm</li>
             		<li class="breadcrumb-item active" aria-current="page">Chi tiết sản phẩm</li>
             	</c:when>
             	<c:otherwise> 
             		<li class="breadcrumb-item active" aria-current="page">Default</li>
             	</c:otherwise>
              </c:choose>
              
            </ol>
          </nav>
        </div>
      </div>
      
      
    </div>
  </div>
</div>
