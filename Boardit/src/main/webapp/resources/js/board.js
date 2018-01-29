$(document).ready(
		function() {
			alert("board.js");
			
			var openWin;
			

			$("#btn_plus").click(
					function() {
						window.name = "parentForm";
						openWin = window.open("pop_board", "childForm", "width=400, height=200, resizable=no, scrollbars=no");
						
					});

		});



function setChildValue(name){
    //document.getElementById("p_txt").value = name;
	var $list = $('#myList');
    var li = "<li><a>"+ name +"</a></li>";
    $list.append(li);
}

