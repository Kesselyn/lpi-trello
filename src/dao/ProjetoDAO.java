package dao;

import java.sql.*;
import model.Projeto;

public class ProjetoDAO {
	
	private Connection conexao;
	
	public ProjetoDAO() {
		this(null);
	}
	
	public ProjetoDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void createProjeto(Projeto projeto) {
		String create = "INSERT INTO projeto(nome_projeto, lista_coluna, usuario_proprietario)"
			+ " VALUES (?, ?, ?)";
		
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

	public void updateProjeto(Projeto projeto) {
		String update = "UPDATE projeto SET nome_projeto = ?, lista_coluna = ?, usuario_proprietario = ?  WHERE id_projeto = ?";

		try(PreparedStatement pst = conexao.prepareStatement(update)) {
			
			pst.setString(1, projeto.getNomeProjeto());
			pst.setString(2, projeto.getLista());
			pst.setString(3, projeto.getUsuarioProprietario().getApelido());
			pst.setInt(4, projeto.getIdentificadorProjeto());

			int linhasAfetadas = pst.executeUpdate();
			System.out.println("Done Kesselyn! Rows affected: " + linhasAfetadas);
			if (pst.executeUpdate() == 0) {
				System.err.println(" Não existe contato com esse ID. ");
			}

		} catch(SQLException e) {
			System.err.println("Falha no banco : " + e.getMessage());
			e.printStackTrace();
		} catch(Exception e) {
			System.err.println("Falha no java: " + e.getMessage());
			e.printStackTrace();
		}
	}
}