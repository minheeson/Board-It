function btnSubmitClicked() {
	document.c_form.method="post";
	var opener = window.opener.name;
	var value = document.c_form.c_txt.value;
	
	window.opener.setBoardName(opener, value);
	document.c_form.c_txt_ex.value = opener.substring(0, opener.length-10);
	document.c_form.submit();
	self.close();
}

function btnCancelClicked() {
	self.close();
}