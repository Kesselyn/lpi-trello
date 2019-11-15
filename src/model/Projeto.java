package model;

import java.util.ArrayList;

public class Projeto {
	private int identificadorProjeto;
	private String nomeProjeto;
	private String lista;
	private Usuario usuarioProprietario;
	private ArrayList <Usuario> usuarios;
	private ArrayList <Tarefa> tarefas;
	
	//Construtor:
	public Projeto() {
		this(0, "", "", null, null, null);
	}
	
	//construtor para o banco sem id e outras coisas	
	public Projeto(int identificadorProjeto, String nomeProjeto, String lista, Usuario usuarioProprietario, ArrayList <Usuario> usuarios, ArrayList <Tarefa> tarefas) {
		this.identificadorProjeto = identificadorProjeto;
		this.nomeProjeto = nomeProjeto;
		this.lista = lista;
		this.usuarioProprietario = usuarioProprietario;
		this.usuarios = usuarios;
		this.tarefas = tarefas;
	}
	
	//Getters:
	public int getIdentificadorProjeto() {
		return identificadorProjeto;
	}

	public String getNomeProjeto() {
		return nomeProjeto;
	}

	public String getLista() {
		return lista;
	}
	
		public Usuario getUsuarioProprietario() {
			return usuarioProprietario;
		}

	public ArrayList <Usuario> getUsuarios() {
		return usuarios;
	}
	
	public ArrayList <Tarefa> getTarefas() {
		return tarefas;
	}
	
	//Setters:
	public void setIdentificadorProjeto(int identificadorProjeto) {
		this.identificadorProjeto = identificadorProjeto;
	}

	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}

	public void setLista(String lista) {
		this.lista = lista;
	}
	
	public void setUsuarioProprietario(Usuario usuarioProprietario) {
		this.usuarioProprietario = usuarioProprietario;
	}

	public void setUsuarios(ArrayList <Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public void setTarefas(ArrayList <Tarefa> tarefas) {
		this.tarefas = tarefas;
	}
	
}
