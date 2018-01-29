<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
<link href="<c:url value="/resources/css/board_style.css?v=2"/>"
	rel="stylesheet">

<script src="<c:url value="/resources/js/board.js?v=27" />"></script>

<meta charset="UTF-8">
<title>BOARD-IT</title>
<body>
	<div class="header">
		<img class="img_logo" src="resources/img/boardit.png" />

		<p class="user_name">mini_son</p>
	</div>

	<div class="content">

		<div class="ct_personal">
			<div class="ct_personal_header">
				<button class="btn_plus" id="btn_plus" type="submit">
					<img class="btn_img" src="resources/img/btn_plus.png">
				</button>

				<p class="p_personal">Personal Board</p>
			</div>

			<div class="ct_personal_board">
				<ul class="mylist" id="myList">

					<li><a href="https://www.w3schools.com" id="a_school">SAMPLE</a></li>

				</ul>

			</div>


		</div>

		<!-- <div class="ct_team">
			<div class="ct_team_header">
				<button class="btn_plus" type="submit">
					<img class="btn_img" src="resources/img/btn_plus.png">
				</button>
			</div>
			
			<div></div>

		</div> -->

	</div>


	<input type="text" id="p_txt">


</body>
</html>