<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>All Patient</title>
<%@include file="head.jsp"%>
</head>

<body>
	<div class="bw">
		<div class="dh">

			<!-- navigation -->
			<%@include file="navbar.jsp"%>


			<!-- Body Part -->
			<div class="et brf">
				<div class="bqn">
					<div class="bqo">
						<h6 class="bqq">Dashboards</h6>
						<h2 class="bqp">All Patients</h2>
					</div>
				</div>

				<div class="bop ayg">
					<div class="boq bor">
						<div class="axm bpy">
							<input type="text" class="form-control bsx"
								placeholder="Search orders"> <span class="bv bhw"></span>
						</div>
					</div>
					<div class="boq">
						<div class="ol">
							<button type="button" class="ce nr">
								<span class="bv bji"></span>
							</button>
							<button type="button" class="ce nr">
								<span class="bv bei"></span>
							</button>
						</div>
					</div>
				</div>

				<form:form class="form" method="POST" modelAttribute="patient"
					action="/addPatient" role="form">
					<div class="row modal-body">
						<label id="message"></label>
						<div>
						<h3>${message}</h3>
							<button type="submit" class="btn" name="saveOrUpdatePatient"
								id="saveOrUpdatePatient">
								<a href="">SAVE/UPDATE</a>
							</button>
							<button type="reset" class="btn" name="clear" id="clear">
								<a href="">CLEAN</a>
							</button>
							<button type="button" class="btn" name="search" id="search">
								<a href="">SEARCH</a>
							</button>
							<button type="button" class="btn" name="executeQuery"
								id="executeQuery">
								<a href="">EXECUTE QUERY</a>
							</button>
						</div>

						<div class="col-sm-12">
							<hr />
							<h4>Patient Registration :</h4>

							<form:hidden class="form-control" path="patientNo"
								placeholder="Patient No" />

							<div class="col-sm-2">
								<div>
									<label>First Name</label>
								</div>
								<div>
									<form:input class="form-control" type="text" path="firstName"
										id="firstName" placeholder="First Name" />
									<label id="checkFirstName"></label>
								</div>
							</div>

							<div class="col-sm-2">
								<div>
									<label>Last Name</label>
								</div>
								<div>
									<form:input class="form-control" type="text" path="lastName"
										id="lastName" placeholder="Last Name" />
									<label id="checkLastName"></label>
								</div>
							</div>

							<div class="col-sm-2">
								<div>
									<label>Father's Name</label>
								</div>
								<div>
									<form:input class="form-control" type="text" path="fathersName"
										id="fathersName" placeholder="Father's Name" />
									<label id="checkFatherName"></label>
								</div>
							</div>

							<div class="col-sm-3">
								<div>
									<label>Mother's Name</label>
								</div>
								<div>
									<form:input class="form-control" type="text" path="mothersName"
										id="mothersName" placeholder="Mother's Name" />
									<label id="checkMothersName"></label>
								</div>
							</div>

							<div class="col-sm-3">
								<div>
									<label>Date of Birth</label>
								</div>
								<div>
									<form:input class="form-control" type="date" path="birthDate"
										id="birthDate" />
									<label id="checkBirthDate"></label>
								</div>
							</div>
						</div>

						<div class="col-sm-12">

							<div class="col-sm-3">
								<div>
									<label>Gender</label>
								</div>
								<div>

									<form:select class="selectpicker" style="" id="gender" path="genderCode">
										<option value="">Select One</option>
										<c:forEach items="${gender}" var="gend">
											<form:option value="${gend.gender_code}">${gend.gender_name}</form:option>
										</c:forEach>
									</form:select> <label id="checkGender"></label>
								</div>
							</div>

							<div class="col-sm-3">
								<div>
									<label>Marital Status</label>
								</div>
								<div>
									<form:select class="selectpicker" style="" id="maritalStatus" path="maritalStatusCode">
										<option value="">Select One</option>
										<c:forEach items="${maritalStatus}" var="ms">
											<form:option value="${ms.marital_status_code}">${ms.marital_status_name}</form:option>
										</c:forEach>
									</form:select> <label id="checkMaritalStatus"></label>
								</div>
							</div>

							<div class="col-sm-3">
								<div>
									<label>Nationality</label>
								</div>
								<div>
									<form:select class="selectpicker" style="" id="nationalities" path="nationalityCode">
										<option value="">Select One</option>
										<c:forEach items="${nationalities}" var="nat">
											<form:option value="${nat.nationality_code}">${nat.nationality_name}</form:option>
										</c:forEach>
									</form:select> <label id="checkNationalities"></label>
								</div>
							</div>

							<div class="col-sm-3">
								<div>
									<label>Phone Number</label>
								</div>
								<div>
									<form:input class="form-control" type="text" path="phoneNumber"
										id="phoneNumber" placeholder="Phone Number" />
								</div>
								<label id="checkPhoneNumber"></label>
							</div>
						</div>
					</div>
				</form:form>
				<br />
				<div class="container">
					<table id="example"
						class="table table-striped table-bordered nowrap"
						style="width: 100%">
						<thead>
							<tr>
								<th>Patient No</th>
								<th>Full Name</th>
								<th>Father's Name</th>
								<th>B.Date</th>
								<th>Gender</th>
								<th>M.Status</th>
								<th>Nationality</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${allPatient}" var="allPat">
								<tr>
									<td>${allPat.patientNo}</td>
									<td>${allPat.firstName}${ allPat.lastName }</td>
									<td>${allPat.fathersName}</td>
									<td>${allPat.birthDate}</td>
									<td>${allPat.genderCode}</td>
									<td>${allPat.maritalStatusCode}</td>
									<td>${allPat.nationalityCode}</td>
									<td><a href="/goEditPatient/${allPat.patientNo}">Edit</a>
										<a href="/deletePatient/${allPat.patientNo}">Delete</a></td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr>
								<th>Patient No</th>
								<th>Full Name</th>
								<th>Father's Name</th>
								<th>B.Date</th>
								<th>Gender</th>
								<th>M.Status</th>
								<th>Nationality</th>
								<th>Action</th>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- footer -->
	<%@include file="footer.jsp"%>
	<script>
		$(document).ready(function() {
			var table = $('#example').DataTable({
				responsive : true
			});

			new $.fn.dataTable.FixedHeader(table);
		});

		$("#saveOrUpdatePatient")
				.click(
						function() {
							console.log('newPatient Clicked');
							var firstName = $("#firstName").val();
							var lastName = $("#lastName").val();
							var fathersName = $("#fathersName").val();
							var mothersName = $("#mothersName").val();
							var birthDate = $("#birthDate").val();
							var g = document.getElementById("gender");
							var gender = g.options[g.selectedIndex].value;
							var maritalS = document
									.getElementById("maritalStatus");
							var maritalStatus = maritalS.options[maritalS.selectedIndex].value;
							var nation = document
									.getElementById("nationalities");
							var nationalities = nation.options[nation.selectedIndex].value;
							var phoneNumber = $("#phoneNumber").val();

							var contextPath = '${pageContext.request.contextPath}';

							console.log(contextPath);
							console.log(firstName);
							console.log(lastName);
							console.log(fathersName);
							console.log(mothersName);
							console.log(birthDate);
							console.log(gender);
							console.log(maritalStatus);
							console.log(nationalities);
							console.log(phoneNumber);
							if (firstName === '' || firstName === null
									|| firstName === 'undefined') {
								$("#checkFirstName")
										.html(
												"<font color='red'>Please Insert First Name</font>");
								document.getElementById("firstName").focus();
							} else if (lastName === '' || lastName === null
									|| lastName === 'undefined') {
								$("#checkLastName")
										.html(
												"<font color='red'>Please Insert Last Name</font>");
								document.getElementById("lastName").focus();
							} else if (fathersName === ''
									|| fathersName === null
									|| fathersName === 'undefined') {
								$("#checkFatherName")
										.html(
												"<font color='red'>Please insert Father's Name</font>");
								document.getElementById("fathersName").focus();
							} else if (mothersName === ''
									|| mothersName === null
									|| mothersName === 'undefined') {
								$("#checkMothersName")
										.html(
												"<font color='red'>Please Insert Mother's Name</font>");
								document.getElementById("mothersName").focus();
							} else if (birthDate === '' || birthDate === null
									|| birthDate === 'undefined') {
								$("#checkBirthDate")
										.html(
												"<font color='red'>Please Insert Birth Date</font>");
								document.getElementById("birthDate").focus();
							} else if (gender === '' || gender === null
									|| gender === 'undefined') {
								$("#checkGender")
										.html(
												"<font color='red'>Please Select Gender</font>");
								document.getElementById("birthDate").focus();
							} else if (maritalStatus === ''
									|| maritalStatus === null
									|| maritalStatus === 'undefined') {
								$("#checkMaritalStatus")
										.html(
												"<font color='red'>Please Select Marital Status</font>");
								document.getElementById("maritalStatus")
										.focus();
							} else if (nationalities === ''
									|| nationalities === null
									|| nationalities === 'undefined') {
								$("#checkNationalities")
										.html(
												"<font color='red'>Please Select Nationalities</font>");
								document.getElementById("nationalities")
										.focus();
							} else if (phoneNumber === ''
									|| phoneNumber === null
									|| phoneNumber === 'undefined') {
								$("#checkPhoneNumber")
										.html(
												"<font color='red'>Please Insert Phone Number</font>");
								document.getElementById("phoneNumber").focus();
							} else {
								/* $.ajax({
									type : "GET",
									url : "addPatient",
									success : function(data) {
										console.log('ajax called');
										$.each(data, function(index, element) {
											var message = element.message;
											console.log('Message =' + message);
											$(".modal-body #message").val(
													message);
										});
									}
								}); */
							}
						});
	</script>
</body>
</html>