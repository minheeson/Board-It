<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page session="true"%>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
<link href="<c:url value="/resources/css/board_style.css?v=32"/>"
	rel="stylesheet">

<script src="<c:url value="/resources/js/board.js?v=82" />"></script>

<meta charset="UTF-8">
<title>BOARD-IT</title>
<body>

	<c:choose>
		<c:when test="${not empty sessionScope.userLoginInfo }">
			<div class="header">
				<img class="img_logo" src="resources/img/boardit.png" />
				<p class="user_name">
					<c:out value="${sessionScope.userLoginInfo.userId}" />
				</p>
				<a class="btn_logout" href="logout">logout</a>
			</div>

			<div class="content">

				<div class="ct_personal">
					<div class="ct_personal_header">
						<button class="btn_personal_plus" id="btn_personal_plus"
							type="submit">
							<img class="btn_img" src="resources/img/btn_plus.png">
						</button>
						<p class="p_personal">Personal Board</p>
					</div>
					<div class="ct_personal_board">
						<c:when test="${fn:length(list) > 0 }">
							<c:forEach items="${list }" var="row">

								<ul class="boardList" id="personalList">
									<li><a href="https://www.w3schools.com" id="a_school">SAMPLE</a></li>
									<li><a href="https://www.w3schools.com">${row.board_name }</a>
								</ul>
							</c:forEach>
						</c:when>
					</div>
				</div>

				<div class="ct_team">
					<div class="ct_team_header">
						<button class="btn_team_plus" id="btn_team_plus" type="submit">
							<img class="btn_img" src="resources/img/btn_plus.png">
						</button>
						<p class="p_team">Team Board</p>
					</div>
					<div class="ct_team_board">
						<ul class="boardList" id="teamList">
							<li><a href="https://www.w3schools.com" id="a_school">SAMPLE</a></li>
						</ul>
					</div>
				</div>

			</div>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>
</body>
</html>