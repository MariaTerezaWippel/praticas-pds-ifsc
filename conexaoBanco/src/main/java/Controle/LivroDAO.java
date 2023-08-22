package Controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Modelo.Livro;

public class LivroDAO {

	public boolean inserir(Livro p) {
		
		Conexao c = Conexao.getInstancia();
		
		Connection con = c.conectar();
		
		
		String query = "INSERT INTO livro "
				+ "(genero, volume) "
				+ "VALUES (?, ?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, p.getGenero());
			ps.setString(2, p.getVolume());
			
			ps.executeUpdate();
			
			c.fecharConexao();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean excluir(Livro p) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();
		
		String query = "DELETE FROM livro\r\n  WHERE idLivro = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, p.getGenero());
			ps.setString(2, p.getVolume());
			
			c.fecharConexao();
			return true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}
	public boolean atualizar(Livro p) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();
		
		
		String query = "UPDATE livro\r\n   SET" 
				+ "genero = ?\r\n" + "volume = ?,  WHERE idLivro = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, p.getGenero());
			ps.setString(2, p.getVolume());
			
			ps.executeUpdate();
			
			c.fecharConexao();
			return true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			c.fecharConexao();
		}
		return false;
	}

}
