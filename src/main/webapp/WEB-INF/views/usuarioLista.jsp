<%@page import="com.luisops.capitulo2.model.UsuarioDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mantenimiento de usuarios</title>
</head>
<body>
	<h1>Listado de Usuarios</h1>
	<br />
	<% List<UsuarioDTO> lista = (List<UsuarioDTO>) request.getAttribute("lista"); %>
	<table border="1">
		<thead>
			<tr>
				<th>Usuario</th>
				<th>Clave</th>
				<th>Nombre completo</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (UsuarioDTO usuario : lista) {
			%>
			<tr>
				<td><%=usuario.getUsuario()%></td>
				<td><%=usuario.getClave()%></td>
				<td><%=usuario.getNombreCompleto()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<a href="usuarioCrear.do">Crear Usuario</a>
</body>
</html>