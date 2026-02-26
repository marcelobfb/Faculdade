package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Inclusao2 {
	static final String url = "jdbc:mysql://localhost:3306/escola";
	
	public Inclusao2() {
		String sql= "INSERT INTO aluno(cpf,nome)VALUES('98745632115','Fernanda'),"+"('45678912398','Maria'),"+"('12398745698','Jorge')";
		
		try {
			Connection conexao=DriverManager.getConnection(url,"root","");
			PreparedStatement operacao = conexao.prepareStatement(sql);
			operacao.execute();
			
			System.out.print("Alunos incluidos com sucesso!");
			conexao.close();
		}
		catch(SQLException e) {
			System.out.print("Erro:"+e.getMessage());
		}
	}
}
