<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.com.deitos.modelo.Contato"%>
<%@page import="java.util.List"%>
<%@page import="br.com.deitos.dao.ContatoDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listagem De Contatos</title>

<style type="text/css">
table, td, tr {
	border: 1px solid black;
}
</style>
</head>
<body>
	<div>
		<h1>LISTA DE CONTATOS</h1>
		<%
			// usando CASt para converter o objeto em uma lista    
			ContatoDao dao = new ContatoDao();
			List<Contato> list = dao.getLista();
			for (Contato c : list) {
		%>
		<table>
			<tr>
				<td>
					<%
						out.print("Contato - " + c.getId());
					%>
				</td>
			</tr>
			<tr>
				<td>
					<%
						out.print(c.getNome());
					%>
				</td>
			</tr>
			<tr>
				<td>
					<%
						out.print(c.getEmail());
					%>
				</td>
			</tr>
			<tr>
				<td>
					<%
						out.print(c.getEndereco());
					%>
				</td>
			</tr>
			<tr>
				<td>
					<%
					// Ajusta data para exibição legível
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					String dateStr = sdf.format(c.getDataNascimento().getTime());
					
					//imprime a data de nascimento
					out.print(dateStr);
					%>
				</td>
			</tr>
		</table>
		<br />
		<%
			}
		%>
	</div>

</body>
</html>