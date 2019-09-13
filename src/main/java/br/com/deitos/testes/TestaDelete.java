package br.com.deitos.testes;

import br.com.deitos.dao.ContatoDao;
import br.com.deitos.modelo.Contato;

public class TestaDelete {

	public static void main(String[] args) {

		Contato contato = new Contato();
		ContatoDao dao = new ContatoDao();

		//contato.setId((long) 2);
		//dao.deletaContato(contato);
		dao.limpaTabelacontato();

		System.out.println("Contato removido com sucesso!");
	}

}
