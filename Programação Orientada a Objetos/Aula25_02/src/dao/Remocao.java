package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Remocao {
	static final String url = "jdbc:mysql://localhost:3306/escola";
	
	public Remocao() {
		String sql= "DELETE FROM aluno WHERE id=4";
		
		try {
			Connection conexao=DriverManager.getConnection(url,"root","");
			PreparedStatement operacao = conexao.prepareStatement(sql);
			operacao.execute();
			
			System.out.print("Aluno removido com sucesso!");
			conexao.close();
		}
		catch(SQLException e) {
			System.out.print("Erro:"+e.getMessage());
		}
	}
}
