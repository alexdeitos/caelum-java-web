package br.com.deitos.testes;

import java.util.Calendar;

import br.com.deitos.dao.ContatoDao;
import br.com.deitos.modelo.Contato;

public class TestaAltera {

	public static void main(String[] args) {
		
		
		ContatoDao dao = new ContatoDao();
		Contato contato = new Contato();
		
		contato.setNome("Alexsandro Deitos");
		contato.setEmail("alexdeitos01@gmail.com");
		contato.setEndereco("Rua Nereu Ramos 2036");
		contato.setDataNascimento(Calendar.getInstance());
		contato.setId((long)2);
		
		dao.alteraContatos(contato);
		
		System.out.println("Alterado com sucesso!");
	}

}
