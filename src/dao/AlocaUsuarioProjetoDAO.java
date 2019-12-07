package dao;

import java.sql.*;
import model.AlocaUsuarioProjeto;
import model.Projeto;
import model.Usuario;
import java.util.ArrayList;
import java.io.*;

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
    
    //A classe é do tipo array de projetos pois é o tipo que quero retornar
    //Ela recebe AlocaProjetoUsuario como parâmetro pq é onde estão os dados que vou utilizar na consulta
    public ArrayList <Projeto> readProjetosUsuario(AlocaUsuarioProjeto alocaUsuarioProjeto) {
		
        String consulta = "SELECT id_projeto, nome_projeto, lista_coluna, usuario_proprietario "
                            + " FROM aloca_usuario_projeto AS A"
                            + " INNER JOIN projeto AS P"
                            + " ON A.fk_projeto = P.id_projeto"
                            + " AND fk_usuario = ?";
        
        try (PreparedStatement pst = conexao.prepareStatement(consulta)) {
            
            pst.setString(1, alocaUsuarioProjeto.getUsuario().getApelido());
            
            //executando a busca
            ResultSet resultado = pst.executeQuery();
            
            //Array que vai guardar os dados que eu quero buscar
            //como quero apenas dados do projeto o array será do tipo projeto
            ArrayList<Projeto> projetos = new ArrayList();
            
            Projeto projeto = null;
            Usuario usuario = null;
            
            //Percorrendo todas as linhas retornadas do banco de dados
            while (resultado.next()) {
                projeto = new Projeto();
                usuario = new Usuario();

                // pegando os valores da linha da vez:
                int idProjeto = resultado.getInt("id_projeto");
                String nomeProjeto = resultado.getString("nome_projeto");
                String colunaProjeto = resultado.getString("lista_coluna");
                String usuarioProprietario = resultado.getString("usuario_proprietario");
                
                //inserindo os dados nos objetos para serem colocados no array depois
                usuario.setApelido(usuarioProprietario);
                
                projeto.setIdentificadorProjeto(idProjeto);
                projeto.setNomeProjeto(nomeProjeto);
                projeto.setLista(colunaProjeto);
                projeto.setUsuarioProprietario(usuario);

                //Adicionando o objeto da vez ArrayList
                projetos.add(projeto);
            }
            
            //retorno do array com os dados
            return projetos;
            
        }
        catch (SQLException ex) {
            // Se acontecer alguma exceção imprima a pilha de erros
            ex.printStackTrace();
        }
        
        // se acontecer algum problema
        return null;
    }

    public ArrayList <Projeto> readProjetosADM(Projeto projeto) {
		
        String consulta = "SELECT * FROM projeto WHERE usuario_proprietario = ?";
        
        try (PreparedStatement pst = conexao.prepareStatement(consulta)) {
            
            pst.setString(1, projeto.getUsuarioProprietario().getApelido());
            
            //executando a busca
            ResultSet resultado = pst.executeQuery();
            
            //Array que vai guardar os dados que eu quero buscar
            //como quero apenas dados do projeto o array será do tipo projeto
            ArrayList<Projeto> projetos = new ArrayList();
            
            Projeto p = null;
            Usuario usuario = null;
            
            //Percorrendo todas as linhas retornadas do banco de dados
            while (resultado.next()) {
                p = new Projeto();
                usuario = new Usuario();

                // pegando os valores da linha da vez:
                int idProjeto = resultado.getInt("id_projeto");
                String nomeProjeto = resultado.getString("nome_projeto");
                String colunaProjeto = resultado.getString("lista_coluna");
                String usuarioProprietario = resultado.getString("usuario_proprietario");
                
                //inserindo os dados nos objetos para serem colocados no array depois
                usuario.setApelido(usuarioProprietario);
                
                p.setIdentificadorProjeto(idProjeto);
                p.setNomeProjeto(nomeProjeto);
                p.setLista(colunaProjeto);
                p.setUsuarioProprietario(usuario);

                //Adicionando o objeto da vez ArrayList
                projetos.add(p);
            }
            
            //retorno do array com os dados
            return projetos;
            
        }
        catch (SQLException ex) {
            // Se acontecer alguma exceção imprima a pilha de erros
            ex.printStackTrace();
        }
        
        // se acontecer algum problema
        return null;
    }

    public ArrayList <Usuario> readUsuarioProjeto(AlocaUsuarioProjeto alocaUsuarioProjeto) {
		
        String consulta = "SELECT apelido_usuario, nome_usuario, email_usuario, senha_usuario, telefone_usuario, foto"
                            + " FROM aloca_usuario_projeto AS A"
                            + " INNER JOIN usuario AS U"
                            + " ON A.fk_usuario = U.apelido_usuario"
                            + " AND fk_projeto = ?";
        
        try (PreparedStatement pst = conexao.prepareStatement(consulta)) {
            
            pst.setInt(1, alocaUsuarioProjeto.getProjeto().getIdentificadorProjeto());
            
            //executando a busca
            ResultSet resultado = pst.executeQuery();
            
            //Array que vai guardar os dados que eu quero buscar
            //como quero apenas dados do projeto o array será do tipo projeto
            ArrayList<Usuario> usuarios = new ArrayList();
            
            Usuario usuario = null;
            
            //Percorrendo todas as linhas retornadas do banco de dados
            while (resultado.next()) {
                usuario = new Usuario();
                
                // pegando os valores da linha da vez:
                String apelidoUsuario = resultado.getString("apelido_usuario");
                String nomeUsuario = resultado.getString("nome_usuario");
                String emailUsuario = resultado.getString("email_usuario");
                String senhaUsuario = resultado.getString("senha_usuario");
                String telefoneUsuario = resultado.getString("telefone_usuario"); 
                InputStream input = resultado.getBinaryStream("foto");
                
                if(telefoneUsuario != null) {
                    usuario.setTelefone(telefoneUsuario);
                }

                if(input != null) {
                    File foto = new File("foto_" + apelidoUsuario + ".jpg");
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
                
                //inserindo os dados nos objetos para serem colocados no array depois
                usuario.setApelido(apelidoUsuario);
                usuario.setNomeUsuario(nomeUsuario);
                usuario.setEmail(emailUsuario);
                usuario.setSenha(senhaUsuario);

                //Adicionando o objeto da vez ArrayList
                usuarios.add(usuario);
            }
            
            resultado.close();

            //retorno do array com os dados
            return usuarios;
            
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

    public ArrayList <Usuario> readUsuarioAusenteProjeto(AlocaUsuarioProjeto alocaUsuarioProjeto) {
		
        String consulta = "SELECT * FROM trello.usuario where apelido_usuario not in (SELECT fk_usuario FROM trello.aloca_usuario_projeto where fk_projeto = ?)";
        
        try (PreparedStatement pst = conexao.prepareStatement(consulta)) {
            
            pst.setInt(1, alocaUsuarioProjeto.getProjeto().getIdentificadorProjeto());
            
            //executando a busca
            ResultSet resultado = pst.executeQuery();
            
            //Array que vai guardar os dados que eu quero buscar
            //como quero apenas dados do projeto o array será do tipo projeto
            ArrayList<Usuario> usuarios = new ArrayList();
            
            Usuario usuario = null;
            
            //Percorrendo todas as linhas retornadas do banco de dados
            while (resultado.next()) {
                usuario = new Usuario();
                
                // pegando os valores da linha da vez:
                String apelidoUsuario = resultado.getString("apelido_usuario");
                String nomeUsuario = resultado.getString("nome_usuario");
                String emailUsuario = resultado.getString("email_usuario");
                String senhaUsuario = resultado.getString("senha_usuario");
                String telefoneUsuario = resultado.getString("telefone_usuario"); 
                InputStream input = resultado.getBinaryStream("foto");

                if(telefoneUsuario != null) {
                    usuario.setTelefone(telefoneUsuario);
                }

                if(input != null) {
                    File foto = new File("foto_" + apelidoUsuario + ".jpg");
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
                
                //inserindo os dados nos objetos para serem colocados no array depois
                usuario.setApelido(apelidoUsuario);
                usuario.setNomeUsuario(nomeUsuario);
                usuario.setEmail(emailUsuario);
                usuario.setSenha(senhaUsuario);

                //Adicionando o objeto da vez ArrayList
                usuarios.add(usuario);
            }
            
            //retorno do array com os dados
            return usuarios;
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