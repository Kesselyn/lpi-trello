package dao;

import java.sql.*;
import model.AlocaUsuarioProjeto;
import model.Projeto;
import model.Usuario;
import java.util.ArrayList;

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
    
 
    //A classe È do tipo array de projetos pois È o tipo que quero retornar
    //Ela recebe AlocaProjetoUsuario como par‚metro pq È onde est„o os dados que vou utilizar na consulta
 
    //A classe √© do tipo array de projetos pois √© o tipo que quero retornar
    //Ela recebe AlocaProjetoUsuario como par√¢metro pq √© onde est√£o os dados que vou utilizar na consulta

    public ArrayList <Projeto> readProjetosUsuario(AlocaUsuarioProjeto alocaUsuarioProjeto) {
		
        String consulta = "SELECT id_projeto, nome_projeto, lista_coluna, usuario_proprietario "
                            + " FROM aloca_usuario_projeto AS A"
                            + " INNER JOIN Projeto AS P"
                            + " ON A.fk_projeto = P.id_projeto"
                            + " AND fk_usuario = ?";
        
        try (PreparedStatement pst = conexao.prepareStatement(consulta)) {
            
            pst.setString(1, alocaUsuarioProjeto.getUsuario().getApelido());
            
            //executando a busca
            ResultSet resultado = pst.executeQuery();
            
            //Array que vai guardar os dados que eu quero buscar

            //como quero apenas dados do projeto o array ser· do tipo projeto

            //como quero apenas dados do projeto o array ser√° do tipo projeto

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

            // Se acontecer alguma exceÁ„o imprima a pilha de erros

            // Se acontecer alguma exce√ß√£o imprima a pilha de erros

            ex.printStackTrace();
        }
        
        // se acontecer algum problema
        return null;
    }
}