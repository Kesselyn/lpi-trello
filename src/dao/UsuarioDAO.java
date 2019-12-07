package dao;

import java.sql.*;

import javax.swing.JOptionPane;

import java.io.*;

import model.Projeto;
import model.Usuario;

public class UsuarioDAO {
	
	private Connection conexao;
	
	public UsuarioDAO() {
		this(null);
	}
	
	public UsuarioDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void createUsuario(Usuario usuario) throws Exception {
		
		if (readUsuario(usuario) == true) {
			throw new Exception(" Usuario já cadastrado !!!");
		}
		String create = "INSERT INTO usuario(apelido_usuario, nome_usuario, email_usuario, senha_usuario, telefone_usuario, foto)"
				+ " VALUES (?, ?, ?, ?, ?, ?)";
		
		// Condições 
		String patternSenha = "(?=.*[0-9])(?=.*[a-z]|[A-Z]).{5,}";
		String patternEmail = "(.*@.*)";
		//---------------------------------
		
		try(PreparedStatement pst = conexao.prepareStatement(create)) {
			
			FileInputStream inputStream = new FileInputStream(usuario.getFoto());
			
					// pega o apelido informado na criação e garante que ele tem pelo menos 5 digtos
			if(usuario.getApelido()== null) {
				throw new Exception(" Defina um apelido !!!");
			}
			else if(usuario.getApelido().length() < 5) { // caso n tenha			
					throw new Exception("O apelido precisa ter pelo menos 5 caracteres");
			}
			else {
					pst.setString(1, usuario.getApelido());// caso tenha	
			}
					// Verifica o nome
			if(usuario.getNomeUsuario()== null) {
					throw new Exception(" Informe seu nome!!!");
			}
			else {
					pst.setString(2, usuario.getNomeUsuario());
			}
					// Verifica o email
			if(usuario.getEmail()== null) {
				throw new Exception(" Informe um email!!!");
			}
			else if(usuario.getEmail().matches(patternEmail)==false) { 					
					throw new Exception(" Email sem @ "+ "\n tente novamente");
			}
			else {
					pst.setString(3, usuario.getEmail()); // caso não de  o erro
				}
					// verifica senha 
			if(usuario.getSenha()== null) {
				throw new Exception(" Informe uma senha!!!");
			}
			else if(usuario.getSenha().matches(patternSenha)== false) { 					
					throw new Exception("Coloque uma senha com números e letras, além de terno mínimo 5 caracteres"+"\n tente novamente");
			}
			else if(usuario.getSenha().indexOf(usuario.getApelido()) != -1) {
					throw new Exception("A senha não pode conter o apelido do usuário"+ "\n tente novamente");
			}
			else {
					pst.setString(4, usuario.getSenha());
			}
					// VERIFICA O TELEFONE
			if(usuario.getTelefone()== null) {
					throw new Exception(" Defina um apelido !!!");
			}
			else{
				pst.setString(5, usuario.getTelefone());
			}		
			
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

	public void updateUsuario(Usuario usuario) {
		String update = "UPDATE usuario SET nome_usuario = ?, email_usuario = ?, senha_usuario=?, telefone_usuario=?, foto=?  WHERE apelido_usuario = ?";
		
		try(PreparedStatement pst = conexao.prepareStatement(update)) {
			
			FileInputStream inputStream = new FileInputStream(usuario.getFoto());
			
			pst.setString(1, usuario.getNomeUsuario());
			pst.setString(2, usuario.getEmail());
			pst.setString(3, usuario.getSenha());
			pst.setString(4, usuario.getTelefone());
			pst.setBinaryStream(5, (InputStream) inputStream, (int) (usuario.getFoto().length()));
			pst.setString(6, usuario.getApelido());

		
			int linhasAfetadas = pst.executeUpdate();
			System.out.println("Done! Rows affected: " + linhasAfetadas);
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

	public void deleteUsuario (Usuario usuario) {
		String delete = "DELETE FROM usuario WHERE apelido_usuario = ?";
		
		try(PreparedStatement pst = conexao.prepareStatement(delete)) {
			
			System.out.print("Aqui:" + usuario.getApelido());

			pst.setString(1, usuario.getApelido());
			
			pst.execute();
			
		} catch(SQLException e) {
			System.err.println("Falha na exclusÃ£o no Banco: " + e.getMessage());
			e.printStackTrace();
		} catch(Exception e) {
			System.err.println("Falha no java: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public boolean readUsuario(Usuario usuario) throws Exception {
		String select = " SELECT * FROM projeto WHERE usuario_apelido = ?";
        
		PreparedStatement pst = conexao.prepareStatement(select);
			
		pst.setString(1, usuario.getApelido());
		pst.execute();
		ResultSet resultado = pst.executeQuery();
		if (resultado.next()) {
			return true;
		} 
		
		return false;
	}
}	
