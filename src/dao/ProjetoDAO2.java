package dao;

import java.sql.*;
import model.Projeto;

public class ProjetoDAO2 {
	
	private Connection conexao;
	
	public ProjetoDAO2() {
//		this(null);
	}
	
	public ProjetoDAO2(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void createProjeto(Projeto projeto) {
		String create = "INSERT INTO projeto( nome_projeto, lista_coluna, usuario_proprietario)"
				+ " VALUES (?, ?, ?)"; //oq passar nas que são auto i
		
		try(PreparedStatement pst = conexao.prepareStatement(create)) {
			
			
			pst.setString(1, projeto.getNomeProjeto());
			pst.setString(2, projeto.getLista());
			pst.setString(3, projeto.getUsuarioProprietario().getApelido());
		
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