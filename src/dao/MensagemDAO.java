package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.TimeZone;

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
				+ " 	VALUES (?, 'lida', now(), null, ?,?)";
		 
		try(PreparedStatement pst = conexao.prepareStatement(create)) {
			
			pst.setString(1, mensagem.getTexto());
			pst.setString(2, mensagem.getRemetente().getApelido());
			pst.setString(3, mensagem.getDestinatario().getApelido());
			
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

	public ArrayList<Mensagem> readMensagemUsuario(Usuario usuario, Usuario destinatario) {
		String consulta = "SELECT * FROM mensagem AS M WHERE M.remetente = ? AND M.destinatario = ? OR M.remetente = ? AND M.destinatario = ?";

		try(PreparedStatement pst = conexao.prepareStatement(consulta)) {
			pst.setString(1, usuario.getApelido());
			pst.setString(2, destinatario.getApelido());
                        pst.setString(3, destinatario.getApelido());
			pst.setString(4, usuario.getApelido());
                        
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
                                envio.setTime(new java.util.Date(resultado.getTimestamp("data_hora_envio").getTime()));
				if(resultado.getTimestamp("data_hora_visualizacao") != null) {
					ver.setTime(new java.util.Date(resultado.getTimestamp("data_hora_visualizacao").getTime()));
					mensagem.setDataHoraVisualizacao(ver);
				}
                                String remetente = resultado.getString("remetente");
				String recebedor = resultado.getString("destinatario");
				remetenteUsuario.setApelido(remetente);
				destinatarioUsuario.setApelido(recebedor);
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

	public void alteraEstadoMensagem(int idMensagem) {
		String update = "UPDATE mensagem SET estado_mensagem = 'lida', data_hora_visualizacao = WHERE id_mensagem = ?";

		try(PreparedStatement pst = conexao.prepareStatement(update)) {
			pst.setInt(1, idMensagem);

			int linhasAfetadas = pst.executeUpdate();
			System.out.println("Done Kesselyn! Rows affected: " + linhasAfetadas);
			
			if (pst.executeUpdate() == 0) {
				System.err.println(" Não existe contato com esse ID. ");
			}
		}

		catch(SQLException e) {
			System.err.println("Falha no banco : " + e.getMessage());
			e.printStackTrace();
		}

		catch(Exception e) {
			e.printStackTrace();
		}
	}

    private TimeZone TimeZone(String gmT300) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}