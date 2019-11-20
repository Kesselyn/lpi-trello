package dao;

import java.sql.*;
import model.AlocaUsuarioProjeto;

public class AlocaUsuarioProjetoDAO {
    private Connection conexao;

    public AlocaUsuarioProjetoDAO() {
        this(null);
    }

    public AlocaUsuarioProjetoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void createAlocaUsuarioProjeto(AlocaUsuarioProjeto aloca) {
		String create = "INSERT INTO aloca_usuario_projeto(fk_usuario, fk_projeto)"
				+ " 	VALUES (?, ?)";
		 
		try(PreparedStatement pst = conexao.prepareStatement(create)) {
			
			pst.setString(1, aloca.getUsuario().getApelido());
			pst.setInt(2, aloca.getProjeto().getIdentificadorProjeto());
			
			pst.execute();
		}
		
		catch(SQLException e) {
			System.err.println("Falha no banco: " + e.getMessage());
			e.printStackTrace();
		}
		catch ( Exception e) {
			System.err.println("Falha no java: " + e.getMessage());
			e.printStackTrace();
		}
    }
    
    public void deleteAlocaUsuarioProjeto(AlocaUsuarioProjeto aloca) {
		String delete = "DELETE FROM aloca_usuario_projeto WHERE id_aloca_usuario_projeto = ?";
		
		try(PreparedStatement pst = conexao.prepareStatement(delete)) {
			
			pst.setInt(1, aloca.getIdenficiadorAlocaUsuarioProjeto());
			
			pst.execute();
		}
			
		catch(SQLException e) {
			System.err.println("Falha delete mensagem no banco: " + e.getMessage());
			e.printStackTrace();
		}
		
		catch(Exception e) {
			System.err.println("Falha delete mensagem no java: " + e.getMessage());
			e.printStackTrace();
		}
	}
}