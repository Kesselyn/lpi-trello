package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Mensagem;

public class MensagemDAO {
	
	private Connection conexao;
	
	public MensagemDAO() {
		this(null);
	}
	
	public MensagemDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void createMensagem(Mensagem mensagem) {
		String create = "INSERT INTO mensagem(texto_mensagem, "
				+ "		estado_mensagem, data_hora_envio, data_hora_visualizacao, remetente, destinatario )"
				+ " 	VALUES (?, ?, ?, ?, ?,?)";
		 
		try(PreparedStatement pst = conexao.prepareStatement(create)) {
			Date dataHoraEnvio = new Date(mensagem.getDataHoraEnvio().getTimeInMillis());
			Date dataHoraVisualizacao = new Date(mensagem.getDataHoraVisualizacao().getTimeInMillis());
			pst.setString(1, mensagem.getTexto());
			pst.setString(2, mensagem.getEstado());
			pst.setDate(3, dataHoraEnvio);
			pst.setDate(4, dataHoraVisualizacao);
			pst.setObject(5, mensagem.getRemetente());
			pst.setObject(6, mensagem.getDestinatario());
			
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
}