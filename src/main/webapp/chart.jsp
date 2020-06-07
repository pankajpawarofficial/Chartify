<%@page import="com.chartify.services.DaoChart"%>
<%@page import="com.chartify.beans.ChartDataBean"%>


<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="bs/css/bootstrap.min.css">
<link rel="stylesheet" href="bs/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/style.css">
<script src="bs/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/d3.js"></script>
<script type="text/javascript" src="js/d3.js"></script>
<script type="text/javascript" src="js/c3.min.js"></script>
<link href="css/c3.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/linechart.js"></script>
<title>Chartify</title>
<script src="js/script.js" type="text/javascript"></script>
</head>
<body>
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
				<li><a href="#">Grant Access</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<%
		DaoChart dao = new DaoChart();
		ArrayList<ChartDataBean> array = dao.databaseReader("B2B");
		ArrayList<String> quarters = dao.getQuarters();
		ArrayList<String> years = dao.getYears();
	%>
	<div style="margin-left: 1%">
		<div class="dropdown" style="display: inline-block;">
			<button class="btn btn-primary dropdown-toggle " type="button"
				id="yearbutton" data-toggle="dropdown">
				<span id="year">Year</span> <span class="caret"></span>
			</button>

			<ul class="dropdown-menu">
				<li><a onclick="selectYear('Year')">--none--</a></li>
				<%
					for (String year : years) {
				%>
				<li><a href="#" onclick="selectYear('<%=year%>')"> <%
 	out.println(year);
 %>
				</a></li>
				<%
					}
				%>
			</ul>
		</div>

		<div class="dropdown" style="display: inline-block">
			<button class="btn btn-primary dropdown-toggle disabled"
				id="quarterbutton" type="button" data-toggle="dropdown">
				<span id="quarter">Quarter</span> <span class="caret"></span>
			</button>

			<ul class="dropdown-menu">
				<li><a onclick="selectQuarter('Quarter')">--none--</a></li>
				<%
					for (String quarter : quarters) {
				%>
				<li><a href="#" onclick="selectQuarter('<%=quarter%>')"> <%
 	out.println(quarter);
 %>
				</a></li>
				<%
					}
				%>
			</ul>
		</div>
		<button type="button" class="btn btn-primary pull-right"
			style="margin-right: 1%" data-toggle="modal" data-target="#myModal2">Set
			Control Points</button>
	</div>
	<br>

	<!-- Modal -->
	<div class="modal fade" id="myModal2" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">
						<b>Root Cause Analysis for Outlier</b>
					</h4>
				</div>
				<div class="modal-body">


					<form>
						<!-- <div class="form-group">
							<label for="fromlimit">From(Sl No)</label> <input type="text"
								class="form-control" id="fromlimit"
								placeholder="Enter Start Point">
						</div>
						<div class="form-group">
							<label for="fromlimit">To(Sl No)</label> <input type="text"
								class="form-control" id="fromlimit"
								placeholder="Enter End Point">
						</div> -->
						<div class="form-group">
							<label for="exampleInputPassword1">Password</label> <input
								type="password" class="form-control" id="exampleInputPassword1"
								placeholder="Password">
						</div>
						<div class="form-group">
							<label for="exampleSelect1">Example select</label> <select
								class="form-control" id="exampleSelect1">
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							</select>
						</div>
						<div class="form-group">
							<label for="exampleSelect2">Example multiple select</label> <select
								multiple class="form-control" id="exampleSelect2">
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							</select>
						</div>
						<div class="form-group">
							<label for="exampleTextarea">Example textarea</label>
							<textarea class="form-control" id="exampleTextarea" rows="3"></textarea>
						</div>
						<div class="form-group">
							<label for="exampleInputFile">File input</label> <input
								type="file" class="form-control-file" id="exampleInputFile"
								aria-describedby="fileHelp"> <small id="fileHelp"
								class="form-text text-muted">This is some placeholder
								block-level help text for the above input. It's a bit lighter
								and easily wraps to a new line.</small>
						</div>
						<fieldset class="form-group">
							<legend>Radio buttons</legend>
							<div class="form-check">
								<label class="form-check-label"> <input type="radio"
									class="form-check-input" name="optionsRadios"
									id="optionsRadios1" value="option1" checked> Option one
									is this and that&mdash;be sure to include why it's great
								</label>
							</div>
							<div class="form-check">
								<label class="form-check-label"> <input type="radio"
									class="form-check-input" name="optionsRadios"
									id="optionsRadios2" value="option2"> Option two can be
									something else and selecting it will deselect option one
								</label>
							</div>
							<div class="form-check disabled">
								<label class="form-check-label"> <input type="radio"
									class="form-check-input" name="optionsRadios"
									id="optionsRadios3" value="option3" disabled> Option
									three is disabled
								</label>
							</div>
						</fieldset>
						<div class="form-check">
							<label class="form-check-label"> <input type="checkbox"
								class="form-check-input"> Check me out
							</label>
						</div>
						<button type="submit" class="btn btn-primary">Submit</button>
					</form>


				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>
	<div class="chartdiv">
		<div id="chart"></div>
	</div>

	<input type="text" id="searchinput" onkeyup="searchFunction()"
		placeholder="Search">

	<div class="table-responsive">
		<table class="table" id="table">
			<thead class="customth">
				<tr>
					<th class="text-center txtcolor">Sl No</th>
					<th class="text-center txtcolor">Data Points</th>
					<th class="text-center txtcolor">Outlier</th>
					<th class="text-center txtcolor">UCL 3-σ</th>
					<th class="text-center txtcolor">LCL 3-σ</th>
					<th class="text-center txtcolor">UCL 2-σ</th>
					<th class="text-center txtcolor">LCL 2-σ</th>
					<th class="text-center txtcolor">UCL 1-σ</th>
					<th class="text-center txtcolor">LCL 1-σ</th>
					<th class="text-center txtcolor">Mean</th>
					<th class="text-center txtcolor">USL</th>
					<th class="text-center txtcolor">LSL</th>
					<th class="text-center txtcolor">Incident id</th>
				</tr>
			</thead>
			<tbody id="customtbody">
				<%
					for (ChartDataBean chartDataBean : array) {
				%>
				<tr>
					<td name='slno'>
						<%
							out.println(chartDataBean.getSlNo());
						%>
					</td>
					<td name='datapoints'>
						<%
							out.println(chartDataBean.getDataPoint());
						%>
					</td>
					<td name='outlier'>
						<%
							out.println(chartDataBean.isOutlier());
						%>
					</td>
					<td name='ucl3'>
						<%
							out.println(chartDataBean.getuCL3());
						%>
					</td>
					<td name='lcl3'>
						<%
							out.println(chartDataBean.getuCL3());
						%>
					</td>
					<td name='ucl2'>
						<%
							out.println(chartDataBean.getuCL2());
						%>
					</td>
					<td name='lcl2'>
						<%
							out.println(chartDataBean.getlCL2());
						%>
					</td>
					<td name='ucl1'>
						<%
							out.println(chartDataBean.getuCL1());
						%>
					</td>
					<td name='lcl1'>
						<%
							out.println(chartDataBean.getlCL1());
						%>
					</td>
					<td name='mean'>
						<%
							out.println(chartDataBean.getMean());
						%>
					</td>
					<td name='usl'>
						<%
							out.println(chartDataBean.getuSL());
						%>
					</td>
					<td name='lsl'>
						<%
							out.println(chartDataBean.getlSL());
						%>
					</td>
					<td name='incidentid'><a href="#" data-toggle="modal"
						data-target="#myModal"
						onclick="modalField('<%=chartDataBean.getIncidentId()%>')"> <%
 	out.println(chartDataBean.getIncidentId());
 %>
					</a></td>
				</tr>
				<div class="modal fade" id="myModal" role="dialog">
					<div class="modal-dialog">

						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title" id="modalheader"></h4>
							</div>
							<div class="modal-body">
								<p>Some text in the modal.</p>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
							</div>
						</div>

					</div>
				</div>
				<%
					}
				%>


			</tbody>
		</table>

	</div>


	<div class="buttonHolder ">
		<a id="add_row" class="button tick btn btn-default"></a> <a
			id='delete_row' class="button cross btn btn-default pull-right"></a>
	</div>
	</div>
	</section>

	<div id="somediv"></div>


</body>
</html>