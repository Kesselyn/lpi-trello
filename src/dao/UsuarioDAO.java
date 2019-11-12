package dao;

import java.sql.*;
import java.io.*;
import model.Usuario;

public class UsuarioDAO {
	
	private Connection conexao;
	
	public UsuarioDAO() {
//		this(null);
	}
	
	public UsuarioDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void createUsuario(Usuario usuario) {
		String create = "INSERT INTO usuario(apelido_usuario, nome_usuario, email_usuario, senha_usuario, telefone_usuario, foto)"
				+ " VALUES (?, ?, ?, ?, ?, ?)";
		
		try(PreparedStatement pst = conexao.prepareStatement(create)) {
			
			FileInputStream inputStream = new FileInputStream(usuario.getFoto());
			
			pst.setString(1, usuario.getApelido());
			pst.setString(2, usuario.getNomeUsuario());
			pst.setString(3, usuario.getEmail());
			pst.setString(4, usuario.getSenha());
			pst.setString(5, usuario.getTelefone());
			pst.setBinaryStream(6, (InputStream) inputStream, (int) (usuario.getFoto().length()));
		
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