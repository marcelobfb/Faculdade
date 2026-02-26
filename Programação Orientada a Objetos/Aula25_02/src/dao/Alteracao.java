package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Alteracao {
	static final String url = "jdbc:mysql://localhost:3306/escola";
	
	public Alteracao() {
		//String sql= "UPDATE aluno SET nome = 'George' WHERE id=4";
		String sql= "UPDATE aluno SET id=id -1 WHERE id>3";
		
		try {
			Connection conexao=DriverManager.getConnection(url,"root","");
			PreparedStatement operacao = conexao.prepareStatement(sql);
			operacao.execute();
			
			System.out.print("Aluno alterado com sucesso!");
			conexao.close();
		}
		catch(SQLException e) {
			System.out.print("Erro:"+e.getMessage());
		}
	}
}
