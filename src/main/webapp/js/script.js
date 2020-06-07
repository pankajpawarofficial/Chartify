function proceed(){
	if( document.getElementById("hiddenform").style.display==="none"){
		window.location.replace("chart.jsp");
	}
	else
	{	
		document.getElementById("hiddenform").submit();
	}
}

function searchFunction() {
	var input, filter, table, tr, td, i,j;
	input = document.getElementById("searchinput");
	filter = input.value.toUpperCase();
	table = document.getElementById("table");
	tr = table.getElementsByTagName("tr");
	for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td");
		for(j=0;j<td.length;j++){
			if (td[j]) {

				if (td[j].innerHTML.toUpperCase().indexOf(filter) > -1) {
					tr[i].style.display = "";
					break;
				} else {
					tr[i].style.display = "none";
				}
			}
		}
	}
}


function map(employeeid,employeename,buyrate,sellrate,grossmargin,expensefactor,rrq,util){
	document.getElementById("employeeid2").value=employeeid;
	document.getElementById("employeename2").value=employeename;
	document.getElementById("buyrate2").value=buyrate;
	document.getElementById("sellrate2").value=sellrate;
	document.getElementById("grossmargin2").value=grossmargin;
	document.getElementById("expensefactor2").value=expensefactor;
	document.getElementById("rrq").value=rrq;
	document.getElementById("utilization2").value=util;
	console.log(employeeid2);
	console.log(employeename2);
}

function modalField(modalHeader){
	console.log(String(modalHeader));
	document.getElementById("modalheader").innerHTML=String(modalHeader);
}



