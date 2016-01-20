<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>  
<!DOCTYPE html>
<html lang="en">
<head>
<link rel='stylesheet'
	href='/spring-mvc/webjars/bootstrap/3.3.6/css/bootstrap.min.css'></link>
</head>
<body>
	<script type="text/javascript"
		src="/spring-mvc/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<!-- <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script> -->
	<form:form class="form-horizontal" action="save"
		modelAttribute="userForm" method="post">
			<input name="id" type="hidden" value="${userForm.id}"/>
<!-- 		<fieldset> -->
			<!-- Form Name -->
<!-- 			<legend>User</legend> -->
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="username"><spring:message code="user.username"/></label>
				<div class="col-md-4">
					<input id="username" name="username" type="text"
						class="form-control input-md" value="${userForm.username}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-4 control-label" for="name"><spring:message code="user.name"/></label>
				<div class="col-md-4">
					<input id="name" name="name" type="text"
						class="form-control input-md" value="${userForm.name}">
				</div>
			</div>
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="email"><spring:message code="user.email"/></label>
				<div class="col-md-4">
					<input id="email" name="email" type="text"
						class="form-control input-md" value="${userForm.email}">

				</div>
			</div>
			<div class="form-group">
				<label class="col-md-4 control-label" for="role"><spring:message code="user.role"/></label>
				<div class="col-md-4">
					<input id="role" name="role" type="text"
						class="form-control input-md" value="${userForm.role}">

				</div>
			</div>
			<!-- address -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="streetAddress"><spring:message code="address.streetAddress"/></label>
				<div class="col-md-4">
					<input id="streetAddress" name="address.streetAddress" type="text"
						class="form-control input-md" value="${userForm.address.streetAddress}">

				</div>
			</div>
			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for=""></label>
				<div class="col-md-4">
					<button id="" name="" class="btn btn-primary"><spring:message code="user.save"/></button>
				</div>
			</div>
<!-- 		</fieldset> -->
	</form:form>
</body>
</html>