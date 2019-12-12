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
		
		if (readUsuario(usuario) == 2) {
			throw new Exception(" Usuario já cadastrado escolha outro apelido");
		}
		
		else if (readUsuario(usuario) == 1) {
			throw new Exception(" Email já cadastrado, use outro");
		}
		
		else if(readUsuario(usuario) == 0) {
			String create = "INSERT INTO usuario(apelido_usuario, nome_usuario, email_usuario, senha_usuario, telefone_usuario, foto)"
				+ " VALUES (?, ?, ?, ?, ?, ?)";
			
			try(PreparedStatement pst = conexao.prepareStatement(create)) {
				
				
				pst.setString(1, usuario.getApelido());
				pst.setString(2, usuario.getNomeUsuario());
				pst.setString(3, usuario.getEmail());
				pst.setString(4, usuario.getSenha());
				pst.setString(5, usuario.getTelefone());		
				
				if (usuario.getFoto() != null) {
					FileInputStream inputStream = new FileInputStream(usuario.getFoto());
					pst.setBinaryStream(6, (InputStream) inputStream, (int) (usuario.getFoto().length()));
				} else {
					pst.setBinaryStream(6, null);
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

	public void updateUsuario(Usuario usuario) throws Exception {
		String update = "UPDATE usuario SET nome_usuario = ?, email_usuario = ?, senha_usuario=?, telefone_usuario=?, foto=?  WHERE apelido_usuario = ?";
		
		try(PreparedStatement pst = conexao.prepareStatement(update)) {
			//nome
			FileInputStream inputStream = new FileInputStream(usuario.getFoto());
			
			if(usuario.getNomeUsuario() == null) {
					throw new Exception(" Informe um novo nome!!!");
			}else {
					pst.setString(1, usuario.getNomeUsuario());
			}
			//email
			if(usuario.getEmail() == null) {
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
				pst.setString(2, usuario.getEmail()); 
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
				throw new Exception("SENHA J� CADASTRADA");
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
	
	// para se cadastrar verifica se o apelido e ou o email ja estão sendo usados por outro usuario
	public int readUsuario(Usuario usuario) throws Exception {
		String select = "SELECT * FROM usuario WHERE apelido_usuario = ? OR email_usuario = ?";
			
		try (PreparedStatement pst = conexao.prepareStatement(select)) {

			pst.setString(1, usuario.getApelido());
			pst.setString(2, usuario.getEmail());
			pst.execute();

			ResultSet resultado = pst.executeQuery();

			while (resultado.next()) {
				String apelido = resultado.getString("apelido_usuario");
				String email = resultado.getString("email_usuario");

				if(apelido.equals(usuario.getApelido())) {
					return 2;
				}
				else if(email.equals(usuario.getEmail())) {
					return 1;
				}
			}
				
		}
        catch (SQLException ex) {
            // Se acontecer alguma exceção imprima a pilha de erros
            ex.printStackTrace();
		}
		
		return 0;
	}

	// para se logar verifica se o apelido do usuario existe no banco
	public String existeUsuario(Usuario usuario) throws Exception {
		String select = " SELECT * FROM usuario WHERE apelido_usuario = ? ";
			
		try (PreparedStatement pst = conexao.prepareStatement(select)) {
			pst.setString(1, usuario.getApelido());
			pst.execute();
	
			ResultSet resultado = pst.executeQuery();
			
			if (resultado.next()) {
				String apelido = resultado.getString("apelido_usuario");
				return apelido;
			}

			return "N";
		}

		catch (SQLException ex) {
            ex.printStackTrace();
		}

		return null;
	}

	// para se logar verica se o apelido do usuario bate com a senha
	public Usuario loginUsuario(Usuario usuario) throws Exception {		
		if (!existeUsuario(usuario).equals(usuario.getApelido())) {
			throw new Exception("Usuario não encontrado");
		} else {
			String select = " SELECT * FROM usuario WHERE senha_usuario = ? AND apelido_usuario = ?";

			try (PreparedStatement pst = conexao.prepareStatement(select)) {
				
				pst.setString(1, usuario.getSenha());
				pst.setString(2, usuario.getApelido());
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
