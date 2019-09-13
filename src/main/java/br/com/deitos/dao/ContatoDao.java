package br.com.deitos.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.deitos.modelo.Contato;

public class ContatoDao {
	
	// a conexão com o banco de dados
	private Connection conexao ;
	
	public ContatoDao() {
		this.conexao = new ConnectionFactory().getConnection();
	}
	
	
	// adicionando contatos
	public void adicionaContato(Contato contato) {
		
		String sql = "insert into contatos(nome,email,endereco,dataNascimento)values(?,?,?,?)";
		
		try {
			
			//prepara a instrução sql para ser executada pelo java no banco de dados
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			//setando os valores
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			
			//executa
			stmt.execute();
			
			//fecha
			stmt.close();	
			
		} catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}
	
	// listando contatos
	public List<Contato> getLista(){
		try {
			
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.conexao.prepareStatement("select * from contatos");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()){
				
				
				// criando o objeto contato
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				
				// montando a data através do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				
				//SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
				//dataFormat.setCalendar(data);
								
				
				//adicionando o objeto a lista
				contatos.add(contato);
			}
			
			rs.close();
			stmt.close();
			return contatos;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	// alterando contatos
	public void alteraContatos(Contato contato) {
		
		String sql = "update contatos set nome=? , email=? , endereco=? , dataNascimento=? where id=?";
		
		try {
			
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void deletaContato(Contato contato) {
		String sql = "delete from contatos where id=?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setLong(1, contato.getId());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
		
	}
	
	public void limpaTabelacontato() {
		
		String sql = "truncate table contatos";
		String sql1 = " alter table contatos auto_increment=1";
		
		try {
			
			PreparedStatement stmt = conexao.prepareStatement(sql);
			PreparedStatement stmt1 = conexao.prepareStatement(sql1);
			stmt.execute();
			stmt1.execute();
			stmt1.close();
			stmt.close();
			
			System.out.println("truncate realizado na tabela contatos");
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
