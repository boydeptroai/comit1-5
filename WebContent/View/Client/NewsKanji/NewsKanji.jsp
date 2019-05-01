<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="icon" href="image/favicon.png" type="image/png">
<title>Hoc tu moi</title>
<!-- Bootstrap CSS -->
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="./Template/Client/css/bootstrap.css">
<link rel="stylesheet"
	href="./Template/Client/vendors/linericon/style.css">
<link rel="stylesheet" href="./Template/Client/css/font-awesome.min.css">
<link rel="stylesheet"
	href="./Template/Client/vendors/bootstrap-datepicker/bootstrap-datetimepicker.min.css">
<link rel="stylesheet"
	href="./Template/Client/vendors/nice-select/css/nice-select.css">
<link rel="stylesheet"
	href="./Template/Client/vendors/owl-carousel/owl.carousel.min.css">
<!-- main css -->
<link rel="stylesheet" href="./Template/Client/css/style.css">
<link rel="stylesheet" href="./Template/Client/css/_footer.css">
<link rel="stylesheet" href="./Template/Client/css/button.css">
<link rel="stylesheet" href="./Template/Client/css/responsive.css">
<!-- style cmt -->
<link rel="stylesheet" type="text/css"
	href="./Template/Client/stylecmt.css" />


<link href="./Template/Client/cssh/custom.css" rel="stylesheet">
</head>
<style type="text/css" media="screen">
img {
	vertical-align: middle;
}

/* Position the image container (needed to position the left and right arrows) */
.container {
	position: relative;
}

/* Hide the images by default */
.mySlides {
	display: none;
}

/* Add a pointer when hovering over the thumbnail images */
.cursor {
	cursor: pointer;
}

/* Next & previous buttons */
.prev, .next {
	cursor: pointer;
	position: absolute;
	top: 40%;
	width: auto;
	padding: 16px;
	margin-top: -50px;
	color: white;
	font-weight: bold;
	font-size: 20px;
	border-radius: 0 3px 3px 0;
	user-select: none;
	-webkit-user-select: none;
}

/* Position the "next button" to the right */
.next {
	right: 0;
	border-radius: 3px 0 0 3px;
}

/* On hover, add a black background color with a little bit see-through */
.prev:hover, .next:hover {
	background-color: rgba(0, 0, 0, 0.8);
}

/* Number text (1/3 etc) */
.numbertext {
	color: #f2f2f2;
	font-size: 12px;
	padding: 8px 12px;
	position: absolute;
	top: 0;
}

/* Container for image text */
.caption-container {
	text-align: center;
	background-color: #222;
	padding: 2px 16px;
	color: white;
}

.row:after {
	content: "";
	display: table;
	clear: both;
}

/* Six columns side by side */
.column {
	float: left;
	width: 16.66%;
}

/* Add a transparency effect for thumnbail images */
.demo {
	opacity: 0.6;
}

.active, .demo:hover {
	opacity: 1;
}
</style>

<body>
	<!-- ########## -->
	<jsp:include page="../Header.jsp" />
	<!-- ########## -->
	<!--================Breadcrumb Area =================-->

	<main class="room">
	<a href="chitiet.html"> </a>
	<div class="container">
		<a href="chitiet.html"> </a>
		<div class="row">
			<a href="chitiet.html"> </a>
			<div class="col-lg-8 col-12">
				<a href="chitiet.html">

					<h2
						style="color: #427c19; margin-bottom: 30px; font-size: 30px; margin-top: 40px;">Slideshow
						Gallery</h2>

				</a>
				<div class="container">
					<a href="chitiet.html">
					<p><%=request.getAttribute("kjWNews") %></p>
					<c:forEach items="${kjWNews.resultList}" var="list">
					
						<div class="mySlides" style="display: none;">
							<div class="numbertext"></div>
							<img src="./Template/Client/image/${list.word_img}" style="width: 100%"
								title="write a comment...">
						</div>
					</c:forEach>
						
					</a><a class="prev" onclick="plusSlides(-1)">❮</a> <a class="next"
						onclick="plusSlides(1)"> ❯ </a>

					<div class="caption-container">
						<p id="caption">The Woods</p>
					</div>

					<div class="row" style="margin-left: 0px; margin-right: 0px;">
					<c:forEach items="${kjWNews.resultList}" var="list">
					<div class="column">
							<img class="demo cursor active" src="./Template/Client/image/${list.word_img}"
								style="width: 100%" onclick="currentSlide(this)" alt="${list.word_name}"
								title="write a comment...">
						</div>
					</c:forEach>
					</div>
				</div>

				<script>
					var slideIndex = 1;
					showSlides(slideIndex);

					function plusSlides(n) {
						showSlides(slideIndex += n);
					}


                    function currentSlide(el) {
                        var els = Array.prototype.slice.call( document.getElementsByClassName('demo'), 0 );
                      var n=els.indexOf(event.currentTarget)
                      console.log(n)
                        showSlides(slideIndex = n+1);
                    }

					function showSlides(n) {
						var i;
						var slides = document.getElementsByClassName("mySlides");
						var dots = document.getElementsByClassName("demo");
						var captionText = document.getElementById("caption");
						if (n > slides.length) {
							slideIndex = 1
						}
						if (n < 1) {
							slideIndex = slides.length
						}
						for (i = 0; i < slides.length; i++) {
							slides[i].style.display = "none";
						}
						for (i = 0; i < dots.length; i++) {
							dots[i].className = dots[i].className.replace(
									" active", "");
						}
						slides[slideIndex - 1].style.display = "block";
						dots[slideIndex - 1].className += " active";
						captionText.innerHTML = dots[slideIndex - 1].alt;
					}
				</script>

				<!-- div linhtinh sau slite -->
				<div class="section-title sm"></div>
				<div class="room-services-list"></div>
				<div class="similar-rooms"></div>
				<!-- div linhtinh sau slite -->
			</div>

			<div class="col-lg-4 col-xs-12">
				<div class="blog_right_sidebar"></div>
				<h4>Note</h4>
				<textarea class="textbox-lines" rows="4"></textarea>
				<!-- commet -->
				<div class="comment-wrapper cmt">
					<div class="panel panel-info">
						<div class="panel-heading">Comment panel</div>
						<div class="panel-body">
							<textarea class="form-control" placeholder="write a comment..."
								title="hh" rows="2" style="font-size: 1.5rem"></textarea>
							<br>

							<div class="clearfix"></div>
							<hr>
							<ul class="media-list">
								<li class="media"><a href="#" class="pull-left"> <img
										src="https://bootdey.com/img/Content/user_1.jpg" alt=""
										class="img-circle">
								</a>
									<div class="media-body">
										<span class="text-muted pull-right"> <small
											class="text-muted">30 min ago</small>
										</span> <strong class="text-success">@MartinoMont</strong>
										<p style="font-size: 1.3rem">
											Lorem ipsum dolor sit amet, consectetur adipiscing elit.
											Lorem ipsum dolor sit amet, <a href="#">#consecteturadipiscing
											</a>.
										</p>
									</div></li>
								<li class="media"><a href="#" class="pull-left"> <img
										src="https://bootdey.com/img/Content/user_1.jpg" alt=""
										class="img-circle">
								</a>
									<div class="media-body">
										<span class="text-muted pull-right"> <small
											class="text-muted">30 min ago</small>
										</span> <strong class="text-success">@MartinoMont</strong>
										<p style="font-size: 1.3rem">
											Lorem ipsum dolor sit amet, consectetur adipiscing elit.
											Lorem ipsum dolor sit amet, <a href="#">#consecteturadipiscing
											</a>.
										</p>
									</div></li>

							</ul>
						</div>
					</div>
				</div>
				<!-- end coment -->
			</div>
		</div>
	</main>
	<!-- ########## -->
	<jsp:include page="../Footer.jsp" />
	<!-- ########## -->
	<script
		src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script src="./Template/Client/js/popper.js"></script>
	<script src="./Template/Client/js/bootstrap.min.js"></script>
	<script
		src="./Template/Client/vendors/owl-carousel/owl.carousel.min.js"></script>
	<script src="./Template/Client/js/jquery.ajaxchimp.min.js"></script>
	<script
		src="./Template/Client/vendors/bootstrap-datepicker/bootstrap-datetimepicker.min.js"></script>
	<script
		src="./Template/Client/vendors/nice-select/js/jquery.nice-select.js"></script>
	<script src="./Template/Client/js/mail-script.js"></script>
	<script src="./Template/Client/js/stellar.js"></script>
	<script src="./Template/Client/vendors/lightbox/simpleLightbox.min.js"></script>
	<script src="./Template/Client/js/custom.js"></script>
</body>
</html>