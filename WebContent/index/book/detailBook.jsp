<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="entity.book.Book"%>
<%@page import="dao.book.BookDAO"%>
<head>
<title>Free Movies Store Website Template | Preview :: w3layouts</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="../../css/style.css" rel="stylesheet" type="text/css" media="all"/>
<script type="text/javascript" src="../../js/jquery-1.9.0.min.js"></script> 
<script type="text/javascript" src="../../js/move-top.js"></script>
<script type="text/javascript" src="../../js/easing.js"></script>
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
							<%if (session.getAttribute("username") == null){ %>
								<li><a href="../person/register.jsp">Register</a></li>
								<li><a href="../person/login.jsp">Login</a></li>
							<%}else{ %>
								<li><a href="#">Hello <%=session.getAttribute("username") %></a></li>
								<li><a href="../../Logout">Logout</a></li>		<!-- nhảy đến servlet xử lí log out -->
								<li><a href="../orders/checkOut.jsp">Check Out</a></li>
								<li><a href="#">My Account</a></li>
							<%} %>
						</ul>
					</div>
				<div class="clear"></div>
			</div>
	  	</div>
  	  		<div class="wrap">
				<div class="header_top">
					<div class="logo">
						<a href="index.html"><img src="images/logo.png" alt="" /></a>
					</div>
						<div class="header_top_right">
						  <div class="cart">
						  	   <p><span>Cart</span><div id="dd" class="wrapper-dropdown-2"> (empty)
						  	   	<ul class="dropdown">
										<li>you have no items in your Shopping cart</li>
								</ul></div></p>
						  </div>
							  <div class="search_box">
					     		<form>
					     			<input type="text" value="Search" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search';}"><input type="submit" value="">
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
					
										obj.dd.on('click', function(event){
											$(this).toggleClass('active');
											event.stopPropagation();
										});	
									}
								}
					
								$(function() {
					
									var dd = new DropDown( $('#dd') );
					
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
   <div class="main">
   	 <div class="wrap">
   	 	<div class="content_top">
    		<div class="back-links">
    		<p><a href="index.html">Home</a> &gt;&gt;&gt;&gt; <a href="#" class="active">English</a></p>
    	    </div>
    		<div class="clear"></div>
    	</div>
   	 	<div class="section group">
   	 		
   	 			<%int idBook= Integer.parseInt(request.getParameter("IdBook"));
   	 			BookDAO bookDAO = new BookDAO("sa", "123456");
   	 			Book book = bookDAO.getBookByID(idBook);
   	 			
   	 			%>
   	 	
				<div class="cont-desc span_1_of_2">
						<div class="product-details">				
							<div class="grid images_3_of_2">
								<img src="../../imageBook/<%=book.getImage() %>" alt="" />
						 </div>
							<div class="desc span_3_of_2">
									<h2>Tên sách: <%=book.getTitle() %></h2>				
									<div class="price">
										<p>Giá: <span>$<%=book.getOriginalPrice() %></span></p>
									</div>
									<div class="available">
										<ul>
										  <li><span>Năm xuất bản:</span> <%=book.getPublishYear() %></li>
										  <li><span>Nhà xuất bản:</span> <%=book.getPublisher() %></li>
										  <li><span>Tác giả:</span>  <%=book.getAuthor() %></li>
									    </ul>
									</div>
								<div class="share-desc">
									<div class="share">
										<!-- <p>Số lượng :</p><input id="qta_field" class="text_box" type="text"> -->
										
										<p>Số lượng :</p><input type="number" id="qta_field" class="text_box" min="1" max="100" required>
										
										
										 <script type="text/javascript">
										 
											$(document).ready(function(){
											    $('a#id1').click(function(e) {
													var bla = $('#qta_field').val();
													if (isNaN(bla) == true){
														<!-- alert('khoong phai so'); -->
														window.location.href = "../../AddToCart?method=get&IdBook=<%=book.getId()%>";
														window.stop();
													}
											    	
													a = document.querySelector('a#id1');
													a.setAttribute('href',a.getAttribute('href')+bla);
													
											    });
											 });
											
										 </script>			
									</div>
									<div class="button"><span><a id="id1" href="../../AddToCart?method=get&IdBook=<%=book.getId()%>&quantity=">Add to Cart</a></span></div>
									<div class="clear"></div>
								</div>
								<div class="available"></div>
							</div>
					<div class="clear"></div>
				  </div>
				<div class="product_desc">	
					 <h2>Thông tin thêm :</h2>
					   <p><%=book.getDescription() %></p>
			   </div>
		   </div>
				<div class="rightsidebar span_3_of_1 sidebar">
				
					<h2>Giảm giá nhất</h2>
					<%ArrayList<Book> listBook = bookDAO.getBookSale(); 
						for (int i=0; i<listBook.size(); i++){%>
							<div class="special_movies">
						 	   <div class="movie_poster">
							 		  <a href="preview.html"><img src="../../imageBook/<%=listBook.get(i).getImage() %>" alt="" /></a>
							 		 </div>
							 		   <div class="movie_desc">
									    <h3><a href="preview.html"><%=listBook.get(i).getTitle() %></a></h3>
										<p><span>$<%=listBook.get(i).getOriginalPrice() %></span> &nbsp; $<%=listBook.get(i).getSalePrice() %></p>
										     <span><a href="../../index/book/detailBook.jsp?IdBook=<%=listBook.get(i).getId() %>">Add to Cart</a></span>
									 </div>
								<div class="clear"></div>
					 		</div>	
						<%}
					%>	 
 				</div>
 				
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
							      <li><a href="#" target="_blank"><img src="images/facebook.png" alt="" /></a></li>
							      <li><a href="#" target="_blank"><img src="images/twitter.png" alt="" /></a></li>
							      <li><a href="#" target="_blank"><img src="images/skype.png" alt="" /> </a></li>
							      <li><a href="#" target="_blank"> <img src="images/linkedin.png" alt="" /></a></li>
							      <div class="clear"></div>
						     </ul>
   	 					</div>
				</div>
			</div>
			 <div class="copy_right">
				<p>Company Name Â© All rights Reseverd | Design by  <a href="http://w3layouts.com">W3Layouts</a> </p>
		   </div>			
        </div>
    </div>
   <script type="text/javascript">
		$(document).ready(function() {			
			$().UItoTop({ easingType: 'easeOutQuart' });
			
		});
	</script>
    <a href="#" id="toTop"><span id="toTopHover"> </span></a>
</body>
</html>

