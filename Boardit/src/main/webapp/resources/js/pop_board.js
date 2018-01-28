function sendTxt() {
	window.opener.document.getElementById("p_txt").value = document.c_form.c_txt.value;
	self.close();
}