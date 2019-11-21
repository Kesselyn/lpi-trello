package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
  
import model.Projeto;
import model.Tarefa;
import model.Usuario;

public class TarefaDAO {
	
	private Connection conexao;
	
	public TarefaDAO() {
		this(null);
	}
	
	public TarefaDAO(Connection conexao) {
		this.conexao = conexao;
	}
	 
	public void createTarefa(Tarefa tarefa) {
		String create = "INSERT INTO tarefa(titulo_tarefa, descricao_tarefa, nivel_prioridade, estado_tarefa, ordem_tarefa, fk_usuario, fk_projeto)"
				+ " VALUES (?,?,?,?,?,?,?)";
		
		try(PreparedStatement pst = conexao.prepareStatement(create)) {
			
			pst.setString(1, tarefa.getTitulo());
			pst.setString(2, tarefa.getDescricao());
			pst.setString(3, tarefa.getNivelPrioridade());
			pst.setString(4, tarefa.getEstado());
			pst.setInt(5, tarefa.getOrdem());
			pst.setString(6, tarefa.getUsuario().getApelido());
			pst.setInt(7, tarefa.getProjeto().getIdentificadorProjeto());

			pst.execute();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch ( Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateTarefa(Tarefa tarefa) {
		String update = "UPDATE tarefa SET titulo_tarefa = ?, descricao_tarefa = ?, nivel_prioridade = ?, estado_tarefa = ?, ordem_tarefa = ?, fk_usuario = ?, fk_projeto = ? WHERE id_tarefa = ?";

		try(PreparedStatement pst = conexao.prepareStatement(update)) {
			
			pst.setString(1, tarefa.getTitulo());
			pst.setString(2, tarefa.getDescricao());
			pst.setString(3, tarefa.getNivelPrioridade());
			pst.setString(4, tarefa.getEstado());
			pst.setInt(5, tarefa.getOrdem());
			pst.setString(6, tarefa.getUsuario().getApelido());
			pst.setInt(7, tarefa.getProjeto().getIdentificadorProjeto());
			pst.setInt(8, tarefa.getidentificadorTarefa());
			
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

	public void deleteTarefa(Tarefa tarefa) {
		String delete = " DELETE FROM tarefa WHERE id_tarefa = ?";
		
		try(PreparedStatement pst = conexao.prepareStatement(delete)) {
			
			pst.setInt(1, tarefa.getidentificadorTarefa());
			
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
	public ArrayList <Tarefa> readTarefa(Projeto projeto) {
		String consulta = "Select * from tarefa where fk_projeto= ?";
		Tarefa tarefa = null;
		try(PreparedStatement pst = conexao.prepareStatement(consulta)){
			
			pst.setInt(1, tarefa.getProjeto().getIdentificadorProjeto());
			
			ResultSet resultado = pst.executeQuery();
			
			ArrayList<Tarefa> tarefas = new ArrayList();
			
			Usuario usuario = null;
			projeto = null;
			while(resultado.next()) {
				tarefa = new Tarefa();	
				usuario = new Usuario();
				projeto = new Projeto();
			
				String titulo = resultado.getString("titulo_tarefa");
				String descricao = resultado.getString("descricao_tarefa");
				String nivelPrioridade = resultado.getString("nivel_prioridade");
				String estado = resultado.getString("estado_tarefa");
				int ordem = resultado.getInt("ordem_tarefa");
				String apelidoUsuario = resultado.getString("fk_usuario");
				int idProjeto = resultado.getInt("fk_projeto");
				
				usuario.setApelido(apelidoUsuario);
				projeto.setIdentificadorProjeto(idProjeto);
				
				tarefa.setTitulo(titulo);
				tarefa.setDescricao(descricao);
				tarefa.setNivelPrioridade(nivelPrioridade);
				tarefa.setEstado(estado);
				tarefa.setOrdem(ordem);
				tarefa.setUsuario(usuario);
				tarefa.setProjeto(projeto);
				
				tarefas.add(tarefa);
			}
			return tarefas;
		}
		catch (SQLException ex) {
            // Se acontecer alguma exceção imprima a pilha de erros
            ex.printStackTrace();
        }
        
        // se acontecer algum problema
        return null;
		
		 
 		
		
	}
}
	
