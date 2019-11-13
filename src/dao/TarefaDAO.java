package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Tarefa;

public class TarefaDAO {
	
	private Connection conexao;
	
	public TarefaDAO() {
		this(null);
	}
	
	public TarefaDAO(Connection conexao) {
		this.conexao = conexao;
	}
	/**/
	public void createTarefa(Tarefa tarefa) {
		String create = "INSERT INTO tarefa(titulo_tarefa, descricao_tarefa, nivel_prioridade, estado_tarefa, ordem_tarefa, fk_usuario, fk_projeto)"
				+ " VALUES (?,?,?,?,?,?,2)";
		
		try(PreparedStatement pst = conexao.prepareStatement(create)) {
			pst.setString(1, tarefa.getTitulo());
			pst.setString(2, tarefa.getDescricao());
			pst.setString(3, tarefa.getNivelPrioridade());
			pst.setString(4, tarefa.getEstado());
			pst.setInt(5, tarefa.getOrdem());
			pst.setString(6, tarefa.getUsuario().getApelido());
//			pst.setInt(7, tarefa.getProjeto().getIdentificadorProjeto());

			pst.execute();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch ( Exception e) {
			e.printStackTrace();
		}
	}
}