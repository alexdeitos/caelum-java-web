package br.com.deitos.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.deitos.dao.ContatoDao;
import br.com.deitos.modelo.Contato;

@WebServlet(urlPatterns = { "/cadastraContatos" })
public class cadastraContatos extends HttpServlet {

	ContatoDao dao = new ContatoDao();

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		log("Iniciando	a	servlet");
	}

	public void destroy() {
		super.destroy();
		log("Destruindo	a	servlet");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		System.out.println("Chamou pelo método GET!");

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("cadastraContato.jsp");
		req.setAttribute("listaContatos", dao.getLista());
		requestDispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		// recupera dados digitados pelo usuário no arquivo JSP (pega os parametros)
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String endereco = req.getParameter("endereco");
		String dataNascimento = req.getParameter("dataNascimento");

		// Tratamento de dada com calendar e formatando com SimpleDateFormat
		Calendar cal = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			cal = Calendar.getInstance();
			Date dataFormatada = sdf.parse(dataNascimento);
			cal.setTime(dataFormatada);
		} catch (ParseException e) {

			System.out.println("erro com a data de nascimento!");
		}

		// monta um objeto Contato
		Contato contato = new Contato();

		// preenche os dados do objeto Contato
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(cal);

		// adiciona no banco de dados
		dao.adicionaContato(contato);

		System.out.println("Cadastrado");
		System.out.println("Chamou pelo método POST");

		// redicionamento pelo servidor
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("cadastraContato.jsp");
		req.setAttribute("msg", "Cadastrado com sucesso!");
		req.setAttribute("listaContatos", dao.getLista());
		requestDispatcher.forward(req, resp);

	}

}
