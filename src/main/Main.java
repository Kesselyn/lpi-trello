package main;

import java.io.File;
// import java.util.ArrayList;

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
		// ArrayList <Tarefa> listaTarefa = new ArrayList<>();
		// ArrayList <Usuario> listaUsuario = new ArrayList<>();
		// ArrayList <Projeto> listaProjeto = new ArrayList<>();
		// ArrayList <Mensagem> listaMensagem = new ArrayList<>();
		
		// Criando dois usuarios para poder usar como remetente e destinatário depois na tabela de mensagem
		Usuario u = new Usuario("agffhagfrwft", "kegsselyn", "afggrth@fgrtghegailff.br", "1234", "4002-8922", new File("rato.jpg"), null, null, null);
		Usuario u2 = new Usuario("arffgssh5t", "jugvens", "atu@hfgrhgrthetmaffil.com.br", "1234", "5555-5555", new File("rato.jpg"), null, null, null);

		// Criando uma mensaem
		Mensagem m = new Mensagem(u, u2, "oi2", "enviada", null, null);

		// Criando um projeto, o id passado não é usado para cria-lo pois ele é auto icrement, mas sim para usar como FK na tabela tarefa
		Projeto p = new Projeto(1,"Times do Brasil", "Em andamento", u, null, null);
		
		// Criando uma tarefa, o id passado não é usado para cria-lo pois ele é auto icrement, por isso pode-se passar 0 como default
		Tarefa t = new Tarefa(0, "Jogar", "Ganhar esse negocio", 1, "A fazer", "Alto", u, p);
		
		try {
			UsuarioDAO teste = new UsuarioDAO(Conexao.conectar());

			//Crate de usuario
			teste.createUsuario(u2);
			teste.createUsuario(u);
			
			//Update de usuario
			u = new Usuario("arffgssh5t", "Juliana2", "aaigmanyil@doido.com", "554321", "455-555", new File("rato.jpg"), null, null, null);
			teste.updateUsuario(u);

		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			MensagemDAO teste = new MensagemDAO(Conexao.conectar());
			
			//Crate mensagem
			teste.createMensagem(m);

		} catch(Exception e) {
			System.err.println("Não inseriu na model: " + e.getMessage());
			e.printStackTrace();
		}
		
		try {
			ProjetoDAO teste = new ProjetoDAO(Conexao.conectar());

			//Create projeto
			teste.createProjeto(p);

			//Update projeto, passando o id manualmente para poder excluir na tabela um registro ja existente
			p = new Projeto(1,"Times do Chile", "Continua em andamento", u, null, null);
			teste.updateProjeto(p);

		} catch(Exception e) {
			System.err.println("Não inseriu na model: " + e.getMessage());
			e.printStackTrace();
		}
		
		try {
			TarefaDAO teste = new TarefaDAO(Conexao.conectar());
			
			//Create tarefa
			teste.createTarefa(t);

			//Update tarefa, passando o id manualmente para poder excluir na tabela um registro ja existente
			t = new Tarefa(1, "Jogar mais", "Ganhar esse negocio mesmo", 1, "A fazendo", "Altissima", u, p);
			teste.updateTarefa(t);
			
		} catch(Exception e) {
			System.err.println("Não inseriu na model: " + e.getMessage());
			e.printStackTrace();
		}
		
	}
}
