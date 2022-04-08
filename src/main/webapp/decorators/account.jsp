<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url value="/templates/" var="url"></c:url>

<!doctype html>
<html class="no-js" lang="zxx">


<head>
	<meta charset="utf-8">
	<meta http-equiv="x-ua-compatible" content="ie=edge">
	<title>FUFU SHOP</title>
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- Favicon -->
	<link rel="shortcut icon" type="image/x-icon"
		href="${url }images/menu/logo/1.jpg">
	<!-- Material Design Iconic Font-V2.2.0 -->
	<link rel="stylesheet"
		href="${url }css/material-design-iconic-font.min.css">
	<!-- Font Awesome -->
	<link rel="stylesheet" href="${url }css/font-awesome.min.css">
	<!-- Font Awesome Stars-->
	<link rel="stylesheet" href="${url }css/fontawesome-stars.css">
	<!-- Meanmenu CSS -->
	<link rel="stylesheet" href="${url }css/meanmenu.css">
	<!-- owl carousel CSS -->
	<link rel="stylesheet" href="${url }css/owl.carousel.min.css">
	<!-- Slick Carousel CSS -->
	<link rel="stylesheet" href="${url }css/slick.css">
	<!-- Animate CSS -->
	<link rel="stylesheet" href="${url }css/animate.css">
	<!-- Jquery-ui CSS -->
	<link rel="stylesheet" href="${url }css/jquery-ui.min.css">
	<!-- Venobox CSS -->
	<link rel="stylesheet" href="${url }css/venobox.css">
	<!-- Nice Select CSS -->
	<link rel="stylesheet" href="${url }css/nice-select.css">
	<!-- Magnific Popup CSS -->
	<link rel="stylesheet" href="${url }css/magnific-popup.css">
	<!-- Bootstrap V4.1.3 Fremwork CSS -->
	<link rel="stylesheet" href="${url }css/bootstrap.min.css">
	<!-- Helper CSS -->
	<link rel="stylesheet" href="${url }css/helper.css">
	<!-- Main Style CSS -->
	<link rel="stylesheet" href="${url }style.css">
	<!-- Responsive CSS -->
	<link rel="stylesheet" href="${url }css/responsive.css">
	<!-- Modernizr js -->
	<script src="${url }js/vendor/modernizr-2.8.3.min.js"></script>
</head>

<body>
	<!-- Begin Body Wrapper -->
	<div class="body-wrapper">
		<!-- Begin Header Area -->
		<header>
			<!-- Begin Header Top Area -->
			<%@ include file="/common/account/HeaderTop.jsp"%>
			<!-- Header Top Area End Here -->
		</header>
		
		<dec:body />
		
		<!-- Begin Footer Area -->
		<div class="footer">
			<!-- Begin Footer Static Top Area -->
			<%@ include file = "/common/account/FooterTop.jsp" %>
			<!-- Footer Static Top Area End Here -->
			
			<!-- Begin Footer Static Middle Area -->
			<%@ include file = "/common/account/FooterMiddle.jsp" %>
			<!-- Footer Static Middle Area End Here -->
			
			<!-- Begin Footer Static Bottom Area -->
			<%@ include file = "/common/account/FooterBottom.jsp" %>
			<!-- Footer Static Bottom Area End Here -->
		</div>
		<!-- Footer Area End Here -->
		
		<!-- Begin Quick View | Modal Area -->
		<%@ include file = "/common/account/QuickView.jsp" %>
		<!-- Quick View | Modal Area End Here -->
	</div>
	<!-- Body Wrapper End Here -->

	
</body>

	<!-- jQuery-V1.12.4 -->
	<script src="${url }js/vendor/jquery-1.12.4.min.js"></script>
	<!-- Popper js -->
	<script src="${url }js/vendor/popper.min.js"></script>
	<!-- Bootstrap V4.1.3 Fremwork js -->
	<script src="${url }js/bootstrap.min.js"></script>
	<!-- Ajax Mail js -->
	<script src="${url }js/ajax-mail.js"></script>
	<!-- Meanmenu js -->
	<script src="${url }js/jquery.meanmenu.min.js"></script>
	<!-- Wow.min js -->
	<script src="${url }js/wow.min.js"></script>
	<!-- Slick Carousel js -->
	<script src="${url }js/slick.min.js"></script>
	<!-- Owl Carousel-2 js -->
	<script src="${url }js/owl.carousel.min.js"></script>
	<!-- Magnific popup js -->
	<script src="${url }js/jquery.magnific-popup.min.js"></script>
	<!-- Isotope js -->
	<script src="${url }js/isotope.pkgd.min.js"></script>
	<!-- Imagesloaded js -->
	<script src="${url }js/imagesloaded.pkgd.min.js"></script>
	<!-- Mixitup js -->
	<script src="${url }js/jquery.mixitup.min.js"></script>
	<!-- Countdown -->
	<script src="${url }js/jquery.countdown.min.js"></script>
	<!-- Counterup -->
	<script src="${url }js/jquery.counterup.min.js"></script>
	<!-- Waypoints -->
	<script src="${url }js/waypoints.min.js"></script>
	<!-- Barrating -->
	<script src="${url }js/jquery.barrating.min.js"></script>
	<!-- Jquery-ui -->
	<script src="${url }js/jquery-ui.min.js"></script>
	<!-- Venobox -->
	<script src="${url }js/venobox.min.js"></script>
	<!-- Nice Select js -->
	<script src="${url }js/jquery.nice-select.min.js"></script>
	<!-- ScrollUp js -->
	<script src="${url }js/scrollUp.min.js"></script>
	<!-- Main/Activator js -->
	<script src="${url }js/main.js"></script>
<!-- index30:23-->
</html>
	