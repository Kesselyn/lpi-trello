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
		// 0 tudo certo,1 email =,2 apelido =,3 os dois =
		if (readUsuario(usuario) == 3) {
			throw new Exception(" Usuario já cadastrado e email já cadastrado !!!");
		}else if (readUsuario(usuario) == 2) {
			throw new Exception(" Usuario já cadastrado escolha outro apelido !!!");
		}else if (readUsuario(usuario) == 3) {
			throw new Exception(" Email já cadastrado !!!");
		}
		else if(readUsuario(usuario)== 0) {
			String create = "INSERT INTO usuario(apelido_usuario, nome_usuario, email_usuario, senha_usuario, telefone_usuario, foto)"
				+ " VALUES (?, ?, ?, ?, ?, ?)";
		
		try(PreparedStatement pst = conexao.prepareStatement(create)) {
			
			FileInputStream inputStream = new FileInputStream(usuario.getFoto());
			
			// pega o apelido informado na criação 
			if(usuario.getApelido()== null) {
				throw new Exception(" Defina um apelido !!!");
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
			
				String selectEmail = " email_usuario FROM usuario WHERE email_usuario LIKE(?);";
				conexao.prepareStatement(selectEmail); 
				pst.setString(1, usuario.getEmail());
				pst.execute();
				ResultSet resultado = pst.executeQuery();
				
			if (resultado.next()) {
				throw new Exception("Email já cadastrado");
			} 
			else {
				pst.setString(3, usuario.getEmail()); // caso não de  o erro
			}
			// verifica senha 
			if(usuario.getSenha()== null) {
				throw new Exception(" Informe uma senha!!!");
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
	}

	public void updateUsuario(Usuario usuario) throws Exception {
		String update = "UPDATE usuario SET nome_usuario = ?, email_usuario = ?, senha_usuario=?, telefone_usuario=?, foto=?  WHERE apelido_usuario = ?";
		
		try(PreparedStatement pst = conexao.prepareStatement(update)) {
			//nome
			FileInputStream inputStream = new FileInputStream(usuario.getFoto());
			
			if(usuario.getNomeUsuario()== null) {
					throw new Exception(" Informe um novo nome!!!");
			}else {
					pst.setString(1, usuario.getNomeUsuario());
			}
			//email
			if(usuario.getEmail()== null) {
				throw new Exception(" Informe um email!!!");
			}
					String selectEmail = " email_usuario FROM usuario WHERE email_usuario LIKE(?);";
					conexao.prepareStatement(selectEmail); 
					pst.setString(1, usuario.getEmail());
					pst.execute();
					ResultSet resultado = pst.executeQuery();
					
			if(resultado.next()) {
				throw new Exception("Email já cadastrado");
			} 
			else {
				pst.setString(2, usuario.getEmail()); // caso não de  o erro
			}
			// senha
			if(usuario.getTelefone()== null) {
				throw new Exception(" Informe um nova senha!!!");
			}
				String selectSenha = " senha_usuario FROM usuario WHERE senha_usuario LIKE(?);";
				conexao.prepareStatement(selectSenha); 
				pst.setString(1, usuario.getSenha());
				pst.execute();
				ResultSet resultadoSenha = pst.executeQuery();
				
			if(resultadoSenha.next()) {
				throw new Exception("SENHA JÁ CADASTRADA");
			} 
			else {
				pst.setString(3, usuario.getSenha());
			}
			// telefone
			if(usuario.getTelefone()== null) {
				throw new Exception(" Informe um novo telefone!!!");
			}
			else {
				pst.setString(4, usuario.getTelefone());
			}
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
	
	public int readUsuario(Usuario usuario) throws Exception {
		String select = " SELECT * FROM usuario WHERE usuario_apelido = ? or email_usuario = ?";
			
		PreparedStatement pst = conexao.prepareStatement(select);
			
			pst.setString(1, usuario.getApelido());
			pst.setString(2, usuario.getEmail());
			pst.execute();
			ResultSet resultado = pst.executeQuery();
			String apelido = resultado.getString("usuario_apelido");
			String email = resultado.getString("email_usuario");
			
		if(apelido.equals(usuario.getApelido()) && email.equals(usuario.getEmail())) {
			return 3;
		}
		else if(apelido.equals(usuario.getApelido()) && !email.equals(usuario.getEmail())) {
			return 2;
		}
		else if(!apelido.equals(usuario.getApelido()) && email.equals(usuario.getEmail())) {
			return 1;
		}else { 
			return 0;
		}
	}
}	
