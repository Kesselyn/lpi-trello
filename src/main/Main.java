package main;

import java.io.File;
import java.util.GregorianCalendar;

import dao.Conexao;
import dao.MensagemDAO;
import dao.UsuarioDAO;
import model.Mensagem;
import model.Usuario;

public class Main {
	public static void main(String[] args) {
		Conexao.conectar();
		Usuario u = new Usuario("kess4", "kesselyn", "keselyn@gmail.br", "1234", "4002-8922", new File("rato.jpg"));
		Usuario u2 = new Usuario("kess5", "kesselyn", "keselyn@hotmail.com.br", "1234", "4002-8922", new File("rato.jpg"));
		
		//inserção do usuario certissima
		try {
			UsuarioDAO teste = new UsuarioDAO(Conexao.conectar());
			teste.createUsuario(u);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			MensagemDAO teste = new MensagemDAO(Conexao.conectar());
			teste.createMensagem(new Mensagem(u, u2, "oi", "enviada", new GregorianCalendar(), new GregorianCalendar()));
		} catch(Exception e) {
			System.err.println("Não inseriu na model: " + e.getMessage());
			e.printStackTrace();
		}
		
	}
}
