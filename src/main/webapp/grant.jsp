<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="bs/css/bootstrap.min.css">
<link rel="stylesheet" href="bs/css/bootstrap-theme.min.css">
<script src="bs/js/bootstrap.min.js" async></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="css/style.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
					<li><a href="index.jsp">Login</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div>
		<div class="col-xs-offset-1 col-xs-10 col-sm-offset-3 col-sm-6 col-md-offset-3 col-md-6 col-lg-offset-3 col-lg-6">
			<form class="customform2" action="AccessServlet" method="post">
				<div class="form-group">
					<h2 class=customh2>
						Grant Access
					</h2>
				</div>
				<div class="form-group">
					<label for="adminusername">Admin Username</label> <input type="text"
						class="form-control" id="adminusername" placeholder="Admin User Name"
						name="adminusername">
				</div>
				<div class="form-group">
					<label for="adminpassword">Password</label> <input type="password"
						class="form-control" id="adminpassword" placeholder="Admin Password"
						name="adminpassword">
				</div>
				<div class="form-group">
					<label for="newusername">New User Name</label> <input type="text"
						class="form-control" id="newusername" placeholder="New User Name"
						name="newusername">
				</div>
                <div class="form-group">
                    <label for="select">Access Type</label>
                    <select class="form-control" id="select" name="select">
                    <option value="admin">Admin</option>
                    <option value="normal">Normal</option>
                    </select>
                </div>
				<div class="form-group">
					<button type="submit" class="custombtn btn btn-default">GRANT ACCESS</button>
				</div>
			</form>
		</div>
	</div>

	<section></section>

	<footer> </footer>
</body>
</html>