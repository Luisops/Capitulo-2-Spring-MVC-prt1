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
				<th>Foto</th>
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
				<td><a href="fotoMostrar.do?codigoUsuario=<%= usuario.getUsuario()%>" >Foto</a></td>
				<td><a href="usuarioModificar.do?codigoUsuario=<%= usuario.getUsuario()%>" >Editar</a></td>
				<td><a href="usuarioEliminar.do?codigoUsuario=<%= usuario.getUsuario()%>" >Eliminar</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<a href="usuarioCrear.do">Crear Usuario</a>
	<br/>
	<h3>Se han creado en esta sesion ${sessionScope.contador} usuarios!</h3>
</body>
</html>