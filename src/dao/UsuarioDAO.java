package dao;

import java.sql.*;
import java.io.*;

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
		
		// Condi��es 
		String patternSenha = "(?=.*[0-9])(?=.*[a-z]|[A-Z]).{5,}";
		String patternEmail = "(.*@.*)";
		//---------------------------------
		
		try(PreparedStatement pst = conexao.prepareStatement(create)) {
			
			FileInputStream inputStream = new FileInputStream(usuario.getFoto());
			
					// pega o apelido informado na cria��o e garante que ele tem pelo menos 5 digtos
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
					pst.setString(3, usuario.getEmail()); // caso n�o de  o erro
				}
					// verifica senha 
			if(usuario.getSenha()== null) {
				throw new Exception(" Informe uma senha!!!");
			}
			else if(usuario.getSenha().matches(patternSenha)== false) { 					
					throw new Exception("Coloque uma senha com n�meros e letras, al�m de terno m�nimo 5 caracteres"+"\n tente novamente");
			}
			else if(usuario.getSenha().indexOf(usuario.getApelido()) != -1) {
					throw new Exception("A senha n�o pode conter o apelido do usu�rio"+ "\n tente novamente");
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

	public void deleteUsuario (Usuario usuario) {
		String delete = "DELETE FROM usuario WHERE apelido_usuario = ?";
		
		try(PreparedStatement pst = conexao.prepareStatement(delete)) {
			
			System.out.print("Aqui:" + usuario.getApelido());

			pst.setString(1, usuario.getApelido());
			
			pst.execute();
			
		} catch(SQLException e) {
			System.err.println("Falha na exclusão no Banco: " + e.getMessage());
			e.printStackTrace();
		} catch(Exception e) {
			System.err.println("Falha no java: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public boolean readUsuario(Usuario usuario) throws Exception {
		String select = " SELECT * FROM usuario WHERE apelido_usuario = ?";
        
		PreparedStatement pst = conexao.prepareStatement(select);
			
		pst.setString(1, usuario.getApelido());
		pst.execute();
		ResultSet resultado = pst.executeQuery();
		if (resultado.next()) {
			return true;
		} 
		
		return false;
	}

	public Usuario loginUsuario(Usuario usuario) throws Exception {
		
		if (readUsuario(usuario) == false) {
			throw new Exception(" Usuario não encontrado");
		} else {
			String select = " SELECT * FROM usuario WHERE senha_usuario = ?";

			try (PreparedStatement pst = conexao.prepareStatement(select)) {
				
				pst.setString(1, usuario.getSenha());
				pst.execute();

				ResultSet resultado = pst.executeQuery();
				Usuario logUsuario = null;

				if (resultado.next()) {
					logUsuario = new Usuario();

					String apelido = resultado.getString("apelido_usuario");
					String nome = resultado.getString("nome_usuario");
					String email = resultado.getString("email_usuario");
					String senha = resultado.getString("senha_usuario");
					String telefone = resultado.getString("telefone_usuario");
					InputStream input = resultado.getBinaryStream("foto");

					if(telefone != null) {
						logUsuario.setTelefone(telefone);
					}
					
					if(input != null) {
						File foto = new File("foto_" + apelido + ".jpg");
						FileOutputStream output = new FileOutputStream(foto);
						
						byte[] buffer = new byte[1024];
						// Enquanto existir conteúdo no fluxo de dados, continua:
						while (input.read(buffer) > 0) {
							// Escreve o conteúdo no arquivo de destino no disco:
							output.write(buffer);
						}
		
						// Fechando a entrada:
						input.close();
		
						// Encerra a saída:
						output.close();

						usuario.setFoto(foto);
					}
					
					logUsuario.setApelido(apelido);
					logUsuario.setNomeUsuario(nome);
					logUsuario.setEmail(email);
					logUsuario.setSenha(senha);

					return logUsuario;

				} else {
					throw new Exception("Senha errada");
				}
			}

			catch(FileNotFoundException f) {
				f.printStackTrace();
			}

			catch(IOException io) {
				io.printStackTrace();
			}

			catch (SQLException ex) {
				// Se acontecer alguma exceção imprima a pilha de erros
				ex.printStackTrace();
			}
			
			// se acontecer algum problema
			return null;
		}
	}
}	
