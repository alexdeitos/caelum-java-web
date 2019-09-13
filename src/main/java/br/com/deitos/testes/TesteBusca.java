package br.com.deitos.testes;

import java.text.SimpleDateFormat;
import java.util.List;

import br.com.deitos.dao.ContatoDao;
import br.com.deitos.modelo.Contato;

public class TesteBusca {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ContatoDao busca = new ContatoDao();
		List<Contato> contatos = busca.getLista();

		for (Contato contato : contatos) {
			System.out.println("nome: " + contato.getNome());
			System.out.println("email: " + contato.getEmail());
			System.out.println("endereco: " + contato.getEndereco());

			//Formatando a data
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String data = sdf.format(contato.getDataNascimento().getTime());
			System.out.println("Data de Nascimento: " + data);
			
			

		}

	}

}
