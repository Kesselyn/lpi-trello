package main;

import java.io.File;

import dao.Conexao;
import dao.MensagemDAO;
import dao.UsuarioDAO;
import model.Mensagem;
import model.Usuario;

public class Main {
	public static void main(String[] args) {
		Conexao.conectar();
		Usuario u = new Usuario("kss6", "kesselyn", "kselyn@gail.br", "1234", "4002-8922", new File("rato.jpg"), null, null, null);
		Usuario u2 = new Usuario("ess9", "kesselyn", "eselyn@htmail.com.br", "1234", "4002-8922", new File("rato.jpg"), null, null, null);
		
		//inserção do usuario certissima
		try {
			UsuarioDAO teste = new UsuarioDAO(Conexao.conectar());
			teste.createUsuario(u2);
			teste.createUsuario(u);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			MensagemDAO teste = new MensagemDAO(Conexao.conectar());
			teste.createMensagem(new Mensagem(u, u2, "oi", "enviada", null, null));
		} catch(Exception e) {
			System.err.println("Não inseriu na model: " + e.getMessage());
			e.printStackTrace();
		}
		
	}
}
