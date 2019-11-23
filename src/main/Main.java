package main;

import dao.AlocaUsuarioProjetoDAO;

import java.io.File;
import java.util.ArrayList;

// import dao.AlocaUsuarioProjetoDAO;
import dao.Conexao;
// import dao.MensagemDAO;
// import dao.ProjetoDAO;
import dao.TarefaDAO;
// import dao.UsuarioDAO;
// import model.Mensagem;
import model.Projeto;
import model.Tarefa;
import model.Usuario;
import model.AlocaUsuarioProjeto;

public class Main {
	public static void main(String[] args) {
		Conexao.conectar();

		// Criando dois usuarios para poder usar como remetente e destinatário depois na tabela de mensagem
		Usuario u = new Usuario("kess", "kesselyn", "afggrth@fgrtghegailff.br", "1234", "4002-8922", new File("rato.jpg"), null, null, null);
		Usuario u2 = new Usuario("vit", "kesselyn2", "atu@hfgrhgrthetmaffil.com.br", "1234", "5555-5555", new File("rato.jpg"), null, null, null);

		// // Criando uma mensaem, passando o id para poder usar na exclusão depois
		// Mensagem m = new Mensagem(1, u, u2, "oi2", "enviada", null, null);

		// Criando um projeto, o id passado não é usado para cria-lo pois ele é auto icrement, mas sim para usar como FK na tabela tarefa
		Projeto p = new Projeto(1,"Times do Brasil", "Em andamento", u2, null, null);
		
		// // Criando uma tarefa, o id passado não é usado para cria-lo pois ele é auto icrement, mas sim para usar no delete depois
		// Tarefa t = new Tarefa(1, "Jogar", "Ganhar esse negocio", 1, "A fazer", "Alto", u, p);
		
		//Criando a inserção de um usuario em um projeto, o id é passado para ser usado posteriormente no delete
		AlocaUsuarioProjeto a = new AlocaUsuarioProjeto(1, u2, p);

		// try {
		// 	UsuarioDAO teste = new UsuarioDAO(Conexao.conectar());

		// 	//Crate do usuario
		// 	teste.createUsuario(u2);
		// 	teste.createUsuario(u);
			
		// 	//Update do usuario
		// 	// u = new Usuario("arffgssh5t", "Juliana2", "aaigmanyil@doido.com", "554321", "455-555", new File("rato.jpg"), null, null, null);
		// 	// teste.updateUsuario(u);

		// 	//Delete do usuario
		// 	// teste.deleteUsuario(u);

		// } catch(Exception e) {
		// 	e.printStackTrace();
		// }
		
		// try {
		// 	MensagemDAO teste = new MensagemDAO(Conexao.conectar());
			
		// 	//Crate mensagem
		// 	teste.createMensagem(m);

		// 	//Delete mensagem
		// 	// teste.deleteMensagem(m);

		// } catch(Exception e) {
		// 	System.err.println("Não inseriu na model: " + e.getMessage());
		// 	e.printStackTrace();
		// }
		
		// try {
		// 	ProjetoDAO teste = new ProjetoDAO(Conexao.conectar());

		// 	//Create projeto
		// 	teste.createProjeto(p);

		// 	//Update projeto, passando o id manualmente para poder excluir na tabela um registro ja existente
		// 	// p = new Projeto(1,"Times do Chile", "Continua em andamento", u, null, null);
		// 	// teste.updateProjeto(p);

		// 	//Delete projeto
		// 	// teste.deleteProjeto(p);

		// } catch(Exception e) {
		// 	System.err.println("Não inseriu na model: " + e.getMessage());
		// 	e.printStackTrace();
		// }
		
		// try {
		// 	TarefaDAO teste = new TarefaDAO(Conexao.conectar());
			
		// 	//Create tarefa
		// 	teste.createTarefa(t);

		// 	//Update tarefa, passando o id manualmente para poder excluir na tabela um registro ja existente
		// 	// t = new Tarefa(1, "Jogar mais", "Ganhar esse negocio mesmo", 1, "A fazendo", "Altissima", u, p);
		// 	// teste.updateTarefa(t);

		// 	//Delete Tarefa
		// 	// teste.deleteTarefa(t);
			
		// } catch(Exception e) {
		// 	System.err.println("Não inseriu na model: " + e.getMessage());
		// 	e.printStackTrace();
		// }

		// try {
		// 	AlocaUsuarioProjetoDAO teste = new AlocaUsuarioProjetoDAO(Conexao.conectar());
			
		// 	//Create AlocaUsuarioProjeto
		// 	teste.createAlocaUsuarioProjeto(a);

		// 	//Delete AlocaUsuarioProjeto
		// 	teste.deleteAlocaUsuarioProjeto(a);
			
		// } catch(Exception e) {
		// 	System.err.println("Não inseriu na model: " + e.getMessage());
		// 	e.printStackTrace();
		// }
		
		AlocaUsuarioProjetoDAO teste = new AlocaUsuarioProjetoDAO(Conexao.conectar());

		// //Array com os projetos em que o usuários está
		// ArrayList<Projeto> retorno = teste.readProjetosUsuario(a);
		
		// //Array com os projetos que o usuário é proprietátio
		// ArrayList<Projeto> retorno = teste.readProjetosADM(p);
		
		// System.out.println("Total de linhas encontradas:" + retorno.size());
		// //percorrendo o arraylist de retorno
		// for(Projeto t : retorno) { 
		// 	System.out.println("id: " + t.getIdentificadorProjeto() + " nome: "+ t.getNomeProjeto() + " coluna: "+ t.getLista() + " idProp: "+ t.getUsuarioProprietario().getApelido());
		// }
		
		 ArrayList<Usuario> retorno1 = teste.readUsuarioProjeto(a);

		 System.out.println("Total de linhas encontradas:" + retorno1.size());
		 for(Usuario t : retorno1) { 
		 	System.out.println("id: " + t.getApelido() + " nome: "+ t.getNomeUsuario() + " email: "+ t.getEmail() + " senha: "+ t.getSenha() + " telefone: " + t.getTelefone());
		 }
		
		ArrayList<Usuario> retorno = teste.readUsuarioAusenteProjeto(a);

		 System.out.println();
		 System.out.println("Total de linhas encontradas dos ausentinhos:" + retorno.size());
		 for(Usuario t : retorno) { 
			 System.out.println("id: " + t.getApelido() + " nome: "+ t.getNomeUsuario() + " email: "+ t.getEmail() + " senha: "+ t.getSenha() + " telefone: " + t.getTelefone());
		 }

		TarefaDAO testar = new TarefaDAO(Conexao.conectar());
		ArrayList<Tarefa> tarefas = testar.readTarefa(p);
		
		for(Tarefa zig : tarefas) { 
			System.out.println(" id: " + zig.getIdentificadorTarefa() + ", titulo: "+ zig.getTitulo() + ", descricao  "+ zig.getDescricao() + ", nivel prioridade "+ zig.getNivelPrioridade() +", estado "+zig.getEstado()+", ordem "+zig.getOrdem()+
									", apelido  usuario " +zig.getUsuario().getApelido()+", id projeto "+ zig.getProjeto().getIdentificadorProjeto());
		}
	}
}
