<%@page import="java.text.SimpleDateFormat"%>
<%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!--	cria	o	DAO	-->
	<jsp:useBean id="dao" class="br.com.deitos.dao.ContatoDao" />
	<table>
		<!--	percorre	contatos	montando	as	linhas	da	tabela	-->
		<c:forEach var="contato" items="${dao.lista}">
			<tr>
				<td>${contato.nome}</td>
			</tr>
			<tr>
				<td>${contato.email}</td>
			</tr>
			<tr>
				<td>${contato.endereco}</td>
			</tr>
			<tr>
				<td>${contato.dataNascimento.time}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>