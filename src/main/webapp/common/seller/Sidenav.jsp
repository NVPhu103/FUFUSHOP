<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>


<!-- Sidenav -->
  <nav class="sidenav navbar navbar-vertical  fixed-left  navbar-expand-xs navbar-light bg-white" id="sidenav-main">
    <div class="scrollbar-inner">
      <!-- Brand -->
      <div class="sidenav-header  align-items-center">
        <a class="navbar-brand" href="javascript:void(0)">
          <img src="${url }img/brand/blue.png"  class="navbar-brand-img" alt="...">
        </a>
      </div>
      <div class="navbar-inner">
        <!-- Collapse -->
        <div class="collapse navbar-collapse" id="sidenav-collapse-main">
          <!-- Nav items -->
          <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link ${tagActiveSideNav == 4 ? "active":"" }" href="#">
                <i class="ni ni-tv-2 text-primary"></i>
                <span class="nav-link-text">Thống kê</span>
              </a>
            </li>
            
            <li class="nav-item">
              <a class="nav-link ${tagActiveSideNav == 3 ? "active":"" }" href="#">
                <i class="ni ni-single-02 text-yellow"></i>
                <span class="nav-link-text">Tài khoản của tôi</span>
              </a>
            </li>
            <li class="nav-item ">
              <a class="nav-link ${tagActiveSideNav == 2 || tagActiveSideNav == 0 ? "active":"" }" href="list-product?index=1">
                <i class="ni ni-bullet-list-67 text-default"></i>
                <span class="nav-link-text">Danh sách sản phẩm</span>
              </a>
            </li>
            <li class="nav-item ">
              <a class="nav-link ${tagActiveSideNav == 5  ? "active":"" }" href="list-pendingProduct?index=1">
                <i class="ni ni-bullet-list-67 text-default"></i>
                <span class="nav-link-text">Danh sách sản phẩm chờ</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link ${tagActiveSideNav == 1 ? "active":"" }" href="add-product">
                <i class="ni ni-key-25 text-info"></i>
                <span class="nav-link-text">Thêm sản phẩm</span>
              </a>
            </li>
          </ul>
          
          
        </div>
      </div>
    </div>
  </nav>