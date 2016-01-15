<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>  
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<table>
	<thead>
		<tr>
			<th><spring:message code="user.name"/></th>
			<th><spring:message code="user.email"/></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${users}" var="user" varStatus="status">
			<tr>
				<td>${user.name}</td>
				<td>${user.email}</td>
				<td><a href="/spring-mvc/user/${user.id}">Edit</a>
			</tr>
		</c:forEach>
	</tbody>
</table>
<form:form action="/spring-mvc/user/new" method="GET">
	<input type="submit" value="Add User" />
</form:form>
</body>
</html>