package dao;

import java.sql.*;
import model.Projeto;

public class ProjetoDAO {
	
	private Connection conexao;
	
	public ProjetoDAO() {
//		this(null);
	}
	
	public ProjetoDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void createUsuario(Projeto projeto) {
		String create = "INSERT INTO projeto(nome_projeto, lista_coluna, usuario_proprietario)"
				+ " VALUES (?, ?, ?)"; //oq passar nas que são auto i
		
		try(PreparedStatement pst = conexao.prepareStatement(create)) {
			
			pst.setInt(1, projeto.getIdentificadorProjeto());
			pst.setString(2, projeto.getNomeProjeto());
			pst.setString(3, projeto.getLista());
			pst.setObject(4, projeto.getUsuarioProprietario());
		
			pst.execute();
			
		} catch(SQLException e) {
			System.err.println("Falha no banco: " + e.getMessage());
			e.printStackTrace();
		} catch(Exception e) {
			System.err.println("Falha no java: " + e.getMessage());
			e.printStackTrace();
		}
	}
}