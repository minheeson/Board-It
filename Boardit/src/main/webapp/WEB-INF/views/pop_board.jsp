<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
<link href="<c:url value="/resources/css/pop_style.css?v=21"/>"
	rel="stylesheet">

<script src="<c:url value="/resources/js/pop_board.js?v=79" />"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


</head>
<body>
	<div id="div_popup">
		<p id="p_main">Create Board</p>
		<form name="c_form" id="form_input" method="post" >
			<div id="div_input">
				<input type="text" name="boardName"id="c_txt" placeholder=" title" /> 
				<input
					type="text" id="c_txt_ex" name="boardType" placeholder=" explanation ... " />
			</div>

			<div id="div_btn">
				<input type="button" id="btn_cancel" onclick="btnCancelClicked()"
					value=" cancel "> <input type="submit" id="btn_submit"
					onclick="btnSubmitClicked()" value=" submit ">
			</div>



		</form>
	</div>


</body>
</html>