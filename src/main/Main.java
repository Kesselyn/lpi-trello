package main;

import java.io.File;
import java.util.ArrayList;

import dao.Conexao;
import dao.MensagemDAO;
import dao.ProjetoDAO;
import dao.TarefaDAO;
import dao.UsuarioDAO;
import model.Mensagem;
import model.Projeto;
import model.Tarefa;
import model.Usuario;

public class Main {
	public static void main(String[] args) {
		Conexao.conectar();
		//Listas
		ArrayList <Tarefa> listaTarefa = new ArrayList<>();
		ArrayList <Usuario> listaUsuario = new ArrayList<>();
		ArrayList <Projeto> listaProjeto = new ArrayList<>();
		ArrayList <Mensagem> listaMensagem = new ArrayList<>();
		Mensagem m = null;
		
		Usuario u = new Usuario("gfhft", "kesselyn", "th@grtghegailff.br", "1234", "4002-8922", new File("rato.jpg"), listaMensagem, listaProjeto, listaTarefa);
		Usuario u2 = new Usuario("rffht", "juvens", "tu@hhgrthetmaffil.com.br", "1234", "5555-5555", new File("rato.jpg"), listaMensagem, listaProjeto, listaTarefa);

		Projeto p = new Projeto(0,"Times do Brasil", "Em andamento",listaUsuario,u, listaTarefa);
//		listaProjeto.add(0,p);
		
		Tarefa t = new Tarefa(0, u, p, "Times de S�o Paulo", "Nomes de times localizados em s�o paulo",1, "A fazer", "Alto" );
//		listaTarefa.add(0,t);
		
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
		
		try {
			ProjetoDAO teste = new ProjetoDAO(Conexao.conectar());
			teste.createProjeto(p);
		} catch(Exception e) {
			System.err.println("Não inseriu na model: " + e.getMessage());
			e.printStackTrace();
		}
		
		try {
			TarefaDAO teste = new TarefaDAO(Conexao.conectar());
			teste.createTarefa(t);
		} catch(Exception e) {
			System.err.println("Não inseriu na model: " + e.getMessage());
			e.printStackTrace();
		}
		
	}
}
