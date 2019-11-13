package model;

import java.util.ArrayList;

public class Projeto {
	private int identificadorProjeto;
	private String nomeProjeto;
	private String lista;
	private ArrayList <Usuario> usuarios;
	private Usuario usuarioProprietario;
	private ArrayList <Tarefa> tarefas;
	
	//Construtor:
	public Projeto() {
		this(0, "", "", null, null, null);
	}
	
	public Projeto(int identificadorProjeto, String nomeProjeto, String lista, ArrayList <Usuario> usuarios, Usuario usuarioProprietario, ArrayList <Tarefa> tarefas) {
		this.identificadorProjeto = identificadorProjeto;
		this.nomeProjeto = nomeProjeto;
		this.lista = lista;
		this.usuarios = usuarios;
		this.usuarioProprietario = usuarioProprietario;
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

	public ArrayList <Usuario> getUsuarios() {
		return usuarios;
	}

	public Usuario getUsuarioProprietario() {
		return usuarioProprietario;
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


	public void setUsuarios(ArrayList <Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void setUsuarioProprietario(Usuario usuarioProprietario) {
		this.usuarioProprietario = usuarioProprietario;
	}
	
	public void setTarefas(ArrayList <Tarefa> tarefas) {
		this.tarefas = tarefas;
	}
	
}
