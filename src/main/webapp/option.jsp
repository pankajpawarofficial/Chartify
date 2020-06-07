<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Select</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
		integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
		crossorigin="anonymous">

	<!-- Optional theme -->
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
		integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
		crossorigin="anonymous">

	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
	<link rel="stylesheet" href="css/style.css">

<script src="js/option.js" type="text/javascript"></script>
<script src="js/script.js" type="text/javascript"></script>
</head>
<body class="custombody">
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand customh" href="#">CHARTIFY</a>
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#mainNavBar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>

		<div class="collapse navbar-collapse" id="mainNavBar">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Login</a></li>
				<li><a href="grant.jsp">Grant Access</a></li>
			</ul>
		</div>
	</div>
	</nav>
	<div class="row">
	<div class="formdiv container col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3 col-lg-6">

		<p class="customh3">Select:</p>
		<div class="radiodiv" onclick="displayform()">
			<div class="circle" id="circle1">
				<div class="circle3" id="import"></div>
			</div>
			<p class="customh4">Import Excel</p>
		</div>
		<hr>



		<div class="container-fluid">
			<form class="hiddenform" id="hiddenform" method="post" enctype="multipart/form-data" action="UploadFileForm" name="hiddenform">
				<div class="form-group">
					<label for="projectname" style="color:white">Project Name</label> 
					<input type="text"	class="form-control" id="projectname" placeholder="Project Name" name="projectname">
				</div>
				
				<div class="form-group">
					<label for="InputFile" style="color:white">Browse File</label> 
					<input type="file"	id="InputFile" name="inputfile">
				</div>
				
				<button type="submit" class="btn btn-default" id="hiddenbutton">SUBMIT</button>
			</form>
		</div>



		<div class="radiodiv" onclick="hideform()">
			<div class="circle" id="circle2">
				<div class="circle3" id="proceed"></div>

			</div>
			<p class="customh4">Display Chart</p>
		</div>

		<div>
			<button class="custombtn btn btn-default" type="button" id="proceed" onclick="proceed()">PROCEED</button>
		</div>


	</div>
	</div>


</body>
</html>