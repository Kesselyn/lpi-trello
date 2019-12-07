package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import model.Usuario;
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

	public void deleteMensagem(Mensagem mensagem) {
		String delete = "DELETE FROM mensagem WHERE id_mensagem = ?";
		
		try(PreparedStatement pst = conexao.prepareStatement(delete)) {
			
			pst.setInt(1, mensagem.getIdentificadorMensagem());
			
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

	public ArrayList<Mensagem> readMensagemUsuario(Usuario usuario) {
		String consulta = "SELECT *"
							+ " FROM mensagem AS M"
							+ " WHERE M.remetente = ?"
							+ " OR M.destinatario = ?";

		try(PreparedStatement pst = conexao.prepareStatement(consulta)){
			pst.setString(1, usuario.getApelido());
			pst.setString(2, usuario.getApelido());

			ResultSet resultado = pst.executeQuery();

			ArrayList<Mensagem> mensagens = new ArrayList<>();

			Mensagem mensagem = null;
			Usuario remetenteUsuario = null;
			Usuario destinatarioUsuario = null;

			while(resultado.next()) {
				mensagem = new Mensagem();
				remetenteUsuario = new Usuario();
				destinatarioUsuario = new Usuario();

				GregorianCalendar envio = new GregorianCalendar();
				GregorianCalendar ver = new GregorianCalendar();

				int idMensagem = resultado.getInt("id_mensagem");
				String texto = resultado.getString("texto_mensagem");
				String estado = resultado.getString("estado_mensagem");
				envio.setTime(new java.util.Date(resultado.getDate("data_hora_envio").getTime()));
				if(resultado.getDate("data_hora_visualizacao") != null) {
					ver.setTime(new java.util.Date(resultado.getDate("data_hora_visualizacao").getTime()));
					mensagem.setDataHoraVisualizacao(ver);
				}
				String remetente = resultado.getString("remetente");
				String destinatario = resultado.getString("destinatario");

				remetenteUsuario.setApelido(remetente);
				destinatarioUsuario.setApelido(destinatario);

				mensagem.setIdentificadorMensagem(idMensagem);
				mensagem.setTexto(texto);
				mensagem.setEstado(estado);
				mensagem.setDataHoraEnvio(envio);
				mensagem.setRemetente(remetenteUsuario);
				mensagem.setDestinatario(destinatarioUsuario);

				mensagens.add(mensagem);
			}
			return mensagens;
		}
		catch (SQLException ex) {
            // Se acontecer alguma exceção imprima a pilha de erros
            ex.printStackTrace();
        }
        
        // se acontecer algum problema
        return null;
	}
}