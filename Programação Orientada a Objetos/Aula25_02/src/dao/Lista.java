package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Lista {
	static final String url = "jdbc:mysql://localhost:3306/escola";
	
	public Lista() {
		String sql= "SELECT * FROM aluno";
		
		try {
			Connection conexao=DriverManager.getConnection(url,"root","");
			PreparedStatement operacao = conexao.prepareStatement(sql);
			ResultSet resultado = operacao.executeQuery();
			
			resultado.first();
			System.out.print(resultado.getObject(1)+"|"+resultado.getObject(2)+"|"+resultado.getObject(3));
			conexao.close();
		}
		catch(SQLException e) {
			System.out.print("Erro:"+e.getMessage());
		}
	}
}
