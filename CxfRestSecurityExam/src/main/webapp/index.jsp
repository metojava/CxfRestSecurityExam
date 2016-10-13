<html>

<head>
<link rel="stylesheet"
	href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<script>
	$(document)
			.ready(
					function() {

						var url = "http://localhost:8080/CxfRestSecurityExam/services/UserService/users";

						$
								.ajax(
										{
											dataType : "json",
											url : url,
											beforeSend : function(xhr) {
												xhr
														.setRequestHeader(
																"Authorization",
																"Bearer mamuka:arabuli");

											}

										})
								.done(
										function(data) {
											var items = [];
											var tableData = [];
											var l = data.user.length;
											console.log(l);
											for (var i = 0; i < l; i++) {
												var usr = data.user[i];
												//console.log(usr.age+" "+usr.fname+" "+usr.lname+" "+usr.salary);
												var usrData = usr.age + " "
														+ usr.fname + " "
														+ usr.lname + " "
														+ usr.salary;
												items.push("<li>" + usrData
														+ "</li>");
												tableData.push("<tr><td>"
														+ usr.age + "</td>"
														+ "<td>" + usr.fname
														+ "</td>" + "<td>"
														+ usr.lname + "</td>"
														+ "<td>" + usr.salary
														+ "</td>" + "</tr>");
											}
											$("<ul/>", {
												html : items.join("")
											}).css("color", "yellow").append(
													"<hr/>").appendTo("#main");

											//$('<table data-role="table" data-mode="columntoggle" class="ui-responsive table-stroke" />', {
											//	html : items.join("")
											//}).css("", "1px").appendTo("#main");

											var stable = $('<table data-role="table"  data-mode="columntoggle" class="ui-responsive table-stroke" id="service"></table>');

											var shead = $("<thead><tr><th data-priority='1'>Age</th><th>First Name:</th data-priority='2'><th data-priority='3'>Last Name:</th><th data-priority='4'>Salary</th></tr></thead>");
											var sbody = $('<tbody></tbody>');
											sbody.append(tableData);
											stable.append(shead).append(sbody);
											stable.appendTo("#main");
										}).fail(function(jqXHR, textStatus) {

									alert("Error: " + textStatus);
								});

					});
</script>

<style>
#main {
	margin: 0 auto;
	width: 800px;
	align: center;
}
</style>
</head>

<body data-role="page">

	<div id="main">

		<div id="head" align="center">
			<h1>Restful with Jquery and Security</h1>
		</div>

	</div>
</body>

</html>
