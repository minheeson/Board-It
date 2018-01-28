<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="<c:url value="/resources/js/pop_board.js?v=89" />"></script>
<script type="text/javascript">
function sendTxt() {
	window.opener.setChildValue(document.c_form.c_txt.value);
	//window.opener.document.getElementById("p_txt").value = document.c_form.c_txt.value;
	self.close();
}
</script>
</head>
<body>

	<form name="c_form">
		<input type="text" id="c_txt"> <input type="button"
			onclick="sendTxt()" value=" send ">
	</form>

</body>
</html>