<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<%@page import="entity.orders.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="entity.book.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.book.BookDAO"%>
<head>
<title>Free Movies Store Website Template | Home :: w3layouts</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="../../css/style.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="../../css/slider.css" rel="stylesheet" type="text/css"
	media="all" />
<script type="text/javascript" src="../../js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="../../js/move-top.js"></script>
<script type="text/javascript" src="../../js/easing.js"></script>
<script type="text/javascript" src="../../js/jquery.nivo.slider.js"></script>



<script type="text/javascript">
	$(window).load(function() {
		$('#slider').nivoSlider();
	});
</script>
</head>
<body>
	<div class="header">
		<div class="headertop_desc">
			<div class="wrap">
				<div class="nav_list">
					<ul>
						<li><a href="../home/home.jsp">Home</a></li>
					</ul>
				</div>
				<div class="account_desc">
					<ul>
						<%if (session.getAttribute("username") == null) {%>
							<li><a href="../person/register.jsp">Register</a></li>
							<li><a href="../person/login.jsp">Login</a></li>
						<%} else {%>
							<li><a href="#">Hello <%=session.getAttribute("username")%></a></li>
							<li><a href="../../Logout">Logout</a></li>
						<!-- nhảy đến servlet xử lí log out -->
						<%if (session.getAttribute("cart") == null) {%>
							<li><a href="#">Check out</a></li>
						<%} else {%>
							<li><a href="../orders/checkOut.jsp">Check out</a></li>
						<%}%>
							<li><a href="#">My account</a></li>
						<%}%>
					</ul>
				</div>
				<div class="clear"></div>
			</div>

		</div>
		<div class="wrap">
			<div class="header_top">
				<div class="logo">
					<a href="home.jsp"><img src="../../imageBook/logo.jpg" alt="" /></a>
				</div>
				<div class="header_top_right">
					<div class="cart">
						<p>
							<span>Cart</span>
						<div id="dd" class="wrapper-dropdown-2">
							(empty)
							<ul class="dropdown">
								<li>you have no items in your Shopping cart</li>
							</ul>
						</div>
						</p>
					</div>
					<div class="search_box">
						<form>
							<input type="text" value="Search" onfocus="this.value = '';"
								onblur="if (this.value == '') {this.value = 'Search';}"><input
								type="submit" value="">
						</form>
					</div>
					<div class="clear"></div>
				</div>
				<script type="text/javascript">
					function DropDown(el) {
						this.dd = el;
						this.initEvents();
					}
					DropDown.prototype = {
						initEvents : function() {
							var obj = this;

							obj.dd.on('click', function(event) {
								$(this).toggleClass('active');
								event.stopPropagation();
							});
						}
					}

					$(function() {

						var dd = new DropDown($('#dd'));

						$(document).click(function() {
							// all dropdowns
							$('.wrapper-dropdown-2').removeClass('active');
						});

					});
				</script>
				<div class="clear"></div>
			</div>
			
		</div>
	</div>
	<!------------End Header ------------>
	<div class="main">
		<div class="wrap">
			<div class="content">
				<div class="content_top">
					<div class="heading">
						<h3>New Products</h3>
					</div>
				</div>


				<%
					ArrayList<Book> listBook = (ArrayList<Book>) session.getAttribute("listBookSearch");
					for (int j = 0; j < Math.ceil((float) listBook.size() / 5); j++) {
				%>
				<div class="section group">
					<%
						int temp = 5 * j;
							int temp_1 = 5 * j + 5;
							if (temp_1 > listBook.size()) {
								temp_1 = listBook.size();
							}
							for (int i = temp; i < temp_1; i++) {
					%>

					<div class="grid_1_of_5 images_1_of_5">
						<a
							href="../../index/book/detailBook.jsp?IdBook=<%=listBook.get(i).getId()%>"><img
							src="../../imageBook/<%=listBook.get(i).getImage()%>" alt="" /></a>
						<h2>
							<a
								href="../../index/book/detailBook.jsp?IdBook=<%=listBook.get(i).getId()%>"><%=listBook.get(i).getTitle()%></a>
						</h2>
						<div class="price-details">
							<div class="price-number">
								<p>
									<span class="rupees">$<%=listBook.get(i).getSalePrice()%></span>
								</p>
							</div>
							<div class="add-cart">
								<h4>
									<a
										href="../../index/book/detailBook.jsp?IdBook=<%=listBook.get(i).getId()%>">Add
										to Cart</a>
								</h4>
							</div>
							<div class="clear"></div>
						</div>
					</div>
					<%
						}
					%>
				</div>
			</div>
			<%
				}
			%>


			
			
		</div>
	</div>
	</div>
	<div class="footer">
		<div class="wrap">
			<div class="section group">
				<div class="col_1_of_4 span_1_of_4">
					<h4>Information</h4>
					<ul>
						<li><a href="#">About Us</a></li>
						<li><a href="#">Customer Service</a></li>
						<li><a href="#">Advanced Search</a></li>
						<li><a href="#">Orders and Returns</a></li>
						<li><a href="contact.html">Contact Us</a></li>
					</ul>
				</div>
				<div class="col_1_of_4 span_1_of_4">
					<h4>Why buy from us</h4>
					<ul>
						<li><a href="#">About Us</a></li>
						<li><a href="#">Customer Service</a></li>
						<li><a href="#">Privacy Policy</a></li>
						<li><a href="contact.html">Site Map</a></li>
						<li><a href="#">Search Terms</a></li>
					</ul>
				</div>
				<div class="col_1_of_4 span_1_of_4">
					<h4>My account</h4>
					<ul>
						<li><a href="contact.html">Sign In</a></li>
						<li><a href="index.html">View Cart</a></li>
						<li><a href="#">My Wishlist</a></li>
						<li><a href="#">Track My Order</a></li>
						<li><a href="contact.html">Help</a></li>
					</ul>
				</div>
				<div class="col_1_of_4 span_1_of_4">
					<h4>Contact</h4>
					<ul>
						<li><span>+91-123-456789</span></li>
						<li><span>+00-123-000000</span></li>
					</ul>
					<div class="social-icons">
						<h4>Follow Us</h4>
						<ul>
							<li><a href="#" target="_blank"><img
									src="images/facebook.png" alt="" /></a></li>
							<li><a href="#" target="_blank"><img
									src="images/twitter.png" alt="" /></a></li>
							<li><a href="#" target="_blank"><img
									src="images/skype.png" alt="" /> </a></li>
							<li><a href="#" target="_blank"> <img
									src="images/linkedin.png" alt="" /></a></li>
							<div class="clear"></div>
						</ul>
					</div>
				</div>
			</div>
			<div class="copy_right">
				<p>
					Company Name Â© All rights Reseverd | Design by <a
						href="http://w3layouts.com">W3Layouts</a>
				</p>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$().UItoTop({
				easingType : 'easeOutQuart'
			});

		});
	</script>
	<a href="#" id="toTop"><span id="toTopHover"> </span></a>
</body>
</html>

