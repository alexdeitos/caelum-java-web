<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="br.com.deitos.modelo.Contato"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Contatos</title>

<style type="text/css">

form {
	/* Apenas para centralizar o form na p�gina */
	width: 400px;
	/* Para ver as bordas do formul�rio */
	padding: 1em;
	border: 1px solid #CCC;
	border-radius: 1em;
	margin-bottom: 10px;
}

label {
	/*Para ter certeza que todas as labels tem o mesmo tamanho e est�o propriamente alinhadas */
	display: inline-block;
	width: 90px;
	margin-top: 10px;
	text-align: right;
	text-align: justify;
	text-align: right;
}

input, textarea {
	/* Para certificar-se que todos os campos de texto t�m as mesmas configura��es de fonte. Por padr�o, textareas ter uma fonte monospace*/
	font: 1em sans-serif;
	/* Para dar o mesmo tamanho a todos os campo de texto */
	width: 300px;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	/* Para harmonizar o look & feel das bordas nos campos de texto*/
	border: 1px solid #999;
}

input:focus, textarea:focus {
	/* Dar um pouco de destaque nos elementos ativos */
	border-color: #000;
}

textarea {
	/* Para alinhar corretamente os campos de texto de v�rias linhas com sua label*/
	vertical-align: top;
	/* Para dar espa�o suficiente para digitar algum texto */
	height: 5em;
	/* Para permitir aos usu�rios redimensionarem qualquer textarea verticalmente. Ele n�o funciona em todos os browsers */
	resize: vertical;
}

.button {
	/* Para posicionar os bot�es para a mesma posi��o dos campos de texto */
	width: 100px;
	display: block;
	align-content: center;
	padding: 10px;
	margin: 0 auto;
	margin-top: 10px;

	/* mesmo tamanho que os elementos do tipo label */
}
</style>

</head>
<body>
	<div>

		<%
			Object msg = request.getAttribute("msg");
			if (msg != null) {

				// usando o Cast para converter o objeto em uma string
				String msgSrt = (String) msg;
				out.print(msg);
			}
		%>

	</div>
	<div>
		<form action="cadastraContatos" method="post">
			<h3>Cadastro de Contatos</h3>
			<label for="nome">Nome:</label><input type="text" name="nome" /><br />
			<label for="nome">E-mail:</label><input type="text" name="email" /><br />
			<label for="nome">Endere�o:</label><input type="text" name="endereco" /><br />
			<label for="nome">Data Nascimento:</label><input type="text"
				name="dataNascimento" /><br />
			<button class="button" type="submit">Gravar</button>
			<button class="button"><a href="listagemContatos.jsp" target="blank">ListaClientes</a> </button>
			<button class="button"><a href="listaJSTL.jsp" target="blank">ListaClientes pelo JSTL</a> </button>
		</form>
	</div>
	
</body>
</html>