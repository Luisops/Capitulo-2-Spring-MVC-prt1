<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Datos del Usuario</title>
<style type="text/css">
.formFieldError {
	background-color: #FFC;
}
</style>
</head>
<body>
	<h1>Datos del usuario</h1>
	<br />
	<mvc:form modelAttribute="usuarioBean" action="usuarioGrabar.do">
		<table>
			<tr>
				<td><mvc:label path="usuario">Usuario: </mvc:label></td>
				<td><mvc:input path="usuario" cssErrorClass="formFieldError" /></td>
				<td><mvc:errors path="usuario" /></td>
			</tr>
			<tr>
				<td><mvc:label path="clave">Clave: </mvc:label></td>
				<td><mvc:input path="clave" cssErrorClass="formFieldError" /></td>
				<td><mvc:errors path="clave" /></td>
			</tr>
			<tr>
				<td><mvc:label path="nombreCompleto">Nombre Completo: </mvc:label></td>
				<td><mvc:input path="nombreCompleto"
						cssErrorClass="formFieldError" /></td>
				<td><mvc:errors path="nombreCompleto" /></td>
			</tr>
			<tr>
				<td colspan="1">
					<input type="submit" value="${accion}" />
					&nbsp;   &nbsp; &nbsp;  
					<a href="usuarioCancelar.do" class="btn btn-primary">Cancelar</a>
				</td>
			</tr>
		</table>
			<input type="hidden" name="accion" value="${accion}" />
	</mvc:form>
</body>
</html>