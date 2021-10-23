<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="JobsCarousel.css" type="text/css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="slideshow-container">

  <!-- Full-width images with number and caption text -->
  <div class="mySlides fade">
    <div class="numbertext">1 / 3</div>
    <div id="rcorners1">Here is a job</div>
    <div class="text">Caption Text</div>
  </div>

  <!-- Next and previous buttons -->
  <a id="slide_buttons" class="prev" onclick="plusSlides(-1)">&#10094;</a>
  <a id="slide_buttons" class="next" onclick="plusSlides(1)">&#10095;</a>
</div>
<br>

<!-- The dots/circles -->
<div style="text-align:center">
  <span class="dot" onclick="currentSlide(1)"></span>
  <span class="dot" onclick="currentSlide(2)"></span>
  <span class="dot" onclick="currentSlide(3)"></span>
</div>
<script src="jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/JobsJS.js"></script>

</body>
</html>