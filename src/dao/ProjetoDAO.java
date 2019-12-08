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
		if (readProjeto(projeto) == 3) {
			throw new Exception(" Usuario proprietário já cadastrado e nome de projeto já cadastrado !!!");
		}else if (readProjeto(projeto) == 2) {
			throw new Exception(" Usuario proprietário já cadastrado escolha outro!!!");
		}else if (readProjeto(projeto) == 3) {
			throw new Exception(" Nome de projeto já cadastrado !!!");
		}
		else if(readProjeto(projeto)== 0) {
		
		String create = "INSERT INTO projeto(nome_projeto, lista_coluna, usuario_proprietario)"
			+ " VALUES (?, ?, ?)";
		
		try(PreparedStatement pst = conexao.prepareStatement(create)) {
				// nome projeto
				if(projeto.getNomeProjeto()== null) {
					throw new Exception("Informe um nome de projeto");
				}
				else{
					pst.setString(1, projeto.getNomeProjeto());
				}
				//lista coluna
				if(projeto.getLista()== null) {
					throw new Exception("Crie uma lista");
				}
				else {
					pst.setString(2, projeto.getLista());
				}
				//  usuario proprietario
				if(projeto.getUsuarioProprietario().getApelido()==null) {
					throw new Exception("Usuário Proprietário não encontrado");
				}
				else {
					pst.setString(3, projeto.getUsuarioProprietario().getApelido());
				}
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

	public void updateProjeto(Projeto projeto) throws Exception {
		String update = "UPDATE projeto SET nome_projeto = ?, lista_coluna = ?, usuario_proprietario = ?  WHERE id_projeto = ?";
		//nome projeto
		try(PreparedStatement pst = conexao.prepareStatement(update)) {
			if(projeto.getNomeProjeto()== null) {
				throw new Exception("Informe um novo nome de projeto");
			}
			String selectProjeto = " nome_projeto FROM projeto WHERE nome_projeto LIKE(?);";
			conexao.prepareStatement(selectProjeto); 
			pst.execute();
			ResultSet resultado = pst.executeQuery();
			
			if(resultado.next()) {
				throw new Exception("Nome de projeto já cadastrado");
			} 
			else {
				pst.setString(1, projeto.getNomeProjeto());
			}
			// lista
			if(projeto.getLista()== null) {
					throw new Exception("Insira uma Lista");
			}else {
				pst.setString(2, projeto.getLista());
			}
			//proprietario
			if(projeto.getUsuarioProprietario().getApelido()==null) {
				throw new Exception("Insira apelido do novo proprietário");
			}else {
				pst.setString(3, projeto.getUsuarioProprietario().getApelido());	
			}
			
			pst.setInt(4, projeto.getIdentificadorProjeto());

			int linhasAfetadas = pst.executeUpdate();
			System.out.println("Rows affected: " + linhasAfetadas);
			if (pst.executeUpdate() == 0) {
				throw new Exception(" NÃ£o existe contato com esse ID. ");
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
		
	public int readProjeto(Projeto projeto) throws Exception {
		String select = " SELECT * FROM projeto WHERE usuario_proprietario = ? or nome_projeto = ?";
        

		PreparedStatement pst = conexao.prepareStatement(select);
		// vai dar conflito se o usuario tiver mais de um projeto como proprietario?	
		pst.setString(1, projeto.getUsuarioProprietario().getApelido());
		pst.setString(2, projeto.getNomeProjeto());
		pst.execute();
		ResultSet resultado = pst.executeQuery();
		String proprietario = resultado.getString("usuario_proprietario");
		String nomeProjeto = resultado.getString("nome_projeto");
		if(proprietario.equals(projeto.getUsuarioProprietario().getApelido()) && nomeProjeto.equals(projeto.getNomeProjeto())) {
			return 3;
		}
		else if(!proprietario.equals(projeto.getUsuarioProprietario().getApelido()) && nomeProjeto.equals(projeto.getNomeProjeto())) {
			return 2;
		}
		else if(proprietario.equals(projeto.getUsuarioProprietario().getApelido()) && !nomeProjeto.equals(projeto.getNomeProjeto())) {
			return 1;
		}else { 
			return 0;
		}
	}
}
//		public boolean readProjeto(Projeto projeto) throws Exception {
//			String select = " SELECT * FROM projeto WHERE usuario_proprietario = ? and nome_projeto = ?";
//            
//
//			PreparedStatement pst = conexao.prepareStatement(select);
//			// vai dar conflito se o usuario tiver mais de um projeto como proprietario?	
//			pst.setString(1, projeto.getUsuarioProprietario().getApelido());
//			pst.setString(2, projeto.getNomeProjeto());
//			pst.execute();
//			ResultSet resultado = pst.executeQuery();
//			String apelido = resultado.getString("usuario_apelido");
//			String email = resultado.getString("email_usuario");
//			if (resultado.next()) {
//				return true;
//			} 
//			
//			return false;
//			
//	}
