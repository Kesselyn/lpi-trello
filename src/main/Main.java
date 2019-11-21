package main;

import dao.AlocaUsuarioProjetoDAO;

import java.io.File;
import java.util.ArrayList;

// import dao.AlocaUsuarioProjetoDAO;
import dao.Conexao;
// import dao.MensagemDAO;
// import dao.ProjetoDAO;
// import dao.TarefaDAO;
// import dao.UsuarioDAO;
// import model.Mensagem;
import model.Projeto;
// import model.Tarefa;
import model.Usuario;
import model.AlocaUsuarioProjeto;

public class Main {
	public static void main(String[] args) {
		Conexao.conectar();

		// Criando dois usuarios para poder usar como remetente e destinat�rio depois na tabela de mensagem
		Usuario u = new Usuario("kess", "kesselyn", "afggrth@fgrtghegailff.br", "1234", "4002-8922", new File("rato.jpg"), null, null, null);
		Usuario u2 = new Usuario("vit", "kesselyn2", "atu@hfgrhgrthetmaffil.com.br", "1234", "5555-5555", new File("rato.jpg"), null, null, null);

		// // Criando uma mensaem, passando o id para poder usar na exclus�o depois
		// Mensagem m = new Mensagem(1, u, u2, "oi2", "enviada", null, null);

		// Criando um projeto, o id passado n�o � usado para cria-lo pois ele � auto icrement, mas sim para usar como FK na tabela tarefa
		Projeto p = new Projeto(1,"Times do Brasil", "Em andamento", u, null, null);
		
		// // Criando uma tarefa, o id passado n�o � usado para cria-lo pois ele � auto icrement, mas sim para usar no delete depois
		// Tarefa t = new Tarefa(1, "Jogar", "Ganhar esse negocio", 1, "A fazer", "Alto", u, p);
		
		//Criando a inser��o de um usuario em um projeto, o id � passado para ser usado posteriormente no delete
		AlocaUsuarioProjeto a = new AlocaUsuarioProjeto(1, u2, p);

		AlocaUsuarioProjetoDAO teste = new AlocaUsuarioProjetoDAO(Conexao.conectar());

		ArrayList<Projeto> retorno = teste.readProjetosUsuario(a);
		
		System.out.println("Total de linhas encontradas:" + retorno.size());
		//percorrendo o arraylist de retorno
		for(Projeto t : retorno) { 
			System.out.println("id: " + t.getIdentificadorProjeto() + " nome: "+ t.getNomeProjeto() + " coluna: "+ t.getLista() + " idProp: "+ t.getUsuarioProprietario().getApelido());
		}
		
		

	}
}