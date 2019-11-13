package dao;

import java.sql.*;

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
				+ " 	VALUES (?, ?, now(), null, ?,?)";
		 
		try(PreparedStatement pst = conexao.prepareStatement(create)) {
			
			pst.setString(1, mensagem.getTexto());
			pst.setString(2, mensagem.getEstado());
			pst.setString(3, mensagem.getRemetente().getApelido());
			pst.setString(4, mensagem.getDestinatario().getApelido());
			
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