package dao;

import java.sql.*;
import java.util.ArrayList;

import model.Projeto;
import model.Usuario;

public class ProjetoDAO {
	
	private Connection conexao;
	
	
	public ProjetoDAO() {
		this(null);
	}
	
	public ProjetoDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	
	public void createProjeto(Projeto projeto) throws Exception {
		if (readProjeto(projeto) == true) {
			throw new Exception(" Projeto já existente !!!");
		}
		
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
				System.err.println(" NÃ£o existe contato com esse ID. ");
			}

		} catch(SQLException e) {
			System.err.println("Falha no banco : " + e.getMessage());
			e.printStackTrace();
		} catch(Exception e) {
			System.err.println("Falha no java: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void deleteProjeto(Projeto projeto) {
		String delete = " DELETE FROM projeto WHERE id_projeto = ?";
		
		try(PreparedStatement pst = conexao.prepareStatement(delete)) {
			
			pst.setInt(1, projeto.getIdentificadorProjeto());
			
			pst.execute();
		}
		
		catch(SQLException e) {
			System.err.println("Falha no delete do banco: " + e.getMessage());
			e.printStackTrace();
		}
		
		catch(Exception e) {
			System.err.println("Falha no delete no java: " + e.getMessage());
			e.printStackTrace();
		}
	}
		public boolean readProjeto(Projeto projeto) throws Exception {
			String select = " SELECT * FROM projeto WHERE usuario_proprietario = ? and nome_projeto = ?";
            

			PreparedStatement pst = conexao.prepareStatement(select);
				
			pst.setString(1, projeto.getUsuarioProprietario().getApelido());
			pst.setString(2, projeto.getNomeProjeto());
		
			pst.execute();
			ResultSet resultado = pst.executeQuery();
			if (resultado.next()) {
				return true;
			} 
			
			return false;
			
	}
}