package br.com.deitos.testes;

import java.util.Calendar;

import br.com.deitos.dao.ContatoDao;
import br.com.deitos.modelo.Contato;

public class TesteInsere {

	public static void main(String[] args) {

		Contato contato = new Contato();

		contato.setId((long) 1);
		contato.setNome("Alexsandro De Oliveira Deitos");
		contato.setEmail("alexdeitos01@gmail.com");
		contato.setEndereco("Rua Barao do Cerro Azul, 1152");
		contato.setDataNascimento(Calendar.getInstance());

		ContatoDao dao = new ContatoDao();

		dao.adicionaContato(contato);
		System.out.println("Contato adicionado com sucesso!");

	}

}
